package pl.pb.clinic.model;

public class Clinic {

    private static final int MAX_PATIENTS = 1000;

    private int patientsNumber = 0;
    private Patient[] patients = new Patient[MAX_PATIENTS];


    public void addPatient(Patient patient) {
        if (patientsNumber < MAX_PATIENTS) {
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

    public void addCat(Cat cat) {
        if (patientsNumber < MAX_PATIENTS) {
            patients[patientsNumber] = cat;
            patientsNumber++;
        } else {
            System.out.println("Osiągnięto maksymalną liczbę Kocich pacjentów");
        }
    }

    public void printCats() { //wyświetlają się tylko koty z tablicy
        int countCats = 0;
        for (int i = 0; i < patientsNumber; i++) {
            if (patients[i] instanceof Cat) {
                patients[i].printInfo();
                countCats++;
            }
        }

        {
            if (countCats == 0) {
                System.out.println("Brak kocich pacjentów");
            }
        }
    }

    public void addDog(Dog dog) {
        if (patientsNumber < MAX_PATIENTS) {
            patients[patientsNumber] = dog;
            patientsNumber++;
        } else {
            System.out.println("Osiągnięto maksymalną liczbę psich pacjentów");
        }
    }

    public void printDogs() {
        int countDogs = 0;
        for (int i = 0; i < patientsNumber; i++) {
            if (patients[i] instanceof Dog) {
                patients[i].printInfo();
                countDogs++;
            }
        }
        {
            if (countDogs == 0) {
                System.out.println("Brak psich pacjentów");
            }
        }
    }

}
