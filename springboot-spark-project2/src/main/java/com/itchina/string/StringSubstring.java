package com.itchina.string;

import java.io.File;
import java.util.UUID;

/**
 * @Date: 2021/4/12 13:56
 * @Desc:
 */
public class StringSubstring {


    public static void main(String[] args) {

        String path = "resfile/auth/template/";
        downloadFileFromPath(path);
    }

    public static File downloadFileFromPath(String filePath) {
        if (filePath.startsWith("/")) {
            filePath = filePath.substring(1, filePath.length());
        }
        return downloadFilePubMethod(filePath);
    }

    private static File downloadFilePubMethod(String filePath) {

        String fileName = filePath.substring(filePath.lastIndexOf("/"), filePath.length());
        fileName = UUID.randomUUID() + filePath.substring(filePath.lastIndexOf("."), filePath.length());
        return null;
    }
}
