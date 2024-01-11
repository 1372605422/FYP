package com.front;

import com.back.StaticData.InputData;
import com.database.FileUtils;
import com.database.Search;
import com.leewyatt.rxcontrols.controls.RXLineButton;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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
    public TextField B26;
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
    public GridPane Sheet4;
    public GridPane Sheet5;
    public TextField captialRatioForNextYear;
    public TextField nextYearGrowthRate;
    public TextField growthRateUpToN;
    public TextField finalYearGrowthRate;
    public TextField capitalRatioUptoN;

    public RXLineButton DatabaseSearchButton;
    public ComboBox TickerComboBox;
    public Text DataBaseProfile;
    public Text DataBaseName;
    public TextField country;
    public TextField industry;
    public TextField OperatingMargin;
    public TextField TargetSalesToCapitalRatio;

    //    tab页面
    @FXML
    private TabPane tabPane;
//    数据库页面
    public Pane DatabasePane;




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
        tabPane.setVisible(true);

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


            InputData.setB24(isPercentage("0"));
            InputData.setB26(isPercentage(B26.getText()));
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

            InputData.setDate(String.valueOf(B1.getValue()));
            InputData.setCountry(String.valueOf(country.getText()));
            InputData.setCompanyName(String.valueOf(B2.getText()));
            InputData.setIndustry(String.valueOf(industry.getText()));



            HashMap<String, Object> resultSetMap = new HashMap<>();
            try {
                ResultSetMetaData metaData = resultSetInfo.getMetaData();
                int columnCount = metaData.getColumnCount();

                // Iterate over the ResultSet and store each column value in the map
                while (resultSetInfo.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        Object columnValue = resultSetInfo.getObject(i);
                        resultSetMap.put(columnName, columnValue);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

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
                stage.setUserData(resultSetMap);
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




    public void setZero(TextField textField){
        textField.setText("0");
    }


    public void CalculationButton() {
        DatabasePane.setVisible(false);
        tabPane.setVisible(true);
    }

    public void DatabaseButton() {
        tabPane.setVisible(false);
        DatabasePane.setVisible(true);
    }


    Connection conn;
    List<String> tables;
    ObservableList<String> observableTables;
    ResultSet resultSet;
    ResultSet resultSetInfo;
    String osName = System.getProperty("os.name");


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
    public void DatabaseSearch() {
            String ticker = TickerComboBox.getEditor().getText();
            String underlyingSymbol = Search.checkCol(conn, ticker);


            if (underlyingSymbol != null) {
                String temp = underlyingSymbol;
                underlyingSymbol = ticker;
                ticker = temp;
            }

            if (tables.contains(ticker)) {
                try {
                    //查询数据，并保存到一个list中
                    resultSet = Search.searchTable(conn, ticker);


                    if (underlyingSymbol == null) {
                        while (resultSet.next()) {
                            underlyingSymbol = resultSet.getString("long_name");
                        }
                    }

                    // Close the current ResultSet
                    resultSet.close();

                    // Execute the query again to get a new ResultSet
                    resultSet = Search.searchTable(conn, ticker);

                    resultSetInfo = Search.searchTable(conn, underlyingSymbol);

                    String longName = resultSetInfo.getString("longName");
                    DataBaseName.setText(longName);


                    String longBusinessSummary = resultSetInfo.getString("longBusinessSummary");
                    DataBaseProfile.setText(longBusinessSummary);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Message");
                    alert.setHeaderText("Data found!");
                    alert.show();

                } catch (SQLException e) {
                    System.out.println("Empty Data or wrong ticker!");
                }
            }else{
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
                    String filePath = "GetData/config/config.json";
                    FileUtils.writeFile(filePath, onlineTicker);

                    String script = "GetData/dist/GetFinanceData/GetFinanceData";

                    int exitcode;

                    try {
                        exitcode = Search.searchOnline(script);
                    } catch (IOException | InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }

                    Platform.runLater(() -> {
                        if (exitcode != 0) {
                            Alert alert1 = new Alert(Alert.AlertType.WARNING);
                            alert1.setTitle("WARNING");
                            alert1.setHeaderText("Empty Data or wrong ticker!");
                            alert1.setContentText("Please enter a correct Ticker!");
                            alert.close();
                            alert1.show();

                        } else {
                            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                            alert2.setTitle("Message");
                            alert2.setHeaderText("Data found!");
                            alert2.show();

                            // 获取 OK 按钮
                            ButtonType okButtonType = ButtonType.OK;
                            Button okButton = (Button) alert2.getDialogPane().lookupButton(okButtonType);

                            // 添加点击事件
                            okButton.setOnAction(actionEvent -> {
                                // 在这里添加 OK 按钮点击事件的处理代码
                                // 例如，关闭当前对话框

                                try {
                                    conn.close();
                                    conn = DriverManager.getConnection("jdbc:sqlite:FinanceData.db");
                                    tables = Search.getDataTable(conn);
                                    tables.sort(new Comparator<String>() {
                                        @Override
                                        public int compare(String s1, String s2) {
                                            return Character.compare(s1.charAt(0), s2.charAt(0));
                                        }
                                    });

                                    observableTables = FXCollections.observableArrayList(tables);
                                    TickerComboBox.setItems(observableTables);

                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                            });
                        }
                    });
                });


                alert.show();
            }
    }



    //将数据加载到计算界面
    public void DatabaseLoad() throws SQLException {
        B2.clear();
        B8.clear();
        B9.clear();
        B10.clear();
        B11.clear();
        B12.clear();
        B15.clear();
        B17.clear();
        B18.clear();
        B19.clear();
        B20.clear();
        country.clear();
        industry.clear();

        if (resultSet == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText("Data miss!");
            alert.setContentText("Please select the company you want to search for!");
            alert.show();
            return;
        }

        String c = resultSetInfo.getString("country");
        String i = resultSetInfo.getString("industry");
        String b = resultSetInfo.getString("longName");

        country.setText(c);
        industry.setText(i);
        B2.setText(b);


        double totalAssets = 0.0;

        while (resultSet.next()) {
            String columnName = resultSet.getString("income_statement_index");
            double value = resultSet.getDouble("income_statement_value");
            String balanceSheetIndex = resultSet.getString("balance_sheet_index");
            double balanceSheetValue = resultSet.getDouble("balance_sheet_value");

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

            String fileName = "";
            //适配不同操作系统
            if (osName.startsWith("Windows")) {
                fileName = folderPath.substring(folderPath.lastIndexOf("\\") + 1);
            } else if (osName.startsWith("Mac")) {
                fileName = folderPath.substring(folderPath.lastIndexOf("/") + 1);
            }
            String fileNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf("."));
            System.out.println(fileNameWithoutExtension);
            Search.importData(fileNameWithoutExtension, folderPath, conn);
        }else{
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("WARNING");
            alert1.setHeaderText("Empty Data or wrong ticker!");
            alert1.setContentText("Please enter a correct Ticker!");
            alert1.show();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notice");
        alert.setHeaderText("Import finish!");
        alert.show();
    }

    public void DatabaseDownload() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        File selectedDirectory = directoryChooser.showDialog(new Stage());

        if (resultSet == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText("Data miss!");
            alert.setContentText("Please select the company you want to search for!");
            alert.show();
            return;
        }

        if (selectedDirectory != null) {
            String folderPath = selectedDirectory.getAbsolutePath();
            String ticker = TickerComboBox.getEditor().getText();
            Search.downloadData(ticker,folderPath, resultSet);
        }else{
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("WARNING");
            alert1.setHeaderText("Empty Data or wrong ticker!");
            alert1.setContentText("Please enter a correct Ticker!");
            alert1.show();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notice");
        alert.setHeaderText("Export finish!");
        alert.show();
    }

    public void DataBaseComboBox() {
        String searchText = TickerComboBox.getEditor().getText().toLowerCase();
        ObservableList<String> filteredItems = FXCollections.observableArrayList();

        for (String item : observableTables) {
            if (item.toLowerCase().contains(searchText)) {
                filteredItems.add(item);
            }
        }

        TickerComboBox.setItems(filteredItems);
    }

}
