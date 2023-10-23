package com.back.example.CostOfCapital;

import com.back.StaticData.InputData;

public class CostB50EquityComponent {
    private static double equityComponent;

    public static double getEquityComponent() {
        return equityComponent;
    }

    public static void setEquityComponent() {
        double B12riskFreeRate = InputData.getB30();
        double C45leveredBeta = CostC45LeveredBetaForEquity.getLeveredBetaForEquity();
        double B15ERP = CostB15ERPInEquity.getERPInEquity();
        equityComponent = B12riskFreeRate + C45leveredBeta * B15ERP;
    }
}
