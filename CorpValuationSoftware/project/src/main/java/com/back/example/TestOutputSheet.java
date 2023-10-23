package com.back.example;

import com.back.StaticData.*;
import com.back.example.OutputSheet.*;


public class TestOutputSheet {

    public static void main(String[] args) {

        InputData inputData = new InputData();
        CountryEquityRiskPremiums cerp = new CountryEquityRiskPremiums();
        OptionValue ov=new OptionValue();
        OperatingLeaseConverter olc = new OperatingLeaseConverter();
        RDConverter rdc = new RDConverter();

        A12CostOfCapital costOfCapital = new A12CostOfCapital();
        costOfCapital.setTerminalostOfCapital(inputData.isB41(), inputData.getB42(), inputData.isB57(), inputData.getB58(), cerp.getB1(), inputData.getB30());
        costOfCapital.setCostOfCapitalList(inputData.getB31(),InputData.getYearOfList(),InputData.getYear2_x());

        A2RevenueGrowthRate revenueGrowthRate = new A2RevenueGrowthRate();
        revenueGrowthRate.setTerminalRevenue(inputData.isB60(), inputData.getB61(), inputData.isB57(), inputData.getB58(), inputData.getB30());

        revenueGrowthRate.setRevenueGrowthRateList(inputData.getB23(), inputData.getB25(), revenueGrowthRate.getTerminalRevenue(), InputData.getYearOfList(),InputData.getYear2_x());

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
        proceedsIfFirmFails.setProceedsIfFirmFails(inputData.getB49(), inputData.getB11(), inputData.getB12(), inputData.getB50(), sumOfPV);

        A24ValueOfOperatingAssets valueOfOperatingAssets=new A24ValueOfOperatingAssets();
        valueOfOperatingAssets.setValueOfOperatingAssets(sumOfPV,proceedsIfFirmFails,probabilityOfFailure);

        A25Debt debt=new A25Debt();
        debt.setDebt(inputData.isB14(), olc.getC28(), inputData.getB12());

        A26MinorityInterests minorityInterests=new A26MinorityInterests();
        minorityInterests.setMinorityInterests(inputData.getB17());

        A27Cash cash=new A27Cash();
        cash.setCash(inputData.isB63(), inputData.getB15(), inputData.getB64(), inputData.getB65(), inputData.getB21());

        A28NonOperatingAssets nonOperatingAssets=new A28NonOperatingAssets();
        nonOperatingAssets.setNonOperatingAssets(inputData.getB16());

        A29ValueOfEquity valueOfEquity=new A29ValueOfEquity();
        valueOfEquity.setValueOfEquity(valueOfOperatingAssets,debt,minorityInterests,cash,nonOperatingAssets);

        A30ValueOfOptions valueOfOptions=new A30ValueOfOptions();
        valueOfOptions.setValueOfOptions(inputData.isB33(), ov.getD27());

        A31ValueOfEquityInCommonStock valueOfEquityInCommonStock=new A31ValueOfEquityInCommonStock();
        valueOfEquityInCommonStock.setValueOfEquityInCommonStock(valueOfEquity,valueOfOptions);

        A32NumberOfShares numberOfShares=new A32NumberOfShares();
        numberOfShares.setNumberOfShares(inputData.getB18());

        A33EstimatedValueShare estimatedValueShare=new A33EstimatedValueShare();
        estimatedValueShare.setEstimatedValueShare(numberOfShares,valueOfEquityInCommonStock);

        A34Price price=new A34Price();
        price.setPrice(inputData.getB19());

        A35PriceAsOfValue priceAsOfValue=new A35PriceAsOfValue();
        priceAsOfValue.setPriceAsPercentageOfValue(price,estimatedValueShare);






        System.out.println(" 2 Revenue growth rate       \t" + revenueGrowthRate.getRevenueGrowthRateList().toString());
        System.out.println(" 3 Revenues                  \t" + revenues.getRevenuesList().toString());
        System.out.println(" 4 EBIT (Operating) margin   \t" + ebitMargin.getEBITMarginList().toString());
        System.out.println(" 5 EBIT (Operating income)   \t" + ebitIncome.getEBITIncomeList().toString());
        System.out.println(" 6 Tax rate                  \t" + taxRate.getTaxRateList().toString());
        System.out.println(" 7 EBIT(1-t)                 \t" + ebit1t.getEBIT1tList().toString());
        System.out.println(" 8 Reinvestment              \t" + reinvestment.getReinvestmentList().toString());
        System.out.println(" 9 FCFF                      \t" + fcff.getFcffList().toString());
        System.out.println("10 NOL                       \t" + nol.getNolList().toString());
        System.out.println("12 Cost of capital           \t" + costOfCapital.getCostOfCapitalList().toString());
        System.out.println("13 Cumulated discount factor \t" + cumulatedDiscountFactor.getCumulatedDFList().toString());
        System.out.println("14 PV(FCFF)                  \t" + pvfcff.getPvFcffList().toString());
        System.out.println("\n");
        System.out.println("16 Terminal cash flow        \t" + fcff.getTerminalFcff());
        System.out.println("17 Terminal cost of capital  \t" + costOfCapital.getTerminalostOfCapital());
        System.out.println("18 Terminal value            \t" + a18terminalValue.getTerminalvalue());
        System.out.println("19 PV (Terminal value)       \t" + pvTerminalValue.getpVTerminalValue());
        System.out.println("20 PV (CF over next 10 years)\t" + pvcfOver10Year.getpVCFOver10Year());
        System.out.println("21 Sum of PV                 \t" + sumOfPV.getSumOfPV());
        System.out.println("22 Probability of failure    \t" + probabilityOfFailure.getProbability_failure());
        System.out.println("23 Proceeds if firm fails    \t" + proceedsIfFirmFails.getProceedsIfFirmFails());
        System.out.println("24 Value of operating asset \t"+valueOfOperatingAssets.getValueOfOperatingAssets());
        System.out.println("25 Debt                      \t"+debt.getDebt());
        System.out.println("A26 Minority interests       \t"+minorityInterests.getMinorityInterests());
        System.out.println("A27 Cach                     \t"+cash.getCash());
        System.out.println("A28 Non-operating assets     \t"+nonOperatingAssets.getNonOperatingAssets());
        System.out.println("️A29 Value of equity         \t"+valueOfEquity.getValueOfEquity());
        System.out.println("A30 Value of options         \t"+valueOfOptions.getValueOfOptions());
        System.out.println("♦A31 Value of equity stock   \t"+valueOfEquityInCommonStock.getValueOfEquityInCommonStock());
        System.out.println("A32 Number of shares         \t"+numberOfShares.getNumberOfShares());
        System.out.println("️A33 Estimated value /share  \t"+estimatedValueShare.getEstimatedValueShare());
        System.out.println("A34 Price                    \t"+price.getPrice());
        System.out.println("️A35 Price as % of value     \t"+priceAsOfValue.getPriceAsPercentageOfValue());

        System.out.println("\n");
        System.out.println("38 Sales to capital ratio    \t" + salesToCapitalRatio.getSalesToCapitalRatioList().toString());
        System.out.println("39 Invested capital          \t" + investedCapital.getInvestedCapitalList().toString());
        System.out.println("40 ROIC                      \t" + roic.getRoicList().toString());
    }
}

