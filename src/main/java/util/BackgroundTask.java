package util;

import java.util.ArrayList;
import java.util.List;

/**
 * BackgroundTask
 *
 * @author <a href="mailto:mhjang@nextree.co.kr">Jang, Mihyeon</a>
 * @since 2018. 12. 11.
 */
public class BackgroundTask extends Thread {
    //
    private static final List<BackgroundTask> backgroundTasks = new ArrayList<>();

    private Executable executable;
    private Executable completedCallback;

    public BackgroundTask(Executable executable) {
        //
        this.setName(this.getClass().getSimpleName());
        this.setDaemon(true);
        this.executable = executable;
    }

    public static void runBackground(Executable executable) {
        //
        runBackground(executable, null);
    }

    public static void runBackground(Executable executable, Executable completedCallback) {
        //
        BackgroundTask task = new BackgroundTask(executable);
        task.setCompletedCallback(completedCallback);
        backgroundTasks.add(task);
        task.execute();
    }

    public static void stopAllTask() {
        //
        for (BackgroundTask task : backgroundTasks) {
            task.cancel();
        }
    }

    private void execute() {
        //
        executable.execute();

        if (completedCallback != null) {
            completedCallback.execute();
        }

    }

    private void cancel() {
        //
        this.interrupt();
    }

    private void setCompletedCallback(Executable completedCallback) {
        this.completedCallback = completedCallback;
    }

}
