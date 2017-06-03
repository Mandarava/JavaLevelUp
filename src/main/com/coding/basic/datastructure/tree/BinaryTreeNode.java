package com.coding.basic.datastructure.tree;

public class BinaryTreeNode<T extends Comparable<T>> {

    private T data;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public BinaryTreeNode<T> insert(T o) {
        BinaryTreeNode<T> newBinaryTreeNode = new BinaryTreeNode<>(o);
        BinaryTreeNode<T> parentNode = this.getParentNode(this, o);
        int compareResult = o.compareTo(parentNode.data);
        if (compareResult < 0) {
            parentNode.setLeft(newBinaryTreeNode);
        } else if (compareResult > 0) {
            parentNode.setRight(newBinaryTreeNode);
        } else {
            return this;
        }
        return newBinaryTreeNode;
    }


    private BinaryTreeNode<T> getParentNode(BinaryTreeNode<T> parentNode, T o) {
        if (o.compareTo(parentNode.data) < 0) {
            if (parentNode.getLeft() == null) {
                return parentNode;
            } else {
                return getParentNode(parentNode.getLeft(), o);
            }
        } else {
            if (parentNode.getRight() == null) {
                return parentNode;
            } else {
                return getParentNode(parentNode.getRight(), o);
            }
        }
    }

}
