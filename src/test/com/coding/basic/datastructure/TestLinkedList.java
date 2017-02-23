package com.coding.basic.datastructure;

import org.junit.Test;

/**
 * Created by zt on 2017/2/19.
 */
public class TestLinkedList {

    @Test
    public void testAdd() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.add(0, -1);
        list.remove(1);
        list.removeLast();
        list.addFirst(999);
        list.removeFirst();
        System.out.println("list size : " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        java.util.LinkedList list1 = new java.util.LinkedList();
        list1.add(0, 2);
        System.out.print(list1.get(0));
    }

    @Test
    public void testStack() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.pop();
        System.out.println(stack.size());
        Object obj = stack.peek();
    }

    @Test
    public void testQueue() {
        Queue queue = new Queue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        Object object = queue.deQueue();
        System.out.println("dqueue object : " + object);
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
    }
}
