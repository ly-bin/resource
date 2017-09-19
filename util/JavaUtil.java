package com.qb.util

/**
 * @author qts
 * @Date 2017/09/05 19:16
 * @description:
 **/

public class JavaUtil {

    private final static String HEX = "0123456789ABCDEF";

    /**
     * byte数组转为16进制的字符串
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes){
        StringBuilder sb = new StringBuilder(bytes.length * 2 + 2);
        sb.append("[");
        for (byte b : bytes) {
			//先高位后低位
            sb.append(HEX.charAt((b >> 4) & 0x0f));
            sb.append(HEX.charAt(b & 0x0f));
        }
        sb.append("]");
        return sb.toString();
    }
}
