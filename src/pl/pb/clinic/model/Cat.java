package pl.pb.clinic.model;

import java.util.Objects;

public class Cat extends Patient {

    private String breed, colour;

    public Cat(String name, String lastName, String placeOfBirth, String sex, int yearOfBirth, double weight,
               double height, String breed, String colour) {
        super(name, lastName, placeOfBirth, sex, yearOfBirth, weight, height);
        this.breed = breed;
        this.colour = colour;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

/*    @Override
    public void printInfo() {
        super.printInfo();
        catPrintInfo();
    }

    private void catPrintInfo() {
        System.out.println("Rasa: " + breed
                + "\n Umaszczenie " + colour);
    }*/

    @Override
    public String toString() {
        return super.toString() + "Koci pacjent: " +
                " rasa: " + breed +
                ", umaszczenie" + colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false; //sprawdza pola ktore dziedziczymy po patient
        Cat cat = (Cat) o;
        return Objects.equals(breed, cat.breed) && Objects.equals(colour, cat.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), breed, colour);
    }
}
