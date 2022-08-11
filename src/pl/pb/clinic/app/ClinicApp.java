package pl.pb.clinic.app;

public class ClinicApp {
    private static final String APP_NAME = "VetClinic v 0.4";
    public static void main(String[] args) {
        System.out.println(APP_NAME);

        ClinicControl clinicControl = new ClinicControl();
        clinicControl.controlLoop();

    }
}
