package com.ganesh.threads.ExecutorService;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by Ganesh on 3/13/15.
 */
public class ExecutorServiceTest {

    private static int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        List<Callable<Job>> callables = new ArrayList<Callable<Job>>();


        for (int i = 0; i < 6; i++) {
            callables.add(new Task(i));

        }

        long startTime = System.currentTimeMillis();
        List<Job> result = new ArrayList<Job>();

        try {

            for (int i = 0; i < callables.size(); i += THREAD_POOL_SIZE) {

                List<Future<Job>> futures = executorService.invokeAll(callables.subList(i, i + THREAD_POOL_SIZE));

                for (Future<Job> future : futures) {
                    result.add(future.get());
                }

                System.out.println("completed "+THREAD_POOL_SIZE+" tasks.");

            }
        } catch (Exception ex) {
            throw new RuntimeException();
        }


        executorService.shutdown();

        Collections.sort(result);

        for (Job job : result) {
            System.out.println(job.getJobId());
        }
        System.out.println("time took:" + (System.currentTimeMillis() - startTime));


    }
}
