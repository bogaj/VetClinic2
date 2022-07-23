package pl.pb.clinic.app;

import pl.pb.clinic.io.DataReader;
import pl.pb.clinic.model.Clinic;
import pl.pb.clinic.model.Patient;


public class ClinicControl {
    private final int exit = 0;
    private final int addPatient = 1;
    private final int printPatients = 2;

    private DataReader dataReader = new DataReader();
    private Clinic clinic = new Clinic();


    public void controlLoop(){
        int option; //zmienna do opcji od użytkownika
        do {
            printOptions();
            option = dataReader.getInt();
            switch (option){
                case addPatient:
                    addPatient();
                    break;
                case printPatients:
                    printPatients();
                    break;
                case exit:
                    exit();
                    break;
                default:
                    System.out.println("Wybrałeś błędną opcję, wprowadź ponownie poprawną");

            }
        } while (option != exit); //będzie się wykonywać tak długo jak opcja wybrana przez usera będzie różna od exit
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
        System.out.println(exit + " - wyjście z programu");
        System.out.println(addPatient + " - dodanie nowego pacjenta");
        System.out.println(printPatients + " - wyświetl dostępnych pacjentów");

    }
}
