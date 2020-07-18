public class Worker {
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    public interface OnTaskErrorListener {
        void onError(String result);
    }

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;


    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallback.onError("Error");
                break;
            }
            callback.onDone("Task " + i + " is done");
        }
    }
}