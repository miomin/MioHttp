package scu.miomin.com.miohttplib.parse;

import scu.miomin.com.miohttplib.parse.MioAbstractParseListener;

/**
 * Created by miomin on 16/3/15.
 */
public abstract class XmlRequestListener<T> extends MioAbstractParseListener<T> {

    @Override
    protected T bindData(String result) {
        return null;
    }
}
