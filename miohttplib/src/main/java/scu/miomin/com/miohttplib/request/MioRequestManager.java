package scu.miomin.com.miohttplib.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import scu.miomin.com.miohttplib.task.MioRequestTask;
import scu.miomin.com.miohttplib.zdownloadfile.MioMultiResumeDownTask;

/**
 * Created by miomin on 16/3/16.
 */
public class MioRequestManager {

    private static MioRequestManager instance;
    private HashMap<String, ArrayList<MioRequest>> requestMap;
    private HashMap<String, ArrayList<MioMultiResumeDownTask>> downtaskMap;

    public static MioRequestManager getInstance() {
        if (instance == null) {
            instance = new MioRequestManager();
        }
        return instance;
    }

    private MioRequestManager() {
        requestMap = new HashMap<>();
        downtaskMap = new HashMap<>();
    }

    // 执行普通的HTTP访问任务
    public void excuteRequest(MioRequest request) {
        MioRequestTask task = new MioRequestTask(request);
        task.execute();

        if (!requestMap.containsKey(request.getTag())) {
            ArrayList<MioRequest> requests = new ArrayList<>();
            requestMap.put(request.getTag(), requests);
        }
        requestMap.get(request.getTag()).add(request);
    }

    // 执行文件下载任务
    public void excuteDownTask(MioMultiResumeDownTask task) {
        if (!downtaskMap.containsKey(task.getTag())) {
            ArrayList<MioMultiResumeDownTask> downTasks = new ArrayList<>();
            downtaskMap.put(task.getTag(), downTasks);
        }
        downtaskMap.get(task.getTag()).add(task);
    }

    // 取消与tag的Activity相关的所有任务
    public void cancelRequest(String tag) {

        if (tag == null || "".equals(tag.trim())) {
            return;
        }

        if (requestMap.containsKey(tag)) {
            ArrayList<MioRequest> requests = requestMap.remove(tag);
            for (MioRequest mioRequest : requests) {
                if (!mioRequest.isCancle() && mioRequest.getTag().equals(tag)) {
                    mioRequest.cancle();
                }
            }
        }

        // 暂停与该activity关联的所有下载任务
        if (downtaskMap.containsKey(tag)) {
            ArrayList<MioMultiResumeDownTask> downTasks = downtaskMap.remove(tag);
            for (MioMultiResumeDownTask downTask : downTasks) {
                if (!downTask.isDownloading() && downTask.getTag().equals(tag)) {
                    downTask.resumeDownload();
                }
            }
        }
    }

    // 取消进程中的所有下载和访问任务
    public void cancleAll() {

        for (Map.Entry<String, ArrayList<MioRequest>> entry : requestMap.entrySet()) {
            ArrayList<MioRequest> requests = entry.getValue();
            for (MioRequest mioRequest : requests) {
                if (!mioRequest.isCancle()) {
                    mioRequest.cancle();
                }
            }
        }

        for (Map.Entry<String, ArrayList<MioMultiResumeDownTask>> entry : downtaskMap.entrySet()) {
            ArrayList<MioMultiResumeDownTask> downTasks = entry.getValue();
            for (MioMultiResumeDownTask downTask : downTasks) {
                if (!downTask.isDownloading()) {
                    downTask.resumeDownload();
                }
            }
        }
    }
}
