package pl.pb.clinic.app;

public enum Option {
    EXIT(0, "wyjście z programu"),
    ADD_PATIENT(1,"dodanie nowego pacjenta"),
    ADD_CAT(2,"dodanie kociego pacjenta"),
    ADD_DOG(3, "dodanie psiego pacjenta"),
    PRINT_PATIENTS(4, "wyświetlenie wszystkich dostępnych pacjentów"),
    PRINT_CATS (5, "wyświetlenie kocich pacjentów"),
    PRINT_DOGS(6, "wyświetlenie psich pacjentów");

    private final int value;
    private final String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }
    static Option createFromInt (int option){
        return Option.values()[option];
    }
}
