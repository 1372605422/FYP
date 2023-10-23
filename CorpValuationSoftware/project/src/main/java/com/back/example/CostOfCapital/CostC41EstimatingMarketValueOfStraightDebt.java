package com.back.example.CostOfCapital;

import com.back.StaticData.InputData;


public class CostC41EstimatingMarketValueOfStraightDebt {
    public static double getEstimatingMarketValueOfStraightDebt() {
        return estimatingMarketValueOfStraightDebt;
    }

    /**
     * B19*(1-(1+B25)^(-B20))/B25+B18/(1+B25)^B20
     */
    public static void setEstimatingMarketValueOfStraightDebt() {
        double costB18BookValueOfStraightDebt = InputData.getB12();
        double costB19InterestExpenseOnDebt = InputData.getB10();
        double costB25preTexCostOfDebt = CostB25PreTaxCostOfDebt.getPreTaxCostOfDebt();
        double costB20AverageMaturity = InputForCapital.getB20AverageMaturity();
        estimatingMarketValueOfStraightDebt = costB19InterestExpenseOnDebt * (1 - Math.pow(1+costB25preTexCostOfDebt, -costB20AverageMaturity))/costB25preTexCostOfDebt + costB18BookValueOfStraightDebt/Math.pow((1+costB25preTexCostOfDebt),costB20AverageMaturity);
    }

    static double estimatingMarketValueOfStraightDebt;

}
