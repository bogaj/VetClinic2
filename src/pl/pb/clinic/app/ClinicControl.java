package pl.pb.clinic.app;

import pl.pb.clinic.io.DataReader;
import pl.pb.clinic.model.Clinic;
import pl.pb.clinic.model.Patient;


public class ClinicControl {
    private static final int EXIT = 0;
    private static final int ADD_PATIENT = 1;
    private static final int PRINT_PATIENTS = 2;

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
                case PRINT_PATIENTS:
                    printPatients();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Wybrałeś błędną opcję, wprowadź ponownie poprawną");

            }
        } while (option != EXIT); //będzie się wykonywać tak długo jak opcja wybrana przez usera będzie różna od exit
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
        System.out.println(PRINT_PATIENTS + " - wyświetl dostępnych pacjentów");

    }
}
