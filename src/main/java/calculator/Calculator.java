package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    String expression;
    Character separators;
    int result;

    public Calculator(String expression) {
        this.expression = expression;
        result = 0;
        separators = ',';
    }

    public void calculate() {

        String[] number;

        if (isCustomExpression()){
            separators = getCustomExpression();
            expression = expression.substring(5);
        }

        expression = expression.replace(separators, ',');
        expression = expression.replace(';', ',');

        number = expression.split(",");

        System.out.println(Arrays.toString(number));

        System.out.println(separators);

        for(String a : number){
            result += Integer.parseInt(a);
        }
    }

    public boolean isCustomExpression(){
        return !expression.matches("^[0-9].*");
    }

    public char getCustomExpression(){
        if (expression.charAt(0) != '/' || expression.charAt(1) != '/' || expression.charAt(3) != '\\' || expression.charAt(4) != 'n'){
            throw new IllegalArgumentException("올바른 커스텀 문자열 형식이 아닙니다.");
        }
        return expression.charAt(2);
    }
}
