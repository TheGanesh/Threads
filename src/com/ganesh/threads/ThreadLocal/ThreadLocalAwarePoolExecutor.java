package com.ganesh.threads.ThreadLocal;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalAwarePoolExecutor extends ThreadPoolExecutor {

  /**
   * https://www.securecoding.cert.org/confluence/display/java/TPS04-J.+Ensure+ThreadLocal+variables+are+reinitialized+when+using+thread+pools
   */
  public ThreadLocalAwarePoolExecutor() {
    super(1, 3, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
  }

  @Override
  protected void beforeExecute(final Thread t, final Runnable r) {
    System.out.println("method=beforeExecute");
  }

  @Override
  protected void afterExecute(Runnable r, Throwable t) {
    System.out.println("method=afterExecute");
  }
}
