package scu.miomin.com.miohttplib.parse;

/**
 * Created by 莫绪旻 on 16/3/15.
 */
public abstract class StringRequestListener extends MioAbstractParseListener<String> {

    @Override
    protected String bindData(String result) {
        return result;
    }
}
