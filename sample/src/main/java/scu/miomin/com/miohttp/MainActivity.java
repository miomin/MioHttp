package scu.miomin.com.miohttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import scu.miomin.com.miohttplib.MioRequest;
import scu.miomin.com.miohttplib.MioRequestTask;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "miomin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        testHttpPost();
        testHttpGet();
    }

    public void testHttpGet() {
        String url = "http://api.stay4it.com";
        MioRequest request = new MioRequest(url, MioRequest.REQUSET_METHOD.GET);

        MioRequestTask requestTask = new MioRequestTask(request, new MioRequestTask.OnMioRequestListener() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, "get result:" + result);
            }

            @Override
            public void onFaild(Exception exception) {
                exception.printStackTrace();
            }
        });
        requestTask.execute();
    }

    public void testHttpPost() {
        String url = "http://api.stay4it.com/v1/public/core/?service=user.login";
        String content = "account=stay4it&password=123456";
        MioRequest request = new MioRequest(url, content, MioRequest.REQUSET_METHOD.POST);

        MioRequestTask requestTask = new MioRequestTask(request, new MioRequestTask.OnMioRequestListener() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, "post result:" + result);
            }

            @Override
            public void onFaild(Exception exception) {
                exception.printStackTrace();
            }
        });
        requestTask.execute();
    }
}
