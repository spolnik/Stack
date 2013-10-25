package com.wordpress.nprogramming;

public interface Queue<E> {
    void enqueue(E value);
    E dequeue();
    E peek();
    boolean isEmpty();
}
