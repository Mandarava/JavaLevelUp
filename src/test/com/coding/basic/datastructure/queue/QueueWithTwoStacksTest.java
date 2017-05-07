package com.coding.basic.datastructure.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zt
 * 2017/5/7 21:03
 */
public class QueueWithTwoStacksTest {

    @Test
    public void deQueue() throws Exception {
        QueueWithTwoStacks<Integer> queueWithTwoStacks = new QueueWithTwoStacks();
        queueWithTwoStacks.enQueue(1);
        queueWithTwoStacks.enQueue(5);
        queueWithTwoStacks.enQueue(7);
        Assert.assertEquals(new Integer(1), queueWithTwoStacks.deQueue());
        Assert.assertEquals(new Integer(5), queueWithTwoStacks.deQueue());
        Assert.assertEquals(false, queueWithTwoStacks.isEmpty());
        queueWithTwoStacks.enQueue(10);
        Assert.assertEquals(2, queueWithTwoStacks.size());
        Assert.assertEquals(new Integer(7), queueWithTwoStacks.deQueue());
        Assert.assertEquals(new Integer(10), queueWithTwoStacks.deQueue());
        Assert.assertEquals(true, queueWithTwoStacks.isEmpty());
    }

}