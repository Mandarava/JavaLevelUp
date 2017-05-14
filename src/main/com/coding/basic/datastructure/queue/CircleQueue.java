package com.coding.basic.datastructure.queue;

/**
 * 用数组实现循环队列
 *
 * @author zt
 */
public class CircleQueue<E> {

    private static final int DEFAULT_SIZE = 10;
    private Object[] elementData = null;
    private int front = 0;
    private int rear = 0;

    public CircleQueue() {
        this(DEFAULT_SIZE);
    }

    public CircleQueue(int capacity) {
        elementData = new Object[capacity];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        // 只容纳capacity - 1个元素
        return (rear + 1) % elementData.length == front;
    }

    public int size() {
        return (rear - front + elementData.length) % elementData.length;
//        return Math.abs(rear - front);
    }

    public void enQueue(E data) {
        if (isFull()) {
            throw new RuntimeException("queue is full");
        }
        rear = (rear + 1) % elementData.length;
        elementData[rear] = data;
    }

    public E deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        front = (front + 1) % elementData.length;
        E data = (E) elementData[front];
        elementData[front] = null;
        return data;
    }

}
