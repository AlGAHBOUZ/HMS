import java.util.*;

interface PatientIterator {
        boolean hasNext();
        Patient next();
}

class PatientCollection {
        private List<Patient> patients;

        public PatientCollection() {
            patients = new ArrayList<>();
        }

        public void addPatient(Patient patient) {
            patients.add(patient);
        }

        public PatientIterator getReverseIterator() {
            return new ReverseIterator(patients);
        }

        public PatientIterator getUpcomingAppointmentsIterator(Date currentDate) {
            return new UpcomingAppointmentsIterator(patients, currentDate);
        }


        public interface Criteria {
            boolean match(Patient patient);
        }
}

class ReverseIterator implements PatientIterator {
        private List<Patient> patients;
        private int index;

        public ReverseIterator(List<Patient> patients) {
            this.patients = patients;
            this.index = patients.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Patient next() {
            return patients.get(index--);
        }
}

class UpcomingAppointmentsIterator implements PatientIterator {
        private List<Patient> patients;
        private Date currentDate;
        private int index;

        public UpcomingAppointmentsIterator(List<Patient> patients, Date currentDate) {
            this.patients = patients;
            this.currentDate = currentDate;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            while (index < patients.size()) {
                if (patients.get(index).hasUpcomingAppointment(currentDate)) {
                    return true;
                }
                index++;
            }
            return false;
        }

        @Override
        public Patient next() {
            return patients.get(index++);
        }
}


class Patient {
        private String name;
        private int age;
        private Date appointmentDate;
        private MedicalInfo medicalInfo;

        public Patient(String name, int age, Date appointmentDate, MedicalInfo medicalInfo) {
            this.name = name;
            this.age = age;
            this.appointmentDate = appointmentDate;
            this.medicalInfo = medicalInfo;
        }

        public boolean hasUpcomingAppointment(Date currentDate) {
            return appointmentDate != null && appointmentDate.after(currentDate);
        }

        // Getters and other methods
}

class MedicalInfo {
        private String medicalHistory;

        public MedicalInfo(String medicalHistory) {
            this.medicalHistory = medicalHistory;
        }

        public String getMedicalHistory() {
            return medicalHistory;
        }
}

// Usage example
public class PatientDemo {
public static void main(String[] args) {
    PatientCollection collection = new PatientCollection();
    collection.addPatient(new Patient("Alice", 30, new Date(System.currentTimeMillis() + 86400000), new MedicalInfo("History1"))); // Appointment tomorrow
    collection.addPatient(new Patient("Bob", 25, new Date(System.currentTimeMillis() - 86400000), new MedicalInfo("History2"))); // Appointment yesterday
    collection.addPatient(new Patient("Charlie", 40, null, new MedicalInfo("History3"))); // No appointment

    PatientIterator reverseIterator = collection.getReverseIterator();
    while (reverseIterator.hasNext()) {
        Patient patient = reverseIterator.next();
        System.out.println("Reverse Iterator: " + patient.name);
    }

    PatientIterator upcomingAppointmentsIterator = collection.getUpcomingAppointmentsIterator(new Date());
    while (upcomingAppointmentsIterator.hasNext()) {
        Patient patient = upcomingAppointmentsIterator.next();
        System.out.println("Upcoming Appointments Iterator: " + patient.name);
    }

}
}