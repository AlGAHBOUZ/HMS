import java.util.*;

interface Mediator {
        void addAppointment(Appointment appointment);
        void addDoctor(Doctor doctor);
        void notifyDoctors();
}

class AppointmentMediator implements Mediator {
        private List<Doctor> doctors = new ArrayList<>();
        private List<Receptionist> receptionists = new ArrayList<>();
        private Queue<Appointment> appointmentQueue = new PriorityQueue<>(Comparator.comparing(Appointment::getPriority));

        @Override
        public void addDoctor(Doctor doctor) {
            doctors.add(doctor);
        }

        @Override
        public void addReceptionist(Receptionist receptionist) {
            receptionists.add(receptionist);
        }


        @Override
        public void notifyDoctors() {
            for (Doctor doctor : doctors) {
                if (!appointmentQueue.isEmpty()) {
                    Appointment appointment = appointmentQueue.poll();
                    doctor.scheduleAppointment(appointment);
                }
            }
        }
}

class Appointment {
        private Patient patient;
        private Doctor doctor;
        private Date date;
        private int priority;

        public Appointment(Patient patient, Doctor doctor, Date date, int priority) {
            this.patient = patient;
            this.doctor = doctor;
            this.date = date;
            this.priority = priority;
        }

        public int getPriority() {
            return priority;
        }
}

class Patient {
        private String name;
        // Other attributes and methods
}

interface Component {
        void setMediator(Mediator mediator);
        String getName();
}

class Doctor implements Component {
        private String name;
        private Mediator mediator;

        public Doctor(String name) {
            this.name = name;
        }

        @Override
        public void setMediator(Mediator mediator) {
            this.mediator = mediator;
        }

        @Override
        public String getName() {
            return "Doctor";
        }

        public void scheduleAppointment(Appointment appointment) {
            // Schedule the appointment
            System.out.println("Doctor " + name + " scheduled an appointment with " + appointment.patient.name);
        }
}

class Receptionist implements Component {
        private String name;
        private Mediator mediator;

        public Receptionist(String name) {
            this.name = name;
        }

        @Override
        public void setMediator(Mediator mediator) {
            this.mediator = mediator;
        }

        @Override
        public String getName() {
            return "Receptionist";
        }

        public void update(Queue<Appointment> appointments) {
            // Update receptionist's appointment list
            System.out.println("Receptionist " + name + " updated with appointments: " + appointments.size());
        }
}

public class MediatorPatternDemo {
public static void main(String[] args) {
    Mediator mediator = new AppointmentMediator();

    Doctor doctor1 = new Doctor("Dr. Smith");
    Doctor doctor2 = new Doctor("Dr. Jones");
    Receptionist receptionist1 = new Receptionist("Receptionist Alice");
    Receptionist receptionist2 = new Receptionist("Receptionist Bob");

    doctor1.setMediator(mediator);
    doctor2.setMediator(mediator);
    receptionist1.setMediator(mediator);
    receptionist2.setMediator(mediator);

    mediator.addDoctor(doctor1);
    mediator.addDoctor(doctor2);
    mediator.addReceptionist(receptionist1);
    mediator.addReceptionist(receptionist2);

    Patient patient1 = new Patient();
    patient1.name = "John Doe";
    Patient patient2 = new Patient();
    patient2.name = "Jane Doe";

    Appointment appointment1 = new Appointment(patient1, doctor1, new Date(), 1);
    Appointment appointment2 = new Appointment(patient2, doctor2, new Date(), 2);

    mediator.addAppointment(appointment1);
    mediator.addAppointment(appointment2);
}
}
