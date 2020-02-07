package com.mindera.school;

public class Main extends Thread {

    private FibonacciCalculator fibCalc = new FibonacciCalculator();
    private String x;
    private int n;


    public Main(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        this.x = fibCalc.fibonacciSequence(n);
    }

    public String getX() {
        return this.x;
    }
}
