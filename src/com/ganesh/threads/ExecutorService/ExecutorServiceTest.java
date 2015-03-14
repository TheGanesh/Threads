package com.ganesh.threads.ExecutorService;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by Ganesh on 3/13/15.
 */
public class ExecutorServiceTest {


    public static void main(String[] args) throws Exception {

        ThreadpoolTaskExecutor threadpoolExecutor = new ThreadpoolTaskExecutor();

        List<Callable<Job>> jobs = new ArrayList<Callable<Job>>();

        for (int i = 0; i < 100; i++) {
            jobs.add(new JobTask(i));

        }

        long startTime = System.currentTimeMillis();

        List<Job> result = threadpoolExecutor.executeInParallel(jobs);


        for (Job job : result) {
            System.out.println(job.getJobId());
        }
        System.out.println("jobs time took:" + (System.currentTimeMillis() - startTime));


        List<Callable<Jaffa>> jaffas = new ArrayList<Callable<Jaffa>>();

        for (int i = 0; i < 100; i++) {
            jaffas.add(new JaffaTask(i));

        }

        startTime = System.currentTimeMillis();

        List<Jaffa> results = threadpoolExecutor.executeInParallel(jaffas);


        for (Jaffa jaffa : results) {
            System.out.println(jaffa.getJaffaId());
        }

        System.out.println("jaffas time took:" + (System.currentTimeMillis() - startTime));


    }


}
