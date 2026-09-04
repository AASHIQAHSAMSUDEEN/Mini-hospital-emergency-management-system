import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static PatientBST patientTree = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue();
    static TreatmentStack treatmentStack = new TreatmentStack();

    public static void main(String[] args) {

        addSamplePatients();
        int choice;

        do {
            displayMenu();

            choice = getIntInput("which case do you want between  choice 1 to 14: ");

            switch (choice) {
                case 1:
                    registerPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    deletePatient();
                    break;

                case 4:
                    displayAllPatients();
                    break;

                case 5:
                    addToEmergencyQueue();
                    break;

                case 6:
                    treatNextPatient();
                    break;

                case 7:
                    displayEmergencyQueue();
                    break;

                case 8:
                    addTreatment();
                    break;

                case 9:
                    removeLastTreatment();
                    break;

                case 10:
                    displayTreatmentHistory();
                    break;

                case 11:
                    addPatientVisit();
                    break;

                case 12:
                    searchPatientVisit();
                    break;

                case 13:
                    removePatientVisit();
                    break;

                case 14:
                    displayPatientVisits();
                    break;

                case 0:
                    System.out.println("\nExiting system...");
                    System.out.println("Thank you for using the Hospital Management SYSTEM.");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }


    public static void displayMenu() {

        System.out.println("\n\n**********");
        System.out.println("     MINI HOSPITAL EMERGENCY MANAGEMENT System");
        System.out.println("**********");

        System.out.println("\nPATIENT RECORDS - BINARY SEARCH TREE");
        System.out.println("1. Register Patient");
        System.out.println("2. Search Patient");
        System.out.println("3. Delete Patient");
        System.out.println("4. Display All Patients");

        System.out.println("\nEMERGENCY QUEUE");
        System.out.println("5. Add Patient to Emergency Queue");
        System.out.println("6. Treat Next Patient");
        System.out.println("7. Display Emergency Queue");

        System.out.println("\nTREATMENT HISTORY - STACK");
        System.out.println("8. Add Treatment");
        System.out.println("9. Remove Last Treatment");
        System.out.println("10. Display Treatment History");

        System.out.println("\nPATIENT VISIT HISTORY - LINKED LIST");
        System.out.println("11. Add Patient Visit");
        System.out.println("12. Search Patient Visit");
        System.out.println("13. Remove Patient Visit");
        System.out.println("14. Display Patient Visits");

        System.out.println("\n0. Exit");

        System.out.println("***************");
    }


    public static void addSamplePatients() {

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

        patientTree.insert(p1);
        patientTree.insert(p2);
        patientTree.insert(p3);
        patientTree.insert(p4);
        patientTree.insert(p5);
        patientTree.insert(p6);
    }


    //register patient
    public static void registerPatient() {
        System.out.println("\n--- REGISTER NEW PATIENT ---");

        int id = getIntInput("Enter Patient ID: ");

        if (patientTree.search(id) != null) {
            System.out.println("Patient ID already exists.");
            return;
        }

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        int age = getIntInput("Enter Age: ");

        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();

        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();

        Patient patient = new Patient(
            id,
            name,
            age,
            contact,
            condition
        );

        patientTree.insert(patient);

        System.out.println("Patient registered successfully.");
    }

    // 2. SEARCH PATIENT
    public static void searchPatient() {

        System.out.println("\n--- SEARCH PATIENT ---");

        int id = getIntInput("Enter Patient ID: ");

        Patient patient = patientTree.search(id);

        if (patient != null) {

            System.out.println("\nPatient found:");
            System.out.println("--------------------");

            patient.displayPatient();

        } else {

            System.out.println("Patient not found.");
        }
    }


    // 3. DELETE PATIENT
    public static void deletePatient() {

        System.out.println("\n--- DELETE PATIENT ---");

        int id = getIntInput("Enter Patient ID: ");

        patientTree.delete(id);
    }

    public static void displayAllPatients() {

        System.out.println("\n--- ALL PATIENTS ---");

        patientTree.displayInOrder();
    }



    // 5. ADD TO EMERGENCY QUEUE
    public static void addToEmergencyQueue() {

        System.out.println("\n--- ADD PATIENT TO EMERGENCY QUEUE ---");

        int id = getIntInput("Enter Patient ID: ");

        Patient patient = patientTree.search(id);

        if (patient == null) {

            System.out.println("Patient not found.");

            return;
        }

        emergencyQueue.enqueue(patient);
    }


  
    // 6. TREAT NEXT PATIENT
    public static void treatNextPatient() {

        System.out.println("\n--- TREAT NEXT PATIENT ---");

        Patient patient = emergencyQueue.dequeue();

        if (patient != null) {

            System.out.println(
                "Now treating Patient: "
                + patient.getPatientName()
            );

            System.out.println(
                "Patient ID: "
                + patient.getPatientId()
            );
        }
    }

    public static void displayEmergencyQueue() {

        System.out.println("\n--- EMERGENCY WAITING QUEUE ---");

        emergencyQueue.displayQueue();
    }


    // 8. ADD TREATMENT
    public static void addTreatment() {

        System.out.println("\n--- ADD COMPLETED TREATMENT ---");

        int treatmentId = getIntInput("Enter Treatment ID: ");

        int patientId = getIntInput("Enter Patient ID: ");

        Patient patient = patientTree.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");

            return;
        }

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter Treatment Date: ");
        String date = scanner.nextLine();

        System.out.print("Enter Treatment Description: ");
        String description = scanner.nextLine();

        Treatment treatment = new Treatment(
            treatmentId,
            patientId,
            patient.getPatientName(),
            doctor,
            date,
            description
        );

        treatmentStack.push(treatment);
    }


    // 9. REMOVE TREATMENT
    public static void removeLastTreatment() {

        System.out.println("\n--- REMOVE MOST RECENT TREATMENT ---");

        Treatment treatment = treatmentStack.pop();

        if (treatment != null) {

            System.out.println(
                "Removed treatment for: "
                + treatment.getPatientName()
            );
        }
    }


    public static void displayTreatmentHistory() {

        System.out.println("\n--- TREATMENT HISTORY ---");

        treatmentStack.displayStack();
    }


    // 11. ADD PATIENT VISIT
    public static void addPatientVisit() {

        System.out.println("\n--- ADD PATIENT VISIT ---");

        int patientId = getIntInput("Enter Patient ID: ");

        Patient patient = patientTree.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");

            return;
        }

        int visitId = getIntInput("Enter Visit ID: ");

        if (patient.getVisitHistory().searchVisit(visitId) != null) {

            System.out.println("Visit ID already exists for this patient.");

            return;
        }

        System.out.print("Enter Visit Date: ");
        String date = scanner.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        Visit visit = new Visit(
            visitId,
            date,
            doctor,
            diagnosis,
            treatment
        );

        patient.getVisitHistory().addVisit(visit);
    }


  
    // 12. SEARCH PATIENT VISIT
    public static void searchPatientVisit() {

        System.out.println("\n--- SEARCH PATIENT VISIT ---");

        int patientId = getIntInput("Enter Patient ID: ");

        Patient patient = patientTree.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");

            return;
        }

        int visitId = getIntInput("Enter Visit ID: ");

        Visit visit = patient.getVisitHistory().searchVisit(visitId);

        if (visit != null) {

            System.out.println("\nVisit found:");
            System.out.println("--------------------");

            visit.displayVisit();

        } else {

            System.out.println("Visit not found.");
        }
    }


    // 13. REMOVE PATIENT VISIT
    public static void removePatientVisit() {

        System.out.println("\n--- REMOVE PATIENT VISIT ---");

        int patientId = getIntInput("Enter Patient ID: ");

        Patient patient = patientTree.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");

            return;
        }

        int visitId = getIntInput("Enter Visit ID: ");

        patient.getVisitHistory().removeVisit(visitId);
    }


    public static void displayPatientVisits() {

        System.out.println("\n--- DISPLAY PATIENT VISITS ---");

        int patientId = getIntInput("Enter Patient ID: ");

        Patient patient = patientTree.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");

            return;
        }

        System.out.println(
            "\nVisit History for "
            + patient.getPatientName()
        );

        patient.getVisitHistory().displayVisits();
    }



    public static int getIntInput(String message) {

        while (true) {

            System.out.print(message);

            try {

                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println(
                    "Invalid input. Please enter a number."
                );
            }
        }
    }
}