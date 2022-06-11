package thread;

import java.util.concurrent.*;

/**
 * @author 咕噜科
 * ClassName: ThreadTest
 * date: 2022-06-11 14:52
 * Description: 测试Future和FutureTask
 * version 1.0
 */
public class ThreadTest {

    /*Future*/
    /*public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> future = executorService.submit(new Task());
        Integer integer = future.get();
        System.out.println(integer);
        executorService.shutdown();
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("子线程开始计算");
            int sum = 0;
            for (int i = 0; i <= 100; i++) {
                sum += i;
            }
            return sum;
        }
    }*/

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        FutureTask<Integer> futureTask = new FutureTask<>(new Task());
        executorService.submit(futureTask);
        Integer integer = futureTask.get();
        System.out.println(integer);
        executorService.shutdown();
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("子线程开始计算");
            int sum = 0;
            for (int i = 0; i <= 100; i++) {
                sum += i;
            }
            return sum;
        }
    }
    

}
