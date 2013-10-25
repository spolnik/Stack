package com.wordpress.nprogramming;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleQueueTest {
    private Queue<String> queue;

    @Before
    public void setUp() {
        queue = new SimpleQueue<>();
    }

    @Test
    public void testEmptyQueue() throws Exception {
        assertThat(queue.isEmpty(), is(true));
    }

    @Test(expected = IllegalStateException.class)
    public void testDequeueEmptyQueue() throws Exception {
        queue.dequeue();
    }

    @Test
     public void testQueueWithOneItem() throws Exception {
        String value = "Value";
        queue.enqueue(value);
        String item = queue.dequeue();
        assertThat(item, is(value));
    }

    @Test
    public void testPeekItem() throws Exception {
        String value = "Value";
        queue.enqueue(value);

        assertThat(queue.peek(), is(value));
        assertThat(queue.peek(), is(value));
    }

    @Test
    public void testQueueIsWorkingInFIFO() throws Exception {
        String first = "First";
        String second = "Second";

        queue.enqueue(first);
        queue.enqueue(second);

        assertThat(queue.dequeue(), is(first));
        assertThat(queue.dequeue(), is(second));
    }
}
