package net.winfield.demo.computer.sb.service;

import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class ComputerService {

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
        if (b == 0) {

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
