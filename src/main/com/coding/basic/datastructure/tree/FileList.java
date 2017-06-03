package com.coding.basic.datastructure.tree;

import java.io.File;

public class FileList {

    public void list(File f) {
        list(f, 0);
    }

    private void list(File f, int depth) {
        printName(f, depth);
        if (f.isDirectory()) {
            File[] files = f.listFiles();
            for (File file : files) {
                list(file, depth + 1);
            }
        }
    }

    private void printName(File file, int depth) {
        String name = file.getName();
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        if (file.isDirectory()) {
            System.out.println("Dir: " + name);
        } else {
            System.out.println(file.getName());
        }
    }

}
