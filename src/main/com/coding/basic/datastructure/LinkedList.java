package com.coding.basic.datastructure;

/**
 * Created by zt on 2017/2/19.
 */
public class LinkedList implements List {

    private Node head;

    private Node tail;

    private int size = 0;

    public LinkedList() {

    }

    /**
     * 假定当前链表和list均包含已升序排列的整数
     * 从当前链表中取出那些list所指定的元素
     * 例如当前链表 = 11->101->201->301->401->501->601->701
     * listB = 1->3->4->6
     * 返回的结果应该是[101,301,401,601]
     */
    public static int[] getElements(LinkedList list) {
        return null;
    }

      /*@Override
    public void add(Object object) {
        if (null == head) {
            head = new Node(object);
            head.next = null;
        } else {
            // 头插法
            Node nextNode = new Node(object);
            nextNode.next = head.next;
            head.next = nextNode;
        }
    }*/

    @Override
    public void add(Object object) {
        if (null == head) {
            head = new Node(object);
            head.next = null;
            tail = head;
            size++;
        } else {
            // 尾插法
            Node newNode = new Node(object);
            tail.next = newNode;
            tail = newNode;
            tail.next = null;
            size++;
        }
    }

    @Override
    public void add(int index, Object object) {
        checkRange(index);
        if (null == head) {
            add(object);
            return;
        }
        if (index == 0) {
            addFirst(object);
            return;
        }
        Node pre = node(index - 1);
        Node newNode = new Node(object);
        newNode.next = pre.next;
        pre.next = newNode;
        size++;
    }

    @Override
    public Object get(int index) {
        checkRange(index);
        checkNodeNotNull();
        Node node = node(index);
        return node.data;
    }

    @Override
    public Object remove(int index) {
        checkRange(index);
        checkNodeNotNull();
        Object object;
        if (index == 0) {
            object = removeFirst();
            return object;
        }
        Node pre = node(index - 1);
        object = pre.next.data;
        pre.next = pre.next.next;
        size--;
        return object;
    }

    @Override
    public int size() {
        return size;
    }

    public void addFirst(Object object) {
        if (null == head) {
            head = new Node(object);
            head.next = null;
            size++;
        } else {
            Node firstNode = new Node(object);
            firstNode.next = head;
            head = firstNode;
            size++;
        }
    }

    public Object removeFirst() {
        checkNodeNotNull();
        Object oldValue = head.data;
        head = head.next;
        size--;
        return oldValue;
    }

    public Object removeLast() {
        checkNodeNotNull();
        Object oldValue;
        if (size == 1) {
            oldValue = head.data;
            head = null;
            return oldValue;
        }
        Node pre = node(size() - 2);
        oldValue = pre.next.data;
        pre.next = null;
        size--;
        return oldValue;
    }

    private void checkRange(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkNodeNotNull() {
        if (null == head) {
            throw new NullPointerException();
        }
    }

    private Node node(int index) {
        checkRange(index);
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void reverse() {
        checkNodeNotNull();

        Node temp = head.next;
        // 指向原head位置,基准节点
        Node pivot = head;
        while (pivot.next != null) {
            Node p = temp.next;
            temp.next = head;
            pivot.next = p;
            head = temp;
            temp = p;
        }
    }

    /**
     * 删除一个单链表的前半部分
     * 例如：list = 2->5->7->8 , 删除以后的值为 7->8
     * 如果list = 2->5->7->8->10 ,删除以后的值为7,8,10
     */
    public void removeFirstHalf() {
        for (int i = 1; i <= size / 2; i++) {
            removeFirst();
        }
    }

    /**
     * 从第i个元素开始， 删除length 个元素 ， 注意i从0开始
     */
    public void remove(int i, int length) {
        if (i == 0) {
            for (int j = 0; j < length; j++) {
                removeFirst();
            }
        } else {
            Node pre = node(i - 1);
            for (int j = 0; j < length; j++) {
                pre.next = pre.next.next;
                size--;
            }
        }
    }

    /**
     * 已知链表中的元素以值递增有序排列，并以单链表作存储结构。
     * 从当前链表中中删除在list中出现的元素
     */
    public void subtract(LinkedList list) {

    }

    /**
     * 已知当前链表中的元素以值递增有序排列，并以单链表作存储结构。
     * 删除表中所有值相同的多余元素（使得操作后的线性表中所有元素的值均不相同）
     */
    public void removeDuplicateValues() {

    }

    /**
     * 已知链表中的元素以值递增有序排列，并以单链表作存储结构。
     * 试写一高效的算法，删除表中所有值大于min且小于max的元素（若表中存在这样的元素）
     */
    public void removeRange(int min, int max) {

    }

    /**
     * 假设当前链表和参数list指定的链表均以元素依值递增有序排列（同一表中的元素值各不相同）
     * 现要求生成新链表C，其元素为当前链表和list中元素的交集，且表C中的元素有依值递增有序排列
     */
    public LinkedList intersection(LinkedList list) {
        return null;
    }

    private static class Node {
        Node next;
        private Object data;

        public Node() {

        }

        public Node(Object data) {
            this.data = data;
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Object data, Node next, Node prev) {
            this.data = data;
            this.next = next;
        }
    }

}
