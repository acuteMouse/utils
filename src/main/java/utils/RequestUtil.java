package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 功能：
 * Created by cgl on 2017/5/4 0004.
 */
public class RequestUtil {
    static final String POST = "POST";
    static final String PUT = "PUT";
    static final int CONNECTIONTOMEOUT = 1000;


    /**
     * @param url
     * @param data 要发送的格式。如：&a=?&b=?
     * @return
     */
    public static String post(String url, String data) {
        StringBuilder result = new StringBuilder(200);
        BufferedReader reader = null;
        try {
            URL realUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setConnectTimeout(CONNECTIONTOMEOUT);//1s连接超时
            connection.setReadTimeout(CONNECTIONTOMEOUT);//设置读取超时时间
            connection.setRequestMethod(POST);
            connection.setDoOutput(true);

            OutputStream outputStream = connection.getOutputStream();
            if (data != null) {
                outputStream.write(data.getBytes());
            }
            outputStream.flush();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {

            }

        }
        return result.toString();
    }

    public static String get(String url) {
        StringBuilder result = new StringBuilder(200);
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            connection.setConnectTimeout(CONNECTIONTOMEOUT);
            connection.setReadTimeout(CONNECTIONTOMEOUT);
            // 建立实际的连接
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result.toString();
    }
}
