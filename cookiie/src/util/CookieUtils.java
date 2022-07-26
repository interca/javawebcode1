package util;

import javax.servlet.http.Cookie;

public class CookieUtils {
    /**
     * 查找指定的cookie对象
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie findCookie(String name,Cookie[]cookies){
       if(name==null||cookies==null||cookies.length==0)return null;
        for (Cookie cookie : cookies) {
             if(cookie.getName().equals(name))return cookie;
        }
        return null;
    }
}
