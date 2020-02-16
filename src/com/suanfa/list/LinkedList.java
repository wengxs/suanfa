package com.suanfa.list;

public class LinkedList<E> {

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

    private Node<E> dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node<>();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed, Illegal index.");

//        if (index == 0) {
//            addFirst(e);
//        } else {
//            Node<E> prev = head;
//            for (int i = 0; i < index - 1; i++) {
//                prev = prev.next;
//            }
////            Node<E> node = new Node<>(e);
////            node.next = prev.next;
////            prev.next = node;
//
//            prev.next = new Node<>(e, prev.next);
//            size++;
//        }

        Node<E> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node<>(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
//        Node<E> node = new Node<>(e);
//        node.next = head;
//        head = node;

//        head = new Node<>(e, head);
//        size++;
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("get failed, Illegal index.");
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.item;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("set failed, Illegal index.");
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.item = e;
    }

    public boolean contains(E e) {
        Node<E> cur = dummyHead.next;
        while (cur != null) {
            if (cur.item.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }
    
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("remove failed, Illegal index.");
        Node<E> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node<E> retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.item;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Node<E> cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("null");
        return res.toString();
    }
}
