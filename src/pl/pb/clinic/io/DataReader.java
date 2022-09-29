package pl.pb.clinic.io;

import pl.pb.clinic.model.Cat;
import pl.pb.clinic.model.Dog;
import pl.pb.clinic.model.Patient;

import java.util.Scanner;

public class DataReader {
    private Scanner scanner = new Scanner(System.in); //jest tu nie w metodzie, zeby nie trzeba było zamykać i nie wyrzuci błędu przy 2 obiekcie
private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer) {// tzw. wstrzykiwanie zależności
        this.printer = printer;
    }

    public Patient readAndCreatePatient(){
        printer.printLine("Imię:");
        String name = scanner.nextLine();
        printer.printLine("Nazwisko:");
        String lastName = scanner.nextLine();
        printer.printLine("Płeć:");
        String sex = scanner.nextLine();
        printer.printLine("Rok urodzenia");
        int yearOfBirth = getInt();

        printer.printLine("Miejsce urodzenia");
        String placeOfBirth = scanner.nextLine();
        printer.printLine("Waga");
        double weight = scanner.nextDouble();
        scanner.nextLine();
        printer.printLine("Wzrost");
        double height = scanner.nextDouble();
        scanner.nextLine();
        return new Patient(name,lastName,placeOfBirth,sex,yearOfBirth,weight,height);
    }
    public Cat readAndCreateCat(){
        printer.printLine("Imię:");
        String name = scanner.nextLine();
        printer.printLine("Nazwisko:");
        String lastName = scanner.nextLine();
        printer.printLine("Płeć:");
        String sex = scanner.nextLine();
        printer.printLine("Rok urodzenia");
        int yearOfBirth = getInt();

        printer.printLine("Miejsce urodzenia");
        String placeOfBirth = scanner.nextLine();
        printer.printLine("Rasa:");
        String breed = scanner.nextLine();
        printer.printLine("Umaszczenie:");
        String colour = scanner.nextLine();
        printer.printLine("Waga");
        double weight = scanner.nextDouble();
        scanner.nextLine();
        printer.printLine("Wzrost");
        double height = scanner.nextDouble();
        scanner.nextLine();
        return new Cat(name,lastName,placeOfBirth,sex,yearOfBirth,weight,height,breed, colour);
    }

    public Dog readAndCreateDog(){
        printer.printLine("Imię:");
        String name = scanner.nextLine();
        printer.printLine("Nazwisko:");
        String lastName = scanner.nextLine();
        printer.printLine("Płeć:");
        String sex = scanner.nextLine();
        printer.printLine("Rok urodzenia");
        int yearOfBirth = getInt();

        printer.printLine("Miejsce urodzenia");
        String placeOfBirth = scanner.nextLine();
        printer.printLine("Rasa:");
        String breed = scanner.nextLine();
        printer.printLine("Umaszczenie:");
        String colour = scanner.nextLine();
        printer.printLine("Waga");
        double weight = scanner.nextDouble();
        scanner.nextLine();
        printer.printLine("Wzrost");
        double height = scanner.nextDouble();
        scanner.nextLine();
        return new Dog(name,lastName,placeOfBirth,sex,yearOfBirth,weight,height,breed, colour);
    }
    public int getInt(){
       try {

           return scanner.nextInt();
       }finally {
           scanner.nextLine();
       }

    }
    public String getString(){
        return scanner.nextLine();
    }
    public void close(){
       scanner.close();
    }
}
