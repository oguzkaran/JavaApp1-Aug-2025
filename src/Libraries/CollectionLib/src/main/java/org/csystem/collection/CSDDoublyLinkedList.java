package org.csystem.collection;

public class CSDDoublyLinkedList<E> {
    private static class Node<E> {
        E e;
        Node<E> prev;
        Node<E> next;
    }
}
