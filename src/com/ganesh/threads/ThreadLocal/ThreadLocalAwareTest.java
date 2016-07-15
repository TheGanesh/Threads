package com.ganesh.threads.ThreadLocal;

public class ThreadLocalAwareTest {

  final ThreadLocalAwarePoolExecutor threadLocalAwarePoolExecutor;

  ThreadLocalAwareTest() {
    threadLocalAwarePoolExecutor = new ThreadLocalAwarePoolExecutor();
  }

  public void doSomething1(Task task) {
    threadLocalAwarePoolExecutor.execute(new Runnable() {
      @Override
      public void run() {
        task.threadSpecificTask();
      }
    });
  }

  public static void main(String[] args) {
    Task task = new Task(1);
    task.threadSpecificTask();
    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

    ThreadLocalAwareTest threadLocalAwareTest = new ThreadLocalAwareTest();
    threadLocalAwareTest.doSomething1(task);
    threadLocalAwareTest.doSomething1(task);
    threadLocalAwareTest.doSomething1(task);
  }

}
