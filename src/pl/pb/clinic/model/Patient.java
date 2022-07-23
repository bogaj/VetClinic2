package pl.pb.clinic.model;

import org.w3c.dom.ls.LSOutput;

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

    public void printInfo() {
        String info = "Pacjent: " + "\n Imię: " + name +
                "\n Nazwisko: " + lastName + "\n Płeć: " + sex +
                "\n Rok urodzenia: " + yearOfBirth + "\n Miejsce urodzenia: " + placeOfBirth +
                "\n Waga: " + weight + " kg. ";
        if(height != 0){ //jeśli nie podasz wzrostu to nie wyswietli się 0.0

            info += "wzrost " + height + " cm";
        }
        System.out.println(info);
    }
}

