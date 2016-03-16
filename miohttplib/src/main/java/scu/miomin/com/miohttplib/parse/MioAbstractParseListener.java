package scu.miomin.com.miohttplib.parse;

import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import scu.miomin.com.miohttplib.error.MioException;
import scu.miomin.com.miohttplib.interf.IMioRequestListener;
import scu.miomin.com.miohttplib.util.HttpStatus;

/**
 * Created by 莫绪旻 on 16/3/15.
 */
public abstract class MioAbstractParseListener<T> implements IMioRequestListener<T> {

    @Override
    public T parse(HttpURLConnection connection) throws MioException,IOException, JSONException {

        int status = connection.getResponseCode();
        if (status == HttpStatus.SC_OK) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream is = connection.getInputStream();
            byte[] buffer = new byte[2048];
            int len;
            while ((len = is.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            is.close();
            out.flush();
            out.close();

            String result = new String(out.toByteArray());

            return bindData(result);
        } else {
            throw new MioException(HttpStatus.CON_FAILED);
        }
    }

    protected abstract T bindData(String result) throws JSONException;

}
