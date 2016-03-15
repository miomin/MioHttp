package scu.miomin.com.miohttp;

import android.test.InstrumentationTestCase;
import android.util.Log;

import scu.miomin.com.miohttplib.MioHttpUrlConnectionUtil;
import scu.miomin.com.miohttplib.MioRequest;

/**
 * Created by miomin on 16/3/7.
 */
public class HttpTest extends InstrumentationTestCase {

    private static final String TAG = "miomin";

    public void testHttpGet() throws Throwable {
        String url = "http://api.stay4it.com";
        MioRequest request = new MioRequest(url, MioRequest.REQUSET_METHOD.GET);
        String result = MioHttpUrlConnectionUtil.get(request);
        Log.i(TAG, result);
    }

    public void testHttpPost() throws Throwable {
        String url = "http://api.stay4it.com/v1/public/core/?service=user.login";
        String content = "account=stay4it&password=123456";
        MioRequest request = new MioRequest(url, content, MioRequest.REQUSET_METHOD.POST);
        String result = MioHttpUrlConnectionUtil.post(request);
        Log.i(TAG, result);
    }
}
