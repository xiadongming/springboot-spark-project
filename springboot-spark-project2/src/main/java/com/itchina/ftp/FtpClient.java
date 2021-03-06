package com.itchina.ftp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Date: 2021/3/5 22:23
 * @Desc:
 */
@Component
public class FtpClient {
    @Value("${spring.ftp.host}")
    private String host;
    @Value("${spring.ftp.port}")
    private String port;
    @Value("${spring.ftp.username}")
    private String username;
    @Value("${spring.ftp.password}")
    private String password;
    @Value("${spring.ftp.basePath}")
    private String basePath;
    @Value("${spring.ftp.httpPath}")
    private String httpPath;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getHttpPath() {
        return httpPath;
    }

    public void setHttpPath(String httpPath) {
        this.httpPath = httpPath;
    }

    @Override
    public String toString() {
        return "FtpClient{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", basePath='" + basePath + '\'' +
                ", httpPath='" + httpPath + '\'' +
                '}';
    }
}
