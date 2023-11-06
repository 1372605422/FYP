package com.front;

import com.back.StaticData.InputData;
import com.back.example.CostOfCapital.*;
import com.back.example.OutPutMethod;
import com.database.FileUtils;
import com.database.Search;
import com.leewyatt.rxcontrols.controls.RXLineButton;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class Controller {
    /*
     * b标签与a标签一一对应
     * 日期行业等先不用输入，只输入数据相关*/
    public static String B19Result;
    public DatePicker B1;
    public TextField B2;
    public TextField B8;
    public TextField B9;
    public TextField B10;
    public TextField B11;
    public TextField B12;
    public TextField B15;
    public TextField B16;
    public TextField B17;
    public TextField B18;
    public TextField B19;
    public TextField B20;
    public CheckBox B13Yes;
    public CheckBox B13No;
    public TextField B21;
    public TextField B24;
//    public TextField B25;
    public TextField B26;
//    public TextField B27;
//    public TextField B28;
//    public TextField B30;
    public TextField B31;
    public TextField B34;
    public TextField B35;
    public TextField B36;
    public TextField B37;
    public CheckBox B33Yes;
    public CheckBox B33No;
    public TextField B42;
    public TextField B45;
    public CheckBox B41Yes;
    public CheckBox B41No;
    public CheckBox B44Yes;
    public CheckBox B44No;
    public CheckBox B47Yes;
    public CheckBox B47No;
    public TextField B48;
    public TextField B50;
    public TextField B55;
    public TextField B59;
    public CheckBox B54Yes;
    public CheckBox B54No;
    public CheckBox B57Yes;
    public CheckBox B57No;
    public CheckBox B60Yes;
    public CheckBox B60No;
    public CheckBox B63Yes;
    public CheckBox B63No;
    public TextField B61;
    public TextField B64;
    public TextField B65;
    public CheckBox B52Yes;
    public CheckBox B52No;
    public Text B50Text;
    public Text B48Text;
    public Text B49Text;
    public Text B45Text;
    public Text B42Text;
    public Text B55Text;
    public Text B61Text;
    public Text B64Text;
    public Text B65Text;
    public Text B59Text;
    public CheckBox B49B;
    public CheckBox B49V;
    public GridPane Sheet1;
    public Button changeButton;
    public GridPane Sheet2;
    public GridPane Sheet4;
    public GridPane Sheet3;
    public GridPane Sheet5;
    public GridPane Sheet6;
    public GridPane Sheet7;
    public Button ChartOpen;
    public TextField captialRatioForNextYear;
    public TextField nextYearGrowthRate;
    public TextField growthRateUpToN;
    public TextField finalYearGrowthRate;
    public TextField FinalYearCapitalRatio;
    public TextField capitalRatioUptoN;
    public Button ChartOpenForCapitalRatio;


    public ComboBox<String> comboCoC1;
    public ComboBox<String> comboCoC2;
    public ComboBox<String> comboCoC3;
    public ComboBox<String> comboCoC5;
    public ComboBox<String> comboCoC4;
    public TextField DirectInputERP;
    public TextField DirectInput1;
    public TextField DirectInputDebt;
    public Text CoCText1;
    public Text CoCText2;
    public Text CoCText3;
    public Text CoCText4;
    public Text CoCText5;
    public Tab tab9;
    public TabPane CostTabPane;
    public Tab tab81;
    public Tab tab82;
    public Tab tab83;
    /**
     * numbers of share outstanding
     */
    public TextField EquityInput1;
    /**
     * Market stock price
     */
    public TextField EquityInput2;
    /**
     * Unlevered Beta
     */
    public TextField EquityInput3;
    /**
     * RiskFree rate
     */
    public TextField EquityInput4;
    /**
     *  ERP
     */
    public TextField EquityInput5;


    public TextField StockInput4;
    public TextField StockInput3;
    public TextField StockInput2;
    /**
     * book value of straight debt
     */
    public TextField DebtInput1;
    /**
     * Interest expense
     */
    public TextField DebtInput2;
    /**
     * Average Maturity
     */
    public TextField DebtInput3;
    public TextField DebtInput4;
    public TextField DebtInput5;
    public TextField DebtInput6;
    public TextField DebtInput7;
    public TextField DebtInput8;
    public TextField DebtInput9;
    public TextField DebtInput10;
    //output part
    public TextField cocOutput1;
    public TextField cocOutput2;
    public TextField cocOutput3;
    public TextField cocOutput4;
    public TextField cocOutput5;
    public TextField cocOutput11;
    public TextField cocOutput12;
    public TextField cocOutput13;
    public TextField cocOutput14;
    public TextField cocOutput21;
    public TextField cocOutput22;
    public TextField cocOutput23;
    public TextField cocOutput24;
    public TextField cocOutput31;
    public TextField cocOutput32;
    public TextField cocOutput33;
    public TextField cocOutput34;
    public Button submit_CostOfCapital;
    public GridPane Sheet8;
    public GridPane Sheet9;
    public GridPane Sheet10;
    public GridPane Sheet11;
    public GridPane Sheet12;

    public RXLineButton DatabaseSearchButton;
    public ComboBox TickerComboBox;

    //    tab页面
    @FXML
    private TabPane tabPane;
//    数据库页面
    public Pane DatabasePane;
//    ML页面
    public Pane MLPane;



    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private void B13CheckYes() {
        //b 为YES 和 NO 选择的返回值， yes为true  no为false
        boolean b = CheckBoxYes(B13Yes, B13No);
        InputData.setB13(b);
    }

    @FXML
    private void initialize() {

        LocalDate currentDate = LocalDate.now();
        B1.setValue(currentDate);

        comboBox1.getItems().addAll(
                "United States",
                "United Kingdom",
                "China",
                "Denmark",
                "Japan","HongKong");




        /*
        ObservableList<String> observableList = FXCollections.observableArrayList("111", "222", "333");
        comboCoC1.setItems(observableList);
         */

        comboBox1.getItems().addAll("United States", "United Kingdom", "China", "Denmark", "Japan","HongKong");
//        comboBox4.getItems().addAll("United States", "United Kingdom", "China", "Denmark", "Japan","HongKong");
        comboCoC1.getItems().addAll("Direct input","Single Business(US)","Single Business(Global)");
        comboCoC2.getItems().addAll("Will input", "Country of incorporation");
        comboCoC3.getItems().addAll("Direct input", "Actual rating", "Synthetic rating");
        comboCoC4.getItems().addAll("1-safer","2-risky");
        comboCoC5.getItems().addAll("Aaa/AAA", "Aa2/AA", "A1/A+", "A2/A", "A3/A-", "Baa2/BBB",
                "Ba1/BB+", "Ba2/BB", "B1/B+", "B2/B", "B3/B-", "C2/C", "Ca2/CC", "Caa/CCC", "D2/D");

        comboCoC1.setValue("Direct input");
        comboCoC2.setValue("Will input");
        comboCoC3.setValue("Direct input");
        comboCoC4.setValue("1-safer");
        comboCoC5.setValue("Aaa/AAA");
        DefaultCoCSelect();




        setAllZero(EquityInput1, EquityInput2, EquityInput3, EquityInput4, EquityInput5, StockInput2, StockInput3, StockInput4, DebtInput1, DebtInput2);
        setAllZero(DebtInput3, DebtInput4, DebtInput5, DebtInput6, DebtInput7, DebtInput8, DebtInput9, DebtInput10, DirectInput1, DirectInputERP);
        setZero(DirectInputDebt);

        tabPane.setVisible(true);
        MLPane.setVisible(false);
        DatabasePane.setVisible(false);
        TickerComboBox.setItems(observableTables);
    }

    private void setAllZero(TextField equityInput1, TextField equityInput2, TextField equityInput3, TextField equityInput4, TextField equityInput5, TextField stockInput2, TextField stockInput3, TextField stockInput4, TextField debtInput1, TextField debtInput2) {
        setZero(equityInput1);
        setZero(equityInput2);
        setZero(equityInput3);
        setZero(equityInput4);
        setZero(equityInput5);
        setZero(stockInput2);
        setZero(stockInput3);
        setZero(stockInput4);
        setZero(debtInput1);
        setZero(debtInput2);
    }


    @FXML
    void result(ActionEvent event) {
        //submit 按钮进行读入 后进行计算
//        try {
            InputData.setB8(Double.parseDouble(B8.getText()));
            InputData.setB9(Double.parseDouble(B9.getText()));
            InputData.setB10(Double.parseDouble(B10.getText()));
            InputData.setB11(Double.parseDouble(B11.getText()));
            InputData.setB12(Double.parseDouble(B12.getText()));

            InputData.setB15(Double.parseDouble(B15.getText()));
            InputData.setB16(Double.parseDouble(B16.getText()));
            InputData.setB17(Double.parseDouble(B17.getText()));
            InputData.setB18(Double.parseDouble(B18.getText()));
            InputData.setB19(Double.parseDouble(B19.getText()));
            B19Result = B19.getText();
            InputData.setB20(isPercentage(B20.getText()));
            InputData.setB21(isPercentage(B21.getText()));


            InputData.setB24(isPercentage(B24.getText()));
//            InputData.setB25(isPercentage(B25.getText()));
            InputData.setB26(isPercentage(B26.getText()));
//            InputData.setB27(Double.parseDouble(B27.getText()));
//            InputData.setB28(Double.parseDouble(B28.getText()));

//            InputData.setB30(isPercentage(B30.getText()));
            InputData.setB31(isPercentage(B31.getText()));

            InputData.setB34(Double.parseDouble(B34.getText()));
            InputData.setB35(Double.parseDouble(B35.getText()));
            InputData.setB36(Double.parseDouble(B36.getText()));
            InputData.setB37(isPercentage(B37.getText()));

            InputData.setB42(isPercentage(B42.getText()));

            InputData.setB45(isPercentage(B45.getText()));
            InputData.setB48(isPercentage(B48.getText()));
            if (B49B.isSelected()){
                InputData.setB49("B");
            } else if (B49V.isSelected()) {
                InputData.setB49("V");
            }

            InputData.setB50(isPercentage(B50.getText()));

            InputData.setB55(Double.parseDouble(B55.getText()));
            InputData.setB58(isPercentage(B59.getText()));
            InputData.setB61(isPercentage(B61.getText()));
            InputData.setB64(Double.parseDouble(B64.getText()));
            InputData.setB65(isPercentage(B65.getText()));


        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("result.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            Scene scene = new Scene(root, 1096, 742);
            stage.setTitle("Result");
            stage.setScene(scene);
            stage.show();
    }


    public void B13CheckNo() {
        boolean b = CheckBoxNo(B13Yes, B13No);
        InputData.setB13(b);
    }

    public void B33CheckYes() {
        boolean b = CheckBoxYes(B33Yes, B33No);
        InputData.setB33(b);
    }

    public void B33CheckNo() {
        boolean b = CheckBoxNo(B33Yes, B33No);
        InputData.setB33(b);
    }

    public void B41CheckYes() {
        boolean b = CheckBoxYes(B41Yes, B41No);
        isVisible(B42Text, B42, B41Yes.isSelected());
        InputData.setB41(b);
    }

    public void B44CheckYes() {
        boolean b = CheckBoxYes(B44Yes, B44No);
        isVisible(B45Text, B45, B44Yes.isSelected());
        InputData.setB44(b);
    }

    public void B41CheckNo() {
        boolean b = CheckBoxNo(B41Yes, B41No);
        InputData.setB41(b);
        B42.setText("0");
    }

    public void B44CheckNo() {
        boolean b = CheckBoxNo(B44Yes, B44No);
        InputData.setB44(b);
        B45.setText("0");
    }

    public void B47CheckYes() {
        boolean b = CheckBoxYes(B47Yes, B47No);
        isVisible(B48Text, B48, B47Yes.isSelected());
        isVisible(B49Text,B49B, B49V, B47Yes.isSelected());
        isVisible(B50Text, B50, B47Yes.isSelected());
        InputData.setB47(b);
    }

    public void B47CheckNo() {
        boolean b = CheckBoxNo(B47Yes, B47No);
        InputData.setB47(b);
        B48.setText("0");
        B49B.setSelected(true);
        B50.setText("0");
    }

    public void B54CheckYes() {
        boolean b = CheckBoxYes(B54Yes, B54No);
        isVisible(B55Text, B55, B54Yes.isSelected());
        InputData.setB54(b);
    }

    public void B54CheckNo() {
        boolean b = CheckBoxNo(B54Yes, B54No);
        InputData.setB54(b);
        B55.setText("0");
    }

    public void B58CheckYes() {
        boolean b = CheckBoxYes(B57Yes, B57No);
        isVisible(B59Text, B59, B57Yes.isSelected());
        InputData.setB57(b);
    }

    public void B58CheckNo() {
        boolean b = CheckBoxNo(B57Yes, B57No);
        InputData.setB57(b);
        B59.setText("0");
    }

    public void B60CheckYes() {
        boolean b = CheckBoxYes(B60Yes, B60No);
        isVisible(B61Text, B61, B60Yes.isSelected());
        InputData.setB60(b);
    }

    public void B60CheckNo() {
        boolean b = CheckBoxNo(B60Yes, B60No);
        InputData.setB60(b);
        B61.setText("0");
    }

    public void B63CheckYes() {
        boolean b = CheckBoxYes(B63Yes, B63No);
        isVisible(B64Text, B64, B63Yes.isSelected());
        isVisible(B65Text,B65,B63Yes.isSelected());
        InputData.setB63(b);
    }

    public void B63CheckNo() {
        boolean b = CheckBoxNo(B63Yes, B63No);
        InputData.setB63(b);
        B64.setText("0");
        B65.setText("0");
    }

    // This is for the CheckBox logic
    public boolean CheckBoxYes(CheckBox yes, CheckBox no) {
        no.setDisable(yes.isSelected());
        return true;
    }

    public boolean CheckBoxNo(CheckBox yes, CheckBox no) {
        yes.setDisable(no.isSelected());
        return false;
    }


    public void isVisible(Text t, TextField f, boolean b) {
        t.setVisible(b);
        f.setVisible(b);
    }

    public void isVisible(Text t,CheckBox v, CheckBox b, boolean bool){
        t.setVisible(bool);
        v.setVisible(bool);
        b.setVisible(bool);
    }

    public double isPercentage(String s){
        if (s.contains("%")){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != 37){
                    stringBuilder.append(s.charAt(i));
                }
            }
            return Double.parseDouble(stringBuilder.toString()) * 0.01;
        }

        return Double.parseDouble(s) * 0.01;
    }


    public void B52CheckYes() {
        boolean b = CheckBoxYes(B52Yes, B52No);
        InputData.setB52(b);
    }

    public void B52CheckNo() {
        boolean b = CheckBoxNo(B52Yes, B52No);
        InputData.setB52(b);
    }


    public void B49CheckB() {
        if (B49V.isSelected()){
            B49V.setSelected(false);
        }
    }

    public void B49CheckV() {
        if (B49B.isSelected()){
            B49B.setSelected(false);
        }
    }

    JSObject jsWindow;
    double nextYear;
    double nextYearForCapitalRatio;
    double finalYearForCapitalRatio;
    double finalYear;
    int upToNYearForGrowthRate;
    int upToNYearForCapitalRatio;


    public void openNewWindow() {
        nextYear = Double.parseDouble(nextYearGrowthRate.getText());
        finalYear = Double.parseDouble(finalYearGrowthRate.getText());
        upToNYearForGrowthRate = Integer.parseInt(growthRateUpToN.getText());

        Stage stage = new Stage();
        stage.setTitle("Revenue chart");

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        Button button = new Button("Save and exit");
        button.setLayoutX(100);
        button.setLayoutY(100);
        button.setPrefWidth(100);
        button.setPrefHeight(50);

        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER_LEFT);

        HBox hBoxOne = new HBox();
        hBoxOne.setSpacing(20);
        hBoxOne.setAlignment(Pos.CENTER_LEFT);

        Text guide = new Text();
        guide.setText("Guide: select two points in the chart and input the convergence below ↓\n1.Please select the point in a sequence which end year is bigger than start year\n2.You can only set convergence once.");
        guide.setLayoutX(100);
        guide.setLayoutY(100);
        guide.prefWidth(100);
        guide.prefHeight(50);
        hBoxOne.getChildren().add(guide);

        Text text = new Text();
        text.setText("Set convergence:");
        text.setLayoutX(100);
        text.setLayoutY(100);
        text.prefWidth(100);
        text.prefHeight(50);

        TextField textField = new TextField();
        textField.setLayoutX(100);
        textField.setLayoutY(100);
        textField.prefWidth(100);
        textField.prefHeight(50);

        Button converge = new Button("Set Up");
        converge.setLayoutX(100);
        converge.setLayoutY(100);
        converge.setPrefWidth(100);
        converge.setPrefHeight(50);


        hBox.getChildren().add(text);
        hBox.getChildren().add(textField);
        hBox.getChildren().add(converge);

       converge.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
               double convergence = Double.parseDouble(textField.getText());
               String s = webEngine.executeScript("getConvergence(" + convergence + ")").toString();
               textField.setDisable(true);
               System.out.println(s);
           }
       });

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String result = jsWindow.call("getMyData").toString();
                String[] dataArray = result.split(",");
                double[] values = new double[upToNYearForGrowthRate + 50];

                for (int i = 0; i < dataArray.length; i += 2) {
                    int index = Integer.parseInt(dataArray[i]) - 1;
                    double value = Double.parseDouble(dataArray[i+1]);
                    System.out.println(value);
                    values[index] = value;
                }
                Collections.addAll(OutPutMethod.revenuesList, Arrays.stream(values).boxed().toArray(Double[]::new));



                Stage stage = (Stage)button.getScene().getWindow();
                stage.close();

            }

        });

        webEngine.load(Objects.requireNonNull(this.getClass().getResource("drag.html")).toExternalForm());
        root.getChildren().add(webView);
        root.getChildren().add(hBoxOne);
        root.getChildren().add(hBox);
        root.getChildren().add(button);

        Scene scene = new Scene(root, 825, 550, Color.web("lightgray"));
        stage.setScene(scene);

        webEngine.getLoadWorker().stateProperty().addListener((ObservableValue<? extends Worker.State> ov, Worker.State oldState, Worker.State newState) -> {
            MyBridge myBridge = new MyBridge();
            myBridge.setBaseYear(nextYear);
            myBridge.setTerminalYear(finalYear);
            ArrayList<Double> myArray = myBridge.getValue(upToNYearForGrowthRate);

            if (newState == Worker.State.SUCCEEDED) {
                try {
//                     Read the contents of the JS file
//                    String script = new String(Files.readAllBytes(Paths.get("src/main/resources/com/front/index.js")));
                    URL url = Controller.class.getResource("index.js");
                    String script;
                    try {
                        script = new String(Files.readAllBytes(Paths.get(url.toURI())));
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }


                    URL url1 = Controller.class.getResource("echarts.js");
                    String script1;
                    try {
                        script1 = new String(Files.readAllBytes(Paths.get(url1.toURI())));
                    } catch (IOException | URISyntaxException e) {
                        throw new RuntimeException(e);
                    }

                    webEngine.executeScript(script1);
                    webEngine.executeScript(script);


                    // Execute the JS file in the WebView
                    jsWindow = (JSObject) webEngine.executeScript("window");
                    jsWindow.setMember("javaArray", myArray);
                    webEngine.executeScript("useJavaArray(javaArray,"+ upToNYearForGrowthRate +")");
                    webEngine.executeScript("setDataZoomRange(myChart,0,100,25,75)");

                } catch (IOException e) {
                    e.printStackTrace();
                }

                stage.show();


            }
        });
    }

    public void openNewWindowForCaptialRatio() {
        nextYearForCapitalRatio = Double.parseDouble(captialRatioForNextYear.getText());
        finalYearForCapitalRatio = Double.parseDouble(FinalYearCapitalRatio.getText());
        System.out.println(finalYearForCapitalRatio);
        upToNYearForCapitalRatio = Integer.parseInt(capitalRatioUptoN.getText());

        Stage stage = new Stage();
        stage.setTitle("Revenue chart");

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        Button buttonOk = new Button("Save and exit");
        buttonOk.setLayoutX(100);
        buttonOk.setLayoutY(100);
        buttonOk.setPrefWidth(100);
        buttonOk.setPrefHeight(50);

        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER_LEFT);


        Text text = new Text();
        text.setText("Set convergence:");
        text.setLayoutX(100);
        text.setLayoutY(100);
        text.prefWidth(100);
        text.prefHeight(50);

        TextField textField = new TextField();
        textField.setLayoutX(100);
        textField.setLayoutY(100);
        textField.prefWidth(100);
        textField.prefHeight(50);

        Button converge = new Button("Set Up");
        converge.setLayoutX(100);
        converge.setLayoutY(100);
        converge.setPrefWidth(100);
        converge.setPrefHeight(50);


        hBox.getChildren().add(text);
        hBox.getChildren().add(textField);
        hBox.getChildren().add(converge);

        converge.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double convergence = Double.parseDouble(textField.getText());
                webEngine.executeScript("getConvergence(" + convergence + ")").toString();

            }
        });
        buttonOk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String result = jsWindow.call("getMyData").toString();
                String[] dataArray = result.split(",");
                double[] values = new double[upToNYearForCapitalRatio + 10];

                for (int i = 0; i < dataArray.length; i += 2) {
                    int index = Integer.parseInt(dataArray[i]) - 1;
                    double value = Double.parseDouble(dataArray[i+1]);
                    System.out.println(value);
                    values[index] = value;
                }
                //TODO capital ratio的list在哪？
//                Collections.addAll(OutPutMethod.revenuesList, Arrays.stream(values).boxed().toArray(Double[]::new));
                Stage stage = (Stage)buttonOk.getScene().getWindow();
                stage.close();
            }
        });

        webEngine.load(Objects.requireNonNull(this.getClass().getResource("drag.html")).toExternalForm());
        root.getChildren().add(webView);
        root.getChildren().add(hBox);
        root.getChildren().add(buttonOk);

        Scene scene = new Scene(root, 825, 550, Color.web("lightgray"));
        stage.setScene(scene);

        webEngine.getLoadWorker().stateProperty().addListener((ObservableValue<? extends Worker.State> ov, Worker.State oldState, Worker.State newState) -> {
            MyBridge myBridge = new MyBridge();
            myBridge.setBaseYear(nextYearForCapitalRatio);
            myBridge.setTerminalYear(finalYearForCapitalRatio);
            ArrayList<Double> myArray = myBridge.getValue(upToNYearForCapitalRatio);

            if (newState == Worker.State.SUCCEEDED) {
                try {
                    // Read the contents of the JS file
                    URL url = Controller.class.getResource("index.js");
                    String script;
                    try {
                        script = new String(Files.readAllBytes(Paths.get(url.toURI())));
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }

                    URL url1 = Controller.class.getResource("echarts.js");
                    String script1;
                    try {
                        script1 = new String(Files.readAllBytes(Paths.get(url1.toURI())));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }

                    webEngine.executeScript(script1);

                    webEngine.executeScript(script);
                    // Execute the JS file in the WebView
                    jsWindow = (JSObject) webEngine.executeScript("window");
                    jsWindow.setMember("javaArray", myArray);
                    webEngine.executeScript("useJavaArray(javaArray,"+ upToNYearForCapitalRatio +")");
                    webEngine.executeScript("setDataZoomRange(myChart,0,100,25,75)");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                stage.show();


            }
        });
    }
    public void LightMode() {
        /*
        Scene scene = changeButton.getScene();

        scene.getStylesheets().removeAll("interface.css");

        scene.getStylesheets().add("interface.css");
         */
        //修改背景的

        String[] ChineseSheet1={"日期" ,"公司名" ,"国家" ,"行业" ,"行业(全球)" ,"营业额" ,"营业利润"
                ,"利息费用" ,"股权账面价值" ,"债权账面价值" ,"是否有研发费用需要资本化?" ,"现金和适销证券"
                ,"交叉持股和其他非经营性资产" ,"少数股东权益" ,"流通股票数量" ,"当前股价" ,"有效税率" ,"边际税率"};
        String[] ChineseSheet2={ "次年收入增长率","次年营业利润率", "目标税前营业利润率", "至n年销售额与资本的比率",
                "目标销售额与资本比率","第n年的收入增长率","直至n年的收入增长率", "次年销售额与资本比率",
                "无风险收益率","初始资本成本"};
        String[] ChineseSheet3={"是否存在未完成的员工期权？", "未完成的期权数量", "平均执行价格",
                "平均期限", "股价标准差",};
        String[] ChineseSheet4={"您想覆盖这个假设吗？",
                "输入第10年后的资本成本",
                "您想覆盖这个假设吗？",
                "输入第10年后您预期的资本回报率",
                "我将假设您的公司在第10年后的资本回报率等于其资本成本。我假设您今天拥有的任何竞争优势会随着时间的推移而消失。",
                "在稳定增长阶段，我将假设您的公司的资本成本类似于典型成熟公司的资本成本（无风险利率+4.5％）",
                "我将假设您的公司在可预见的未来没有失败的机会",
                "输入失败概率",
                "您想将失败的收益与什么联系起来？",
                "输入破产清算收益作为账面价值或公允价值的百分比",
                "您想覆盖这个假设吗？",
                "我将假设您的有效税率将调整为您终止年度的边际税率。如果您覆盖此假设，我将保持税率为您的有效税率。",
                "您想覆盖这个假设吗？"};
        String[] ChineseSheet5={"您想覆盖这个假设吗？",
                "输入您带入第1年的可抵税亏损（NOL）",
                "您想覆盖这个假设吗？",
                "输入第10年后的无风险利率",
                "我将假设今天的无风险利率将永久保持不变。如果您覆盖此假设，我将更改第10年后的无风险利率。",
                "我将假设您没有来自前几年的损失结转（NOL）进入估值。如果您的公司存在亏损，您可能需要覆盖此假设。",
                "我将假设永久增长率等于无风险利率。这既可以实现估值一致性，又可以避免“不可能”的增长率。",
                "输入永久增长率",
                "您想覆盖这个假设吗？",
                "我已假设现金没有被周转困难（例如不可从外国周转）并且没有额外的税收责任，现金是一项中性资产。",
                "您想覆盖这个假设吗？",
                "输入被困住的现金（如果是税）或整个余额（如果是不信任）",
                "被困住的现金所在国外市场的平均税率"};
        String[] ChineseSheet6={"请选择一个国家","请选择一个行业","请输入国公司"};
        String[] ChineseSheet7={"股票代码:", "营业收入:", "行业:", "年份:", "营收:", "营业费用:", "研发费用:", "成本及费用:",
                "利息费用:", "EBIT 利润率:", "股东权益账面价值:", "负债账面价值:", "加权平均股本:", "当前股价:",};
        String[] ChineseSheet8={"流通股数量 =", "每股当前市场价格 =", "估算β的方法", "无杠杆β =", "无风险利率 =",
                "输入ERP的方法是什么？", "股权风险溢价用于权益成本 =", "股本", "输入杠杆β（或回归β）", "直接输入ERP",};
        String[] ChineseSheet9={"优先股数量 =", "每股当前市场价格 =", "每股年度股息 =", "优先股",};
        String[] ChineseSheet10={"直接债务的账面价值 =", "债务利息支出 =", "平均到期期限 =",
                "税率 =", "估算税前债务成本的方法", "税前债务成本 =", "可转换债务的账面价值 =",
                "可转换债务的利息支出 =", "可转换债券的到期期限 =", "可转换债券的市场价值 =", "经营租赁的债务价值 =",
                "如果直接输入，则输入税前债务成本", "如果合成评级，则输入公司类型", "如果实际评级，则输入评级",};
        String[] ChineseSheet11={"估算直接债务的市场价值 =", "估算可转换债务的直接债务价值 =",
                "经营租赁中的债务价值 =", "估算可转换债务的股本价值 =", "股权的杠杆β =",};
        String[] ChineseSheet12={"市场价值", "资本成本中的权重", "成本成分",};
        /*
        int i=0;
        for (Node node : Sheet1.getChildren()) {
            if (GridPane.getColumnIndex(node) == 1) {
                // Check if node is in second column
                if (node instanceof Text) {
                    // Check if node is a label or its subclass
                    System.out.println("233"+((Text) node).getText()+"233"+",");
                    ((Text) node).setText(ChineseSheet1[i]);
                    //System.out.println(ChineseSheet1[i]);
                    i++;
                    // Cast node to Labeled and set its text
                }
            }
        }
         */
        ChangeVersion(ChineseSheet1,Sheet1);
        ChangeVersion(ChineseSheet2,Sheet2);
        ChangeVersion(ChineseSheet3,Sheet3);
        ChangeVersion(ChineseSheet4,Sheet4);
        ChangeVersion(ChineseSheet5,Sheet5);
        ChangeVersion(ChineseSheet6,Sheet6);
        ChangeVersion(ChineseSheet7,Sheet7);
        ChangeVersion(ChineseSheet8,Sheet8);
        ChangeVersion(ChineseSheet9,Sheet9);
        ChangeVersion(ChineseSheet10,Sheet10);
        ChangeVersion(ChineseSheet11,Sheet11);
        ChangeVersion(ChineseSheet12,Sheet12);
        System.out.println("道");
        int i=0;
        for (Node node : Sheet9.getChildren()) {
            if (GridPane.getColumnIndex(node) == 1) {
                // Check if node is in second column
                if (node instanceof Text) {
                    // Check if node is a label or its subclass
                    System.out.println("\""+((Text) node).getText()+"\",");
                    //((Text) node).setText(ChineseSheet1[i]);
                    //System.out.println(ChineseSheet1[i]);
                    i++;
                    // Cast node to Labeled and set its text
                }
            }
        }

    }

    public void ChangeVersion(String[] strings, GridPane gridPane){
        int i=0;
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == 1) {
                // Check if node is in second column
                if (node instanceof Text) {
                    if(!Objects.equals(((Text) node).getText(), "")){
                        // Check if node is a label or its subclass
                        System.out.println("\""+((Text) node).getText()+"\""+",");
                        ((Text) node).setText(strings[i]);
                        //System.out.println(ChineseSheet1[i]);
                        i++;
                        // Cast node to Labeled and set its text
                    }
                }
            }
        }
    }

    public void Eng_Version() {
        String[] EnglishSheet1={"Date of valuation", "Company name", "Country", "Industry", "Industry (Global)",
                "Revenues", "EBIT or Operating income", "Interest expense", "Book value of equity", "Book value of debt",
                "R&D expense to capitalize?", "Cash and Marketable Securities",
                "Crossing holdings", "Minority interests", "Number of shares outstanding",
                "Current stock price", "Effective tax rate", "Marginal tax rate",
        };
        String[] EnglishSheet2={"Revenue growth rate for next year",
                "Operating Margin for next year",
                "Target pre-tax operating margin",
                "Sales to capital ratio up to year n =",
                "Target sales to capital ratio",
                "Revenue growth rate for the n year",
                "Revenue growth rate up to year n =",
                "Sales to capital ratio for next year",
                "Risk-Free rate",
                "Initial cost of capital",};
        String[] EnglishSheet3={"Do you have employee options outstanding?",
                "Number of options outstanding",
                "Average strike price",
                "Average maturity",
                "Standard deviation on stock price",};
        String[] EnglishSheet4={"Do you want to override this assumption",
                "Enter the cost of capital after year 10",
                "Do you want to override this assumption",
                "Enter the return on capital you expect after year 10",
                "I will assume that your firm will earn a return on capital equal to its cost of capital after year 10. I am assuming that whatever competitive advantages you have today will fade over time.",
                "In stable growth, I will assume that your firm will have a cost of capital similar to that of typical mature companies (risk-free rate + 4.5%)",
                "I will assume that your firm has no chance of failure over the foreseeable future",
                "Enter the probability of failure",
                "What do you want to tie your proceeds in failure to?",
                "Enter the distress proceeds as percentage of book or fair value",
                "Do you want to override this assumption",
                "I will assume that your effective tax rate will adjust to your marginal tax rate by your terminal year. If you override this assumption, I will leave the tax rate at your effective tax rate.",
                "Do you want to override this assumption",
        };
        String[] EnglishSheet5={"Do you want to override this assumption",
                "Enter the NOL that you are carrying over into year 1",
                "Do you want to override this assumption",
                "Enter the risk-free rate after year 10",
                "I will assume that today's risk free rate will prevail in perpetuity. If you override this assumption, I will change the risk-free rate after year 10.",
                "I will assume that you have no losses carried forward from prior years ( NOL) coming into the valuation. If you have a money losing company, you may want to override this.",
                "I will assume that the growth rate in perpetuity will be equal to the risk free rate. This allows for both valuation consistency and prevents \"impossible\" growth rates.",
                "Enter the growth rate in perpetuity",
                "Do you want to override this assumption?",
                "I have assumed that none of the cash is trapped (in foreign countries) and that there is no additional tax liability coming due and that cash is a neutral asset.",
                "Do you want to override this assumption",
                "Enter trapped cash (if taxes) or entire balance (if mistrust)",
                "Average tax rate of the foreign markets where the cash is trapped",
        };
        String[] EnglishSheet6={"Please choose a country",
                "Please choose an industry","Please enter a company"};
        String[] EnglishSheet7={"Symbol:", "Operating Income:", "Industry:", "Year:", "Revenue:", "Operating Expenses:",
                "Research and Development Expenses:", "Cost and Expenses:", "Interest Expense:", "EBIT Margin:",
                "Book Value of Equity:", "Book Value of debt:", "Weighted Average Shares Outstanding:",
                "Current stock price:",};
        String[] EnglishSheet8={"Number of Shares outstanding =",
                "Current Market Price per share =", "Approach for estimating beta", "Unlevered beta =", "Risk-free Rate =",
                "What approach will be used to input ERP?", "Equity Risk Premium used in cost of equity =",
                "Equity", "Enter levered beta (or regression beta)", "Direct input for ERP",};
        String[] EnglishSheet9={"Number of Preferred Shares =",
                "Current Market Price per share =", "Annual Dividend per Share =", "Preferred Stock",};
        String[] EnglishSheet10={"Book Value of Straight Debt =",
                "Interest Expense on Debt =", "Average Maturity =", "Tax Rate =",
                "Approach for estimating pre-tax cost of debt", "Pre-tax Cost of Debt =",
                "Book Value of Convertible Debt =", "Interest Expense on Convertible =",
                "Maturity of Convertible Bond =", "Market Value of Convertible =",
                "Debt value of operating leases =", "If direct input, input the pre-tax cost of debt",
                "If synthetic rating, input the type of company", "If actual rating, input the rating",};
        String[] EnglishSheet11={"Estimating Market Value of Straight Debt =",
                "Estimated Value of Straight Debt in Convertible =", "Value of Debt in Operating leases =",
                "Estimated Value of Equity in Convertible =", "Levered Beta for equity =",};
        String[] EnglishSheet12={"Market Value", "Weight in Cost of Capital", "Cost of Component",};

        ChangeVersion(EnglishSheet1,Sheet1);
        ChangeVersion(EnglishSheet2,Sheet2);
        ChangeVersion(EnglishSheet3,Sheet3);
        ChangeVersion(EnglishSheet4,Sheet4);
        ChangeVersion(EnglishSheet5,Sheet5);
        ChangeVersion(EnglishSheet6,Sheet6);
        ChangeVersion(EnglishSheet7,Sheet7);
        ChangeVersion(EnglishSheet8,Sheet8);
        ChangeVersion(EnglishSheet9,Sheet9);
        ChangeVersion(EnglishSheet10,Sheet10);
        ChangeVersion(EnglishSheet11,Sheet11);
        ChangeVersion(EnglishSheet12,Sheet12);
    }

    public void CoCSelect1() {
        if(comboCoC1.getValue().equals("Direct input")){
            InputForCapital.setB9ApproachForEstimatingBeta("Direct input");
            DirectInput1.setVisible(true);
            CoCText1.setVisible(true);
        }
        else {
            if(comboCoC1.getValue().equals("Single Business(US")){
                InputForCapital.setB9ApproachForEstimatingBeta("Single Business(US)");
            } else if (comboCoC1.getValue().equals("Single Business(Global)")) {
                InputForCapital.setB9ApproachForEstimatingBeta("Single Business(Global)");
            }
            DirectInput1.setVisible(false);
            CoCText1.setVisible(false);
        }
    }

    public void CoCSelect2() {
        if(comboCoC2.getValue().equals("Will input")){
            DirectInputERP.setVisible(true);
            CoCText2.setVisible(true);
        }
        else {
            DirectInputERP.setVisible(false);
            CoCText2.setVisible(false);
        }
    }

    public void CoCSelect3() {
        if(comboCoC3.getValue().equals("Direct input")){
            DirectInputDebt.setVisible(true);
            CoCText3.setVisible(true);
            comboCoC4.setVisible(false);
            CoCText4.setVisible(false);
            comboCoC5.setVisible(false);
            CoCText5.setVisible(false);
            InputForCapital.setB21ApproachForPreTaxCostOfDebt("Direct input");
        }
        else if(comboCoC3.getValue().equals("Actual rating")){
            DirectInputDebt.setVisible(false);
            CoCText3.setVisible(false);
            comboCoC4.setVisible(false);
            CoCText4.setVisible(false);
            comboCoC5.setVisible(true);
            CoCText5.setVisible(true);
            InputForCapital.setB21ApproachForPreTaxCostOfDebt("Actual rating");
        }
        else if(comboCoC3.getValue().equals("Synthetic rating")){
            DirectInputDebt.setVisible(false);
            CoCText3.setVisible(false);
            comboCoC4.setVisible(true);
            CoCText4.setVisible(true);
            comboCoC5.setVisible(false);
            CoCText5.setVisible(false);
            InputForCapital.setB21ApproachForPreTaxCostOfDebt("Synthetic rating");
        }
    }

    public void CoCSelect4(){
        if(comboCoC4.getValue().equals("1-safer")){
            InputForCapital.setB24SyntheticRatingType("1");
        } else {
            InputForCapital.setB24SyntheticRatingType("2");
        }
    }

    public void CoCSelect5(){
        InputForCapital.setB23ActualRating(comboCoC5.getValue());
    }

    public void DefaultCoCSelect(){
        if(comboCoC1.getValue().equals("Direct input")){
            InputForCapital.setB9ApproachForEstimatingBeta("Direct input");
            DirectInput1.setVisible(true);
            CoCText1.setVisible(true);
        }
        else {
            if(comboCoC1.getValue().equals("Single Business(US")){
                InputForCapital.setB9ApproachForEstimatingBeta("Single Business(US)");
            } else if (comboCoC1.getValue().equals("Single Business(Global)")) {
                InputForCapital.setB9ApproachForEstimatingBeta("Single Business(Global)");
            }
            DirectInput1.setVisible(false);
            CoCText1.setVisible(false);
        }
        if(comboCoC2.getValue().equals("Will input")){
            DirectInputERP.setVisible(true);
            CoCText2.setVisible(true);
        }
        else {
            DirectInputERP.setVisible(false);
            CoCText2.setVisible(false);
        }
        if(comboCoC3.getValue().equals("Direct input")){
            DirectInputDebt.setVisible(true);
            CoCText3.setVisible(true);
            comboCoC4.setVisible(false);
            CoCText4.setVisible(false);
            comboCoC5.setVisible(false);
            CoCText5.setVisible(false);
            InputForCapital.setB21ApproachForPreTaxCostOfDebt("Direct input");
        }
        else if(comboCoC3.getValue().equals("Actual rating")){
            DirectInputDebt.setVisible(false);
            CoCText3.setVisible(false);
            comboCoC4.setVisible(false);
            CoCText4.setVisible(false);
            comboCoC5.setVisible(true);
            CoCText5.setVisible(true);
            InputForCapital.setB21ApproachForPreTaxCostOfDebt("Actual rating");
        }
        else if(comboCoC3.getValue().equals("Synthetic rating")){
            DirectInputDebt.setVisible(false);
            CoCText3.setVisible(false);
            comboCoC4.setVisible(true);
            CoCText4.setVisible(true);
            comboCoC5.setVisible(false);
            CoCText5.setVisible(false);
            InputForCapital.setB21ApproachForPreTaxCostOfDebt("Synthetic rating");
        }
    }


    public void ToTab81() {
        tabPane.getSelectionModel().select(tab9);
        CostTabPane.getSelectionModel().select(tab81);
    }


    public void setZero(TextField textField){
        textField.setText("0");
    }

    public void submitCostOfCapital() {
            //cost of capital part: Equity
            InputData.setB18(Double.parseDouble(EquityInput1.getText()));
            InputData.setB19(Double.parseDouble(EquityInput2.getText()));
            InputForCapital.setB10leveredBeta(Double.parseDouble(DirectInput1.getText()));
            InputData.setB30(Double.parseDouble(EquityInput4.getText()));
            InputForCapital.setB14DirectInputForERP(Double.parseDouble(DirectInputERP.getText()));
            InputForCapital.setCountryERP(0.068);
            CostB15ERPInEquity.setERPInEquity();
            EquityInput5.setText(String.valueOf(CostB15ERPInEquity.getERPInEquity()));

            //cost of capital part: Preferred Stock
            InputForCapital.setB36NumberOfPreferredShares(Double.parseDouble(StockInput2.getText()));
            InputForCapital.setB37CurrentMarketPricePerShare(Double.parseDouble(StockInput3.getText()));
            InputForCapital.setB38AnnualDividedPerShare(Double.parseDouble(StockInput4.getText()));

            //cost of capital part: Debt
            InputData.setB12(Double.parseDouble(DebtInput1.getText()));
            InputData.setB10(Double.parseDouble(DebtInput2.getText()));
            InputForCapital.setB20AverageMaturity(Double.parseDouble(DebtInput3.getText()));
            InputForCapital.setB22DirectInputPreTaxCostOfDebt(Double.parseDouble(DirectInputDebt.getText()));
            CostB25PreTaxCostOfDebt.setPreTaxCostOfDebt();
            DebtInput4.setText(String.valueOf(CostB25PreTaxCostOfDebt.getPreTaxCostOfDebt()));
            InputData.setB21(Double.parseDouble(DebtInput5.getText()));
            InputForCapital.setB28BookValueOfConvertibleDebt(Double.parseDouble(DebtInput6.getText()));
            InputForCapital.setB29InterestExpenseOnConvertible(Double.parseDouble(DebtInput7.getText()));
            InputForCapital.setB30MaturityOfConvertibleBond(Double.parseDouble(DebtInput8.getText()));
            InputForCapital.setB31MarketValueOfConvertible(Double.parseDouble(DebtInput9.getText()));
            InputForCapital.setB33DebtValueOfOperatingLeases(Double.parseDouble(DebtInput10.getText()));


            //output part
            CostB48MarketEquity.setMarketEquity();// Should put front


            CostB11UnleveredBeta.setUnLeveredBeta();
            CostB15ERPInEquity.setERPInEquity();
            CostB25PreTaxCostOfDebt.setPreTaxCostOfDebt();
            CostC41EstimatingMarketValueOfStraightDebt.setEstimatingMarketValueOfStraightDebt();
            CostC42EstimatedValueOfStraightDebtInConvertible.setEstimatedValueOfStraightDebtInConvertible();
            CostC44EstimatedValueOfEquityInConvertible.setEVInConvertible();

            CostC48MarketDebt.setMarketDebt(); // C48 should be placed before C45
            CostC45LeveredBetaForEquity.setLeveredBetaForEquity();

            CostD48MarketPreferredStock.setMarketPreferredStock();
            CostE48MarketCapital.setMarketCapital();

            CostB49WeightOfEquity.setWeightOfEquity();
            CostC49WeightOfDebt.setWeightOfDebt();
            CostD49WeightOfPreferred.setWeightOfPreferredStock();
            CostB50EquityComponent.setEquityComponent();
            CostC50DebtComponent.setDebtComponent();
            CostD50PreferredStockComponent.setPreferredStockComponent();
            CostE50CostOfCapital.setCostOfCapital();


            cocOutput1.setText(String.valueOf(CostC41EstimatingMarketValueOfStraightDebt.getEstimatingMarketValueOfStraightDebt()));
            cocOutput2.setText(String.valueOf(CostC42EstimatedValueOfStraightDebtInConvertible.getEstimatedValueOfStraightDebtInConvertible()));
            cocOutput3.setText(String.valueOf(InputForCapital.getB33DebtValueOfOperatingLeases()));
            cocOutput4.setText(String.valueOf(CostC44EstimatedValueOfEquityInConvertible.getEVInConvertible()));
            cocOutput5.setText(String.valueOf(CostC45LeveredBetaForEquity.getLeveredBetaForEquity()));

            cocOutput11.setText(String.valueOf(CostB48MarketEquity.getMarketEquity()));
            cocOutput12.setText(String.valueOf(CostC48MarketDebt.getMarketDebt()));
            cocOutput13.setText(String.valueOf(CostD48MarketPreferredStock.getMarketPreferredStock()));
            cocOutput14.setText(String.valueOf(CostE48MarketCapital.getMarketCapital()));

            cocOutput21.setText(String.valueOf(CostB49WeightOfEquity.getWeightOfEquity()));
            cocOutput22.setText(String.valueOf(CostC49WeightOfDebt.getWeightOfDebt()));
            cocOutput23.setText(String.valueOf(CostD49WeightOfPreferred.getWeightOfPreferredStock()));
            cocOutput24.setText(String.valueOf(1));

            cocOutput31.setText(String.valueOf(CostB50EquityComponent.getEquityComponent()));
            cocOutput32.setText(String.valueOf(CostC50DebtComponent.getDebtComponent()));
            cocOutput33.setText(String.valueOf(CostD50PreferredStockComponent.getPreferredStockComponent()));
            cocOutput34.setText(String.valueOf(CostE50CostOfCapital.getCostOfCapital()));
    }

    public void CalculationButton() {
        DatabasePane.setVisible(false);
        MLPane.setVisible(false);
        tabPane.setVisible(true);
    }

    public void DatabaseButton() {
        tabPane.setVisible(false);
        MLPane.setVisible(false);
        DatabasePane.setVisible(true);
    }

    public void MLButton() {
        tabPane.setVisible(false);
        DatabasePane.setVisible(false);
        MLPane.setVisible(true);
    }

    Connection conn;
    List<String> tables;
    ObservableList<String> observableTables;
    ResultSet resultSet;

    //链接数据库
    {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:FinanceData.db");
            tables = Search.getDataTable(conn);
            tables.sort(new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return Character.compare(s1.charAt(0), s2.charAt(0));
                }
            });

            observableTables = FXCollections.observableArrayList(tables);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //将用户输入查询数据库
    public void DatabaseSearch() throws SQLException {
        String ticker = TickerComboBox.getEditor().getText();
        if (tables.contains(ticker)){
            //查询数据，并保存到一个list中
            resultSet = Search.searchTable(conn, ticker);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("Data found!");
            alert.show();

            B2.setText(ticker);
        } else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText("Data miss!");
            alert.setContentText("Query data does not exist in the database, do you want to do a web search?");
            ButtonType customButtonType = new ButtonType("Search Online");
            ButtonType cancelButtonType = ButtonType.CANCEL;

            alert.getButtonTypes().setAll(customButtonType, cancelButtonType);

            DialogPane dialogPane = alert.getDialogPane();
            Button customButton = (Button) dialogPane.lookupButton(customButtonType);
            customButton.setOnAction(e -> {
                // 网上搜索并导入到数据中
                String onlineTicker = TickerComboBox.getEditor().getText();
                if (Objects.equals(onlineTicker, "")){
                    Alert alert1 = new Alert(Alert.AlertType.WARNING);
                    alert1.setTitle("WARNING");
                    alert1.setHeaderText("Empty Data or wrong ticker!");
                    alert1.setContentText("Please enter a correct Ticker!");
                    alert.close();
                    alert1.show();
                }else{
                    String filePath = "GetData/config/config.json";
                    FileUtils.writeFile(filePath,onlineTicker);
                    int exitcode = Search.searchOline();
                    if (exitcode != 0){
                        Alert alert1 = new Alert(Alert.AlertType.WARNING);
                        alert1.setTitle("WARNING");
                        alert1.setHeaderText("Empty Data or wrong ticker!");
                        alert1.setContentText("Please enter a correct Ticker!");
                        alert.close();
                        alert1.show();
                    }
                }
            });


            alert.show();
        }

    }


    //将数据加载到计算界面
    public void DatabaseLoad() throws SQLException {
        if (resultSet == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText("Data miss!");
            alert.setContentText("Please select the company you want to search for!");
            alert.show();
            return;
        }

        double totalAssets = 0.0;

        while (resultSet.next()) {
            String columnName = resultSet.getString("income_statement_index");
            double value = resultSet.getDouble("income_statement_value");
            String balanceSheetIndex = resultSet.getString("balance_sheet_index");
            double balanceSheetValue = resultSet.getDouble("balance_sheet_value");
            //cashFlow table 暂时不用
            String cashFlowIndex = resultSet.getString("cashflow_index");
            double cashFlowValue = resultSet.getDouble("cashflow_value");

            String currentPrice = resultSet.getString("current_price");
            double currentPriceValue = resultSet.getDouble("current_price_value");
            
            if (Objects.equals(columnName, "EBIT")){
                B9.setText(String.valueOf(value));
            } else if (Objects.equals(columnName, "Total Revenue")){
                B8.setText(String.valueOf(value));
            } else if (Objects.equals(columnName, "Interest Expense")){
                B10.setText(String.valueOf(value));
            } else if (Objects.equals(columnName, "Tax Rate For Calcs")){
                B20.setText(String.valueOf(value * 100));
            } else if (Objects.equals(balanceSheetIndex, "Cash And Cash Equivalents")) {
                B15.setText(String.valueOf(balanceSheetValue));
            }else if (Objects.equals(balanceSheetIndex, "Minority Interest")) {
                B17.setText(String.valueOf(balanceSheetValue));
            } else if (Objects.equals(currentPrice, "current_price")) {
                B19.setText(String.valueOf(currentPriceValue));
            } else if (Objects.equals(balanceSheetIndex, "Ordinary Shares Number")) {
                B18.setText(String.valueOf(balanceSheetValue));
            } else if (Objects.equals(balanceSheetIndex, "Total Assets")) {
                totalAssets = balanceSheetValue;
            } else if (Objects.equals(balanceSheetIndex, "Total Equity Gross Minority Interest")) {
                double BookValueOfDebt = totalAssets - balanceSheetValue;
                B12.setText(String.valueOf(BookValueOfDebt));
            } else if (Objects.equals(balanceSheetIndex, "Total Liabilities Net Minority Interest")) {
                double BookValueOfEquity = totalAssets - balanceSheetValue;
                B11.setText(String.valueOf(BookValueOfEquity));
            }
        }

        CalculationButton();
    }

    public void DataBaseImport() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        File selectedDirectory = fileChooser.showOpenDialog(new Stage());
        if (selectedDirectory != null) {
            String folderPath = selectedDirectory.getAbsolutePath();
            System.out.println(folderPath);
        }
    }

    public void DatabaseDownload() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        File selectedDirectory = directoryChooser.showDialog(new Stage());
        if (selectedDirectory != null & resultSet != null) {
            String folderPath = selectedDirectory.getAbsolutePath();
            System.out.println(folderPath);
            String ticker = TickerComboBox.getEditor().getText();
            Search.downloadData(ticker,folderPath, resultSet);
        }else{
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("WARNING");
            alert1.setHeaderText("Empty Data or wrong ticker!");
            alert1.setContentText("Please enter a correct Ticker!");
            alert1.show();
        }
    }

}
