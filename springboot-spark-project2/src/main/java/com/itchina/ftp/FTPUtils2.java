package com.itchina.ftp;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Date: 2021/3/5 22:34
 * @Desc:
 */
@Component
public class FTPUtils2 {
    static final Logger logger = LoggerFactory.getLogger(FTPUtils2.class);
    private static final String url = "192.168.1.124";
    private static final String username = "ftpuser";
    private static final String password = "X123456789";
    private static final String basePath = "/var/ftp/pub";
    private static final String localDir = "C:\\Users\\Administrator\\Desktop\\12121\\";
    private static final int port = 21;

    private FTPClient connectFtpServer() {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setConnectTimeout(1000 * 30);//设置连接超时时间
        ftpClient.setControlEncoding("utf-8");//设置ftp字符集
        ftpClient.enterLocalPassiveMode();//设置被动模式，文件传输端口设置
        try {

            ftpClient.connect(url, port);
            ftpClient.login(username, password);
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//设置文件传输模式为二进制，可以保证传输的内容不会被改变
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                logger.error("connect ftp {} failed", url);
                ftpClient.disconnect();
                return null;
            }
            logger.info("连接成功 replyCode==========={}", replyCode);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("connect fail ------->>>{}", e.getCause());
            return null;
        }
        return ftpClient;
    }

    /**
     * 单个文件下载
     *
     * @param remoteFileName ftp上的文件名
     * @param localFileName  本地文件名
     */
    public void download(String remoteFileName, String localFileName) {
        FTPClient ftpClient = connectFtpServer();
        if (ftpClient == null) {
            return;
        }
        OutputStream outputStream = null;
        try {
            ftpClient.changeWorkingDirectory(basePath);
            FTPFile[] ftpFiles = ftpClient.listFiles(basePath);
            Boolean flag = false;
            //遍历当前目录下的文件，判断是否存在待下载的文件
            for (FTPFile ftpFile : ftpFiles) {
                logger.info("目标文件下的文件是：{}", ftpFile.getName());
                if (ftpFile.getName().equals(remoteFileName)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                logger.error("directory：{}下没有 {}", basePath, remoteFileName);
                return;
            }
            outputStream = new FileOutputStream(localDir + localFileName);//创建文件输出流
            Boolean isSuccess = ftpClient.retrieveFile(remoteFileName, outputStream); //下载文件
            if (!isSuccess) {
                logger.error("download file 【{}】 fail", remoteFileName);
            }
            logger.info("download file success");
            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("download file 【{}】 fail ------->>>{}", remoteFileName, e.getCause());
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("disconnect fail ------->>>{}", e.getCause());
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("outputStream close fail ------->>>{}", e.getCause());
                }
            }
        }
    }

    /**
     * 批量下载
     */
    public void downloadBatch2(FTPFile[] ftpFiles, FTPClient ftpClient) {
        if (ftpClient == null) {
            return;
        }
        OutputStream outputStream = null;
        try {
            Boolean isSuccess = null;
            for (FTPFile ftpFile : ftpFiles) {
                outputStream = new FileOutputStream(localDir + ftpFile.getName());//创建文件输出流
                isSuccess = ftpClient.retrieveFile(ftpFile.getName(), outputStream); //下载文件
                if (!isSuccess) {
                    logger.error("download file 【{}】 fail", ftpFile.getName());
                }
            }
            logger.info("download file success");

            deleteRemoteFiles(ftpFiles, ftpClient);

            ftpClient.logout();
        } catch (IOException e) {
            logger.error("下载失败");
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("disconnect fail ------->>>{}", e.getCause());
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("outputStream close fail ------->>>{}", e.getCause());
                }
            }
        }
    }

    private void deleteRemoteFiles(FTPFile[] ftpFiles, FTPClient ftpClient) {
        logger.info("开始删除文件");

        for (FTPFile ftpFile : ftpFiles) {
            try {
                //deleteFile 删除不了
                // ftpClient.deleteFile(ftpFile.getName());
                ftpClient.dele(ftpFile.getName());
            } catch (IOException e) {
                logger.info("删除失败");
                e.printStackTrace();
            }
        }
        logger.info("全部删除成功");

    }
}
