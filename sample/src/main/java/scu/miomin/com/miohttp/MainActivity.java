package scu.miomin.com.miohttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import scu.miomin.com.miohttplib.request.MioRequest;
import scu.miomin.com.miohttplib.task.MioRequestTask;
import scu.miomin.com.miohttplib.parse.JsonRequestListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "miomin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        testHttpJsonGet();
    }

//    public void testHttpStringGet() {
//        String url = "http://v.juhe.cn/xianxing/index?key=48cfb0f1ae6a5666274147e99b6838fa&city=beijing&type=1";
//        MioRequest request = new MioRequest(url, MioRequest.REQUSET_METHOD.GET, new JsonRequestListener<String>() {
//            @Override
//            public void onSuccess(String result) {
//                Log.i(TAG, "get result:" + result);
//            }
//
//            @Override
//            public void onFaild(Exception exception) {
//                exception.printStackTrace();
//            }
//        });
//
//        MioRequestTask requestTask = new MioRequestTask(request);
//        requestTask.execute();
//    }

    public void testHttpJsonGet() {
        String url = "http://v.juhe.cn/xianxing/index?key=48cfb0f1ae6a5666274147e99b6838fa&city=beijing&type=1";
        MioRequest request = new MioRequest(url, MioRequest.REQUSET_METHOD.GET, new JsonRequestListener<Xianxing>() {
            @Override
            public void onSuccess(Xianxing result) {

                Log.i(TAG, "get result:" + result.toString());
            }

            @Override
            public void onFaild(Exception exception) {
                exception.printStackTrace();
            }
        }.setRootKey("result"));

        MioRequestTask requestTask = new MioRequestTask(request);
        requestTask.execute();
    }

//    public void testHttpPost() {
//        String url = "http://api.stay4it.com/v1/public/core/?service=user.login";
//        String content = "account=stay4it&password=123456";
//        MioRequest request = new MioRequest(url, content, MioRequest.REQUSET_METHOD.POST);
//
//        MioRequestTask requestTask = new MioRequestTask(request, new MioRequestTask.IMioRequestListener<String>() {
//            @Override
//            public void onSuccess(String result) {
//                Log.i(TAG, "post result:" + result);
//            }
//
//            @Override
//            public void onFaild(Exception exception) {
//                exception.printStackTrace();
//            }
//        });
//        requestTask.execute();
//    }
}
