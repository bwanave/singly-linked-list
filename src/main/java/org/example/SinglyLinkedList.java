package org.example;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class SinglyLinkedList<T> implements List<T> {

    private Node head;
    private int size;

    public class Node {
        private final T data;
        private Node next;

        private Node(T data) {
            this.data = data;
        }
    }

    @Override
    public void insertAtBegin(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void insertAtMiddle(T data, int position) {
        Node newNode = new Node(data);
        if (head == null)
            head = newNode;
        else if (position <= 0) {
            newNode.next = head;
            head = newNode;
        } else {
            if (position > size)
                position = size;
            Node current = head;
            for (int i = 0; i < position - 1; i++) // position-1 because we won't stop one position before
            {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void insertAtEnd(T data) {
        Node newNode = new Node(data);
        if (head == null)
            head = newNode;
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public int length() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    @Override
    public int lengthByRecursion() {
        return lengthByRecursion(head);
    }

    public int lengthByRecursion(Node head) {
        if (head == null)
            return 0;
        return 1 + lengthByRecursion(head.next);
    }

    @Override
    public boolean contains(T data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsByRecursion(T data) {
        return containsByRecursion(head, data);
    }

    public boolean containsByRecursion(Node head, T data) {
        if (head == null)
            return false;
        else if (head.data.equals(data))
            return true;
        return containsByRecursion(head.next, data);
    }

    @Override
    public T findNthElement(int n) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (index == n)
                return current.data;
            index++;
            current = current.next;
        }
        throw new RuntimeException("Invalid index");
    }

    @Override
    public T findNthElementByRecursion(int n) {
        return findNthElementByRecursion(head, n, 0);
    }

    public T findNthElementByRecursion(Node head, int n, int index) {
        if (head == null)
            throw new RuntimeException("Invalid index");
        else if (index == n)
            return head.data;
        else
            return findNthElementByRecursion(head.next, n, ++index);
    }

    @Override
    public T findMid() {
        if (head == null)
            throw new RuntimeException("Empty list");
        else {
            Node slow = head, fast = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow.data;
        }
    }

    @Override
    public int findOccurrences(T data) {
        int count = 0;
        Node current = head;
        while (current != null) {
            if (current.data.equals(data))
                count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public int findOccurrencesByRecursion(T data) {
        return findOccurrencesByRecursion(head, data);
    }

    public int findOccurrencesByRecursion(Node head, T data) {
        if (head == null)
            return 0;
        return (head.data.equals(data) ? 1 : 0) + findOccurrencesByRecursion(head.next, data);
    }

    @Override
    public boolean detectLoop() {
        Set<Node> visitedNodes = new HashSet<>();
        Node current = head;
        while (current != null) {
            if (visitedNodes.contains(current))
                return true;
            visitedNodes.add(current);
            current = current.next;
        }
        return false;
    }

    @Override
    public void reverse() {
        Node current = head;
        Node previous = null;
        while (current != null) {
            Node temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        head = previous;
    }

    @Override
    public void reverseRecursively() {
        head = reverseRecursively(head);
    }

    public Node reverseRecursively(Node head) {

        if (head == null || head.next == null)
            return head;

        Node newHead = reverseRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(" --> ");
        Node current = head;
        while (current != null) {
            stringJoiner.add(current.data.toString());
            current = current.next;
        }
        return stringJoiner.toString();
    }
}
