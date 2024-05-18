// Implementor Interface
public interface PatientState {
void handleState();
}

// Concrete Implementors
public class MildState implements PatientState {
@Override
        public void handleState() {
    System.out.println("Treating patient in mild state.");
    // Additional logic for treating mild state
}
}

public class CriticalState implements PatientState {
@Override
        public void handleState() {
    System.out.println("Treating patient in critical state.");
    // Additional logic for treating critical state
}
}

// Abstraction
public abstract class Patient {
        protected PatientState state;

        public Patient(PatientState state) {
            this.state = state;
        }

        public abstract void treat();
}

// Refined Abstraction
public class NormalPatient extends Patient {
public NormalPatient(PatientState state) {
    super(state);
}

@Override
        public void treat() {
    state.handleState();
}
}

public class HospitalManagementSystem {
public static void main(String[] args) {
    // Creating patients
    Patient mildPatient = new NormalPatient(new MildState());
    Patient criticalPatient = new NormalPatient(new CriticalState());

    // Treating patients
    mildPatient.treat();
    criticalPatient.treat();
}
}
