package com.back.example.CostOfCapital;

public class CostC42EstimatedValueOfStraightDebtInConvertible {
    private static double EstimatedValueOfStraightDebtInConvertible;

    public static double getEstimatedValueOfStraightDebtInConvertible() {
        return EstimatedValueOfStraightDebtInConvertible;
    }

    /**
     * B29*(1-(1+B25)^(-B30))/B25+B28/(1+B25)^B30
     *
     */
    public static void setEstimatedValueOfStraightDebtInConvertible() {
        double costB28BookValueOfConvertibleDebt = InputForCapital.getB28BookValueOfConvertibleDebt();
        double costB29InterestExpenseOnConvertible = InputForCapital.getB29InterestExpenseOnConvertible();
        double costB30MaturityOfConvertibleBond = InputForCapital.getB30MaturityOfConvertibleBond();
        double costB25preTexCostOfDebt = CostB25PreTaxCostOfDebt.getPreTaxCostOfDebt();
        EstimatedValueOfStraightDebtInConvertible = costB29InterestExpenseOnConvertible * (1 - Math.pow(1+costB25preTexCostOfDebt, -costB30MaturityOfConvertibleBond))/costB25preTexCostOfDebt + costB28BookValueOfConvertibleDebt/Math.pow((1+costB25preTexCostOfDebt),costB30MaturityOfConvertibleBond);
    }
}
