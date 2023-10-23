package com.back.example.InputSheet;

public class MarketNumbers {


/*    public MarketNumbers(double riskfree_rate_A30, double initial_cost_of_capital_A31) {
        Riskfree_rate_A30 = riskfree_rate_A30;
        Initial_cost_of_capital_A31 = initial_cost_of_capital_A31;
    }*/

    public double getRiskfree_rate_A30() {
        return Riskfree_rate_A30;
    }

    public void setRiskfree_rate_A30(double riskfree_rate_A30) {
        Riskfree_rate_A30 = riskfree_rate_A30;
    }

    public double getInitial_cost_of_capital_A31() {
        return Initial_cost_of_capital_A31;
    }

    public void setInitial_cost_of_capital_A31(double initial_cost_of_capital_A31) {
        Initial_cost_of_capital_A31 = initial_cost_of_capital_A31;
    }

    private double Riskfree_rate_A30;
    private double Initial_cost_of_capital_A31;



}
