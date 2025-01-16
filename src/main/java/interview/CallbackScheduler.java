package interview;

import lombok.Builder;
import lombok.Value;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Класс CallbackSchedulerImpl планирует исполнение Runnable в заданный момент времени.
 * Задачи хранятся в приоритетной очереди и обрабатываются отдельным потоком.
 */
public class CallbackScheduler {

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final BlockingQueue<InstantRunnable> queue = new PriorityBlockingQueue<>();

    public CallbackScheduler() {
        Thread workerThread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    InstantRunnable task = queue.take();
                    long delay = Duration.between(Instant.now(), task.getInstant()).toMillis();
                    if (delay > 0) {
                        Thread.sleep(delay);
                    }
                    scheduler.execute(task.getRunnable());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        workerThread.start();
    }

    public void schedule(Runnable callback, Instant when) {
        queue.add(InstantRunnable.builder().instant(when).runnable(callback).build());
    }

    @Value
    @Builder
    public static class InstantRunnable implements Comparable<InstantRunnable> {
        Instant instant;
        Runnable runnable;

        @Override
        public int compareTo(InstantRunnable o) {
            return instant.compareTo(o.getInstant());
        }
    }

    @Test
    void testSimple() throws InterruptedException {
        CallbackScheduler callbackScheduler = new CallbackScheduler();
        final CountDownLatch callbackExecuted = new CountDownLatch(1);
        callbackScheduler.schedule(callbackExecuted::countDown, Instant.now().plusSeconds(2));

        if (!callbackExecuted.await(4, TimeUnit.SECONDS)) {
            fail("Timeout exceeded");
        }
    }

    @Test
    void testPastTime() throws InterruptedException {
        CallbackScheduler callbackScheduler = new CallbackScheduler();
        CountDownLatch latch = new CountDownLatch(1);
        callbackScheduler.schedule(latch::countDown, Instant.now().minusSeconds(10));

        if (!latch.await(100, TimeUnit.MILLISECONDS)) {
            fail("Timeout exceeded");
        }
    }


    @Test
    void testImmediateExecution() throws InterruptedException {
        CallbackScheduler callbackScheduler = new CallbackScheduler();
        CountDownLatch latch = new CountDownLatch(1);
        callbackScheduler.schedule(latch::countDown, Instant.now()); // время "сейчас"

        if (!latch.await(2, TimeUnit.SECONDS)) {
            fail("Timeout exceeded");
        }
    }
}