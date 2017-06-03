package com.coderising.miniJvm.gc;

/**
 * Created by zt
 * 2017/6/3 16:24
 */
public class StackOverflow {

    public static void main(String[] args) {
        StackOverflow stackOverflow = new StackOverflow();
        stackOverflow.stackOverflowError();
    }

    public void stackOverflowError() {
        stackOverflowError();
    }
}
