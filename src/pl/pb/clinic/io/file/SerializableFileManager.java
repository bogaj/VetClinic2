package pl.pb.clinic.io.file;

import pl.pb.clinic.exception.DataExportException;
import pl.pb.clinic.exception.DataImportException;
import pl.pb.clinic.model.Clinic;

import java.io.*;

public class SerializableFileManager implements FileManager {
    private static final String FILE_NAME = "Clinic.o"; //nazwa pliku

    @Override
    public Clinic importData() {

        try (
                FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {

            return (Clinic) ois.readObject(); //rzutowanie na obiekt Clinic
        } catch (FileNotFoundException e) {
       throw new DataImportException("Brak pliku " + FILE_NAME);
        } catch (IOException e) {
           throw new DataImportException("Błąd odczytu danych do pliku " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportException("Niezgodny typ danych w pliku " + FILE_NAME);
        }
    }

    @Override
    public void exportData(Clinic clinic) {

        try (
                FileOutputStream fos = new FileOutputStream(FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(clinic);
        } catch (FileNotFoundException e) {
            throw new DataExportException("Brak pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu danych do pliku " + FILE_NAME);
        }
    }
}
