package pl.pb.clinic.app;

import pl.pb.clinic.io.DataReader;
import pl.pb.clinic.model.Cat;
import pl.pb.clinic.model.Dog;
import pl.pb.clinic.model.Clinic;
import pl.pb.clinic.model.Patient;


public class ClinicControl {
    private static final int EXIT = 0;
    private static final int ADD_PATIENT = 1;
    private static final int ADD_CAT = 2;
    private static final int ADD_DOG = 3;
    private static final int PRINT_PATIENTS = 4;
    private static final int PRINT_CATS = 5;
    private static final int PRINT_DOGS = 6;

    private DataReader dataReader = new DataReader();
    private Clinic clinic = new Clinic();


    public void controlLoop(){
        int option; //zmienna do opcji od użytkownika
        do {
            printOptions();
            option = dataReader.getInt();
            switch (option){
                case ADD_PATIENT:
                    addPatient();
                    break;
                case ADD_CAT:
                    addCat();
                    break;
                case ADD_DOG:
                    addDog();
                    break;
                case PRINT_PATIENTS:
                    printPatients();
                    break;
                case PRINT_CATS:
                    printCats();
                    break;
                case PRINT_DOGS:
                    printDogs();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Wybrałeś błędną opcję, wprowadź ponownie poprawną");

            }
        } while (option != EXIT); //będzie się wykonywać tak długo jak opcja wybrana przez usera będzie różna od exit
    }

    private void printCats() {
        clinic.printCats();
    }

    private void addCat() {
        Cat cat = dataReader.readAndCreateCat();
        clinic.addCat(cat);
    }
    private void printDogs() {
        clinic.printDogs();
    }

    private void addDog() {
        Dog dog = dataReader.readAndCreateDog();
        clinic.addDog(dog);
    }

    private void exit() {
        System.out.println("Koniec programu");
        dataReader.close();
    }

    private void printPatients() {
        clinic.printPatients();
    }


    private void addPatient() {
        Patient patient = dataReader.readAndCreatePatient();
        clinic.addPatient(patient);
    }

    private void printOptions() {
        System.out.println("Wybierz opcję:");
        System.out.println(EXIT + " - wyjście z programu");
        System.out.println(ADD_PATIENT + " - dodanie nowego pacjenta");
        System.out.println(ADD_CAT + " - dodanie nowego kociego pacjenta");
        System.out.println(ADD_DOG + " - dodanie nowego psiego pacjenta");
        System.out.println(PRINT_PATIENTS + " - wyświetl wszystkich dostępnych pacjentów");
        System.out.println(PRINT_CATS + " - wyświetl dostępnych kocich pacjentów");
        System.out.println(PRINT_DOGS + " - wyświetl dostępnych psich pacjentów");

    }
}
