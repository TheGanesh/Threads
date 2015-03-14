package com.ganesh.threads.ExecutorService;

import java.util.concurrent.Callable;

/**
 * Created by Ganesh on 3/14/15.
 */
public class JaffaTask implements Callable<Jaffa> {

    private int id;

    public JaffaTask(int id) {
        this.id = id;
    }

    @Override
    public Jaffa call() throws Exception {

        Thread.sleep(1000 - id);
        System.out.println(Thread.currentThread().getName() + " jaffa running:" + id);

        return new Jaffa(id);
    }

}
