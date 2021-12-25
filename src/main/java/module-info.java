module com.badr.functionplotterapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires MathParser.org.mXparser;


    opens com.badr.functionplotterapp to javafx.fxml;
    exports com.badr.functionplotterapp;
}