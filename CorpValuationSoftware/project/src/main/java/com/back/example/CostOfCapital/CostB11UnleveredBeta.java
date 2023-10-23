package com.back.example.CostOfCapital;


import java.util.Objects;

/**
 * B11 in Cost of capital worksheet:
 * Unlevered Beta
 */
public class CostB11UnleveredBeta {
    public static double getUnLeveredBeta() {
        return unLeveredBeta;
    }

    /**
     *
     * Different types of data approaching:
     * <p>2. Single Business(US)</p>
     * <p>3. Single Business(Global)</p>
     * <p>4. Multibusiness(US)</p>
     * <p>5. Multibusiness(Global)</p>
     */
    public static void setUnLeveredBeta() {
        String type = InputForCapital.getB9ApproachForEstimatingBeta();
        if(Objects.equals(type, "Single Business(US)")){
            unLeveredBeta = InputForCapital.getSingleUSBeta();
        } else if (Objects.equals(type, "Single Business(Global)")) {
            unLeveredBeta = InputForCapital.getSingleGlobalBeta();
        } else if (Objects.equals(type, "Multibusiness(US)")) {
            unLeveredBeta = InputForCapital.getK48MultiUSBeta();
        } else if (Objects.equals(type, "Multibusiness(Global)")) {
            unLeveredBeta = InputForCapital.getK64MultiGlobalBeta();
        }
    }

    static double unLeveredBeta;

}
