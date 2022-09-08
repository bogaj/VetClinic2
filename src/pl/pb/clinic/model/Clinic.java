package pl.pb.clinic.model;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Clinic {

    private static final int MAX_PATIENTS = 1000;

    private int patientsNumber = 0;
    private Patient[] patients = new Patient[MAX_PATIENTS];

    public Patient[] getPatients() { //for ktory wypelni kopie tablicy zeby nie duplikowac pustych
        Patient[] result = new Patient[patientsNumber];
        for (int i = 0; i < result.length; i++) {
            result[i] = patients[i];
        }
        return result;
    }

    public void addPatient(Patient patient) {

        if (patientsNumber >= MAX_PATIENTS) {
            throw new ArrayIndexOutOfBoundsException("Osiągnięto maksymalną liczbę pacjentów " + MAX_PATIENTS);
        }

        patients[patientsNumber] = patient;
        patientsNumber++;

    }


    public void addCat(Cat cat) {
        addPatient(cat);
    }

    public void addDog(Dog dog) {
        addPatient(dog);
    }


}

