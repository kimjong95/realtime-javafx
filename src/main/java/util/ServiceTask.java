package util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ServiceTask extends Thread {
    //
    private static ExecutorService threadPool;
    private static final List<Executable> taskItems = new ArrayList<>();
    private static final String nameFormat = "ServiceTask-%s";
    private static ThreadFactory backingThreadFactory = Executors.defaultThreadFactory();

    static {
        final ThreadFactory threadFactory = runnable -> {
            Thread thread = backingThreadFactory.newThread(runnable);
            thread.setName(String.format(nameFormat, new AtomicLong(0)));
            thread.setDaemon(true);
            return thread;
        };

        threadPool = Executors.newFixedThreadPool(10, threadFactory);
    }

    private boolean background;
    private Executable executable;

    public ServiceTask(Executable executable, boolean background) {
        //
        this.executable = executable;
        this.background = background;
    }

    public static void shutdown() {
        try {
            threadPool.shutdown();
            threadPool.awaitTermination(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ignored) {
            //
        }
    }

    public static void runBackground(Executable executable) {
        //
        ServiceTask task = new ServiceTask(executable, true);
        runServiceTask(task);
    }

    private static void runServiceTask(ServiceTask task) {
        //
        if (Thread.currentThread().getName().startsWith("ServiceTask-")) {
            task.execute();
        }
    }

    private void execute() {
        //
        try {

            if (!background) {
                synchronized (taskItems) {
                    taskItems.add(executable);
                }
            }

            executable.execute();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

}
