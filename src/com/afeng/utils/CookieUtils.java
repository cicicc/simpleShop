package com.afeng.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {


    /**
     * 写一个静态方法 从当前的所有cookie中获取用户查询的cookie并返回
     */
    public static String[] getCookieByName(Cookie[] cookies, String cookieName) {
        String[] userInfo = null;
        //如果cookie不为空 且cookie的长度大于零 那么就对其进行遍历操作
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    userInfo = cookie.getValue().split("@");
                }
            }
        }

        return userInfo;
    }
}
