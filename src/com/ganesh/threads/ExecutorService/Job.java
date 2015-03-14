package com.ganesh.threads.ExecutorService;

/**
 * Created by Ganesh on 3/13/15.
 */
public class Job implements Comparable<Job> {

    private int jobId;

    public Job(int jobId) {
        this.jobId = jobId;
    }


    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Override
    public int compareTo(Job job) {

        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if (this == job) {
            return EQUAL;
        }


        if (this.jobId == job.getJobId()) {
            return EQUAL;
        } else if (this.jobId < job.getJobId()) {
            return BEFORE;
        } else if (this.jobId > job.getJobId()) {
            return AFTER;
        }
        return EQUAL;

    }
}
