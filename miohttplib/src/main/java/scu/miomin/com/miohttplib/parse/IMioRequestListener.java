package scu.miomin.com.miohttplib.parse;

import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by miomin on 16/3/15.
 */
public interface IMioRequestListener<T> {
    void onSuccess(T result);

    void onFaild(Exception exception);

    T parse(HttpURLConnection connection) throws IOException, JSONException;
}
