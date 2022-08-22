package pl.pb.clinic.model;

public class Dog extends Patient {
    private String breed, colour;

    public Dog(String name, String lastName, String placeOfBirth, String sex, int yearOfBirth, double weight,
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

    @Override
    public void printInfo() {
        super.printInfo();
        dogPrintInfo();
    }

    private void dogPrintInfo() {
        System.out.println("Rasa: " + breed
                + "\n Umaszczenie " + colour);
    }
}
