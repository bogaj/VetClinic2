package pl.pb.clinic.app;

import pl.pb.clinic.exception.DataExportException;
import pl.pb.clinic.exception.DataImportException;
import pl.pb.clinic.exception.InvalidDataException;
import pl.pb.clinic.exception.NoSuchOptionException;
import pl.pb.clinic.io.ConsolePrinter;
import pl.pb.clinic.io.DataReader;
import pl.pb.clinic.io.file.FileManager;
import pl.pb.clinic.io.file.FileManagerBuilder;
import pl.pb.clinic.model.Cat;
import pl.pb.clinic.model.Dog;
import pl.pb.clinic.model.Clinic;
import pl.pb.clinic.model.Patient;

import java.util.InputMismatchException;


public class ClinicControl {

    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer); //wstrzykiwanie zależności z DataReader
    private FileManager fileManager;

    private Clinic clinic = new Clinic();

    public ClinicControl() {
        fileManager = new FileManagerBuilder(printer, dataReader).build();
        try {
            clinic = fileManager.importData();
            printer.printLine("Zaimportwoano dane z pliku");
        }catch (DataImportException | InvalidDataException e){
            printer.printLine(e.getMessage());
            printer.printLine("Zaninicjowano nową bazę");
            clinic = new Clinic();
        }
    }

    public void controlLoop() {
        Option option; //zmienna do opcji od użytkownika
        do {
            printOptions();
            option = getOption();
            switch (option) { //jak dodamy nowe alt + enter i wygenruje nowe
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
                    printer.printLine("Wybrałeś błędną opcję, wprowadź ponownie poprawną");

            }
        } while (option != Option.EXIT); //będzie się wykonywać tak długo jak opcja wybrana przez usera będzie różna od exit
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage());
            } catch (InputMismatchException e) {
                printer.printLine("Wprowadzono wartość, która nie jest liczbą, podaj ponownie");
            }
        }
        return option;
    }

    private void printCats() {

        Patient[] patients = clinic.getPatients();
        printer.printCats(patients);

    }

    private void addCat() {
        try {
            Cat cat = dataReader.readAndCreateCat();
            clinic.addCat(cat);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało utworzyć się kociego pacjenta");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnięto limit pacjentów");
        }
    }

    private void printDogs() {
        Patient[] patients = clinic.getPatients();
        printer.printDogs(patients);
    }

    private void addDog() {
        try {
            Dog dog = dataReader.readAndCreateDog();

            clinic.addDog(dog);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało utworzyć się psiego pacjenta");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnięto limit pacjentów");
        }
    }

    private void exit() {
        try {
            fileManager.exportData(clinic);
            printer.printLine("Zapis danych do pliku zakończony powodzeniem");
        }catch (DataExportException e){
            printer.printLine(e.getMessage());
        }

        printer.printLine("Koniec programu");
        dataReader.close();
    }

    private void printPatients() {
        Patient[] patients = clinic.getPatients();
        printer.printPatients(patients);
    }


    private void addPatient() {
        try {
            Patient patient = dataReader.readAndCreatePatient();
            clinic.addPatient(patient);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało utworzyć się pacjenta");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnięto limit pacjentów");
        }
    }

    private void printOptions() {
        printer.printLine("Wybierz opcję: ");
        //zautomatyzuje wybór opcji i jak dojdą nowe to łatwiej będzie je dopisać
        for (Option option : Option.values()) {
            printer.printLine(option.toString());
        }

    }

    private enum Option {
        EXIT(0, "wyjście z programu"),
        ADD_PATIENT(1, "dodanie nowego pacjenta"),
        ADD_CAT(2, "dodanie kociego pacjenta"),
        ADD_DOG(3, "dodanie psiego pacjenta"),
        PRINT_PATIENTS(4, "wyświetlenie wszystkich dostępnych pacjentów"),
        PRINT_CATS(5, "wyświetlenie kocich pacjentów"),
        PRINT_DOGS(6, "wyświetlenie psich pacjentów");

        private final int value;
        private final String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            }catch (ArrayIndexOutOfBoundsException e){
                throw new NoSuchOptionException("Brak opcji o id: " + option);
            }
        }
    }

}
