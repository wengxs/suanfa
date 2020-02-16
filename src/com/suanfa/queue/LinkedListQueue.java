package com.suanfa.queue;

public class LinkedListQueue<E> implements Queue<E> {

    private class Node<E> {
        E item;
        Node<E> next;

        Node(E e, Node<E> next) {
            this.item = e;
            this.next = next;
        }

        Node() {
            this(null, null);
        }

        Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }

    private Node<E> head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node<>(e);
            head = tail;
        } else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        Node<E> retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null)
            tail = null;
        size--;
        return retNode.item;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        return head.item;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        for (Node<E> cur = head; cur != null; cur = cur.next) {
            res.append(cur).append(" -> ");
        }
        res.append("null tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println("dequeue");
                System.out.println(queue);
            }
        }

    }
}
