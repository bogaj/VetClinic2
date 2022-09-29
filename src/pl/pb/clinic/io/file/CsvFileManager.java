package pl.pb.clinic.io.file;

import pl.pb.clinic.exception.DataExportException;
import pl.pb.clinic.exception.DataImportException;
import pl.pb.clinic.exception.InvalidDataException;
import pl.pb.clinic.model.Cat;
import pl.pb.clinic.model.Clinic;
import pl.pb.clinic.model.Dog;
import pl.pb.clinic.model.Patient;

import java.io.*;
import java.util.Scanner;

public class CsvFileManager implements FileManager {
private static final String FILE_NAME = "Clinic.csv";

    @Override
    public Clinic importData() {
        Clinic clinic = new Clinic();
        try(Scanner fileReader = new Scanner(new File(FILE_NAME))) {
            while (fileReader.hasNextLine()){
                String line = fileReader.nextLine();
               Patient patient = createObjectFromString(line);
               clinic.addPatient(patient);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku " + FILE_NAME);
        }
        return clinic;
    }
//tu wiersz tekstu rozdzielony separatorem ;
    private Patient createObjectFromString(String line) {
        String[] split = line.split(";");
        String type = split[0];
        if (Patient.TYPE.equals(type)) {
            return createPatient(split);
        } else if (Cat.TYPE.equals(type)){
return createCat(split);
        }else if (Dog.TYPE.equals(type)){
            return createDog(split);
        }

        throw new InvalidDataException("Nieznany typ pacjenta " + type);
    }

    private Patient createPatient(String[] data) {
        String name = data[1];
        String lastName = data[2];
        String placeOfBirth = data[3];
        String sex = data[4];
        int yearOfBirth = Integer.valueOf(data[5]);
        double weight = Double.valueOf(data[6]);
        double height = Double.valueOf(data[7]);
        String breed = data[8];
        String colour = data [9];
        return new Patient(name,lastName,placeOfBirth,sex,yearOfBirth,weight,height);
    }

    private Dog createDog(String[] data) {
        String name = data[1];
        String lastName = data[2];
        String placeOfBirth = data[3];
        String sex = data[4];
        int yearOfBirth = Integer.valueOf(data[5]);
        double weight = Double.valueOf(data[6]);
        double height = Double.valueOf(data[7]);
        String breed = data[8];
        String colour = data [9];
        return new Dog(name,lastName,placeOfBirth,sex,yearOfBirth,weight,height,breed,colour);
    }

    private Cat createCat(String[] data) {
        String name = data[1];
        String lastName = data[2];
        String placeOfBirth = data[3];
        String sex = data[4];
        int yearOfBirth = Integer.valueOf(data[5]);
        double weight = Double.valueOf(data[6]);
        double height = Double.valueOf(data[7]);
        String breed = data[8];
        String colour = data [9];
        return new Cat(name,lastName,placeOfBirth,sex,yearOfBirth,weight,height,breed,colour);
    }

    @Override
    public void exportData(Clinic clinic) {
        Patient[] patients = clinic.getPatients();
        try (
             var fileWriter = new FileWriter(FILE_NAME);
             var bufferedWriter = new BufferedWriter(fileWriter)
                )
        {
            for (Patient patient : patients) {
                bufferedWriter.write(patient.toCsv());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new  DataExportException("Błąd zapisu danych do pliku " + FILE_NAME);
        }
    }
}
