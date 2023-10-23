package com.back.example.StoriesToNumbers;

import com.back.StaticData.CountryEquityRiskPremiums;
import com.back.StaticData.InputData;
import com.back.StaticData.OperatingLeaseConverter;
import com.back.StaticData.RDConverter;
import com.back.example.OutputSheet.*;



public class TerminalValue {


    public double terminalvalue;


    public void setTerminalvalue(A12CostOfCapital costOfCapital, A16TerminalCashFlow terminalCashFlow, A2RevenueGrowthRate revenueGrowthRate) {
        terminalvalue = terminalCashFlow.getTerminalCashFlow() / (costOfCapital.terminalostOfCapital - revenueGrowthRate.getTerminalRevenueGrowthRate());

    }

    public double getTerminalvalue() {
        return terminalvalue;
    }
}


class TestTerminalValue {
    public static void main(String[] args) {
        InputData data = new InputData();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();

        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(data.isB41(), data.getB42(), data.isB57(), data.getB58(), cerp.getB1(), data.getB30());
        costOfCapital.setCostOfCapitalList(data.getB31(),InputData.getYearOfList(),InputData.getYear2_x());

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(data.isB60(), data.getB61(), data.isB57(), data.getB58(), data.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(data.getB23(), data.getB25(), revenueGrowthRate.getTerminalRevenue(),InputData.getYearOfList(),InputData.getYear2_x());
        A3Revenues revenues = new A3Revenues();

        revenues.setA3RevenuesList(data.getB8(), revenueGrowthRate,InputData.getYearOfList());


        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A4EBITMargin ebitMargin = new A4EBITMargin();

        ebitMargin.setBaseIncome(data.isB14(), data.isB13(), olc.getF32(), rdc.getD39(), data.getB9());
        ebitMargin.setEBITMarginList(data.getB8(), data.getB24(), data.getB26(), data.getB27(),InputData.getYearOfList());

        A5EBITIncome ebitIncome = new A5EBITIncome();
        ebitIncome.setEBITIncomeList(revenues, ebitMargin,InputData.getYearOfList());

        A10NOL nol = new A10NOL();
        nol.setNolList(data.isB54(), data.getB55(), ebitIncome,InputData.getYearOfList());

        A7EBIT1t ebit1t = new A7EBIT1t();
        ebit1t.setTerminalEBIT1t(data.getB20(), revenues, ebitMargin);

        ebit1t.setEBIT1tList(ebitIncome, data.getB20(), nol,InputData.getYearOfList());

        costOfCapital.setTerminalostOfCapital(data.isB41(), data.getB42(), data.isB57(), data.getB58(), cerp.getB1(), data.getB30());


        A40ROIC roic = new A40ROIC();
        roic.setTerminaLROIC(data.isB44(), data.getB45(), costOfCapital);

        A8Reinvestment reinvestment = new A8Reinvestment();
        reinvestment.setReinvestmentList(revenues, data.getB28(), revenueGrowthRate, roic, ebit1t,InputData.getYearOfList());

        A16TerminalCashFlow terminalCashFlow = new A16TerminalCashFlow();
        terminalCashFlow.setTerminalCashFlow(ebit1t, reinvestment);


        TerminalValue terminalValue = new TerminalValue();
        terminalValue.setTerminalvalue(costOfCapital, terminalCashFlow, revenueGrowthRate);
        System.out.println(terminalValue.getTerminalvalue());


    }

}
