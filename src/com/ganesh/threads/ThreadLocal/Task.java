package com.ganesh.threads.ThreadLocal;

public class Task {

  int id;
  private static ThreadLocal<Integer> threadLocalId = null;

  public Task(int id) {

    this.id = id;
    threadLocalId = new ThreadLocal<Integer>() {
      protected Integer initialValue() {
        return id;
      }
    };
  }

  public static Integer getThreadLocalId() {
    return threadLocalId.get();
  }

  public static void setThreadLocalId(Integer id) {
    threadLocalId.set(id);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void threadSpecificTask() {
    System.out.println("method=threadSpecificTask of id=" + id + ",threadLocalId=" + threadLocalId.get());
  }
}
