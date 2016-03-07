package scu.miomin.com.miohttp;

import android.test.InstrumentationTestCase;
import android.util.Log;

import scu.miomin.com.miohttplib.HttpUrlConnectionUtil;
import scu.miomin.com.miohttplib.Request;

/**
 * Created by miomin on 16/3/7.
 */
public class HttpTest extends InstrumentationTestCase {

    private static final String TAG = "miomin";

    public void testHttpGet() throws Throwable {
        String url = "http://api.stay4it.com";
        Request request = new Request(url, Request.REQUSET_METHOD.GET);
        String result = HttpUrlConnectionUtil.get(request);
        Log.i(TAG, result);
    }

    public void testHttpPost() throws Throwable {
        String url = "http://api.stay4it.com/v1/public/core/?service=user.login";
        String content = "account=stay4it&password=123456";
        Request request = new Request(url, content, Request.REQUSET_METHOD.POST);
        String result = HttpUrlConnectionUtil.post(request);
        Log.i(TAG, result);
    }
}
