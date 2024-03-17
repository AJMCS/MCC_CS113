Printer Queue Management System
Objective: Create a Java program to manage a printer queue using a linked list. Implement functionality to add documents to the queue, remove documents from the queue, and print documents. Additionally, write JUnit test cases to ensure the correctness of the PrinterQueue class.

Requirements:

Implement a Document class with attributes:

String name: Name of the document.
int pages: Number of pages in the document.
Implement a PrinterQueue class with the following methods:

void addDocument(Document document): Adds a document to the printer queue.
void removeDocument(Document document): Removes a document from the printer queue.
void printDocument(): Prints the document at the front of the printer queue and removes it from the queue.
int getQueueSize(): Returns the current size of the printer queue.
Queue<Document> getQueue(): Returns the printer queue.
Implement JUnit test cases to test the functionality of the PrinterQueue class.

Write a driver class PrinterQueueDriver with a menu to demonstrate the functionality of the PrinterQueue class:

Add a document to the queue.
Remove a document from the queue.
Print document at the front of the queue.
Display queue size.
Exit the program.
Instructions:

Create a Document class with attributes name and pages.
Implement a PrinterQueue class with methods addDocument, removeDocument, printDocument, getQueueSize, and getQueue.
Write JUnit test cases to ensure the correctness of the PrinterQueue class.
Create a PrinterQueueDriver class with a menu to interactively test the printer queue management system.
Submission: Submit the following files:

Document.java
PrinterQueue.java
PrinterQueueTest.java
PrinterQueueDriver.java