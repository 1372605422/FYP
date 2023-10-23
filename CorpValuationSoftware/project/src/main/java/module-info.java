module com.front {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.web;
    requires jdk.jsobject;
    requires java.sql;
    requires java.base;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.csv;
    requires itextpdf;

    opens com.front to javafx.fxml;
    exports com.front;
    exports com.back.example.CostOfCapital;
    exports com.back.example.InputSheet;
    exports com.back.example.OutputSheet;
    exports com.back.example.StoriesToNumbers;
    exports com.back.StaticData;
}