package scu.miomin.com.miohttplib.parse;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by miomin on 16/3/15.
 */
public abstract class JsonRequestListener<T> extends MioAbstractParseListener<T> {

    private String rootKey;

    // json字符串最外层的key是result还是data之类的字符串，传进来才能解析
    public JsonRequestListener setRootKey(String rootKey) {
        this.rootKey = rootKey;
        return this;
    }

    @Override
    protected T bindData(String result) throws JSONException {
        JSONObject json = new JSONObject(result);
        JSONObject data = json.optJSONObject(rootKey);
        Gson gson = new Gson();
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return gson.fromJson(data.toString(), type);
    }
}
