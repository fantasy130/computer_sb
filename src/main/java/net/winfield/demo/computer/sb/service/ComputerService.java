package net.winfield.demo.computer.sb.service;

import org.slf4j.Logger;
import java.math.BigDecimal;

public class ComputerService {

    private final Logger logger;

    public ComputerService(Logger logger) {
        this.logger = logger;
    }

    public String plus(float a, float b) {
        return String.valueOf(a + b);
    }

    public String minus(float a, float b) {
        return String.valueOf(a - b);
    }

    public String multiple(float a, float b) {
        return String.valueOf(a * b);
    }

    public String divide(float a, float b) throws IllegalArgumentException {
        if(b == 0) {
            logger.error("The 2nd parameter can not be zero.");
            throw new IllegalArgumentException("The 2nd parameter can not be zero.");
        }
        float floatResult = a / b;
        BigDecimal bd = new BigDecimal(Float.toString(floatResult));
        return bd.setScale(1, BigDecimal.ROUND_HALF_UP).toString();
    }

    public String mod(float a, float b) {
        return String.valueOf(a % b);
    }

    public String square(float a) {
        return String.valueOf(a * a);
    }

    public String cublic(float a) {
        return String.valueOf(a * a * a);
    }

    public String power(float a, int b) {
        return String.valueOf(Math.pow(a, b));
    }
}
