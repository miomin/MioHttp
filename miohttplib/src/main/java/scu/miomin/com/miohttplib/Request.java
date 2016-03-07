package scu.miomin.com.miohttplib;

import java.util.Map;

/**
 * Created by miomin on 16/3/7.
 */
public class Request {

    public enum REQUSET_METHOD {GET, POST, PUT, DELELE}

    public String url;
    public String content;
    public Map<String, String> headers;
    public REQUSET_METHOD requset_method;

    public Request(String url, String content, REQUSET_METHOD requset_method) {
        this.url = url;
        this.content = content;
        this.requset_method = requset_method;
    }

    public Request(String url, REQUSET_METHOD requset_method) {
        this.url = url;
        this.requset_method = requset_method;
    }
}
