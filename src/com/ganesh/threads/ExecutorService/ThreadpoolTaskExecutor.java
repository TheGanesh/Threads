package com.ganesh.threads.ExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Ganesh on 3/14/15.
 */
public class ThreadpoolTaskExecutor {

    private static int CONCURRANCY_LIMIT = 11;

    public <T> List<T> executeInParallel(List<Callable<T>> parallelTasks)

    {

        ExecutorService executorService = Executors.newFixedThreadPool(CONCURRANCY_LIMIT);


        List<T> result = new ArrayList<T>();

        try {


            for (int fromIndex = 0; fromIndex < parallelTasks.size(); fromIndex += CONCURRANCY_LIMIT) {


                int toIndex = fromIndex + CONCURRANCY_LIMIT;

                if (toIndex > parallelTasks.size()) {
                    toIndex = parallelTasks.size();
                }

                List<Future<T>> futures = executorService.invokeAll(parallelTasks.subList(fromIndex, toIndex));

                for (Future<T> future : futures) {
                    result.add(future.get());
                }

                System.out.println("completed " + CONCURRANCY_LIMIT + " tasks.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            executorService.shutdownNow();
            throw new RuntimeException();
        }


        executorService.shutdown();

        //  Collections.sort(result);

        return result;

    }

}
