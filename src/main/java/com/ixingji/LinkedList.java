package com.ixingji;

import java.util.Objects;

public class LinkedList<T> {

    private Node<T> headNode;

    static class Node<T> {
        public T element;

        private Node<T> prev;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
        }

        public void setNext(Node<T> next) {
            this.next = next;
            this.next.prev = this;
        }
    }

    public void add(T target) {
        if (headNode == null) {
            headNode = new Node<>(target);
        } else {
            while (headNode.next != null) ;
            headNode.setNext(new Node<T>(target));
        }
    }

    public void remove(T target) {
        if (headNode == null) {
            return;
        }
        Node<T> currentNode = headNode;
        while (currentNode != null && !Objects.equals(currentNode.element, target)) {
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            Node<T> prevNode = currentNode.prev;
            Node<T> nextNode = currentNode.next;
            if (prevNode == null) { // 命中首节点
                headNode = nextNode;
                currentNode.prev = null;
            } else if (nextNode == null) { // 命中尾节点
                currentNode.prev.next = null;
            } else {
                prevNode.setNext(nextNode);
            }
        }
    }

    public void print() {
        Node<T> currentNode = headNode;
        while (currentNode != null) {
            System.err.print(currentNode.element + ",");
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.print();
        list.remove(2);
        list.print();
    }

}
