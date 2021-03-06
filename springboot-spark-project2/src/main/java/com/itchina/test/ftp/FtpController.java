package com.itchina.test.ftp;

import com.itchina.ftp.FTPUtils2;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Date: 2021/3/5 22:17
 * @Desc:
 */
@RestController
@RequestMapping("/ftp")
public class FtpController {

    static final Logger logger = LoggerFactory.getLogger(FTPUtils2.class);

    private static final String url = "192.168.1.124";
    private static final String username = "ftpuser";
    private static final String password = "X123456789";
    private static final String basePath = "/var/ftp/pub";
    private static final String localDir = "C:\\Users\\Administrator\\Desktop\\12121\\";
    private static final int port = 21;


    @Autowired
    private FTPUtils2 fTPUtils2;

    @RequestMapping(value = "/down", method = {RequestMethod.GET, RequestMethod.POST})
    public Object getFtp() {
        fTPUtils2.download("jdk-8u221-linux-x64.tar.gz", "jdk-8u221-linux-x64.tar.gz");
        return "succ";
    }
    @RequestMapping(value = "/downBatch2", method = {RequestMethod.GET, RequestMethod.POST})
    public Object getFtpBatch2() {
        FTPClient ftpClient = connectFtpServer();
        try {
            ftpClient.changeWorkingDirectory(basePath);
            FTPFile[] ftpFiles = ftpClient.listFiles(basePath);
            fTPUtils2.downloadBatch2(ftpFiles, ftpClient);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "succ";
    }
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
            logger.info("replyCode==========={}", replyCode);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("connect fail ------->>>{}", e.getCause());
            return null;
        }
        return ftpClient;
    }

}
