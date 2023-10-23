package com.back.example;

import com.back.StaticData.*;
import com.back.example.OutputSheet.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Objects;

public class OutPutMethod2 {


    public static double revenues_a_B9 = 0;
    public static double revenues_a_C9 = 0;
    public static double revenues_a_D9 = 0;
    public static double revenues_a_F9 = 0;

    public static double operatingMargin_b_B10 = 0;
    public static double operatingMargin_b_C10 = 0;
    public static double operatingMargin_b_D10 = 0;
    public static double operatingMargin_b_F10 = 0;

    public static double taxRate_B11 = 0;
    public static double taxRate_C11 = 0;
    public static double taxRate_D11 = 0;
    public static double taxRate_F11 = 0;

    public static double reinvestment_C_D12 = 0;
    public static double reinvestment_C_F12;

    public static double returnOnCapital_B13 = 0;
    public static double returnOnCapital_D13 = 0;
    public static double returnOnCapital_F13 = 0;


    public static double costOfCapital_d_C14 = 0;
    public static double costOfCapital_d_D14 = 0;
    public static double costOfCapital_d_F14 = 0;

    public static double valueOfOperatingAssets_B24=0;

    //Terminal value
    public static double terminalValue_InTheValue_D29 = 0;
    public static double PV_terminalValue_InTheValue_D30 = 0;
    public static double PV_CF_InTheValue_D31 = 0;
    public static double valueOfOperatingAssets_InTheValue_D32 = 0;
    public static double adjustmentForDistress_D33 = 0;
    public static double _debtAndMnorityInterests_D34 = 0;
    public static double cashAndOtherNon_operatingAssets_D35 = 0;
    public static double valueOfEquity_D36 = 0;
    public static double _valueOfEquityOptions_D37 = 0;
    public static double numberOfShares_D38 = 0;
    public static double valuePerShare_D39 = 0;
    public static double Probability_of_failure_G33;
    public static double Stock_was_trading_at_G39;

    public static double output(String str) {
        InputData inputData = new InputData();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();
        OptionValue ov = new OptionValue();
        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());
        costOfCapital.setCostOfCapitalList(inputData.getB31(),InputData.getYearOfList(),InputData.getYear2_x());

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue(),InputData.getYearOfList(),InputData.getYear2_x());

        A3Revenues revenues = new A3Revenues();
        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate,InputData.getYearOfList());

        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(inputData.isB14(), inputData.isB13(), olc.getF32(), rdc.getD39(), inputData.getB9());
        ebitMargin.setEBITMarginList(inputData.getB8(), inputData.getB24(), inputData.getB26(), inputData.getB27(),InputData.getYearOfList());

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin,InputData.getYearOfList());

        A10NOL nol = new A10NOL();
        nol.setNolList(inputData.isB54(), inputData.getB55(), ebitIncome,InputData.getYearOfList());

        A7EBIT1t ebit1t = new A7EBIT1t();
        ebit1t.setTerminalEBIT1t(inputData.getB20(), revenues, ebitMargin);

        ebit1t.setEBIT1tList(ebitIncome, inputData.getB20(), nol,InputData.getYearOfList());

        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());

        A40ROIC roic = new A40ROIC();
        roic.setTerminaLROIC(inputData.isB44(), inputData.getB45(), costOfCapital);

        A8Reinvestment reinvestment = new A8Reinvestment();
        reinvestment.setReinvestmentList(revenues, inputData.getB28(), revenueGrowthRate, roic, ebit1t,InputData.getYearOfList());


        A16TerminalCashFlow terminalCashFlow = new A16TerminalCashFlow();
        terminalCashFlow.setTerminalCashFlow(ebit1t, reinvestment);


        A6TaxRate taxRate = new A6TaxRate();
        taxRate.setTaxRateList(inputData.getB20(),InputData.getYearOfList());
        A9FCFF fcff = new A9FCFF();
        fcff.setFcffList(ebit1t, reinvestment,InputData.getYearOfList());

        A13CumulatedDiscountFactor cumulatedDiscountFactor = new A13CumulatedDiscountFactor();
        cumulatedDiscountFactor.setCumulatedDFListList(costOfCapital,InputData.getYearOfList());

        A38SalesToCapitalRatio salesToCapitalRatio = new A38SalesToCapitalRatio();
        salesToCapitalRatio.setSalesToCapitalRatioList(inputData.getB28(),InputData.getYearOfList());

        A39InvestedCapital investedCapital = new A39InvestedCapital();
        investedCapital.setInvestedCapitalList(inputData.isB14(), inputData.isB13(), inputData.getB12(), inputData.getB15(), inputData.getB11(), olc.getF33(), rdc.getD35(), reinvestment,InputData.getYearOfList());

        roic.setRoicList(ebit1t, investedCapital,InputData.getYearOfList());
        A14PVFCFF pvfcff = new A14PVFCFF();
        pvfcff.setPvFcffList(fcff, cumulatedDiscountFactor,InputData.getYearOfList());

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
        proceedsIfFirmFails.setProceedsIfFirmFails(inputData.getB49(), inputData.getB11(), inputData.getB12(), inputData.getB50(),sumOfPV);

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

        if (Objects.equals(str, "B9")) {
            revenues_a_B9 = inputData.getB8();
            return revenues_a_B9;
        }
        if (Objects.equals(str, "C9")){
            revenues_a_C9 = inputData.getB25();
            return revenues_a_C9;
        }
        if (Objects.equals(str, "D9")){
            revenues_a_D9 = revenueGrowthRate.getTerminalRevenue();
            return revenues_a_D9;
        }
        if (Objects.equals(str, "F9")){
            revenues_a_F9 = revenueGrowthRate.getTerminalRevenue();
            return revenues_a_F9;
        }


        if (Objects.equals(str, "B10")) {
            operatingMargin_b_B10 = ebitMargin.getEBITMarginList().get(0);
            return operatingMargin_b_B10;
        }
        if (Objects.equals(str, "C10")){
            operatingMargin_b_C10 = ebitMargin.getEBITMarginList().get(0);
            return operatingMargin_b_C10;
        }
        if (Objects.equals(str, "D10")) {
            operatingMargin_b_D10 = ebitMargin.getEBITMarginList().get(11);
            return operatingMargin_b_D10;
        }
        if (Objects.equals(str, "F10")){
            operatingMargin_b_F10 = ebitMargin.getEBITMarginList().get(11);
            return operatingMargin_b_F10;
        }


        if (Objects.equals(str, "B11")) {
            taxRate_B11 = inputData.getB20();
            return taxRate_B11;
        }
        if (Objects.equals(str, "C11")){
            taxRate_C11 = inputData.getB20();
            return taxRate_C11;
        }
        if (Objects.equals(str, "D11")) {
            taxRate_D11 = taxRate.getTerminalTaxRate();
            return taxRate_D11;
        }
        if (Objects.equals(str, "F11")){
            taxRate_F11 = taxRate.getTerminalTaxRate();
            return taxRate_F11;
        }



        if (Objects.equals(str, "D12")) {
            reinvestment_C_D12 = inputData.getB28();
            return reinvestment_C_D12;
        }
        if (Objects.equals(str, "F12")){
            BigDecimal big_TerminalRevenueGrowthRate = new BigDecimal(Double.toString(revenueGrowthRate.getTerminalRevenueGrowthRate()));
            BigDecimal big_terminalRoic = new BigDecimal(Double.toString(roic.terminaLROIC));
            reinvestment_C_F12 = big_TerminalRevenueGrowthRate.divide(big_terminalRoic, 20, RoundingMode.HALF_UP).setScale(4, RoundingMode.HALF_UP).doubleValue();
            return reinvestment_C_F12;
        }


        if (Objects.equals(str, "B13")) {
            returnOnCapital_B13 = roic.getRoicList().get(0);

            return returnOnCapital_B13;
        }
        if (Objects.equals(str, "D13")) {
            double Diagnostics_B5;
            double Diagnostics_B4;
            double Diagnostics_B3;
            double Diagnostics_B2;
            double Diagnostics_B6;
            Diagnostics_B5 = ebitIncome.getEBITIncomeList().get(10) - ebitIncome.getEBITIncomeList().get(0);
            Diagnostics_B3 = investedCapital.getInvestedCapitalList().get(10);
            Diagnostics_B2 = investedCapital.getInvestedCapitalList().get(0);
            Diagnostics_B4 = Diagnostics_B3 - Diagnostics_B2;
            BigDecimal big_B5 = new BigDecimal(Double.toString(Diagnostics_B5));
            BigDecimal big_B4 = new BigDecimal(Double.toString(Diagnostics_B4));
            Diagnostics_B6 = big_B5.divide(big_B4, 20, RoundingMode.HALF_UP).setScale(4, RoundingMode.HALF_UP).doubleValue();
            returnOnCapital_D13 = Diagnostics_B6;
            return returnOnCapital_D13;
        }

        if (Objects.equals(str, "F13")){
            returnOnCapital_F13 = roic.getTerminaLROIC();
            return returnOnCapital_F13;
        }


        if (Objects.equals(str, "C14")){
            costOfCapital_d_C14 = inputData.getB31();
            return costOfCapital_d_C14;
        }
        if (Objects.equals(str, "D14")) {
            costOfCapital_d_D14 = costOfCapital.terminalostOfCapital;
            return costOfCapital_d_D14;
        }
        if (Objects.equals(str, "F14")){
            costOfCapital_d_F14 = costOfCapital.terminalostOfCapital;
            return costOfCapital_d_F14;
        }



        if (Objects.equals(str, "D29")){
            terminalValue_InTheValue_D29=a18terminalValue.getTerminalvalue();
            return terminalValue_InTheValue_D29;
        }
        if (Objects.equals(str, "D30")){
            PV_terminalValue_InTheValue_D30=pvTerminalValue.getpVTerminalValue();
            return PV_terminalValue_InTheValue_D30;
        }
        if (Objects.equals(str, "D31")){
            PV_CF_InTheValue_D31=pvcfOver10Year.getpVCFOver10Year();
            return PV_CF_InTheValue_D31;
        }
        if (Objects.equals(str, "D32")){
            valueOfOperatingAssets_InTheValue_D32=sumOfPV.getSumOfPV();
            return valueOfOperatingAssets_InTheValue_D32;
        }
        if (Objects.equals(str, "B24")){
            valueOfOperatingAssets_B24=valueOfOperatingAssets.getValueOfOperatingAssets();
            return valueOfOperatingAssets_B24;
        }
        if (Objects.equals(str, "D34")){
            _debtAndMnorityInterests_D34=  debt.getDebt()+inputData.getB17();
            return _debtAndMnorityInterests_D34;
        }
        if (Objects.equals(str, "D35")){
            cashAndOtherNon_operatingAssets_D35=cash.getCash()+inputData.getB16();
            return cashAndOtherNon_operatingAssets_D35;
        }
/*        if (Objects.equals(str, "D36")){
            return valueOfEquity_D36;
        }*/
        if (Objects.equals(str, "D37")){
            _valueOfEquityOptions_D37=valueOfOptions.getValueOfOptions();
            return _valueOfEquityOptions_D37;
        }
        if (Objects.equals(str, "D38")){
            numberOfShares_D38=inputData.getB18();
            return numberOfShares_D38;
        }
        if (Objects.equals(str, "D39")){
            return valuePerShare_D39;
        }

        if (Objects.equals(str, "G33")){
            Probability_of_failure_G33=probabilityOfFailure.getProbability_failure();
            return Probability_of_failure_G33;
        }
        if (Objects.equals(str, "G39")){
            Stock_was_trading_at_G39=inputData.getB19();
            return Stock_was_trading_at_G39;
        }
        return 0;
    }
}
