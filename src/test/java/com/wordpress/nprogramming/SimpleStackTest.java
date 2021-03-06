package com.wordpress.nprogramming;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class SimpleStackTest {
    private Stack<String> stack;

    @Before
    public void setUp() {
        stack = new SimpleStack<>();
    }

    @Test
    public void testEmptyStack() throws Exception {
        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void testPushAndPopOneValue() throws Exception {
        String value = "Value";
        stack.push(value);

        assertThat(stack.isEmpty(), is(false));
        assertThat(stack.pop(), is(value));
        assertThat(stack.isEmpty(), is(true));
    }

    @Test(expected = IllegalStateException.class)
    public void testPopOnEmptyStack() throws Exception {
        stack.pop();
    }

    @Test
    public void testPutValuesAndCheckIfReceivedLIFO() throws Exception {
        String first = "First";
        String second = "Second";

        stack.push(first);
        stack.push(second);

        assertThat(stack.pop(), is(second));
        assertThat(stack.pop(), is(first));
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekTheEmptyStack() throws Exception {
        stack.peek();
    }

    @Test
    public void testPushAndPeekValue() throws Exception {
        String value = "Value";
        stack.push(value);

        assertThat(stack.peek(), is(value));
        assertThat(stack.peek(), is(value));
    }
}
