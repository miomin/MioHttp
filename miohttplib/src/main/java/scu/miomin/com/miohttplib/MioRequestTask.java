package scu.miomin.com.miohttplib;

import android.os.AsyncTask;

import java.io.IOException;

/**
 * Created by miomin on 16/3/7.
 */
public class MioRequestTask extends AsyncTask<Void, Integer, Object> {

    public interface OnMioRequestListener {
        void onSuccess(String result);

        void onFaild(Exception exception);
    }

    private OnMioRequestListener onMioRequestListener;

    private MioRequest request;

    public MioRequestTask(MioRequest request, OnMioRequestListener onMioRequestListener) {
        this.request = request;
        this.onMioRequestListener = onMioRequestListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Void... params) {
        try {
            return MioHttpUrlConnectionUtil.execute(request);
        } catch (IOException e) {
            return e;
        }
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        if (o instanceof Exception) {
            onMioRequestListener.onFaild((Exception) o);
        } else {
            onMioRequestListener.onSuccess((String) o);
        }
    }
}
