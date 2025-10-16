package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    String expression;
    List<Character> separators;
    int result;

    public Calculator(String expression) {
        this.expression = expression;
        separators = new ArrayList<>();
        separators.add(';');
        separators.add('.');
    }

    public void calculate() {

        if (isCustomExpression()){
            separators.clear();
            separators.add(getCustomExpression());
        }

        System.out.println(separators);

        result = 30;
    }

    public boolean isCustomExpression(){
        return !expression.startsWith("/^[0-9]*$");
    }

    public char getCustomExpression(){

        if (expression.charAt(0) != '/' || expression.charAt(1) != '/' || expression.charAt(3) != '\\' || expression.charAt(4) != 'n'){
            throw new IllegalArgumentException("올바른 커스텀 문자열 형식이 아닙니다.");
        }
        return expression.charAt(2);
    }
}
