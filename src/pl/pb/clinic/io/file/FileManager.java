package pl.pb.clinic.io.file;

import pl.pb.clinic.model.Clinic;

public interface FileManager {
    Clinic importData();
    void exportData(Clinic clinic);
}
