import java.util.HashMap;
import java.util.Map;

class Patient {
        private String name;
        private int age;
        private MedicalInfo medicalInfo;

        public Patient(String name, int age, MedicalInfo medicalInfo) {
            this.name = name;
            this.age = age;
            this.medicalInfo = medicalInfo;
        }

        // Getters and other methods
}

class MedicalInfo {
        private String medicalHistory;
        private String allergies;
        private String currentMedication;

        public MedicalInfo(String medicalHistory, String allergies, String currentMedication) {
            this.medicalHistory = medicalHistory;
            this.allergies = allergies;
            this.currentMedication = currentMedication;
        }

        // Getters and other methods
}

class MedicalInfoFactory {
        private static Map<String, MedicalInfo> medicalInfoMap = new HashMap<>();

        public static MedicalInfo getMedicalInfo(String medicalHistory, String allergies, String currentMedication) {
            String key = medicalHistory + allergies + currentMedication;
            MedicalInfo medicalInfo = medicalInfoMap.get(key);
            if (medicalInfo == null) {
                medicalInfo = new MedicalInfo(medicalHistory, allergies, currentMedication);
                medicalInfoMap.put(key, medicalInfo);
            }
            return medicalInfo;
        }
}

// Usage example
class PatientDemo {
        public static void main(String[] args) {
            MedicalInfo medicalInfo1 = MedicalInfoFactory.getMedicalInfo("History1", "Allergies1", "Medication1");
            Patient patient1 = new Patient("Patient1", 30, medicalInfo1);

            MedicalInfo medicalInfo2 = MedicalInfoFactory.getMedicalInfo("History1", "Allergies1", "Medication1");
            Patient patient2 = new Patient("Patient2", 25, medicalInfo2);
        }
}
