package scu.miomin.com.miohttplib.request;

import java.util.ArrayList;

import scu.miomin.com.miohttplib.task.MioRequestTask;

/**
 * Created by miomin on 16/3/16.
 */
public class MioRequestManager {

    private static MioRequestManager instance;
    private ArrayList<MioRequest> requests;

    public static MioRequestManager getInstance() {
        if (instance == null) {
            instance = new MioRequestManager();
        }
        return instance;
    }

    public void performRequest(MioRequest request) {
        MioRequestTask task = new MioRequestTask(request);
        task.execute();
        requests.add(request);
    }

    public void cancelRequest(String tag) {

        if (tag == null || "".equals(tag.trim())) {
            return;
        }

        for (MioRequest mioRequest : requests) {
            if (mioRequest.getTag().equals(tag)) {
                mioRequest.cancle();
            }
        }
    }

    public void cancleAll() {

    }
}
