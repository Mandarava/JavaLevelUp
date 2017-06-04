package com.coding.basic.datastructure.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

    private BinaryTreeNode<T> root;

    public BinarySearchTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public T findMin() {
        return findMin(root);
    }

    public T findMax() {
        return findMax(root);
    }

    public int height() {
        return height(root);
    }

    public int size() {
        return size(root);
    }

    public void remove(T e) {
        remove(e, root);
    }

    private T findMin(BinaryTreeNode<T> p) {
        if (p == null) {
            return null;
        } else if (p.getLeft() == null) {
            return p.getData();
        } else {
            return findMin(p.getLeft());
        }
    }

    private T findMax(BinaryTreeNode<T> p) {
        if (p == null) {
            return null;
        } else if (p.getRight() == null) {
            return p.getData();
        } else {
            return findMax(p.getRight());
        }
    }

    private int height(BinaryTreeNode<T> p) {
        if (p == null) {
            return 0;
        } else {
            int leftChildHeight = height(p.getLeft());
            int rightChildHeight = height(p.getRight());
            if (leftChildHeight > rightChildHeight) {
                return leftChildHeight + 1;
            } else {
                return rightChildHeight + 1;
            }
        }
    }

    private int size(BinaryTreeNode<T> p) {
        if (p == null) {
            return 0;
        }
        return size(p.getLeft()) + 1 + size(p.getRight());
    }

    private BinaryTreeNode<T> remove(T x, BinaryTreeNode<T> p) {
        if (p == null) {
            return p;
        }
        int compareResult = x.compareTo(p.getData());

        if (compareResult < 0) {
            p.setLeft(remove(x, p.getLeft()));
        } else if (compareResult > 0) {
            p.setRight(remove(x, p.getRight()));
        } else {
            if (p.getLeft() != null && p.getRight() != null) {
                p.setData(findMin(p.getRight()));
                p.setRight(remove(p.getData(), p.getRight()));
            } else {
                p = (p.getLeft() != null) ? p.getLeft() : p.getRight();
            }
        }
        return p;
    }

    /**
     * 按层次遍历 BFS
     */
    public List<T> levelVisit() {
        if (root == null) {
            return null;
        }
        List<T> result = new ArrayList<>();
        Queue<BinaryTreeNode<T>> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> node = queue.poll();
            result.add(node.getData());
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }
        return result;
    }

    /**
     * 获得所有的叶子节点
     */
    public List<T> getLeaves() {
        if (root == null) {
            return null;
        }
        List<T> result = new ArrayList<>();
        getLeaves(root, result);
        return result;
    }

    private void getLeaves(BinaryTreeNode<T> root, List<T> result) {
        if (root.getLeft() == null && root.getRight() == null) {
            result.add(root.getData());
            return;
        }
        getLeaves(root.getLeft(), result);
        getLeaves(root.getRight(), result);
    }


    /**
     * 获得叶子节点的搜索路径
     */
    public List<List<T>> getLeavesPath() {
        if (root == null) {
            return null;
        }
        List<List<T>> routes = new ArrayList<>();
        getLeavesPath(root, routes, new ArrayList<>());
        return routes;
    }

    private void getLeavesPath(BinaryTreeNode<T> root, List<List<T>> result, List<T> tempList) {
        tempList.add(root.getData());
        if (root.getLeft() == null && root.getRight() == null) {
            result.add(tempList);
            return;
        }
        getLeavesPath(root.getLeft(), result, new ArrayList<>(tempList));
        getLeavesPath(root.getRight(), result, new ArrayList<>(tempList));
    }

    /**
     * 判断一个二叉树是不是二叉查找树<br>
     * 二叉查找树中序遍历的结果按升序排序
     */
    public boolean isValidBST() {
        List<T> result = BinaryTreeUtil.inOrderVisit(root);
        if (result == null || result.size() == 0) {
            return true;
        }
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i).compareTo(result.get(i + 1)) >= 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 获取两个节点的最小公共祖先
     */
    public T getLowestCommonAncestor(T n1, T n2) {
        if (root == null) {
            return null;
        }
        return lowestCommonAncestor(root, n1, n2);
    }

    private T lowestCommonAncestor(BinaryTreeNode<T> node, T n1, T n2) {
        if (node == null) {
            return null;
        }
        // 如果n1和n2都比node的值小，LCA在左孩子
        if (node.getData().compareTo(n1) > 0 && node.getData().compareTo(n2) > 0) {
            return lowestCommonAncestor(node.getLeft(), n1, n2);
        }
        // 如果n1和n2都比node的值大，LCA在右孩子
        if (node.getData().compareTo(n1) < 0 && node.getData().compareTo(n2) < 0) {
            return lowestCommonAncestor(node.getRight(), n1, n2);
        }
        return node.getData();
    }

    /**
     * 返回所有满足下列条件的节点的值：  n1 <= n <= n2 , n 为
     * 该二叉查找树中的某一节点
     */
    public List<T> getNodesBetween(T n1, T n2) {
        List<T> elements = new ArrayList<>();
        getNodesBetween(root, n1, n2, elements);
        return elements;
    }

    private void getNodesBetween(BinaryTreeNode<T> node, T n1, T n2, List<T> elements) {
        if (node == null) {
            return;
        }
        if (n1.compareTo(node.getData()) < 0) {
            getNodesBetween(node.getLeft(), n1, n2, elements);
        }
        if (n1.compareTo(node.getData()) <= 0 && n2.compareTo(node.getData()) >= 0) {
            elements.add(node.getData());
        }
        if (n2.compareTo(node.getData()) > 0) {
            getNodesBetween(node.getRight(), n1, n2, elements);
        }
    }

}

