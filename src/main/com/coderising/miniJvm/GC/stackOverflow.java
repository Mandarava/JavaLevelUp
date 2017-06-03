package com.coderising.miniJvm.GC;

/**
 * Created by zt
 * 2017/6/3 16:24
 */
public class stackOverflow {

    public static void main(String[] args) {
        stackOverflow stackOverflow = new stackOverflow();
        stackOverflow.stackOverflowTest();
    }

    public void stackOverflowTest() {
        stackOverflowTest();
    }
}
