package com.demo.dokong.kotlincoroutinestest.ktx;

import com.alibaba.fastjson.JSON;

import java.util.Map;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * @author jokin
 * @date 2018/8/21 16:07
 */
public class CryptoTongbuUtils {

    static byte[] desKey =
            new byte[]{hexToByte("13"), hexToByte("01"),
                    hexToByte("2a"), hexToByte("3b"),
                    hexToByte("c6"), hexToByte("e3"),
                    hexToByte("4a"), hexToByte("b7")};

    private static final String DEFAULT_KEY_ALGORITHM = "DES";

    public static String encrypy2Hex(Map<String, Object> map) {
        String input = JSON.toJSONString(map);
        byte[] out = new byte[]{};
        try {
            out = CryptoTongbuUtils.encrypy(input.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HexUtils.bytesToHexFun3(out);
    }

    public static byte hexToByte(String inHex) {
        return (byte) Integer.parseInt(inHex, 16);
    }

    /**
     * byte[] 转16进制
     */
    public static String bytesToHexFun(byte[] encryptedData) {
        StringBuilder buf = new StringBuilder(encryptedData.length * 2);
        // 使用String的format方法进行转换
        for (byte b : encryptedData) {
            buf.append(String.format("%02x", b & 0xff));
        }
        return buf.toString();
    }

    /**
     * 加密
     */
    public static byte[] encrypy(byte[] input) throws Exception {
        if (input == null) {
            return null;
        }
        // 用于自行加密异或操作的8字节数据。
        byte[] factor = generateFactor();
        int length = input.length;
        byte[] outputBuffer = new byte[8 + length];
        int index1 = 0;
        int index2 = 0;
        int index3 = 8;
        while (index2 < length) {
            outputBuffer[index3] = (byte) (input[index2] ^ factor[index1]);
            if (++index1 == 8) {
                index1 = 0;
            }
            ++index2;
            ++index3;
        }

        Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(desKey));
        cipher.doFinal(factor, 0, 8, outputBuffer, 0);
        return outputBuffer;
    }

    /**
     * 解密
     */
    public static byte[] decrypt(byte[] input) throws Exception {

        if (input == null) {
            return null;
        }
        int length = input.length;
        if (length < 8) {
            return null;
        }
        byte[] inputBuffer = new byte[16];
        System.arraycopy(input, 0, inputBuffer, 0, 8);

        byte[] factor = new byte[8];

        Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey(desKey));
        cipher.doFinal(inputBuffer, 0, 8, factor, 0);

        byte[] numArray = new byte[length - 8];
        int index1 = 0;
        int index2 = 8;
        int index3 = 0;
        while (index2 < length) {
            numArray[index3] = (byte) (input[index2] ^ factor[index1]);
            if (++index1 == 8) {
                index1 = 0;
            }
            ++index2;
            ++index3;
        }
        return numArray;

    }

    public static SecretKey getSecretKey(byte[] key) throws Exception {

        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DEFAULT_KEY_ALGORITHM);
        return keyFactory.generateSecret(dks);
    }

    static byte[] generateFactor() {
        byte[] numArray = new byte[8];
        byte[] byteArray = UUID.randomUUID().toString().getBytes();
        System.arraycopy(byteArray, 0, numArray, 0, 8);
        for (int index = 0; index < 8; index++) {
            numArray[index] ^= byteArray[8 + index];
        }
        return numArray;
    }
}
