package com.back.example.PDF;

import com.back.StaticData.*;
import com.back.example.OutPutMethod;
import com.back.example.OutPutMethod2;
import com.back.example.OutputSheet.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static com.back.StaticData.InputData.yearOfList;
/**
 * Generates a PDF report that contains various elements such as paragraphs, lines, tables,
 * images, links, and watermarks.
 *
 * @param document The document to write the PDF report to.
 * @throws Exception If there is an error while generating the PDF report.
 * @author [Keyi Liu]
 * @version [2]
 */


public class PdfReport {

    // 
    public static void main(String[] args) throws Exception {
        // 
        Document document = new Document(PageSize.A4);//

        // 
        String str = "PDFDemo2";
        File file = new File(str + ".pdf");
        file.createNewFile();
        setMain(file, document);
    }

    public static void setMain(File file, Document document) {
        try {

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            writer.setPageEvent(new Watermark("GRP14"));// 
            writer.setPageEvent(new MyHeaderFooter());// 

            document.open();
            document.addTitle("Title@PDF-Java");// 
            document.addAuthor("Author@umiz");// 
            document.addSubject("Subject@iText pdf sample");// 
            document.addKeywords("Keywords@iTextpdf");// 
            document.addCreator("Creator@umiz`s");// 

            // 
            new PdfReport().generatePDF(document);

            // 
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 
    private static Font titlefont;
    private static Font headfont;
    private static Font keyfont;
    private static Font textfont;
    // 
    private static int maxWidth = 520;

    // 
    static {
        try {
            // 
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            titlefont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            headfont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            keyfont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
            textfont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 
    public void generatePDF(Document document) throws Exception {


        InputData inputData = new InputData();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();
        OptionValue ov = new OptionValue();
        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());
        costOfCapital.setCostOfCapitalList(inputData.getB31(), InputData.getYearOfList(), InputData.getYear2_x());

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue(), InputData.getYearOfList(), InputData.getYear2_x());

        A3Revenues revenues = new A3Revenues();
        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate, InputData.getYearOfList());

        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(inputData.isB14(), inputData.isB13(), olc.getF32(), rdc.getD39(), inputData.getB9());
        ebitMargin.setEBITMarginList(inputData.getB8(), inputData.getB24(), inputData.getB26(), inputData.getB27(), InputData.getYearOfList());

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin, InputData.getYearOfList());

        A10NOL nol = new A10NOL();
        nol.setNolList(inputData.isB54(), inputData.getB55(), ebitIncome, InputData.getYearOfList());

        A7EBIT1t ebit1t = new A7EBIT1t();
        ebit1t.setTerminalEBIT1t(inputData.getB20(), revenues, ebitMargin);

        ebit1t.setEBIT1tList(ebitIncome, inputData.getB20(), nol, InputData.getYearOfList());


        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());

        A40ROIC roic = new A40ROIC();
        roic.setTerminaLROIC(inputData.isB44(), inputData.getB45(), costOfCapital);


        A8Reinvestment reinvestment = new A8Reinvestment();
        reinvestment.setReinvestmentList(revenues, inputData.getB28(), revenueGrowthRate, roic, ebit1t, InputData.getYearOfList());


        A16TerminalCashFlow terminalCashFlow = new A16TerminalCashFlow();
        terminalCashFlow.setTerminalCashFlow(ebit1t, reinvestment);


        A6TaxRate taxRate = new A6TaxRate();
        taxRate.setTaxRateList(inputData.getB20(), InputData.getYearOfList());
        A9FCFF fcff = new A9FCFF();
        fcff.setFcffList(ebit1t, reinvestment, InputData.getYearOfList());

        A13CumulatedDiscountFactor cumulatedDiscountFactor = new A13CumulatedDiscountFactor();
        cumulatedDiscountFactor.setCumulatedDFListList(costOfCapital, InputData.getYearOfList());

        A38SalesToCapitalRatio salesToCapitalRatio = new A38SalesToCapitalRatio();
        salesToCapitalRatio.setSalesToCapitalRatioList(inputData.getB28(), InputData.getYearOfList());

        A39InvestedCapital investedCapital = new A39InvestedCapital();
        investedCapital.setInvestedCapitalList(inputData.isB14(), inputData.isB13(), inputData.getB12(), inputData.getB15(), inputData.getB11(), olc.getF33(), rdc.getD35(), reinvestment, InputData.getYearOfList());

        roic.setRoicList(ebit1t, investedCapital, InputData.getYearOfList());
        A14PVFCFF pvfcff = new A14PVFCFF();
        pvfcff.setPvFcffList(fcff, cumulatedDiscountFactor, InputData.getYearOfList());

        A18TerminalValue a18terminalValue = new A18TerminalValue();
        a18terminalValue.setTerminalvalue(costOfCapital, terminalCashFlow, revenueGrowthRate);


        A19PVTerminalValue pvTerminalValue = new A19PVTerminalValue();
        pvTerminalValue.setpVTerminalValue(a18terminalValue, cumulatedDiscountFactor);

        A20PVCFOver10Year pvcfOver10Year = new A20PVCFOver10Year();
        pvcfOver10Year.setpVCFOver10Year(pvfcff);

        A21SumOfPV sumOfPV = new A21SumOfPV();
        sumOfPV.setSumOfPV(pvcfOver10Year, pvTerminalValue);

        A22ProbabilityOfFailure probabilityOfFailure = new A22ProbabilityOfFailure();
        probabilityOfFailure.setProbability_failure(inputData.getB48(), inputData.isB47());

        A23ProceedsIfFirmFails proceedsIfFirmFails = new A23ProceedsIfFirmFails();
        proceedsIfFirmFails.setProceedsIfFirmFails(inputData.getB49(), inputData.getB11(), inputData.getB12(), inputData.getB50(), sumOfPV);

        A24ValueOfOperatingAssets valueOfOperatingAssets = new A24ValueOfOperatingAssets();
        valueOfOperatingAssets.setValueOfOperatingAssets(sumOfPV, proceedsIfFirmFails, probabilityOfFailure);

        A25Debt debt = new A25Debt();
        debt.setDebt(inputData.isB14(), olc.getC28(), inputData.getB12());

        A26MinorityInterests minorityInterests = new A26MinorityInterests();
        minorityInterests.setMinorityInterests(inputData.getB17());

        A27Cash cash = new A27Cash();
        cash.setCash(inputData.isB63(), inputData.getB15(), inputData.getB64(), inputData.getB65(), inputData.getB21());

        A28NonOperatingAssets nonOperatingAssets = new A28NonOperatingAssets();
        nonOperatingAssets.setNonOperatingAssets(inputData.getB16());

        A29ValueOfEquity valueOfEquity = new A29ValueOfEquity();
        valueOfEquity.setValueOfEquity(valueOfOperatingAssets, debt, minorityInterests, cash, nonOperatingAssets);

        A30ValueOfOptions valueOfOptions = new A30ValueOfOptions();
        valueOfOptions.setValueOfOptions(inputData.isB33(), ov.getD27());

        A31ValueOfEquityInCommonStock valueOfEquityInCommonStock = new A31ValueOfEquityInCommonStock();
        valueOfEquityInCommonStock.setValueOfEquityInCommonStock(valueOfEquity, valueOfOptions);

        A32NumberOfShares numberOfShares = new A32NumberOfShares();
        numberOfShares.setNumberOfShares(inputData.getB18());

        A33EstimatedValueShare estimatedValueShare = new A33EstimatedValueShare();
        estimatedValueShare.setEstimatedValueShare(numberOfShares, valueOfEquityInCommonStock);

        A34Price price = new A34Price();
        price.setPrice(inputData.getB19());

        A35PriceAsOfValue priceAsOfValue = new A35PriceAsOfValue();
        priceAsOfValue.setPriceAsPercentageOfValue(price, estimatedValueShare);


        // 
        Paragraph paragraph = new Paragraph("Stories to Numbers", titlefont);
        paragraph.setAlignment(1); //
        paragraph.setIndentationLeft(12); //
        paragraph.setIndentationRight(12); //
        paragraph.setFirstLineIndent(24); //
        paragraph.setLeading(20f); //
        paragraph.setSpacingBefore(5f); //
        paragraph.setSpacingAfter(10f); //


        // 
        Paragraph p1 = new Paragraph();
        p1.add(new Chunk(new LineSeparator()));

        // 
        Paragraph p2 = new Paragraph();
        p2.add(new Chunk(new DottedLineSeparator()));

        //

        Anchor anchor = new Anchor("baidu");
        anchor.setReference("www.baidu.com");

        //
        Anchor gotoP = new Anchor("goto");
        gotoP.setReference("#top");

        // 
        /*Image image = Image.getInstance("facebook_cover_photo_1.png");
        image.setAlignment(Image.ALIGN_CENTER);
        image.scalePercent(8); //
        image.setAlignment(0);
*/

        BigDecimal bd;
        String v;

        // 
        PdfPTable table = createTable(new float[]{120, 80, 80, 80, 40, 80, 80});
        table.addCell(createCell("The Assumptions", headfont, Element.ALIGN_LEFT, 7, false));
        //table.setSpacingBefore(30f); //
        table.addCell(createCell("", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("Base year", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("Years 1-5", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("Years 6-10", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("After year 10", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("Link to story", keyfont, Element.ALIGN_CENTER));


        table.addCell(createCell("Revenues (a)", textfont));
        table.addCell(createCell(String.valueOf(OutPutMethod2.output("B9")), textfont));
        v=isPercentage(OutPutMethod2.output("C9"));
        table.addCell(createCell(v, textfont));
        v=isPercentage(OutPutMethod2.output("D9"));
        table.addCell(createCell(v, textfont));
        table.addCell(createCell("", textfont));
        v=isPercentage(OutPutMethod2.output("F9"));
        table.addCell(createCell(v, textfont));
        table.addCell(createCell("", textfont));


        table.addCell(createCell("Operating margin (b)", textfont));
        v=isPercentage(OutPutMethod2.output("B10"));
        table.addCell(createCell(v, textfont));
        v=isPercentage(OutPutMethod2.output("C10"));
        table.addCell(createCell(v, textfont));
        v=isPercentage(OutPutMethod2.output("D10"));
        table.addCell(createCell(v, textfont));
        table.addCell(createCell("", textfont));
        v=isPercentage(OutPutMethod2.output("F10"));
        table.addCell(createCell(v, textfont));
        table.addCell(createCell("", textfont));


        table.addCell(createCell("Tax rate", textfont));
        v=isPercentage(OutPutMethod2.output("B11"));
        table.addCell(createCell(v, textfont));
        v=isPercentage(OutPutMethod2.output("C11"));
        table.addCell(createCell(v, textfont));
        v=isPercentage(OutPutMethod2.output("D11"));
        table.addCell(createCell(v, textfont));
        table.addCell(createCell("", textfont));
        v=isPercentage(OutPutMethod2.output("F11"));
        table.addCell(createCell(v, textfont));
        table.addCell(createCell("", textfont));


        table.addCell(createCell("Reinvestment (c )", textfont));
        table.addCell(createCell("", textfont));
        table.addCell(createCell("Sales to capital ratio =", textfont));
        table.addCell(createCell(String.valueOf(OutPutMethod2.output("D12")), textfont));
        table.addCell(createCell("RIR=", textfont));
        v=isPercentage(OutPutMethod2.output("F12"));
        table.addCell(createCell(v, textfont));
        table.addCell(createCell("", textfont));


        table.addCell(createCell("Return on capital", textfont));
        v=isPercentage(OutPutMethod2.output("B13"));
        table.addCell(createCell(v, textfont));
        table.addCell(createCell("Marginal ROIC =", textfont));
        v=isPercentage(OutPutMethod2.output("D13"));
        table.addCell(createCell(v, textfont));
        table.addCell(createCell("", textfont));
        v=isPercentage(OutPutMethod2.output("F13"));
        table.addCell(createCell(v, textfont));
        table.addCell(createCell("", textfont));


        table.addCell(createCell("Cost of capital (d)", textfont));
        table.addCell(createCell("", textfont));
        v=isPercentage(OutPutMethod2.output("C14"));
        table.addCell(createCell(v, textfont));
        v=isPercentage(OutPutMethod2.output("D14"));
        table.addCell(createCell(v, textfont));
        table.addCell(createCell("", textfont));
        v=isPercentage(OutPutMethod2.output("F14"));
        table.addCell(createCell(v, textfont));
        table.addCell(createCell("", textfont));


        PdfPTable table2 = createTable(new float[]{80, 80, 80, 80, 80, 80, 80});
        table2.addCell(createCell("The Cash Flows", headfont, Element.ALIGN_LEFT, 7, false));
        table2.setSpacingBefore(10f); //
        ArrayList<Double> outputRevenuesList = OutPutMethod.outputRevenuesList();
        ArrayList<Double> outputebitMarginList = OutPutMethod.outputebitMarginList();
        ArrayList<Double> outputEBIT1_tList = OutPutMethod.outputEBIT1_tList();
        ArrayList<Double> outputreinvestmentList = OutPutMethod.outputReinvestmentList();
        table2.addCell(createCell("", textfont));
        table2.addCell(createCell("Revenues", textfont));
        table2.addCell(createCell("Operating Margin", textfont));
        table2.addCell(createCell("EBIT", textfont));
        table2.addCell(createCell("EBIT (1-t)", textfont));
        table2.addCell(createCell("Reinvestment ", textfont));
        table2.addCell(createCell("FCFF", textfont));

        for (int i = 1; i < yearOfList + 2; i++) {
            if (i == yearOfList + 1) {
                table2.addCell(createCell("Terminal year", textfont));
            } else {
                table2.addCell(createCell(String.valueOf(i), textfont));

            }
            bd = isRounded(outputRevenuesList.get(i));
            table2.addCell(createCell(String.valueOf(bd), textfont));

            bd = isRounded(outputebitMarginList.get(i));
            v=isPercentage(bd.doubleValue());
            table2.addCell(createCell(v, textfont));

            bd = isRounded(outputRevenuesList.get(i) * outputebitMarginList.get(i));
            table2.addCell(createCell(String.valueOf(bd), textfont));

            bd = isRounded(outputEBIT1_tList.get(i));
            table2.addCell(createCell(String.valueOf(bd), textfont));

            bd = isRounded(outputreinvestmentList.get(i));
            table2.addCell(createCell(String.valueOf(bd), textfont));

            bd = isRounded(outputEBIT1_tList.get(i) - outputreinvestmentList.get(i));
            table2.addCell(createCell(String.valueOf(bd), textfont));

        }

        PdfPTable table3 = createTable(new float[]{200, 160, 200});
        table3.addCell(createCell("The Value", headfont, Element.ALIGN_LEFT, 3, false));
        table3.setSpacingBefore(10f); //

        table3.addCell(createCell("Terminal value", textfont));
        bd = isRounded(OutPutMethod2.output("D29"));
        table3.addCell(createCell(String.valueOf(bd), textfont));
        table3.addCell(createCell("", textfont));


        table3.addCell(createCell("PV(Terminal value)", textfont));
        bd = isRounded(OutPutMethod2.output("D30"));
        table3.addCell(createCell(String.valueOf(bd), textfont));
        table3.addCell(createCell("", textfont));

        table3.addCell(createCell("PV (CF over next 10 years)", textfont));
        bd = isRounded(OutPutMethod2.output("D31"));
        table3.addCell(createCell(String.valueOf(bd), textfont));
        table3.addCell(createCell("", textfont));


        table3.addCell(createCell("Value of operating assets", textfont));
        bd = isRounded(OutPutMethod2.output("D32"));
        table3.addCell(createCell(String.valueOf(bd), textfont));
        table3.addCell(createCell("", textfont));

        table3.addCell(createCell("Adjustment for distress", textfont));
        double outputD33 =  OutPutMethod2.output("D32") - OutPutMethod2.output("B24");
        bd = isRounded(outputD33);
        table3.addCell(createCell(String.valueOf(bd), textfont));


        bd = isRounded(OutPutMethod2.output("G33"));
        table3.addCell(createCell("Probability of failure =" + bd, textfont));


        table3.addCell(createCell(" - Debt & Mnority Interests", textfont));
        bd = isRounded(OutPutMethod2.output("D34"));
        table3.addCell(createCell(String.valueOf(bd), textfont));
        table3.addCell(createCell("", textfont));

        table3.addCell(createCell(" + Cash & Other Non-operating assets", textfont));
        bd = isRounded(OutPutMethod2.output("D35"));
        table3.addCell(createCell(String.valueOf(bd), textfont));
        table3.addCell(createCell("", textfont));

        table3.addCell(createCell("Value of equity", textfont));
        double outputD36 = OutPutMethod2.output("D32") - outputD33 - OutPutMethod2.output("D34") + OutPutMethod2.output("D35");
        bd = isRounded(outputD36);
        table3.addCell(createCell(String.valueOf(bd), textfont));
        table3.addCell(createCell("", textfont));


        table3.addCell(createCell(" - Value of equity options", textfont));
        bd = isRounded(OutPutMethod2.output("D37"));
        table3.addCell(createCell(String.valueOf(bd), textfont));
        table3.addCell(createCell("", textfont));

        table3.addCell(createCell(" Number of shares", textfont));
        bd = isRounded(OutPutMethod2.output("D38"));
        table3.addCell(createCell(String.valueOf(bd), textfont));
        table3.addCell(createCell("", textfont));

        table3.addCell(createCell("Value per share", textfont));
        double outputD39 =( (outputD36) - OutPutMethod2.output("D37")) /OutPutMethod2.output("D38");
        bd = isRounded(outputD39);


        table3.addCell(createCell(String.valueOf(bd), textfont));
        bd = isRounded(OutPutMethod2.output("G39"));
        table3.addCell(createCell("Stock was trading at =" + bd, textfont));


        Paragraph paragraph2 = new Paragraph("Input sheet", titlefont);
        paragraph2.setAlignment(1); //
        paragraph2.setIndentationLeft(12); //
        paragraph2.setIndentationRight(12); //
        paragraph2.setFirstLineIndent(24); //
        paragraph2.setLeading(20f); //
        paragraph2.setSpacingBefore(100f); //
        paragraph2.setSpacingAfter(10f); //

        //input todo
        PdfPTable table4 = createTable(new float[]{320, 240});
        table4.addCell(createCell("Date of valuation", keyfont));
        table4.addCell(createCell(" ", textfont));
        table4.addCell(createCell("Company name", keyfont));
        table4.addCell(createCell(" ", textfont));

        PdfPTable table5 = createTable(new float[]{320, 240});
        table5.setSpacingBefore(10f); //
        table5.addCell(createCell("Numbers from your base year below ( in consistent units)", headfont, Element.ALIGN_LEFT, 2, false));
        table5.addCell(createCell(" ", keyfont));
        table5.addCell(createCell("This year", keyfont));

        table5.addCell(createCell("Country", textfont));
        table5.addCell(createCell("", keyfont));
        table5.addCell(createCell("Industry", textfont));
        table5.addCell(createCell("", keyfont));
        table5.addCell(createCell("Industry (Global)", textfont));
        table5.addCell(createCell("", keyfont));
        table5.addCell(createCell("Revenues", textfont));
        table5.addCell(createCell(String.valueOf(InputData.getB8()), textfont));
        table5.addCell(createCell("Operating income or EBIT", textfont));
        table5.addCell(createCell(String.valueOf(InputData.getB9()), textfont));
        table5.addCell(createCell("Interest expense", textfont));
        table5.addCell(createCell(String.valueOf(InputData.getB10()), textfont));
        table5.addCell(createCell("Book value of equity", textfont));
        table5.addCell(createCell(String.valueOf(InputData.getB11()), textfont));
        table5.addCell(createCell("Book value of debt", textfont));
        table5.addCell(createCell(String.valueOf(InputData.getB12()), textfont));
        table5.addCell(createCell("Do you have R&D expenses to capitalize?", textfont));
        table5.addCell(createCell(InputData.isB13() ? "yes" : "no", textfont));
        table5.addCell(createCell("Do you have operating lease commitments?", textfont));
        table5.addCell(createCell(InputData.isB14() ? "yes" : "no", textfont));
        table5.addCell(createCell("Cash and Marketable Securities ", textfont));
        table5.addCell(createCell(String.valueOf(InputData.getB15()), textfont));
        table5.addCell(createCell("Cross holdings and other non-operating assets", textfont));
        table5.addCell(createCell(String.valueOf(InputData.getB16()), textfont));
        table5.addCell(createCell("Minority interests", textfont));
        table5.addCell(createCell(String.valueOf(InputData.getB17()), textfont));
        table5.addCell(createCell("Number of shares outstanding = ", textfont));
        table5.addCell(createCell(String.valueOf(InputData.getB18()), textfont));
        table5.addCell(createCell("Current stock price =", textfont));
        table5.addCell(createCell(String.valueOf(InputData.getB19()), textfont));
        table5.addCell(createCell("Effective tax rate =", textfont));
        v=isPercentage(InputData.getB20());
        table5.addCell(createCell(v, textfont));
        table5.addCell(createCell("Marginal tax rate = ", textfont));
        v=isPercentage(InputData.getB21());
        table5.addCell(createCell(v, textfont));


        PdfPTable table6 = createTable(new float[]{320, 240});
        table6.addCell(createCell("The value drivers", headfont, Element.ALIGN_LEFT, 2, false));
        table6.setSpacingBefore(10f); //
        table6.addCell(createCell("Revenue growth rate for next year", textfont));
        v=isPercentage(InputData.getB23());
        table6.addCell(createCell(v, textfont));
        table6.addCell(createCell("Operating Margin for next year", textfont));
        v=isPercentage(InputData.getB24());
        table6.addCell(createCell(v, textfont));
        table6.addCell(createCell("Compounded annual revenue growth rate - years 2-5 =", textfont));
        v=isPercentage(InputData.getB25());
        table6.addCell(createCell(v, textfont));
        table6.addCell(createCell("Target pre-tax operating margin (EBIT as % of sales in year 10) =", textfont));
        v=isPercentage(InputData.getB26());
        table6.addCell(createCell(v, textfont));
        table6.addCell(createCell("Year of convergence", textfont));
        table6.addCell(createCell(String.valueOf(InputData.getB27()), textfont));
        table6.addCell(createCell("Sales to capital ratio  (for computing reinvestment) =", textfont));
        table6.addCell(createCell(String.valueOf(InputData.getB28()), textfont));


        PdfPTable table7 = createTable(new float[]{320, 240});
        table7.addCell(createCell("Market numbers", headfont, Element.ALIGN_LEFT, 2, false));
        table7.setSpacingBefore(10f); //
        table7.addCell(createCell("Riskfree rate", textfont));
        v=isPercentage(InputData.getB30());
        table7.addCell(createCell(v, textfont));
        table7.addCell(createCell("Riskfree rate", textfont));
        v=isPercentage(InputData.getB31());
        table7.addCell(createCell(v, textfont));


        PdfPTable table8 = createTable(new float[]{320, 240});
        table8.addCell(createCell("Other inputs", headfont, Element.ALIGN_LEFT, 2, false));
        table8.setSpacingBefore(10f); //
        table8.addCell(createCell("Do you have employee options outstanding?", textfont));
        table8.addCell(createCell(InputData.isB33() ? "yes" : "no", textfont));
        table8.addCell(createCell("Number of options outstanding =", textfont));
        table8.addCell(createCell(String.valueOf(InputData.getB34()), textfont));
        table8.addCell(createCell("Average strike price =", textfont));
        table8.addCell(createCell(String.valueOf(InputData.getB35()), textfont));
        table8.addCell(createCell("Average maturity =", textfont));
        table8.addCell(createCell(String.valueOf(InputData.getB36()), textfont));
        table8.addCell(createCell("Standard deviation on stock price =", textfont));
        v=isPercentage(InputData.getB37());
        table8.addCell(createCell(v, textfont));

        PdfPTable table9 = createTable(new float[]{400, 160});
        table9.setSpacingBefore(10f); //
        table9.addCell(createCell("Default assumptions. ", headfont, Element.ALIGN_LEFT, 2, false));
        table9.addCell(createCell("In stable growth, I will assume that your firm will have a cost of capital similar to that of typical mature companies (riskfree rate + 4.5%)", keyfont));
        table9.addCell(createCell("", textfont));
        table9.addCell(createCell("Do you want to override this assumption", textfont));
        table9.addCell(createCell(InputData.isB41() ? "yes" : "no", textfont));
        table9.addCell(createCell("If yes, enter the cost of capital after year 10 =", textfont));
        v=isPercentage(InputData.getB42());
        table9.addCell(createCell(v, textfont));

        table9.addCell(createCell("I will assume that your firm will earn a return on capital equal to its cost of capital after year 10. I am assuming that whatever competitive advantages you have today will fade over time.", keyfont));
        table9.addCell(createCell("", textfont));
        table9.addCell(createCell("Do you want to override this assumption", textfont));
        table9.addCell(createCell(InputData.isB44() ? "yes" : "no", textfont));
        table9.addCell(createCell("If yes, enter the return on capital you expect after year 10", textfont));
        v=isPercentage(InputData.getB45());
        table9.addCell(createCell(v, textfont));

        table9.addCell(createCell("I will assume that your firm has no chance of failure over the foreseeable future.", textfont));
        table9.addCell(createCell("", textfont));
        table9.addCell(createCell("Do you want to override this assumption", textfont));
        table9.addCell(createCell(InputData.isB47() ? "yes" : "no", textfont));

        table9.addCell(createCell("If yes, enter the probability of failure =", textfont));
        v=isPercentage(InputData.getB48());
        table9.addCell(createCell(v, textfont));
        table9.addCell(createCell("What do you want to tie your proceeds in failure to?", textfont));
        table9.addCell(createCell(String.valueOf(InputData.getB49()), textfont));
        table9.addCell(createCell("Enter the distress proceeds as percentage of book or fair value", textfont));
        v=isPercentage(InputData.getB50());
        table9.addCell(createCell(v, textfont));


        table9.addCell(createCell("I will assume that your effective tax rate will adjust to your marginal tax rate by your terminal year. If you override this assumption, I will leave the tax rate at your effective tax rate.", keyfont));
        table9.addCell(createCell("", textfont));
        table9.addCell(createCell("Do you want to override this assumption", textfont));
        table9.addCell(createCell(InputData.isB52() ? "yes" : "no", textfont));
        table9.addCell(createCell("I will assume that you have no losses carried forward from prior years ( NOL) coming into the valuation. If you have a money losing company, you may want to override tis.", keyfont));
        table9.addCell(createCell("", textfont));
        table9.addCell(createCell("Do you want to override this assumption", textfont));
        table9.addCell(createCell(InputData.isB54() ? "yes" : "no", textfont));
        table9.addCell(createCell("If yes, enter the NOL that you are carrying over into year 1", textfont));
        table9.addCell(createCell(String.valueOf(InputData.getB55()), textfont));
        table9.addCell(createCell("I will asssume that today's risk free rate will prevail in perpetuity. If you override this assumption, I will change the riskfree rate after year 10.", keyfont));
        table9.addCell(createCell("", textfont));
        table9.addCell(createCell("Do you want to override this assumption", textfont));
        table9.addCell(createCell(InputData.isB57() ? "yes" : "no", textfont));
        table9.addCell(createCell("If yes, enter the riskfree rate after year 10", textfont));
        v=isPercentage(InputData.getB58());
        table9.addCell(createCell(v, textfont));
        table9.addCell(createCell("I will assume that the growth rate in perpetuity will be equal to the risk free rate. This allows for both valuation consistency and prevents \"impossible\" growth rates.", keyfont));


        table9.addCell(createCell("", textfont));

        table9.addCell(createCell("Do you want to override this assumption", textfont));
        table9.addCell(createCell(InputData.isB60() ? "yes" : "no", textfont));
        table9.addCell(createCell("If yes, enter the growth rate in perpetuity", keyfont));
        v=isPercentage(InputData.getB61());
        table9.addCell(createCell(v, textfont));

        table9.addCell(createCell("I have assumed that none of the cash is trapped (in foreign countries) and that there is no additional tax liability coming due and that cash is a neutral asset.", keyfont));
        table9.addCell(createCell("", textfont));
        table9.addCell(createCell("Do you want to override this assumption", textfont));
        table9.addCell(createCell(InputData.isB63() ? "yes" : "no", textfont));
        table9.addCell(createCell("If yes, enter trapped cash (if taxes) or entire balance (if mistrust)", textfont));
        table9.addCell(createCell(String.valueOf(InputData.getB64()), textfont));
        table9.addCell(createCell("& Average tax rate of the foreign markets where the cash is trapped", textfont));
        v=isPercentage(InputData.getB65());
        table9.addCell(createCell(v, textfont));


        Paragraph paragraph3 = new Paragraph("Valuation output", titlefont);
        paragraph3.setAlignment(1); //
        paragraph3.setIndentationLeft(12); //
        paragraph3.setIndentationRight(12); //
        paragraph3.setFirstLineIndent(24); //
        paragraph3.setLeading(20f); //
        paragraph3.setSpacingBefore(100f); //
        paragraph3.setSpacingAfter(10f); //

        PdfPTable table10 = createTable(new float[]{60, 100, 100, 100, 100, 100});
        //table11.setSpacingBefore(10f); //
        table10.addCell(createCell("", textfont));
        table10.addCell(createCell("Revenue growth rate", keyfont));
        table10.addCell(createCell("Revenues", keyfont));
        table10.addCell(createCell("EBIT (Operating) margin", keyfont));
        table10.addCell(createCell("EBIT (Operating income)", keyfont));
        table10.addCell(createCell("Tax rate", keyfont));

        for (int i = 0; i <= yearOfList + 1; i++) {
            if (i == 0) {
                table10.addCell(createCell("Base year", textfont));
            } else if (i == yearOfList + 1) {
                table10.addCell(createCell("Terminal year", textfont));
            } else {
                table10.addCell(createCell(String.valueOf(i), textfont));
            }

            v=isPercentage(revenueGrowthRate.getRevenueGrowthRateList().get(i));
            table10.addCell(createCell(v, textfont));
            bd=isRounded(revenues.getRevenuesList().get(i));
            table10.addCell(createCell(String.valueOf(bd), textfont));
            v=isPercentage(ebitMargin.getEBITMarginList().get(i));
            table10.addCell(createCell(v, textfont));
            bd=isRounded(ebitIncome.getEBITIncomeList().get(i));
            table10.addCell(createCell(String.valueOf(bd), textfont));
            v=isPercentage(taxRate.taxRateList.get(i));
            table10.addCell(createCell(v, textfont));

        }


        PdfPTable table11 = createTable(new float[]{60, 100, 100, 100, 100, 100});
        table11.setSpacingBefore(30f); //
        table11.addCell(createCell("", textfont));
        table11.addCell(createCell("EBIT(1-t)", keyfont));
        table11.addCell(createCell(" - Reinvestment", keyfont));
        table11.addCell(createCell("FCFF", keyfont));
        table11.addCell(createCell("NOL", keyfont));
        table11.addCell(createCell("Cost of capital", keyfont));

        for (int i = 0; i <= yearOfList + 1; i++) {
            if (i == 0) {
                table11.addCell(createCell("Base year", textfont));
            } else if (i == yearOfList + 1) {
                table11.addCell(createCell("Terminal year", textfont));
            } else {
                table11.addCell(createCell(String.valueOf(i), textfont));
            }

            bd=isRounded(ebit1t.getEBIT1tList().get(i));
            table11.addCell(createCell(String.valueOf(bd), textfont));
            bd=isRounded(reinvestment.getReinvestmentList().get(i));
            table11.addCell(createCell(String.valueOf(bd), textfont));
            bd=isRounded(fcff.fcffList.get(i));
            table11.addCell(createCell(String.valueOf(bd), textfont));
            bd=isRounded(nol.getNolList().get(i));
            table11.addCell(createCell(String.valueOf(bd), textfont));
            v=isPercentage(costOfCapital.getCostOfCapitalList().get(i));
            table11.addCell(createCell(v, textfont));

        }


        PdfPTable table12 = createTable(new float[]{60, 100, 100, 100, 100, 100});
        table12.setSpacingBefore(30f); //
        table12.addCell(createCell("", textfont));
        table12.addCell(createCell("Cumulated discount factor", keyfont));
        table12.addCell(createCell("PV(FCFF)", keyfont));
        table12.addCell(createCell("Sales to capital ratio", keyfont));
        table12.addCell(createCell("Invested capital", keyfont));
        table12.addCell(createCell("ROIC", keyfont));

        for (int i = 0; i <= yearOfList; i++) {
            if (i == 0) {
                table12.addCell(createCell("Base year", textfont));
            } else {
                table12.addCell(createCell(String.valueOf(i), textfont));
            }


            table12.addCell(createCell(String.valueOf(cumulatedDiscountFactor.getCumulatedDFList().get(i)), textfont));
            bd=isRounded(pvfcff.getPvFcffList().get(i));
            table12.addCell(createCell(String.valueOf(bd), textfont));
            table12.addCell(createCell(String.valueOf(salesToCapitalRatio.getSalesToCapitalRatioList().get(i)), textfont));
            bd=isRounded(investedCapital.getInvestedCapitalList().get(i));
            table12.addCell(createCell(String.valueOf(bd), textfont));
            v=isPercentage(roic.getRoicList().get(i));
            table12.addCell(createCell(v, textfont));
        }

        table12.addCell(createCell("Terminal year", textfont));
        table12.addCell(createCell("", keyfont));
        table12.addCell(createCell("", keyfont));
        table12.addCell(createCell("", keyfont));
        table12.addCell(createCell("", keyfont));
        table12.addCell(createCell(String.valueOf(roic.getTerminaLROIC()), textfont));

        PdfPTable table13 = createTable(new float[]{320, 240});
        table13.setSpacingBefore(30f); //

        table13.addCell(createCell("Terminal cash flow", textfont));
        bd=isRounded(terminalCashFlow.getTerminalCashFlow());
        table13.addCell(createCell(String.valueOf(bd), textfont));
        table13.addCell(createCell("Terminal cost of capital", textfont));
        v=isPercentage(costOfCapital.getTerminalostOfCapital());
        table13.addCell(createCell(String.valueOf(v), textfont));
        table13.addCell(createCell("Terminal value", textfont));
        bd=isRounded(a18terminalValue.getTerminalvalue());
        table13.addCell(createCell(String.valueOf(bd), textfont));
        table13.addCell(createCell("PV(Terminal value)", textfont));
        bd=isRounded(pvTerminalValue.getpVTerminalValue());
        table13.addCell(createCell(String.valueOf(bd), textfont));
        table13.addCell(createCell("PV (CF over next 10 years)", textfont));
        bd=isRounded(pvcfOver10Year.getpVCFOver10Year());
        table13.addCell(createCell(String.valueOf(bd), textfont));
        table13.addCell(createCell("Sum of PV", textfont));
        bd=isRounded(sumOfPV.getSumOfPV());
        table13.addCell(createCell(String.valueOf(bd), textfont));
        table13.addCell(createCell("Probability of failure =", textfont));
        v=isPercentage(probabilityOfFailure.getProbability_failure());
        table13.addCell(createCell(String.valueOf(v), textfont));
        table13.addCell(createCell("Proceeds if firm fails =", textfont));
        bd=isRounded(proceedsIfFirmFails.getProceedsIfFirmFails());
        table13.addCell(createCell(String.valueOf(bd), textfont));
        table13.addCell(createCell("Value of operating assets =", textfont));
        bd=isRounded(valueOfOperatingAssets.getValueOfOperatingAssets());
        table13.addCell(createCell(String.valueOf(bd), textfont));
        table13.addCell(createCell(" - Debt", textfont));
        bd=isRounded(debt.getDebt());
        table13.addCell(createCell(String.valueOf(bd), textfont));
        table13.addCell(createCell(" - Minority interests", textfont));
        bd=isRounded(minorityInterests.getMinorityInterests());
        table13.addCell(createCell(String.valueOf(bd), textfont));
        table13.addCell(createCell(" +  Cash", textfont));
        bd=isRounded(cash.getCash());
        table13.addCell(createCell(String.valueOf(bd), textfont));
        table13.addCell(createCell(" + Non-operating assets", textfont));
        bd=isRounded(nonOperatingAssets.getNonOperatingAssets());
        table13.addCell(createCell(String.valueOf(bd), textfont));
        table13.addCell(createCell("Value of equity", textfont));
        bd=isRounded(valueOfEquity.getValueOfEquity());
        table13.addCell(createCell(String.valueOf(bd), textfont));
        table13.addCell(createCell(" - Value of options", textfont));
        bd=isRounded(valueOfOptions.getValueOfOptions());
        table13.addCell(createCell(String.valueOf(bd), textfont));
        table13.addCell(createCell("Value of equity in common stock", textfont));
        bd=isRounded(valueOfEquityInCommonStock.getValueOfEquityInCommonStock());
        table13.addCell(createCell(String.valueOf(bd), textfont));
        table13.addCell(createCell("Number of shares", textfont));
        bd=isRounded(numberOfShares.getNumberOfShares());
        table13.addCell(createCell(String.valueOf(bd), textfont));
        table13.addCell(createCell("Estimated value /share", textfont));
        bd=isRounded(estimatedValueShare.getEstimatedValueShare());
        table13.addCell(createCell(String.valueOf(bd), textfont));
        table13.addCell(createCell("Price", textfont));
        table13.addCell(createCell(String.valueOf(price.getPrice()), textfont));
        table13.addCell(createCell("Price as % of value", textfont));
        v=isPercentage(priceAsOfValue.getPriceAsPercentageOfValue());
        table13.addCell(createCell(v, textfont));





        //document.add(image);
        document.add(paragraph);
        //document.add(anchor);
        document.add(p2);
        //document.add(gotoP);
        //document.add(p1);
        document.add(table);
        document.add(table2);
        document.add(table3);


        document.add(paragraph2);
        document.add(p2);
        document.add(table4);
        document.add(table5);
        document.add(table6);
        document.add(table7);
        document.add(table8);
        document.add(table9);


        document.add(paragraph3);
        document.add(p2);
        document.add(table10);
        document.add(table11);
        document.add(table12);
        document.add(table13);


    }

    private BigDecimal isRounded(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd;
    }

    private String isPercentage(double value) {
        value *= 100;
        BigDecimal bd = isRounded(value);
        return bd + "%";
    }

/**------------------------start----------------------------*/
    /**
     * 创建单元格(指定字体)
     *
     * @param value
     * @param font
     * @return
     */
    public PdfPCell createCell(String value, Font font) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    /**
     * 
     *
     * @param value
     * @param font
     * @param align
     * @return
     */
    public PdfPCell createCell(String value, Font font, int align) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    /**
     * 
     *
     * @param value
     * @param font
     * @param align
     * @param colspan
     * @return
     */
    public PdfPCell createCell(String value, Font font, int align, int colspan) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setColspan(colspan);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    /**
     * 
     *
     * @param value
     * @param font
     * @param align
     * @param colspan
     * @param boderFlag
     * @return
     */
    public PdfPCell createCell(String value, Font font, int align, int colspan, boolean boderFlag) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setColspan(colspan);
        cell.setPhrase(new Phrase(value, font));
        cell.setPadding(3.0f);
        if (!boderFlag) {
            cell.setBorder(0);
            cell.setPaddingTop(15.0f);
            cell.setPaddingBottom(8.0f);
        } else if (boderFlag) {
            cell.setBorder(0);
            cell.setPaddingTop(0.0f);
            cell.setPaddingBottom(15.0f);
        }
        return cell;
    }

    /**
     * 
     *
     * @param value
     * @param font
     * @param align
     * @param borderWidth
     * @param paddingSize
     * @param flag
     * @return
     */
    public PdfPCell createCell(String value, Font font, int align, float[] borderWidth, float[] paddingSize, boolean flag) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setPhrase(new Phrase(value, font));
        cell.setBorderWidthLeft(borderWidth[0]);
        cell.setBorderWidthRight(borderWidth[1]);
        cell.setBorderWidthTop(borderWidth[2]);
        cell.setBorderWidthBottom(borderWidth[3]);
        cell.setPaddingTop(paddingSize[0]);
        cell.setPaddingBottom(paddingSize[1]);
        if (flag) {
            cell.setColspan(2);
        }
        return cell;
    }
/**------------------------end----------------------------*/


/**--------------------------start------------------- ---------*/
    /**
     * 
     *
     * @param colNumber
     * @param align
     * @return
     */
    public PdfPTable createTable(int colNumber, int align) {
        PdfPTable table = new PdfPTable(colNumber);
        try {
            table.setTotalWidth(maxWidth);
            table.setLockedWidth(true);
            table.setHorizontalAlignment(align);
            table.getDefaultCell().setBorder(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }

    /**
     * 
     *
     * @param widths
     * @return
     */
    public PdfPTable createTable(float[] widths) {
        PdfPTable table = new PdfPTable(widths);
        try {
            table.setTotalWidth(maxWidth);
            table.setLockedWidth(true);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setBorder(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }

    /**
     * 
     *
     * @return
     */
    public PdfPTable createBlankTable() {
        PdfPTable table = new PdfPTable(1);
        table.getDefaultCell().setBorder(0);
        table.addCell(createCell("", keyfont));
        table.setSpacingAfter(20.0f);
        table.setSpacingBefore(20.0f);
        return table;
    }

/**--------------------------end------------------- ---------*/


}
