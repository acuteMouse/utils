package utils;

/**
 * 功能：邮箱格式验证
 * Created by cgl on 2017/4/20
 */

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    /**
     * 判断客户端中的cookie是否含有指定的cookie
     *
     * @param request the servlet request.
     * @param name    the name of the cookie.
     * @return the Cookie object if it exists, otherwise <tt>null</tt>.
     */
    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie cookies[] = request.getCookies();
        if (cookies == null || name == null || name.length() == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                if (request.getServerName().equals(cookie.getDomain())) {
                    return cookie;
                }
            }
        }
        return null;
    }

    /**
     * @param request
     * @param name          cookir名
     * @param defaultString cookie不存在时，返回指定的默认值
     * @return 返回指定cookie的值，如果不存就返回指定的默认值
     */
    public static String getCookieValue(HttpServletRequest request, String name, String defaultString) {
        Cookie cookie = getCookie(request, name);
        return getCookie(request, name) == null ? defaultString : cookie.getValue();
    }

    /**
     * Deletes the specified cookie.
     *
     * @param request  the servlet request.
     * @param response the servlet response.
     * @param cookie   the cookie object to be deleted.
     */
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, Cookie cookie) {
        if (cookie != null) {
            // Invalidate the cookie
            String path = request.getContextPath() == null ? "/" : request.getContextPath();
            if ("".equals(path)) {
                path = "/";
            }
            cookie.setPath(path);
            cookie.setValue("");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    /**
     * Stores a value in a cookie. By default this cookie will persist for 30 days.
     *
     * @param response the servlet response.
     * @param name     a name to identify the cookie.
     * @param value    the value to store in the cookie.
     */
    public static void setCookie(HttpServletResponse response, String name, String value) {
        // Save the cookie value for 1 month
        setCookie(response, name, value, 60 * 60 * 24 * 30);
    }

    /**
     * Stores a value in a cookie. This cookie will persist for the amount
     * specified in the <tt>saveTime</tt> parameter.
     *
     * @param response the servlet response.
     * @param name     a name to identify the cookie.
     * @param value    the value to store in the cookie.
     * @param maxAge   the time (in seconds) this cookie should live.
     */
    public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
        // Check to make sure the new value is not null (appservers like Tomcat
        // 4 blow up if the value is null).
        if (value == null) {
            value = "";
        }
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}



