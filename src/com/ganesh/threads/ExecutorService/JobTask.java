package com.ganesh.threads.ExecutorService;

import java.util.concurrent.Callable;

/**
 * Created by Ganesh on 3/13/15.
 */
public class JobTask implements Callable<Job> {


    private int id;

    public JobTask(int id) {
        this.id = id;
    }

    @Override
    public Job call() throws Exception {

            Thread.sleep(1000 - id);
//            if (id % 2 == 0) {
//                throw new RuntimeException();
//            }
            System.out.println(Thread.currentThread().getName()+" job running:" + id);

            return new Job(id);
    }


}
