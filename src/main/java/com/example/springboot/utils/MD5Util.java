package com.example.springboot.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.example.springboot.constant.Constant.MD5;
import static com.example.springboot.constant.Constant.NO_SUCH_ALGORITHM_EXCEPTION;

@Component
@Slf4j
public final class MD5Util {
    private static final String[] HEX_ARRAY = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private MD5Util() {
    }

    /**
     * 将1个字节（1 byte = 8 bit）转为 2个十六进制位 1个16进制位 = 4个二进制位 （即4 bit）
     * 转换思路：最简单的办法就是先将byte转为10进制的int类型，然后将十进制数转十六进制
     */
    private static String byteToHexString(byte b) {

        // byte类型赋值给int变量时，java会自动将byte类型转int类型，从低位类型到高位类型自动转换
        int n = b;

        // 将十进制数转十六进制
        if (n < 0) n += 256;
        int d1 = n / HEX_ARRAY.length;
        int d2 = n % HEX_ARRAY.length;

        // d1和d2通过访问数组变量的方式转成16进制字符串；比如 d1 为12 ，那么就转为"c"
        // 因为int类型不会有a,b,c,d,e,f等表示16进制的字符
        return HEX_ARRAY[d1] + HEX_ARRAY[d2];
    }

    /**
     * 将字节数组里每个字节转成2个16进制位的字符串后拼接起来
     */
    private static String byteArrayToHexString(byte[] bytesArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytesArray) {
            stringBuilder.append(byteToHexString(b));
        }
        return stringBuilder.toString();
    }

    /**
     * MD5算法 默认固定长度是 128bit 即 32个16进制位
     */
    public static String md5(String str) {
        String hexString = null;

        try {
            // 1，创建MessageDigest对象
            MessageDigest messageDigest = MessageDigest.getInstance(MD5);

            // 2，计算摘要
            byte[] bytes = messageDigest.digest(str.getBytes());

            // 3,将字节数组转换为16进制位
            hexString = byteArrayToHexString(bytes);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            log.info(NO_SUCH_ALGORITHM_EXCEPTION, e);
        }
        return hexString;
    }

    public static void main(String[] args) {
        log.info(md5("a"));
    }
}
