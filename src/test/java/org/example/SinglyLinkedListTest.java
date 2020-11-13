package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

    private static List<Integer> list;

    @BeforeAll
    static void beforeAll() {
        list = new SinglyLinkedList<>();
    }

    @Test
    void insertAtBegin() {
        list.insertAtBegin(10);
        list.insertAtBegin(20);
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("20 --> 10", list.toString());

        list.insertAtBegin(30);
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("30 --> 20 --> 10", list.toString());

        list.insertAtBegin(40);
        list.insertAtBegin(50);
        Assertions.assertEquals(5, list.size());
        Assertions.assertEquals("50 --> 40 --> 30 --> 20 --> 10", list.toString());
    }

    @Test
    void insertAtMiddle() {
        list.insertAtMiddle(100, 10);
        list.insertAtMiddle(200, 20);
        list.insertAtMiddle(300, 1);
        list.insertAtMiddle(400, 0);
        list.insertAtMiddle(500, 0);
        Assertions.assertEquals(5, list.size());
        Assertions.assertEquals("500 --> 400 --> 100 --> 300 --> 200", list.toString());
    }

    @Test
    void insertAtEnd() {
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("10 --> 20", list.toString());

        list.insertAtEnd(30);
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("10 --> 20 --> 30", list.toString());

        list.insertAtEnd(40);
        list.insertAtEnd(50);
        Assertions.assertEquals(5, list.size());
        Assertions.assertEquals("10 --> 20 --> 30 --> 40 --> 50", list.toString());
    }

    @Test
    void length() {
        Assertions.assertEquals(0, list.length());
        list.insertAtEnd(10);
        Assertions.assertEquals(1, list.length());
        list.insertAtEnd(20);
        Assertions.assertEquals(2, list.length());
    }

    @Test
    void lengthByRecursion() {
        Assertions.assertEquals(0, list.lengthByRecursion());
        list.insertAtEnd(10);
        Assertions.assertEquals(1, list.lengthByRecursion());
        list.insertAtEnd(20);
        Assertions.assertEquals(2, list.lengthByRecursion());
    }

    @Test
    void contains() {
        Assertions.assertFalse(list.contains(100));
        list.insertAtBegin(100);
        list.insertAtBegin(200);
        Assertions.assertTrue(list.contains(100));
        Assertions.assertTrue(list.contains(200));
    }

    @Test
    void containsByRecursion() {
        Assertions.assertFalse(list.containsByRecursion(100));
        list.insertAtBegin(100);
        list.insertAtBegin(200);
        Assertions.assertTrue(list.containsByRecursion(100));
        Assertions.assertTrue(list.containsByRecursion(200));
    }

    @Test
    void findNthElement() {
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        Assertions.assertEquals(40, list.findNthElement(0));
        Assertions.assertEquals(50, list.findNthElement(1));
    }

    @Test
    void findNthElementByRecursion() {
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        Assertions.assertEquals(40, list.findNthElementByRecursion(0));
        Assertions.assertEquals(50, list.findNthElementByRecursion(1));
    }

    @Test
    void findMid() {
        list.insertAtEnd(40);
        Assertions.assertEquals(40, list.findMid());
        list.insertAtEnd(50);
        Assertions.assertEquals(50, list.findMid());
        list.insertAtEnd(60);
        Assertions.assertEquals(50, list.findMid());
        list.insertAtEnd(70);
        Assertions.assertEquals(60, list.findMid());
        list.insertAtEnd(80);
        list.insertAtEnd(90);
        list.insertAtEnd(100);
        Assertions.assertEquals(70, list.findMid());
        list.insertAtEnd(200);
        Assertions.assertEquals(80, list.findMid());
    }

    @Test
    void findOccurrences() {
        Assertions.assertEquals(0, list.findOccurrences(100));
        list.insertAtBegin(10);
        list.insertAtBegin(20);
        list.insertAtBegin(10);
        Assertions.assertEquals(0, list.findOccurrences(100));
        Assertions.assertEquals(2, list.findOccurrences(10));
        Assertions.assertEquals(1, list.findOccurrences(20));
        list.insertAtBegin(20);
        list.insertAtBegin(20);
        Assertions.assertEquals(3, list.findOccurrences(20));
    }

    @Test
    void findOccurrencesByRecursion() {
        Assertions.assertEquals(0, list.findOccurrencesByRecursion(100));
        list.insertAtBegin(10);
        list.insertAtBegin(20);
        list.insertAtBegin(10);
        Assertions.assertEquals(0, list.findOccurrencesByRecursion(100));
        Assertions.assertEquals(2, list.findOccurrencesByRecursion(10));
        Assertions.assertEquals(1, list.findOccurrencesByRecursion(20));
        list.insertAtBegin(20);
        list.insertAtBegin(20);
        Assertions.assertEquals(3, list.findOccurrencesByRecursion(20));
    }

    @Test
    void detectLoop() {
        Assertions.assertFalse(list.detectLoop());
        list.insertAtBegin(10);
        list.insertAtBegin(20);
    }

    @Test
    void reverse() {
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.reverse();
        Assertions.assertEquals("20 --> 10", list.toString());
        list.insertAtEnd(30);
        list.reverse();
        Assertions.assertEquals("30 --> 10 --> 20", list.toString());
    }

    @Test
    void reverseRecursively() {
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.reverseRecursively();
        Assertions.assertEquals("20 --> 10", list.toString());
        list.insertAtEnd(30);
        list.reverseRecursively();
        Assertions.assertEquals("30 --> 10 --> 20", list.toString());
    }

    @Test
    void size() {
        list.insertAtBegin(10);
        list.insertAtBegin(20);
        Assertions.assertEquals(2, list.size());
    }

    @Test
    void clear() {
        list.insertAtBegin(10);
        list.clear();
        Assertions.assertEquals(0, list.size());
        Assertions.assertEquals("", list.toString());
    }

    @AfterEach
    void afterEach() {
        list.clear();
    }
}