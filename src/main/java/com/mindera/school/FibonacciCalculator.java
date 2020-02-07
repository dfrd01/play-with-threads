package com.mindera.school;

import java.util.ArrayList;
import java.util.List;

/**
 * Used to calculate the Fibonacci sequence
 * <p>
 * https://en.wikipedia.org/wiki/Fibonacci_number
 */
public class FibonacciCalculator {

    /**
     * Calculates n entries of the fibonacci sequence
     * <p>
     * In mathematics, the Fibonacci numbers, commonly denoted Fn, form a sequence, called the Fibonacci sequence,
     * such that each number is the sum of the two preceding ones, starting from 0 and 1
     * <p>
     * eg: 0,1,1,2,3,5,8,13,21,34,55,89,144
     *
     * @return
     */
    public String fibonacciSequence(final Integer n) {
        ArrayList<Integer> result = new ArrayList<>();
        int firstNo = 0;
        int secondNo = 1;
        StringBuilder fibSeq = new StringBuilder();
        fibSeq.append("0");

        do {
            result.add(secondNo);
            secondNo = secondNo + firstNo;
            firstNo = secondNo - firstNo;
        } while (secondNo < n);

        for (int j = 0; j < result.size() ; j++) {
            fibSeq.append(",").append(result.get(j));

        }
        return fibSeq.toString();
    }

    /**
     * Calculates n entries of the fibonacci sequence for each entry in the list
     */
    public List<String> sequences(List<Integer> entries) throws InterruptedException {
        // TODO you should use threads for this
        List<String> fibResultSet = new ArrayList<>();
        List<Main> threads = new ArrayList<>();

        for (int i = 0; i < entries.size(); i++) {
            Main main = new Main(entries.get(i));
            main.start();
            threads.add(main);
        }

        for(int j = 0; j < threads.size(); j++){
            threads.get(j).join();
            fibResultSet.add(threads.get(j).getX());
        }

        return fibResultSet;

    }
}
