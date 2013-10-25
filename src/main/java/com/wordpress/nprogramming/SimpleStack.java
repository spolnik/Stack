package com.wordpress.nprogramming;

public class SimpleStack<E> implements Stack<E> {
    private Node<E> top;

    @Override
    public void push(E value) {
        Node<E> node = new Node<>(value);
        node.previous = top;
        top = node;
    }

    @Override
    public E pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty.");
        }

        Node<E> node = top;
        top = top.previous;
        return node.data;
    }

    @Override
    public E peek() {
        return top == null ? null : top.data;
    }

    final class Node<E> {
        Node<E> previous;
        E data;

        Node(E data) {
            this.data = data;
        }
    }
}
