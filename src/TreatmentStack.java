public class TreatmentStack {

   
    private class Node {
        Treatment treatment;
        Node next;

        Node(Treatment treatment) {
            this.treatment = treatment;
            this.next = null;
        }
    }

    private Node top;

    public TreatmentStack() {
        top = null;
    }

    // PUSH
    public void push(Treatment treatment) {

        Node newNode = new Node(treatment);

        newNode.next = top;
        top = newNode;

        System.out.println(
            "Treatment " + treatment.getTreatmentId()
            + " added to treatment history."
        );
    }

    // POP
    public Treatment pop() {

        if (top == null) {
            System.out.println("Treatment stack is empty.");
            return null;
        }

        Treatment treatment = top.treatment;

        top = top.next;

        System.out.println(
            "Treatment " + treatment.getTreatmentId()
            + " removed from treatment history."
        );

        return treatment;
    }

    public void displayStack() {

        if (top == null) {
            System.out.println("Treatment stack is empty.");
            return;
        }

        System.out.println("\nTREATMENT HISTORY");

        Node current = top;

        while (current != null) {

            current.treatment.displayTreatment();
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }
}