public class Main {

    public static void main(String[] args) {

        PatientBST patientTree = new PatientBST();

        Patient p1 = new Patient(
            105,
            "Ahamed",
            25,
            "0771234567",
            "Fever"
        );

        Patient p2 = new Patient(
            101,
            "Fathima",
            30,
            "0712345678",
            "Headache"
        );

        Patient p3 = new Patient(
            110,
            "Mohamed",
            40,
            "0756781234",
            "Asthma"
        );

        Patient p4 = new Patient(
            100,
            "Sara",
            22,
            "0765432109",
            "Flu"
        );

        Patient p5 = new Patient(
            107,
            "Ali",
            35,
            "0709876543",
            "Injury"
        );

        Patient p6 = new Patient(
            115,
            "Zainab",
            28,
            "0787654321",
            "Fever"
        );

        // Insert patients
        patientTree.insert(p1);
        patientTree.insert(p2);
        patientTree.insert(p3);
        patientTree.insert(p4);
        patientTree.insert(p5);
        patientTree.insert(p6);

        // Display patients
        System.out.println("PATIENTS IN ASCENDING ORDER");
       

        patientTree.displayInOrder();

        // Search
        System.out.println("\nSEARCHING FOR PATIENT 107");
      

        Patient found = patientTree.search(107);

        if (found != null) {
            found.displayPatient();
        } else {
            System.out.println("Patient not found.");
        }

        // Delete
        System.out.println("\nDELETING PATIENT 101");
       

        patientTree.delete(101);

        System.out.println("\nPATIENTS AFTER DELETION");
       

        patientTree.displayInOrder();
    }
}