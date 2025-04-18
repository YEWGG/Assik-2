Project Overview

This repository contains custom implementations of common data structures in Java without using java.util.* (except for Iterator). The goal is to deepen understanding of the underlying mechanics by building:

Physical Data Structures (MyList implementations):

-MyArrayList

-MyLinkedList

Logical Data Structures (built on top of the physical ones):

-MyStack

-MyQueue

-MyMinHeap

Each physical structure implements the MyList<T> interface; logical structures choose the most fitting physical basis.


Prerequisites

-Java Development Kit (JDK) 8 or higher

-Maven or Gradle (for build and test automation)


Git

Getting Started

Clone the repository

git clone https://github.com/<your-username>/my-collections.git
cd my-collections


Build the project

Maven: mvn clean compile

Gradle: gradle build

Run tests

Maven: mvn test

Gradle: gradle test


Implementation Details

1. MyList Interface

2. MyArrayList

3. MyLinkedList 

4. Logical Structures

Choose base structure based on performance characteristics:

MyStack: LIFO semantics (use MyArrayList for fast index-based operations)

MyQueue: FIFO semantics (use MyLinkedList for efficient head removal)

MyMinHeap: Priority queue (complete binary tree; use MyArrayList for index math)

Each class exposes typical operations (push/pop, enqueue/dequeue, add/removeMin) and hides underlying list methods.


