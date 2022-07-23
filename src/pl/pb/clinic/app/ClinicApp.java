package pl.pb.clinic.app;

public class ClinicApp {
    public static void main(String[] args) {
        final String appName = "VetClinic v 0.2";
        System.out.println(appName);
        ClinicControl clinicControl = new ClinicControl();
        clinicControl.controlLoop();
    }
}
