package com.afeng.utils;

import java.util.UUID;

public class UUIDUtils {
    /**
     * 获取32位的UUID
     * @return 32位的UUID
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获取64位的UUID
     * @return 64位的UUID
     */
    public static String getUUID64(){
        return getUUID() + getUUID();
    }
}
