package com.back.example;

import com.back.StaticData.*;
import com.back.example.OutputSheet.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class OutPutMethod {
    public static ArrayList<Double> revenuesList = new ArrayList<>();
    public static ArrayList<Double> ebitMarginList = new ArrayList<>();
    public static ArrayList<Double> EBIT1_tList = new ArrayList<>();
    public static ArrayList<Double> reinvestmentList = new ArrayList<>();
    public static ArrayList<BigDecimal> EBITList = new ArrayList<>();
    public static ArrayList<BigDecimal> FCFFList = new ArrayList<>();

    //9 ******************************************
   /* public static double outputB9() {
        InputData inputData = new InputData();
        revenues_a_B9 = inputData.getB8();
        return revenues_a_B9;
    }

    public static double outputC9() {
        InputData inputData = new InputData();
        revenues_a_C9 = inputData.getB25();
        return revenues_a_C9;
    }

    public static double outputD9() {
        InputData inputData = new InputData();
        A2RevenueGrowthRate a2RevenueGrowthRate = new A2RevenueGrowthRate();
        a2RevenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());
        revenues_a_D9 = a2RevenueGrowthRate.getTerminalRevenue();
        return revenues_a_D9;
    }

    public static double outputF9() {
        InputData inputData = new InputData();
        A2RevenueGrowthRate a2RevenueGrowthRate = new A2RevenueGrowthRate();
        a2RevenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());
        revenues_a_F9 = a2RevenueGrowthRate.getTerminalRevenue();
        return revenues_a_F9;
    }


//10 ******************************************

    public static double outputB10() {
        InputData inputData = new InputData();

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue());
        A3Revenues revenues = new A3Revenues();

        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate);

        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(inputData.isB14(), inputData.isB13(), olc.getF32(), rdc.getD39(), inputData.getB9());
        ebitMargin.setEBITMarginList(inputData.getB8(), inputData.getB24(), inputData.getB26(), inputData.getB27());

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);

        operatingMargin_b_B10 = ebitMargin.getEBITMarginList().get(0);
        return operatingMargin_b_B10;
    }

    public static double outputC10() {
        InputData inputData = new InputData();

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue());
        A3Revenues revenues = new A3Revenues();

        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate);

        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(inputData.isB14(), inputData.isB13(), olc.getF32(), rdc.getD39(), inputData.getB9());
        ebitMargin.setEBITMarginList(inputData.getB8(), inputData.getB24(), inputData.getB26(), inputData.getB27());

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);

        operatingMargin_b_C10 = ebitMargin.getEBITMarginList().get(0);
        return operatingMargin_b_C10;
    }

    public static double outputD10() {
        InputData inputData = new InputData();

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue());
        A3Revenues revenues = new A3Revenues();

        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate);

        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(inputData.isB14(), inputData.isB13(), olc.getF32(), rdc.getD39(), inputData.getB9());
        ebitMargin.setEBITMarginList(inputData.getB8(), inputData.getB24(), inputData.getB26(), inputData.getB27());

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);

        operatingMargin_b_D10 = ebitMargin.getEBITMarginList().get(11);
        return operatingMargin_b_D10;
    }

    public static double outputF10() {
        InputData inputData = new InputData();

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue());
        A3Revenues revenues = new A3Revenues();

        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate);

        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(inputData.isB14(), inputData.isB13(), olc.getF32(), rdc.getD39(), inputData.getB9());
        ebitMargin.setEBITMarginList(inputData.getB8(), inputData.getB24(), inputData.getB26(), inputData.getB27());

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);

        operatingMargin_b_F10 = ebitMargin.getEBITMarginList().get(11);
        return operatingMargin_b_F10;
    }


    //11 ******************************************
    public static double outputB11() {
        InputData inputData = new InputData();
        taxRate_B11 = inputData.getB20();
        return taxRate_B11;
    }

    public static double outputC11() {
        InputData inputData = new InputData();
        taxRate_C11 = inputData.getB20();
        return taxRate_C11;
    }

    public static double outputD11() {
        InputData inputData = new InputData();
        A6TaxRate a6TaxRate = new A6TaxRate();
        a6TaxRate.setTaxRateList(inputData.getB20());
        taxRate_D11 = a6TaxRate.getTerminalTaxRate();
        return taxRate_D11;
    }

    public static double outputF11() {
        InputData inputData = new InputData();
        A6TaxRate a6TaxRate = new A6TaxRate();
        a6TaxRate.setTaxRateList(inputData.getB20());
        taxRate_F11 = a6TaxRate.getTerminalTaxRate();
        return taxRate_F11;
    }


    //12 ******************************************

    public static double outputD12() {
        InputData inputData = new InputData();
        reinvestment_C_D12 = inputData.getB28();
        return reinvestment_C_D12;
    }

    public static double outputF12() {
        InputData inputData = new InputData();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();
        OptionValue ov = new OptionValue();
        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());
        costOfCapital.setCostOfCapitalList(inputData.getB31());

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue());

        A3Revenues revenues = new A3Revenues();
        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate);


        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(inputData.isB14(), inputData.isB13(), olc.getF32(), rdc.getD39(), inputData.getB9());
        ebitMargin.setEBITMarginList(inputData.getB8(), inputData.getB24(), inputData.getB26(), inputData.getB27());

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);

        A10NOL nol = new A10NOL();
        nol.setNolList(inputData.isB54(), inputData.getB55(), ebitIncome);

        A7EBIT1t ebit1t = new A7EBIT1t();
        ebit1t.setTerminalEBIT1t(inputData.getB20(), revenues, ebitMargin);

        ebit1t.setEBIT1tList(ebitIncome, inputData.getB20(), nol);


        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());

        A40ROIC roic = new A40ROIC();
        roic.setTerminaLROIC(inputData.isB44(), inputData.getB45(), costOfCapital);


        BigDecimal big_TerminalRevenueGrowthRate = new BigDecimal(Double.toString(revenueGrowthRate.getTerminalRevenueGrowthRate()));
        BigDecimal big_terminalRoic = new BigDecimal(Double.toString(roic.terminaLROIC));

        reinvestment_C_F12 = big_TerminalRevenueGrowthRate.divide(big_terminalRoic, 20, RoundingMode.HALF_UP).setScale(4, RoundingMode.HALF_UP).doubleValue();
        return reinvestment_C_F12;
    }


    //13 ******************************************
    public static double outputB13() {
        InputData inputData = new InputData();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();
        OptionValue ov = new OptionValue();
        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());
        costOfCapital.setCostOfCapitalList(inputData.getB31());

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue());

        A3Revenues revenues = new A3Revenues();
        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate);


        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(inputData.isB14(), inputData.isB13(), olc.getF32(), rdc.getD39(), inputData.getB9());
        ebitMargin.setEBITMarginList(inputData.getB8(), inputData.getB24(), inputData.getB26(), inputData.getB27());

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);

        A10NOL nol = new A10NOL();
        nol.setNolList(inputData.isB54(), inputData.getB55(), ebitIncome);

        A7EBIT1t ebit1t = new A7EBIT1t();
        ebit1t.setTerminalEBIT1t(inputData.getB20(), revenues, ebitMargin);

        ebit1t.setEBIT1tList(ebitIncome, inputData.getB20(), nol);


        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());

        A40ROIC roic = new A40ROIC();
        roic.setTerminaLROIC(inputData.isB44(), inputData.getB45(), costOfCapital);


        A8Reinvestment reinvestment = new A8Reinvestment();
        reinvestment.setReinvestmentList(revenues, inputData.getB28(), revenueGrowthRate, roic, ebit1t);


        A16TerminalCashFlow terminalCashFlow = new A16TerminalCashFlow();
        terminalCashFlow.setTerminalCashFlow(ebit1t, reinvestment);


        A6TaxRate taxRate = new A6TaxRate();
        taxRate.setTaxRateList(inputData.getB20());
        A9FCFF fcff = new A9FCFF();
        fcff.setFcffList(ebit1t, reinvestment);

        A13CumulatedDiscountFactor cumulatedDiscountFactor = new A13CumulatedDiscountFactor();
        cumulatedDiscountFactor.setCumulatedDFListList(costOfCapital);

        A38SalesToCapitalRatio salesToCapitalRatio = new A38SalesToCapitalRatio();
        salesToCapitalRatio.setSalesToCapitalRatioList(inputData.getB28());

        A39InvestedCapital investedCapital = new A39InvestedCapital();
        investedCapital.setInvestedCapitalList(inputData.isB14(), inputData.isB13(), inputData.getB12(), inputData.getB15(), inputData.getB11(), olc.getF33(), rdc.getD35(), reinvestment);

        roic.setRoicList(ebit1t, investedCapital);
        returnOnCapital_B13 = roic.getRoicList().get(0);

        return returnOnCapital_B13;
    }

    public static double outputD13() {
        double Diagnostics_B5;
        double Diagnostics_B4;
        double Diagnostics_B3;
        double Diagnostics_B2;
        double Diagnostics_B6;

        InputData inputData = new InputData();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();
        OptionValue ov = new OptionValue();
        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());
        costOfCapital.setCostOfCapitalList(inputData.getB31());

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue());
        A3Revenues revenues = new A3Revenues();

        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate);
        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(inputData.isB14(), inputData.isB13(), olc.getF32(), rdc.getD39(), inputData.getB9());
        ebitMargin.setEBITMarginList(inputData.getB8(), inputData.getB24(), inputData.getB26(), inputData.getB27());

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);

        Diagnostics_B5 = ebitIncome.getEBITIncomeList().get(10) - ebitIncome.getEBITIncomeList().get(0);


        A10NOL nol = new A10NOL();
        nol.setNolList(inputData.isB54(), inputData.getB55(), ebitIncome);

        A7EBIT1t ebit1t = new A7EBIT1t();
        ebit1t.setTerminalEBIT1t(inputData.getB20(), revenues, ebitMargin);
        ebit1t.setEBIT1tList(ebitIncome, inputData.getB20(), nol);

        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());

        A40ROIC roic = new A40ROIC();
        roic.setTerminaLROIC(inputData.isB44(), inputData.getB45(), costOfCapital);

        A8Reinvestment reinvestment = new A8Reinvestment();
        reinvestment.setReinvestmentList(revenues, inputData.getB28(), revenueGrowthRate, roic, ebit1t);

        A39InvestedCapital investedCapital = new A39InvestedCapital();
        investedCapital.setInvestedCapitalList(inputData.isB14(), inputData.isB13(), inputData.getB12(), inputData.getB15(), inputData.getB11(), olc.getF33(), rdc.getD35(), reinvestment);
        Diagnostics_B3 = investedCapital.getInvestedCapitalList().get(10);
        Diagnostics_B2 = investedCapital.getInvestedCapitalList().get(0);
        Diagnostics_B4 = Diagnostics_B3 - Diagnostics_B2;

        BigDecimal big_B5 = new BigDecimal(Double.toString(Diagnostics_B5));
        BigDecimal big_B4 = new BigDecimal(Double.toString(Diagnostics_B4));

        Diagnostics_B6 = big_B5.divide(big_B4, 20, RoundingMode.HALF_UP).setScale(4, RoundingMode.HALF_UP).doubleValue();


        *//*System.out.println(Diagnostics_B6);
        System.out.println(Diagnostics_B4);
        System.out.println(Diagnostics_B5);
        System.out.println(Diagnostics_B3);
        System.out.println(Diagnostics_B2);*//*

        returnOnCapital_D13 = Diagnostics_B6;
        return returnOnCapital_D13;
    }

    public static double outputF13() {
        InputData inputData = new InputData();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();
        OptionValue ov = new OptionValue();
        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());
        costOfCapital.setCostOfCapitalList(inputData.getB31());

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue());

        A3Revenues revenues = new A3Revenues();
        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate);

        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(inputData.isB14(), inputData.isB13(), olc.getF32(), rdc.getD39(), inputData.getB9());
        ebitMargin.setEBITMarginList(inputData.getB8(), inputData.getB24(), inputData.getB26(), inputData.getB27());

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);

        A10NOL nol = new A10NOL();
        nol.setNolList(inputData.isB54(), inputData.getB55(), ebitIncome);

        A7EBIT1t ebit1t = new A7EBIT1t();
        ebit1t.setTerminalEBIT1t(inputData.getB20(), revenues, ebitMargin);

        ebit1t.setEBIT1tList(ebitIncome, inputData.getB20(), nol);


        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());

        A40ROIC roic = new A40ROIC();
        roic.setTerminaLROIC(inputData.isB44(), inputData.getB45(), costOfCapital);
        returnOnCapital_F13 = roic.getTerminaLROIC();

        return returnOnCapital_F13;
    }


    //14 ******************************************
    public static double outputC14() {
        InputData inputData = new InputData();
        costOfCapital_d_C14 = inputData.getB31();
        return costOfCapital_d_C14;
    }

    public static double outputD14() {
        InputData inputData = new InputData();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();
        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());
        //costOfCapital.setCostOfCapitalList(inputData.getB31());
        costOfCapital_d_D14 = costOfCapital.terminalostOfCapital;
        return costOfCapital_d_D14;
    }

    public static double outputF14() {
        InputData inputData = new InputData();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();
        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());
        //costOfCapital.setCostOfCapitalList(inputData.getB31());
        costOfCapital_d_F14 = costOfCapital.terminalostOfCapital;
        return costOfCapital_d_F14;
    }*/


    //RevenuesList ******************************************
    public static ArrayList<Double> outputRevenuesList() {
        InputData inputData = new InputData();
        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());
        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue(), InputData.getYearOfList(),InputData.getYear2_x());
        A3Revenues revenues = new A3Revenues();
        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate,InputData.getYearOfList());
        revenuesList=revenues.getRevenuesList();
        return revenuesList;
    }


    //ebitMarginList ******************************************
    public static ArrayList<Double> outputebitMarginList() {
        InputData inputData = new InputData();

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue(),InputData.getYearOfList(),InputData.getYear2_x());
        A3Revenues revenues = new A3Revenues();

        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate,InputData.getYearOfList());

        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(inputData.isB14(), inputData.isB13(), olc.getF32(), rdc.getD39(), inputData.getB9());
        ebitMargin.setEBITMarginList(inputData.getB8(), inputData.getB24(), inputData.getB26(), inputData.getB27(),InputData.getYearOfList());

        ebitMarginList = ebitMargin.ebitMarginList;
        return ebitMarginList;
    }

    //EBITList ******************************************
    //todo


    //EBIT1_tList ******************************************
    public static ArrayList<Double> outputEBIT1_tList() {
        InputData inputData = new InputData();
        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

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

        EBIT1_tList = ebit1t.getEBIT1tList();

        return EBIT1_tList;
    }


    //ReinvestmentList******************************************

    public static ArrayList<Double> outputReinvestmentList() {
        InputData inputData = new InputData();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();
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
        reinvestmentList = reinvestment.getReinvestmentList();
        return reinvestmentList;
    }

    //FCFFlist ******************************************
    //todo


    // D29******************************************
   /* public static double outputD29() {
        InputData inputData = new InputData();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();
        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());
        costOfCapital.setCostOfCapitalList(inputData.getB31());

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue());

        A3Revenues revenues = new A3Revenues();
        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate);



        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(inputData.isB14(), inputData.isB13(), olc.getF32(), rdc.getD39(), inputData.getB9());
        ebitMargin.setEBITMarginList(inputData.getB8(), inputData.getB24(), inputData.getB26(), inputData.getB27());

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);

        A10NOL nol = new A10NOL();
        nol.setNolList(inputData.isB54(), inputData.getB55(), ebitIncome);

        A7EBIT1t ebit1t = new A7EBIT1t();
        ebit1t.setTerminalEBIT1t(inputData.getB20(), revenues, ebitMargin);

        ebit1t.setEBIT1tList(ebitIncome, inputData.getB20(), nol);
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());

        A40ROIC roic = new A40ROIC();
        roic.setTerminaLROIC(inputData.isB44(), inputData.getB45(), costOfCapital);

        A8Reinvestment reinvestment = new A8Reinvestment();
        reinvestment.setReinvestmentList(revenues, inputData.getB28(), revenueGrowthRate, roic, ebit1t);


        A16TerminalCashFlow terminalCashFlow = new A16TerminalCashFlow();
        terminalCashFlow.setTerminalCashFlow(ebit1t, reinvestment);

        A18TerminalValue a18terminalValue = new A18TerminalValue();
        a18terminalValue.setTerminalvalue(costOfCapital, terminalCashFlow, revenueGrowthRate);
        terminalValue_InTheValue_D29=a18terminalValue.getTerminalvalue();
        return terminalValue_InTheValue_D29;
    }

    //******************************************
    public static double outputD30() {
        InputData inputData = new InputData();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();
        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());
        costOfCapital.setCostOfCapitalList(inputData.getB31());

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue());

        A3Revenues revenues = new A3Revenues();
        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate);



        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(inputData.isB14(), inputData.isB13(), olc.getF32(), rdc.getD39(), inputData.getB9());
        ebitMargin.setEBITMarginList(inputData.getB8(), inputData.getB24(), inputData.getB26(), inputData.getB27());

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);

        A10NOL nol = new A10NOL();
        nol.setNolList(inputData.isB54(), inputData.getB55(), ebitIncome);

        A7EBIT1t ebit1t = new A7EBIT1t();
        ebit1t.setTerminalEBIT1t(inputData.getB20(), revenues, ebitMargin);

        ebit1t.setEBIT1tList(ebitIncome, inputData.getB20(), nol);
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());

        A40ROIC roic = new A40ROIC();
        roic.setTerminaLROIC(inputData.isB44(), inputData.getB45(), costOfCapital);

        A8Reinvestment reinvestment = new A8Reinvestment();
        reinvestment.setReinvestmentList(revenues, inputData.getB28(), revenueGrowthRate, roic, ebit1t);


        A16TerminalCashFlow terminalCashFlow = new A16TerminalCashFlow();
        terminalCashFlow.setTerminalCashFlow(ebit1t, reinvestment);

        A13CumulatedDiscountFactor cumulatedDiscountFactor = new A13CumulatedDiscountFactor();
        cumulatedDiscountFactor.setCumulatedDFListList(costOfCapital);

        A18TerminalValue a18terminalValue = new A18TerminalValue();
        a18terminalValue.setTerminalvalue(costOfCapital, terminalCashFlow, revenueGrowthRate);
        A19PVTerminalValue pvTerminalValue = new A19PVTerminalValue();
        pvTerminalValue.setpVTerminalValue(a18terminalValue, cumulatedDiscountFactor);
        PV_terminalValue_InTheValue_D30=pvTerminalValue.getpVTerminalValue();
        return PV_terminalValue_InTheValue_D30;
    }

    //******************************************
    public static double outputD31() {
        InputData inputData = new InputData();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();
        OptionValue ov=new OptionValue();
        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());
        costOfCapital.setCostOfCapitalList(inputData.getB31());

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue());

        A3Revenues revenues = new A3Revenues();
        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate);



        A4EBITMargin ebitMargin = new A4EBITMargin();
        ebitMargin.setBaseIncome(inputData.isB14(), inputData.isB13(), olc.getF32(), rdc.getD39(), inputData.getB9());
        ebitMargin.setEBITMarginList(inputData.getB8(), inputData.getB24(), inputData.getB26(), inputData.getB27());

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);

        A10NOL nol = new A10NOL();
        nol.setNolList(inputData.isB54(), inputData.getB55(), ebitIncome);

        A7EBIT1t ebit1t = new A7EBIT1t();
        ebit1t.setTerminalEBIT1t(inputData.getB20(), revenues, ebitMargin);

        ebit1t.setEBIT1tList(ebitIncome, inputData.getB20(), nol);


        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());

        A40ROIC roic = new A40ROIC();
        roic.setTerminaLROIC(inputData.isB44(), inputData.getB45(), costOfCapital);

        A8Reinvestment reinvestment = new A8Reinvestment();
        reinvestment.setReinvestmentList(revenues, inputData.getB28(), revenueGrowthRate, roic, ebit1t);


        A9FCFF fcff = new A9FCFF();
        fcff.setFcffList(ebit1t, reinvestment);

        A13CumulatedDiscountFactor cumulatedDiscountFactor = new A13CumulatedDiscountFactor();
        cumulatedDiscountFactor.setCumulatedDFListList(costOfCapital);

        A14PVFCFF pvfcff = new A14PVFCFF();
        pvfcff.setPvFcffList(fcff, cumulatedDiscountFactor);

        A20PVCFOver10Year pvcfOver10Year = new A20PVCFOver10Year();
        pvcfOver10Year.setpVCFOver10Year(pvfcff);
        PV_CF_InTheValue_D31=pvcfOver10Year.getpVCFOver10Year();

        return PV_CF_InTheValue_D31;
    }
    //******************************************
    public static double outputD32() {
        InputData inputData = new InputData();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();
        OptionValue ov=new OptionValue();
        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());
        costOfCapital.setCostOfCapitalList(inputData.getB31());

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue());

        A3Revenues revenues = new A3Revenues();
        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate);



        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(inputData.isB14(), inputData.isB13(), olc.getF32(), rdc.getD39(), inputData.getB9());
        ebitMargin.setEBITMarginList(inputData.getB8(), inputData.getB24(), inputData.getB26(), inputData.getB27());

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin);

        A10NOL nol = new A10NOL();
        nol.setNolList(inputData.isB54(), inputData.getB55(), ebitIncome);

        A7EBIT1t ebit1t = new A7EBIT1t();
        ebit1t.setTerminalEBIT1t(inputData.getB20(), revenues, ebitMargin);

        ebit1t.setEBIT1tList(ebitIncome, inputData.getB20(), nol);

        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());

        A40ROIC roic = new A40ROIC();
        roic.setTerminaLROIC(inputData.isB44(), inputData.getB45(), costOfCapital);


        A8Reinvestment reinvestment = new A8Reinvestment();
        reinvestment.setReinvestmentList(revenues, inputData.getB28(), revenueGrowthRate, roic, ebit1t);


        A16TerminalCashFlow terminalCashFlow = new A16TerminalCashFlow();
        terminalCashFlow.setTerminalCashFlow(ebit1t, reinvestment);


        A9FCFF fcff = new A9FCFF();
        fcff.setFcffList(ebit1t, reinvestment);

        A13CumulatedDiscountFactor cumulatedDiscountFactor = new A13CumulatedDiscountFactor();
        cumulatedDiscountFactor.setCumulatedDFListList(costOfCapital);


        A39InvestedCapital investedCapital = new A39InvestedCapital();
        investedCapital.setInvestedCapitalList(inputData.isB14(), inputData.isB13(), inputData.getB12(), inputData.getB15(), inputData.getB11(), olc.getF33(), rdc.getD35(), reinvestment);
        roic.setRoicList(ebit1t, investedCapital);
        A14PVFCFF pvfcff = new A14PVFCFF();
        pvfcff.setPvFcffList(fcff, cumulatedDiscountFactor);

        A18TerminalValue a18terminalValue = new A18TerminalValue();
        a18terminalValue.setTerminalvalue(costOfCapital, terminalCashFlow, revenueGrowthRate);



        A19PVTerminalValue pvTerminalValue = new A19PVTerminalValue();
        pvTerminalValue.setpVTerminalValue(a18terminalValue, cumulatedDiscountFactor);

        A20PVCFOver10Year pvcfOver10Year = new A20PVCFOver10Year();
        pvcfOver10Year.setpVCFOver10Year(pvfcff);

        A21SumOfPV sumOfPV = new A21SumOfPV();
        sumOfPV.setSumOfPV(pvcfOver10Year, pvTerminalValue);
        valueOfOperatingAssets_InTheValue_D32=sumOfPV.getSumOfPV();

        return valueOfOperatingAssets_InTheValue_D32;
    }

    //******************************************
    public static double outputD33() { //todo
        return adjustmentForDistress_D33;
    }

    //******************************************
    public static double outputD34() {
        InputData inputData = new InputData();
        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        A25Debt debt=new A25Debt();
        debt.setDebt(inputData.isB14(), olc.getC28(), inputData.getB12());


        _debtAndMnorityInterests_D34=  debt.getDebt()+inputData.getB17();
        return _debtAndMnorityInterests_D34;

    }

    //******************************************
    public static double outputD35() {
        InputData inputData=new InputData();
        A27Cash cash=new A27Cash();
        cash.setCash(inputData.isB63(), inputData.getB15(), inputData.getB64(), inputData.getB65(), inputData.getB21());
        cashAndOtherNon_operatingAssets_D35=cash.getCash()+inputData.getB16();
        return cashAndOtherNon_operatingAssets_D35;
    }

    //******************************************
    public static double outputD36() {//todo
        return valueOfEquity_D36;
    }


    //******************************************
    public static double outputD37() {
        InputData inputData = new InputData();
        OptionValue ov=new OptionValue();
        A30ValueOfOptions valueOfOptions=new A30ValueOfOptions();
        valueOfOptions.setValueOfOptions(inputData.isB33(), ov.getD27());
        _valueOfEquityOptions_D37=valueOfOptions.getValueOfOptions();
        return _valueOfEquityOptions_D37;
    }

    //******************************************
    public static double outputD38() {
        InputData inputData=new InputData();
        numberOfShares_D38=inputData.getB18();
        return numberOfShares_D38;
    }

    //******************************************
    *//*public static double outputD39() { //todo
        return valuePerShare_D39;
    }*//*

    //***************************************
    public static double outputG33(){
        InputData inputData=new InputData();
        A22ProbabilityOfFailure probabilityOfFailure = new A22ProbabilityOfFailure();
        probabilityOfFailure.setProbability_failure(inputData.getB48(), inputData.isB47());
        Probability_of_failure_G33=probabilityOfFailure.getProbability_failure();
        return Probability_of_failure_G33;
    }

    public static double outputG39(){
        InputData inputData=new InputData();
        Stock_was_trading_at_G39=inputData.getB19();
        return Stock_was_trading_at_G39;
    }


    public static double outputB24() {
        return 0.0;
    }*/
}




