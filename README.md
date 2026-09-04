Student Name = SF. AASHIQAH
Student ID = 23DA2-1030

# Mini Hospital Emergency Management System
## CIT300 - Data Structures and Algorithms
A Java-based Mini Hospital Emergency Management System developed using fundamental data structures.

## Project Overview
This system manages patient records, emergency patients, treatment history, and patient visit history.

The project demonstrates the practical use of:

- Binary Search Tree
- Queue
- Stack
- Singly Linked List

## Data Structures Used

### 1. Binary Search Tree
The Binary Search Tree is used to store and manage patient records.
The Patient ID is used as the key.
Operations:
- Insert patient
- Search patient by Patient ID
- Delete patient
- Display patients using in-order traversal

The in-order traversal displays patients in ascending order of Patient ID.

### 2. Queue
The Queue is used to manage patients waiting for emergency treatment.
Operations:
- Enqueue patient
- Dequeue patient
- Display waiting patients
- Check for empty queue

The Queue follows FIFO:

First In, First Out.

### 3. Stack
The Stack is used to maintain completed treatment history.
Operations:
- Push treatment
- Pop most recent treatment
- Display treatment history
- Check for empty stack

The Stack follows LIFO:
Last In, First Out.

### 4. Singly Linked List
Each patient has a separate singly linked list for their hospital visit history.
Each visit contains:
- Visit ID
- Visit Date
- Doctor Name
- Diagnosis
- Treatment

Operations:
- Add visit
- Search visit
- Remove visit
- Display visit history
- Check for empty list

## Project Structure
Mini emergency hospital management system
│
├── src
│   ├── Main.java
│   ├── Patient.java
│   ├── PatientBST.java
│   ├── EmergencyQueue.java
│   ├── Treatment.java
│   ├── TreatmentStack.java
│   ├── Visit.java
│   └── VisitLinkedList.java
│
└── README.md