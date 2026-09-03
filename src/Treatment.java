public class Treatment {

    private int treatmentId;
    private int patientId;
    private String patientName;
    private String doctorName;
    private String treatmentDate;
    private String treatmentDescription;

    public Treatment(
        int treatmentId,
        int patientId,
        String patientName,
        String doctorName,
        String treatmentDate,
        String treatmentDescription
    ) {
        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.treatmentDate = treatmentDate;
        this.treatmentDescription = treatmentDescription;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getTreatmentDate() {
        return treatmentDate;
    }

    public String getTreatmentDescription() {
        return treatmentDescription;
    }

    public void displayTreatment() {

        System.out.println("Treatment ID: " + treatmentId);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Doctor: " + doctorName);
        System.out.println("Date: " + treatmentDate);
        System.out.println("Treatment: " + treatmentDescription);
    }
}
