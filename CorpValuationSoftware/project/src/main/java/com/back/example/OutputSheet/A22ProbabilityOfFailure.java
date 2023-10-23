/**

This class stores the probability of failure, which is used to calculate the adjusted present value (APV).
This class has the following public methods:
setProbability_failure(double inputB48, boolean inputB47)
This method takes in a double value which represents the probability of failure,
and a boolean value which represents if the probability of failure is overridden.
If the probability of failure is overridden, the method sets the probability_failure to the inputB48 value.
Otherwise, the probability_failure is set to 0.
getProbability_failure()
This method returns the probability of failure stored in the probability_failure variable.
*/
package com.back.example.OutputSheet;

public class A22ProbabilityOfFailure {

    public double getProbability_failure() {
        return probability_failure;
    }

    public void setProbability_failure(double inputB48, boolean inputB47) {
        //B47 = if probability of failure is overrided
        if (inputB47) {
            this.probability_failure = inputB48;
        } else {
            this.probability_failure = 0;
        }

    }
    double probability_failure;

}
