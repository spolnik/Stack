package com.wordpress.nprogramming;

public interface Stack<E> {
    void push(E value);
    E pop();
    E peek();
    boolean isEmpty();
}

