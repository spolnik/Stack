package com.wordpress.nprogramming;

public class SimpleQueue<E> implements Queue<E> {
    private Node<E> first;
    private Node<E> last;

    @Override
    public void enqueue(E value) {
        if (isEmpty()) {
            first = new Node<>(value);
            last = first;
            return;
        }

        Node<E> begin = new Node<>(value);
        begin.next = first;
        first.prev = begin;
        first = begin;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        Node<E> n = last;

        if (first == last) {
            first = last = null;
            return n.data;
        }

        last = last.prev;
        last.next = null;
        return n.data;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        return last.data;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    final class Node<E> {
        Node<E> next;
        Node<E> prev;
        E data;

        Node(E data) {
            this.data = data;
        }
    }
}
