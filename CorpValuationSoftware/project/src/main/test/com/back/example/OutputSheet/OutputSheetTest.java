package com.back.example.OutputSheet;

import com.back.StaticData.*;
import com.back.example.OutPutMethod;
import com.back.example.OutPutMethod2;
import com.back.example.OutputSheet.A12CostOfCapital;
import com.back.example.OutputSheet.A2RevenueGrowthRate;
import com.back.example.OutputSheet.A3Revenues;
import com.back.example.OutputSheet.A4EBITMargin;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class OutputSheetTest {

    @Test
    public void testCostOfcaptial() {
        InputData inputData = new InputData();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();
        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());
        costOfCapital.setCostOfCapitalList(inputData.getB31(), InputData.getYearOfList(), InputData.getYear2_x());
        assertNotNull(costOfCapital.getCostOfCapitalList());
    }

    @Test
    public void testRevenueGrowgrate() {
        InputData inputData = new InputData();
        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());
        assertNotNull(revenueGrowthRate.getRevenueGrowthRateList());
    }

    @Test

    public void testRevenues() {
        InputData inputData = new InputData();
        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());
        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue(), InputData.getYearOfList(), InputData.getYear2_x());
        A3Revenues revenues = new A3Revenues();
        revenues.setA3RevenuesList(inputData.getB8(), revenueGrowthRate, InputData.getYearOfList());
        assertNotNull(revenues.getRevenuesList());
    }

    @Test
    public void testEBITMAR() {
        InputData inputData = new InputData();
        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();
        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(inputData.isB14(), inputData.isB13(), olc.getF32(), rdc.getD39(), inputData.getB9());
        ebitMargin.setEBITMarginList(inputData.getB8(), inputData.getB24(), inputData.getB26(), inputData.getB27(), InputData.getYearOfList());
        assertNotNull(ebitMargin.getEBITMarginList());
    }


    @Test
    public void testRevenue() {
        ArrayList<Double> outputRevenuesList = OutPutMethod.outputRevenuesList();
        assertNotNull(outputRevenuesList);
    }

    @Test
    public void testOperatingMargin() {
        ArrayList<Double> outputebitMarginList = OutPutMethod.outputebitMarginList();
        assertNotNull(outputebitMarginList);
    }

    @Test
    public void testEBIT() {
        ArrayList<Double> outputEBIT1_tList = OutPutMethod.outputEBIT1_tList();
        assertNotNull(outputEBIT1_tList);
    }


    @Test
    public void testReinvestment() {
        ArrayList<Double> outputreinvestmentList = OutPutMethod.outputReinvestmentList();
        assertNotNull(outputreinvestmentList);
    }

    @Test
    public void testBaseyearRevenue() {
        double baseyearRevenue = OutPutMethod2.output("B9");
        assertNotNull(baseyearRevenue);
    }

    @Test
    public void testEndRevenue() {
        double endRevenue = OutPutMethod2.output("F9");
        assertNotNull(endRevenue);
    }

    @Test
    public void testBaseyearMargin() {
        double baseyearMargin = OutPutMethod2.output("B10");
        assertNotNull(baseyearMargin);
    }

    @Test
    public void testEndyearMargin() {
        double endyearMargin = OutPutMethod2.output("F10");
        assertNotNull(endyearMargin);
    }

    @Test
    public void testBaseyearTax() {
        double baseyearTax = OutPutMethod2.output("B11");
        assertNotNull(baseyearTax);
    }

    @Test
    public void testEndyearTax() {
        double endyearTax = OutPutMethod2.output("F11");
        assertNotNull(endyearTax);
    }

    @Test
    public void testBaseyearReinvestment() {
        double baseyearReinvestment = OutPutMethod2.output("D12");
        assertNotNull(baseyearReinvestment);
    }

    @Test
    public void testEndyearReinvestment() {
        double endyearReinvestment = OutPutMethod2.output("F12");
        assertNotNull(endyearReinvestment);
    }

    @Test
    public void testBaseyearCostOfCapital() {
        double baseyearCostOfCapital = OutPutMethod2.output("C13");
        assertNotNull(baseyearCostOfCapital);
    }

    @Test
    public void testEndyearCostOfCapital() {
        double endyearCostOfCapital = OutPutMethod2.output("F13");
        assertNotNull(endyearCostOfCapital);
    }

    @Test
    public void testTerminalValue() {
        double TerminalValue = OutPutMethod2.output("D29");
        assertNotNull(TerminalValue);
    }

    @Test
    public void testPV() {
        double PV = OutPutMethod2.output("D30");
        assertNotNull(PV);
    }

    @Test
    public void testPV10() {
        double PV10 = OutPutMethod2.output("D31");
        assertNotNull(PV10);
    }

    @Test
    public void testOperatingAssets() {
        double OperatingAssets = OutPutMethod2.output("D32");
        assertNotNull(OperatingAssets);
    }

    @Test
    public void testDebt() {
        double Debt = OutPutMethod2.output("D34");
        assertNotNull(Debt);
    }

    @Test
    public void testEquityOptions() {
        double testEquityOptions = OutPutMethod2.output("D37");
        assertNotNull(testEquityOptions);
    }

    @Test
    public void testNumberOfShares() {
        double NumberOfShares = OutPutMethod2.output("D38");
        assertNotNull(NumberOfShares);
    }


}
