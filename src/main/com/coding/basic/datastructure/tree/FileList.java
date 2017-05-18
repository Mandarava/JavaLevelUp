package com.coding.basic.datastructure.tree;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileList {

    public void list(File f) {
        MultiTree multiTree = new MultiTree(f);
        listFiles(f, multiTree);
    }

    private void listFiles(File f, MultiTree tree) {
        File[] files = f.listFiles();
        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                if (tree.getMultiTree() == null) {
                    tree.setMultiTree(new ArrayList<>());
                }
                MultiTree<File> multiTree = new MultiTree<>(file);
                tree.getMultiTree().add(multiTree);
                if (file.isDirectory()) {
                    listFiles(file, multiTree);
                }
            }
        }
    }

    class MultiTree<T> {

        private T data;

        private List<MultiTree> multiTree;

        public MultiTree(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public List<MultiTree> getMultiTree() {
            return multiTree;
        }

        public void setMultiTree(List<MultiTree> multiTree) {
            this.multiTree = multiTree;
        }
    }

}
