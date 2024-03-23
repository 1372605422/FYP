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
    requires rxcontrols;
    requires org.apache.poi.ooxml;
    requires jfoenix;


    opens com.GUI to javafx.fxml;
    exports com.GUI;
    exports com.back.example.CostOfCapital;
    exports com.back.example.InputSheet;
    exports com.back.example.OutputSheet;
    exports com.back.example.StoriesToNumbers;
    exports com.back.StaticData;
}