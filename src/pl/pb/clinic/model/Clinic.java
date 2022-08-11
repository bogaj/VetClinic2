package pl.pb.clinic.model;

public class Clinic {

    private static final int MAX_PATIENTS = 1000;
    private static final int MAX_CATS = 1000;
    private static final int MAX_DOGS = 1000;
    private Patient[] patients = new Patient[MAX_PATIENTS];
    private Cat[] cats = new Cat[MAX_CATS];
    private Dog[] dogs = new Dog[MAX_DOGS];
    private int patientsNumber = 0;
    private int catsNumber = 0;
    private int dogsNumber = 0;

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
        if (catsNumber < MAX_CATS) {
            cats[catsNumber] = cat;
            catsNumber++;
        } else {
            System.out.println("Osiągnięto maksymalną liczbę Kocich pacjentów");
        }
    }
    public void printCats() {
        if (catsNumber == 0) {
            System.out.println("Brak kotów");
        }
        for (int i = 0; i < catsNumber; i++) {
            cats[i].printInfo();
        }
    }
    public void addDog(Dog dog) {
        if (dogsNumber < MAX_DOGS) {
            dogs[dogsNumber] = dog;
            dogsNumber++;
        } else {
            System.out.println("Osiągnięto maksymalną liczbę psich pacjentów");
        }
    }
    public void printDogs() {
        if (dogsNumber == 0) {
            System.out.println("Brak psów");
        }
        for (int i = 0; i < dogsNumber; i++) {
            dogs[i].printInfo();
        }
    }

}
