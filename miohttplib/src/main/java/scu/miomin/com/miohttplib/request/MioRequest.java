package scu.miomin.com.miohttplib.request;

import java.util.Map;

import scu.miomin.com.miohttplib.parse.IMioRequestListener;

/**
 * Created by miomin on 16/3/7.
 */
public class MioRequest {

    public IMioRequestListener iMioRequestListener;

    public enum REQUSET_METHOD {GET, POST, PUT, DELELE}

    public String url;
    public String content;
    public Map<String, String> headers;
    public REQUSET_METHOD requset_method;

    public MioRequest(String url, String content, REQUSET_METHOD requset_method, IMioRequestListener iMioRequestListener) {
        this.url = url;
        this.content = content;
        this.requset_method = requset_method;
        this.iMioRequestListener = iMioRequestListener;
    }

    public MioRequest(String url, REQUSET_METHOD requset_method, IMioRequestListener iMioRequestListener) {
        this.url = url;
        this.requset_method = requset_method;
        this.iMioRequestListener = iMioRequestListener;
    }
}