package com.green.boardver3.utils;

import java.util.UUID;

public class FileUtils {
    // 확장자 리턴하는 메소드
    public static String getExt(String fileNm) { //abcd.123.jpg
        return fileNm.substring(fileNm.lastIndexOf(".")+1);
    }

    public static String getFileNm(String fileNm) {
        return fileNm.substring(0,fileNm.lastIndexOf("."));
    }
    // uuid 이용, 랜덤값 파일명 리턴
    public static String makeRandomFileNm(String fileNm) {
        String uuid = UUID.randomUUID().toString();
        return uuid+"."+getExt(fileNm);
    }

    public static void main(String[] args) {
        String fileNm = "abcd.123.jpg";

        String result = getExt(fileNm);
        System.out.println(result);

        String resultFileNm = getFileNm(fileNm);
        System.out.println(resultFileNm);

        String resultRandomFileNm = makeRandomFileNm(fileNm);
        System.out.println(resultRandomFileNm);
    }
}
