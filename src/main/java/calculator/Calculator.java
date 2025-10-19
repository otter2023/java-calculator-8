package calculator;

import java.util.Arrays;

public class Calculator {
    String expression;
    Character separator;
    int result;
    String[] number;

    public Calculator(String expression) {
        this.expression = expression;
        result = 0;
        separator = ',';
    }

    public void calculate() {

        if (expression.isEmpty()) {
            return;
        }

        expression = expression.replace(':', ',');

        if (existCustomExpression()) {
            separator = getCustomExpression();
            expression = expression.substring(5);
        }

        number = expression.split(String.valueOf(separator));

        System.out.println(Arrays.toString(number));
        System.out.println(separator);

        validateExpressionStartAndEndWithNumber();
        validateSeparators();
        validateSeparatorFollowedByNumber();

        for (String a : number) {
            result += Integer.parseInt(a);
        }
    }

    public void validateExpressionStartAndEndWithNumber() {
        if (!(expression.matches("^[0-9].*") && expression.matches(".*[0-9]$"))) {
            throw new IllegalArgumentException("문자열은 숫자로 시작하고 끝나야 합니다.");
        }
    }

    public boolean existCustomExpression() {
        return expression.contains("//") || expression.contains("\\n");
    }

    public char getCustomExpression() {
        if (expression.charAt(0) != '/' || expression.charAt(1) != '/' || expression.charAt(3) != '\\' || expression.charAt(4) != 'n') {
            throw new IllegalArgumentException("올바른 커스텀 문자열 형식이 아닙니다.");
        }
        return expression.charAt(2);
    }

    public void validateSeparators() {
        if (!expression.matches("^[0-9" + separator + "]+$")) {
            throw new IllegalArgumentException("구분자와 숫자 이외의 문자가 있습니다.");
        }
    }

    public void validateSeparatorFollowedByNumber(){
        for (String num : number) {
            if (!num.matches("^[0-9]+$")) {
                throw new IllegalArgumentException("구분자는 연속해서 등장할 수 없습니다.");
            }
        }
    }

}
