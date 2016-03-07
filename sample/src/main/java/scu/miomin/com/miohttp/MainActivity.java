package scu.miomin.com.miohttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.io.IOException;

import scu.miomin.com.miohttplib.HttpUrlConnectionUtil;
import scu.miomin.com.miohttplib.Request;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "miomin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void testHttpGet() throws IOException {
        String url = "http://api.stay4it.com";
        Request request = new Request(url, Request.REQUSET_METHOD.GET);
        String result = HttpUrlConnectionUtil.get(request);
        Log.i(TAG, result);
    }

    public void testHttpPost() throws IOException {
        String url = "http://api.stay4it.com/v1/public/core/?service=user.login";
        String content = "account=stay4it&password=123456";
        Request request = new Request(url, content, Request.REQUSET_METHOD.POST);
        String result = HttpUrlConnectionUtil.post(request);
        Log.i(TAG, result);
    }
}
