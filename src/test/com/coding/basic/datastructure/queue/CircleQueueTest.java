package com.coding.basic.datastructure.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zt
 * 2017/5/8 21:54
 */
public class CircleQueueTest {

    @Test
    public void test() throws Exception {
        CircleQueue<String> queue = new CircleQueue<>(4);
        Assert.assertTrue(queue.isEmpty());
        queue.enQueue("a");
        queue.enQueue("b");
        queue.enQueue("c");
        Assert.assertFalse(queue.isEmpty());
        Assert.assertTrue(queue.isFull());
        Assert.assertEquals(3, queue.size());
        Assert.assertEquals("a", queue.deQueue());
        Assert.assertEquals("b", queue.deQueue());
        Assert.assertEquals("c", queue.deQueue());
        queue.enQueue("d");
        queue.enQueue("e");
        queue.enQueue("f");
        Assert.assertEquals("d", queue.deQueue());
        Assert.assertEquals("e", queue.deQueue());
        Assert.assertEquals("f", queue.deQueue());
        Assert.assertTrue(queue.isEmpty());
    }

}