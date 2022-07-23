package pl.pb.clinic.io;

import pl.pb.clinic.model.Patient;

import java.util.Scanner;

public class DataReader {
    private Scanner scanner = new Scanner(System.in); //jest tu nie w metodzie, zeby nie trzeba było zamykać i nie wyrzuci błędu przy 2 obiekcie

   public Patient readAndCreatePatient(){
        System.out.println("Imię:");
        String name = scanner.nextLine();
        System.out.println("Nazwisko:");
        String lastName = scanner.nextLine();
        System.out.println("Płeć:");
        String sex = scanner.nextLine();
        System.out.println("Rok urodzenia");
        int yearOfBirth = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Miejsce urodzenia");
        String placeOfBirth = scanner.nextLine();
        System.out.println("Waga");
        double weight = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Wzrost");
        double height = scanner.nextDouble();
        scanner.nextLine();
        return new Patient(name,lastName,placeOfBirth,sex,yearOfBirth,weight,height);
    }

    public int getInt(){
       int number = scanner.nextInt();
       scanner.nextLine();
       return number;
    }
    public void close(){
       scanner.close();
    }
}
