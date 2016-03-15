package scu.miomin.com.miohttplib.task;

import android.os.AsyncTask;

import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;

import scu.miomin.com.miohttplib.request.MioRequest;
import scu.miomin.com.miohttplib.util.MioHttpUrlConnectionUtil;

/**
 * Created by miomin on 16/3/7.
 */
public class MioRequestTask extends AsyncTask<Void, Integer, Object> {

    private MioRequest request;

    public MioRequestTask(MioRequest request) {
        this.request = request;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Void... params) {
        try {
            HttpURLConnection connection = MioHttpUrlConnectionUtil.execute(request);
            // 预处理服务器返回的数据
            return request.iMioRequestListener.parse(connection);
        } catch (IOException e) {
            return e;
        } catch (JSONException e) {
            return e;
        }
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        if (o instanceof Exception) {
            request.iMioRequestListener.onFaild((Exception) o);
        } else {
            request.iMioRequestListener.onSuccess(o);
        }
    }
}
