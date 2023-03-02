module com.kensoftph.filechooser {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kensoftph.filechooser to javafx.fxml;
    exports com.kensoftph.filechooser;
}