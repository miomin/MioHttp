package scu.miomin.com.miohttplib.request;

import java.util.Map;

import scu.miomin.com.miohttplib.interf.IMioRequestListener;

/**
 * Created by 莫绪旻 on 16/3/7.
 */
public class MioRequest {

    //timeout后最多重试三次
    public int MaxReCount = 3;

    public IMioRequestListener iMioRequestListener;


    public enum REQUSET_METHOD {GET, POST, PUT, DELELE}

    public String url;
    public String content;
    public Map<String, String> headers;
    public REQUSET_METHOD requset_method;

    private String tag;

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

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void cancle() {

    }

    public boolean isCancle() {
        return false;
    }
}
