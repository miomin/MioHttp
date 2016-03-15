package scu.miomin.com.miohttplib.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import scu.miomin.com.miohttplib.request.MioRequest;

/**
 * Created by miomin on 16/3/7.
 */
public class MioHttpUrlConnectionUtil {

    public static HttpURLConnection execute(MioRequest request) throws IOException {
        switch (request.requset_method) {
            case GET:
            case DELELE:
                return get(request);
            case POST:
            case PUT:
                return post(request);
        }

        return null;
    }

    private static HttpURLConnection get(MioRequest request) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) new URL(request.url).openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(15 * 3000);
        connection.setReadTimeout(15 * 3000);

        addProperty(connection, request.headers);

        return connection;
    }

    private static HttpURLConnection post(MioRequest request) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) new URL(request.url).openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(15 * 3000);
        connection.setReadTimeout(15 * 3000);
        connection.setDoOutput(true);

        addProperty(connection, request.headers);

        OutputStream os = connection.getOutputStream();
        os.write(request.content.getBytes());

        return connection;
    }

    private static void addProperty(HttpURLConnection connection, Map<String, String> headers) {
        if (headers == null || headers.size() == 0) {
            return;
        }
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            connection.addRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}
