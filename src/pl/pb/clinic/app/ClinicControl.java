package pl.pb.clinic.app;

import pl.pb.clinic.io.DataReader;
import pl.pb.clinic.model.Cat;
import pl.pb.clinic.model.Dog;
import pl.pb.clinic.model.Clinic;
import pl.pb.clinic.model.Patient;


public class ClinicControl {


    private DataReader dataReader = new DataReader();
    private Clinic clinic = new Clinic();


    public void controlLoop(){
        Option option; //zmienna do opcji od użytkownika
        do {
            printOptions();
            option = Option.createFromInt(dataReader.getInt());
            switch (option){ //jak dodamy nowe alt + enter i wygenruje nowe
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
        } while (option != Option.EXIT); //będzie się wykonywać tak długo jak opcja wybrana przez usera będzie różna od exit
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
        //zautomatyzuje wybór opcji i jak dojdą nowe to łatwiej będzie je dopisać
        for (Option value : Option.values()) {
            System.out.println(value);
        }

    }
}
