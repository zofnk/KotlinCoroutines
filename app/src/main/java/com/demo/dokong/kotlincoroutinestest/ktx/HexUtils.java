package com.demo.dokong.kotlincoroutinestest.ktx;

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2018/9/5. 15:00
 */
public class HexUtils {

    public static String bytesToHexFun3(byte[] bytes) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) { // 使用String的format方法进行转换
            buf.append(String.format("%02x", new Integer(b & 0xff)));
        }
        return buf.toString();
    }

}
