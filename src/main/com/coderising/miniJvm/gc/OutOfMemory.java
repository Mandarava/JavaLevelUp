package com.coderising.miniJvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zt
 * 2017/6/3 16:26
 */
public class OutOfMemory {

    public static void main(String[] args) {
        OutOfMemory outOfMemory = new OutOfMemory();
        outOfMemory.outOfMemoryHeapSpace();
        outOfMemory.outOfMemoryPermGenSpace();
    }

    public void outOfMemoryHeapSpace() {
        List<byte[]> tmpList = new ArrayList<>();
        while (true) {
            tmpList.add(new byte[1024 * 1024]);
        }
    }

    public void outOfMemoryPermGenSpace() {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
