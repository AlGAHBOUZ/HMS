package model;

import java.util.List;

public class Receptionist extends Employee {
    private Doctor assignedDoctor;

    public Doctor getAssignedDoctor() {
        return assignedDoctor;
    }

    public void setAssignedDoctor(Doctor assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
    }

    public void viewPatientInfo(Patient patient) {
        System.out.println("Patient Name: " + patient.getName());
        System.out.println("Phone Number: " + patient.getPhoneNum());
        // Display other patient information
    }

    public void addPatient(String name, String phoneNum, int age, String gender, String medicalHistory, String allergies, String currentMedication) {
        assignedDoctor.addPatient(name, phoneNum, age, gender, medicalHistory, allergies, currentMedication);
    }

    public void deletePatient(String email, String password) {
        // Implement logic to find and delete the patient
    }

    public void makeAppointment(Patient patient, String notes, String date) {
        assignedDoctor.makeAppointment(patient, notes, date);
    }

    public List<Appointment> searchAppointments(String patientName, String doctorName, Date startDate, Date endDate) {
        // Implement logic to search for appointments based on filters
        return null;
    }

    public Appointment viewAppointment(String patientID, String appointmentID) {
        // Implement logic to retrieve appointment details
        return null;
    }

    public void editAppointment(Appointment appointment, String notes, String date) {
        // Implement logic to update appointment details
    }

    public void deleteAppointment(Appointment appointment) {
        // Implement logic to delete appointment
    }
}
