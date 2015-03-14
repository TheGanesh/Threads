package com.ganesh.threads.ExecutorService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ganesh on 3/13/15.
 */
public class Main {

    private static int THREAD_POOL_SIZE = 11;

    public static void main(String[] args) throws Exception {

        List<String> sourceList = new ArrayList<String>();

        List<String> destList = new ArrayList<String>();

        for (int i = 0; i < 100; i++) {
            sourceList.add("sample:" + i);
        }

        for (int fromIndex = 0; fromIndex < sourceList.size(); fromIndex += THREAD_POOL_SIZE) {

            int toIndex = fromIndex + THREAD_POOL_SIZE;

            if (toIndex > sourceList.size()) {
                toIndex = sourceList.size();
            }
            destList.addAll(sourceList.subList(fromIndex, toIndex));
        }

        for (String entry : destList) {
            System.out.println(entry);
        }


    }
}
