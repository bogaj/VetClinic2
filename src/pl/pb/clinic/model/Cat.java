package pl.pb.clinic.model;

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
    public void printInfo() {
        String info = "Pacjent: " + "\n Imię: " + getName() +
                "\n Nazwisko: " + getLastName() + "\n Płeć: " + getSex() +
                "\n Rok urodzenia: " + getYearOfBirth() + "\n Miejsce urodzenia: " + getPlaceOfBirth() + "\nRasa: " + breed
                + "\nUmaszczenie " + colour +
                "\n Waga: " + getWeight() + " kg. ";
        if(getHeight() != 0){ //jeśli nie podasz wzrostu to nie wyswietli się 0.0

            info += "wzrost " + getHeight() + " cm";
        }
        System.out.println(info);
    }
}
