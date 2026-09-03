public class EmergencyQueue {

    private class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
 
    public EmergencyQueue() {
        front = null;
        rear = null;
    }

    // ENQUEUE(Adds a patient to the rear of the queue)
    public void enqueue(Patient patient) {

        Node newNode = new Node(patient);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println(
            "Patient " + patient.getPatientId()
            + " added to emergency queue."
        );
    }

    // DEQUEUE(Removes and returns the patient at the front)
    public Patient dequeue() {

        if (front == null) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient patient = front.patient;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        System.out.println(
            "Patient " + patient.getPatientId()
            + " removed from emergency queue."
        );

        return patient;
    }

    public void displayQueue() {

        if (front == null) {
            System.out.println("Emergency queue is empty.");
            return;
        }

        System.out.println("\nEMERGENCY WAITING QUEUE");

        Node current = front;

        while (current != null) {

            System.out.println(
                "Patient ID: " + current.patient.getPatientId()
                + " | Name: " + current.patient.getPatientName()
                + " | Condition: " + current.patient.getMedicalCondition()
            );

            current = current.next;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }
}