import java.util.*;

public class Employee {
private String name;
private String phoneNum;
private int age;
private String gender;
private float salary;
private String address;
private String nationalID;
private String email;
private String password;
private Employee manager;
private String department;

// Getters and Setters for all attributes (except password)

public void login(String email, String password) {
    // Implement login logic here
    if (this.email.equals(email) && this.password.equals(password)) {
        System.out.println("Login successful.");
    } else {
        System.out.println("Invalid email or password.");
    }
}

public void editAccount(String name, String phoneNum, int age, String gender, String address, String nationalID, String email) {
    // Update employee information
    this.name = name;
    this.phoneNum = phoneNum;
    this.age = age;
    this.gender = gender;
    this.address = address;
    this.nationalID = nationalID;
    this.email = email;
}
}

class Doctor extends Employee {
        private String department;
        private List<Patient> patients;

        // Getters and Setters for department and patients

        public void viewPatientInfo(Patient patient) {
            // Access patient information using patient's methods
            System.out.println("Patient Name: " + patient.getName());
            System.out.println("Phone Number: " + patient.getPhoneNum());
            // ... (display other patient information)
        }

        public void editPatientInfo(Patient patient, String phoneNum, int age, String medicalHistory, String allergies, String currentMedication, String labResults, String diagnosis) {
            // Update patient information
            patient.setPhoneNum(phoneNum);
            patient.setAge(age);
            patient.setMedicalHistory(medicalHistory.split("")); // Assuming comma-separated values in String
            patient.setAllergies(allergies.split("")); // Assuming comma-separated values in String
            patient.setCurrentMedication(currentMedication.split("")); // Assuming comma-separated values in String
            patient.setLabResults(labResults.split("")); // Assuming comma-separated values in String
            patient.setDiagnosis(diagnosis.split("")); // Assuming comma-separated values in String
        }
}

class Receptionist extends Employee {
        private Doctor assignedDoctor;

        // Getter and Setter for assignedDoctor

        public void viewPatientInfo(Patient patient) {
            // Access patient information using patient's methods
            System.out.println("Patient Name: " + patient.getName());
            System.out.println("Phone Number: " + patient.getPhoneNum());
            // ... (display other patient information)
        }

        public void addPatient(String name, String phoneNum, int age, String gender, String medicalHistory, String allergies,
        String currentMedication) {
            // Assign the patient to the receptionist's assigned doctor (consider validations)
            assignedDoctor.addPatient(name, phoneNum, age, gender, medicalHistory, allergies, currentMedication);
        }

        public void deletePatient(String email, String password) {
            // Receptionist might need to validate credentials before deleting (consider security)
            // Implement logic to find the patient (e.g., by email) and remove from the system (consider database interaction)
        }

        public void makeAppointment(Patient patient, String notes, String date) {
            // Receptionist might check availability and then call doctor's method to create the appointment
            assignedDoctor.makeAppointment(patient, notes, date);
        }

        public List<Appointment> searchAppointments(String patientName, String doctorName, Date startDate, Date endDate) {
            // Implement logic to search for appointments based on filters (consider using assigned doctor's list or central system)
            List<Appointment> allAppointments = new ArrayList<>(); // Replace with logic to retrieve all appointments

            // Your search logic here

            return allAppointments;
        }

        public Appointment viewAppointment(String patientID, String appointmentID) {
            // Implement logic to retrieve appointment details from central system based on IDs
            return null; // Placeholder until actual implementation
        }

        public void editAppointment(Appointment appointment, String notes, String date) {
            // Implement logic to update appointment details in the central system
        }

        public void deleteAppointment(Appointment appointment) {
            // Implement logic to remove appointment from the central system with confirmation
        }
}

class Manager extends Employee {
        private String department;
        private List<Employee> subordinates;

        // Getter and Setter for department and subordinates

        public void viewEmployeeInfo(Employee employee) {
            // Access employee information using employee's methods
            System.out.println("Employee Name: " + employee.getName());
            System.out.println("Department: " + employee.getDepartment());
            // ... (display other employee information)
        }

        public void editEmployeeInfo(Employee employee, String name, String phoneNum, int age, String gender, String address, String nationalID) {
            // Update employee information (consider security and validation)
            employee.setName(name);
            employee.setPhoneNum(phoneNum);
            employee.setAge(age);
            employee.setGender(gender);
            employee.setAddress(address);
            employee.setNationalID(nationalID);
        }

        public void deleteEmployee(Employee employee) {
            // Remove employee from the manager's list and potentially the system (consider security and validation)
            subordinates.remove(employee);
            // Additional logic might involve removing from database or other systems
        }

        public void manageSalary(Employee employee, float newSalary) {
            // Update employee's salary (consider security and validation)
            employee.setSalary(newSalary);
        }
}

// Class: Bill
class Bill {
        private float amount;
        private String category;
        private String classification;
        private String paymentMethod;
        private Date dueDate;
        private FinanceManager financeManager; // Association with FinanceManager

        // Constructor
        public Bill(float amount, String category, String classification, String paymentMethod, Date dueDate, FinanceManager financeManager) {
            this.amount = amount;
            this.category = category;
            this.classification = classification;
            this.paymentMethod = paymentMethod;
            this.dueDate = dueDate;
            this.financeManager = financeManager;
        }

        // Getters and Setters (omitted for brevity)
}

// Class: Item
class Item {
        private String itemName;
        private float price;
        private int quantity;
        private Date expirationDate;

        // Constructor
        public Item(String itemName, float price, int quantity, Date expirationDate) {
            this.itemName = itemName;
            this.price = price;
            this.quantity = quantity;
            this.expirationDate = expirationDate;
        }

        // Getters and Setters (omitted for brevity)
}

class FinanceManager {
        private List<Bill> bills = new ArrayList<>(); // List of bills managed by the finance manager

        // Methods
        public void addBill(Bill bill) {
            bills.add(bill);
        }

        public void editBill(Bill bill, float newAmount, String newCategory, String newClassification, String newPaymentMethod, Date newDueDate) {
            bill.setAmount(newAmount);
            bill.setCategory(newCategory);
            bill.setClassification(newClassification);
            bill.setPaymentMethod(newPaymentMethod);
            bill.setDueDate(newDueDate);
        }

        public void deleteBill(Bill bill) {
            bills.remove(bill);
        }

        public List<Bill> viewPaymentHistory(Date startDate, Date endDate) {
            List<Bill> filteredBills = new ArrayList<>();
            for (Bill bill : bills) {
                if (bill.getDueDate().after(startDate) && bill.getDueDate().before(endDate)) {
                    filteredBills.add(bill);
                }
            }
            return filteredBills;
        }
}

// Class: FacilitiesManager
class FacilitiesManager {
        private List<Item> inventoryItems = new ArrayList<>(); // List of items managed by facilities manager

        // Methods
        public void viewInventory() {
            if (inventoryItems.isEmpty()) {
                System.out.println("Inventory is empty.");
            } else {
                System.out.println("Inventory:");
                for (Item item : inventoryItems) {
                    System.out.println(item); // Assuming Item class has a toString() method
                }
            }
        }

        public void addItems(String itemName, float price, int quantity, Date expirationDate) {
            Item newItem = new Item(itemName, price, quantity, expirationDate);
            inventoryItems.add(newItem);
            System.out.println("Item added successfully.");
        }

        public void deleteItems(String itemName) {
            boolean itemFound = false;
            for (int i = 0; i < inventoryItems.size(); i++) {
                if (inventoryItems.get(i).getItemName().equals(itemName)) {
                    inventoryItems.remove(i);
                    itemFound = true;
                    System.out.println("Item deleted successfully.");
                    break; // Exit the loop after deleting the first matching item
                }
            }
            if (!itemFound) {
                System.out.println("Item not found in inventory.");
            }
        }

        public void editInventory(String itemName, float newPrice, int newQuantity, Date newExpirationDate) {
            boolean itemFound = false;
            for (int i = 0; i < inventoryItems.size(); i++) {
                if (inventoryItems.get(i).getItemName().equals(itemName)) {
                    inventoryItems.get(i).setPrice(newPrice);
                    inventoryItems.get(i).setQuantity(newQuantity);
                    inventoryItems.get(i).setExpirationDate(newExpirationDate);
                    itemFound = true;
                    System.out.println("Item details updated successfully.");
                    break; // Exit the loop after updating the first matching item
                }
            }
            if (!itemFound) {
                System.out.println("Item not found in inventory.");
            }
        }

        public List<Item> filterInventory(String category, String keyword) {
            List<Item> filteredItems = new ArrayList<>();
            for (Item item : inventoryItems) {
                // Implement filtering logic based on category and keyword (e.g., item name, description)
                // This example assumes filtering by item name
                if (item.getItemName().toLowerCase().contains(keyword.toLowerCase())) {
                    filteredItems.add(item);
                }
            }
            return filteredItems;
        }
}

class Supplier {
        private String companyName;
        private String phoneNumber;
        private String companyAddress;
        private String name; // Supplier's name (added)
        private List<ItemInfo> suppliedItems; // List of items supplied by this supplier (added)

        // Constructor
        public Supplier(String companyName, String phoneNumber, String companyAddress, String name) {
            this.companyName = companyName;
            this.phoneNumber = phoneNumber;
            this.companyAddress = companyAddress;
            this.name = name;
            this.suppliedItems = new ArrayList<>();
        }

        // Getters and Setters (omitted for brevity)

        // Method: addItem
        public void addItem(ItemInfo item) {
            suppliedItems.add(item);
        }

        // Method: deleteItem
        public void deleteItem(ItemInfo item) {
            boolean itemFound = false;
            for (int i = 0; i < suppliedItems.size(); i++) {
                if (suppliedItems.get(i).equals(item)) {
                    suppliedItems.remove(i);
                    itemFound = true;
                    break; // Exit the loop after deleting the first matching item
                }
            }
            if (!itemFound) {
                System.out.println("Item not found in supplier's list.");
            }
        }
}
