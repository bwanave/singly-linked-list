package org.example;

public interface List<T> {

    void insertAtBegin(T data);

    void insertAtMiddle(T data, int position);

    void insertAtEnd(T data);

    int length();

    int lengthByRecursion();

    boolean contains(T data);

    boolean containsByRecursion(T data);

    T findNthElement(int n);

    T findNthElementByRecursion(int n);

    T findMid();

    int findOccurrences(T data);

    int findOccurrencesByRecursion(T data);

    boolean detectLoop();

    void reverse();

    void reverseRecursively();

    int size();

    void clear();
}
