package pl.pb.clinic.model;


import java.util.Objects;

public class Patient {
   private String name, lastName, placeOfBirth, sex;
   private int yearOfBirth;
   private double weight, height;


    public Patient(String name, String lastName, String placeOfBirth, String sex, int yearOfBirth, double weight) {
        this.name = name;
        this.lastName = lastName;
        this.placeOfBirth = placeOfBirth;
        this.sex = sex;
        this.yearOfBirth = yearOfBirth;
        this.weight = weight;
    }


   public Patient(String name, String lastName, String placeOfBirth, String sex, int yearOfBirth, double weight, double height) {
       this(name,lastName,placeOfBirth,sex,yearOfBirth,weight);
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    @Override
    public String toString() {
        return "Pacjent: \n" +
                " Imię: " + name +
                ", Nazwisko: " + lastName +
                ", Miejsce urodzenia: " + placeOfBirth +
                ", płeć: " + sex +
                ", rok urodzenia: " + yearOfBirth +
                ", waga: " + weight +
                ", wzrost: " + height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return yearOfBirth == patient.yearOfBirth && Double.compare(patient.weight, weight) == 0 && Double.compare(patient.height, height) == 0 && Objects.equals(name, patient.name) && Objects.equals(lastName, patient.lastName) && Objects.equals(placeOfBirth, patient.placeOfBirth) && Objects.equals(sex, patient.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, placeOfBirth, sex, yearOfBirth, weight, height);
    }


}

