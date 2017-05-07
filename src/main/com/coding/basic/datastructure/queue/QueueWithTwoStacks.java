package com.coding.basic.datastructure.queue;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列
 *
 * @author zt
 */
public class QueueWithTwoStacks<E> {

    private Stack<E> stack1;
    private Stack<E> stack2;

    public QueueWithTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int size() {
        return stack1.isEmpty() ? stack2.size() : stack1.size();
    }

    public void enQueue(E item) {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            stack1.push(item);
            return;
        }
        if (!stack1.isEmpty()) {
            stack1.push(item);
            return;
        }
        if (!stack2.isEmpty()) {
            while (stack2.size() > 0) {
                stack1.push(stack2.pop());
            }
            stack1.push(item);
            return;
        }
    }

    public E deQueue() {
        E data = null;
        if (!stack1.isEmpty()) {
            while (stack1.size() > 1) {
                stack2.push(stack1.pop());
            }
            data = stack1.pop();
        } else if (!stack2.isEmpty()) {
            data = stack2.pop();
        }
        return data;
    }

}

