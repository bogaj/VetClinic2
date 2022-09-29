package pl.pb.clinic.io;

import pl.pb.clinic.model.Cat;
import pl.pb.clinic.model.Dog;
import pl.pb.clinic.model.Patient;

public class ConsolePrinter {

    public void printPatients(Patient[] patients) {
        int countPatients = 0;
        for (Patient patient : patients) {


            if (patient instanceof Patient) {
                System.out.println(patient);
                countPatients++;
            }
        }if (countPatients == 0){
            printLine("Brak pacjentów");
        }
    }

    public void printCats(Patient[] patients) { //wyświetlają się tylko koty z tablicy
        int countCats = 0;
        for (Patient patient : patients) {
            

            if (patient instanceof Cat) {
                System.out.println(patient);
                countCats++;
            }
        }

        {
            if (countCats == 0) {
                printLine("Brak kocich pacjentów");
            }
        }
    }
    public void printDogs(Patient[] patients) {
        int countDogs = 0;
        for (Patient patient : patients) {
            if (patient instanceof Dog) {
                System.out.println(patient);
                countDogs++;
            }
        }
        {
            if (countDogs == 0) {
                printLine("Brak psich pacjentów");
            }
        }
    }
public void printLine(String text){
    System.out.println(text);
}
}