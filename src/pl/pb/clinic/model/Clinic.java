package pl.pb.clinic.model;

public class Clinic {

    private final int maxPatients = 1000;
    private Patient[] patients = new Patient[maxPatients];
    private int patientsNumber = 0;

    public void addPatient(Patient patient) {
        if (patientsNumber < maxPatients) {
            patients[patientsNumber] = patient;
            patientsNumber++;
        } else {
            System.out.println("Osiągnięto maksymalną liczbę pacjentów");
        }
    }

    public void printPatients() {
        if (patientsNumber == 0) {
            System.out.println("Brak pacjentów");
        }
        for (int i = 0; i < patientsNumber; i++) {
            patients[i].printInfo();
        }
    }

}
