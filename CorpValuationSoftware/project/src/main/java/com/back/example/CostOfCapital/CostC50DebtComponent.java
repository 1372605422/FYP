package com.back.example.CostOfCapital;

import com.back.StaticData.InputData;

public class CostC50DebtComponent {
    private static double debtComponent;

    public static double getDebtComponent() {
        return debtComponent;
    }

    public static void setDebtComponent() {
        double taxRate = InputData.getB21();
        debtComponent = CostB25PreTaxCostOfDebt.getPreTaxCostOfDebt() * (1 - taxRate);
    }
}
