/**

 * This class is a tool class. It calculates each node of the two variables in the controller, Revenue and Cost of Capital.
 * @author [Zihao ZHANG]
 * @version [V1.0]
 * @since [2023/2/11]
 */
package com.front;

import java.util.ArrayList;

public class MyBridge {
    private double baseYear;
    private double terminalYear;

    public void setBaseYear(double baseYear) {
        this.baseYear = baseYear;
    }

    public void setTerminalYear(double terminalYear) {
        this.terminalYear = terminalYear;
    }

    public ArrayList<Double> getValue(int uptoN){
        ArrayList<Double> values = new ArrayList<>();
        double difference = (terminalYear - baseYear) / uptoN;
        double value = baseYear;
        for (int i = 0; i < uptoN; i++) {
            value += difference;
            values.add(value);
        }

        for (int i = 0; i < uptoN; i++){
            values.add(value);
        }

        return values;
    }
}
