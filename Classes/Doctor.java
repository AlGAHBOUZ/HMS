package model;

import java.util.List;

public class Doctor extends Employee {
    private String department;
    private List<Patient> patients;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public void viewPatientInfo(Patient patient) {
        System.out.println("Patient Name: " + patient.getName());
        System.out.println("Phone Number: " + patient.getPhoneNum());
        // Display other patient information
    }

    public void editPatientInfo(Patient patient, String phoneNum, int age, String medicalHistory, String allergies, String currentMedication, String labResults, String diagnosis) {
        patient.setPhoneNum(phoneNum);
        patient.setAge(age);
        patient.setMedicalHistory(medicalHistory.split(","));
        patient.setAllergies(allergies.split(","));
        patient.setCurrentMedication(currentMedication.split(","));
        patient.setLabResults(labResults.split(","));
        patient.setDiagnosis(diagnosis.split(","));
    }
}
