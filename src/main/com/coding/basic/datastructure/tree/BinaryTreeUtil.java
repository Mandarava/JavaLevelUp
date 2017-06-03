package com.coding.basic.datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeUtil {

    /**
     * 用递归的方式实现对二叉树的前序遍历<br>
     * 1.访问根节点<br>
     * 2.先序遍历左子树<br>
     * 3.先序遍历右子树<br>
     */
    public static <T extends Comparable<T>> List<T> preOrderVisit(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    /**
     * 用递归的方式实现对二叉树的中序遍历<br>
     * 二叉查找树输出的数从小到大排列<br>
     * 1.中序遍历左子树<br>
     * 2.访问根节点<br>
     * 3.中序遍历右子树<br>
     */
    public static <T extends Comparable<T>> List<T> inOrderVisit(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    /**
     * 用递归的方式实现对二叉树的后序遍历<br>
     * 1.后序遍历左子树<br>
     * 2.后序遍历右子树<br>
     * 3.访问根节点<br>
     */
    public static <T extends Comparable<T>> List<T> postOrderVisit(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private static <T extends Comparable<T>> void preOrder(BinaryTreeNode<T> root, List<T> result) {
        if (root == null) {
            return;
        }
        result.add(root.getData());
        preOrder(root.getLeft(), result);
        preOrder(root.getRight(), result);
    }

    private static <T extends Comparable<T>> void inOrder(BinaryTreeNode<T> root, List<T> result) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft(), result);
        result.add(root.getData());
        inOrder(root.getRight(), result);
    }

    private static <T extends Comparable<T>> void postOrder(BinaryTreeNode<T> root, List<T> result) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft(), result);
        postOrder(root.getRight(), result);
        result.add(root.getData());
    }

    /**
     * 用非递归的方式实现对二叉树的前序遍历<br>
     * 1.访问根节点<br>
     * 2.先序遍历左子树<br>
     * 3.先序遍历右子树<br>
     */
    public static <T extends Comparable<T>> List<T> preOrderWithoutRecursion(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode<T> node = stack.pop();
            result.add(node.getData());
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
        return result;
    }

    /**
     * 用非递归的方式实现对二叉树的中序遍历<br>
     * 1.中序遍历左子树<br>
     * 2.访问根节点<br>
     * 3.中序遍历右子树<br>
     */
    public static <T extends Comparable<T>> List<T> inOrderWithoutRecursion(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.getLeft();
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                result.add(p.getData());
                p = p.getRight();
            }
        }
        return result;
    }

}
