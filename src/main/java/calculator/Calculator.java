package calculator;

import java.util.regex.Pattern;

public class Calculator {
    private String expression;
    private Character separator;
    private int result;
    private String[] numbers;

    public Calculator(String expression) {
        this.expression = expression;
        result = 0;
        separator = ',';
    }

    public int calculate() {
        if (expression.isEmpty()) {
            return 0;
        }

        expression = expression.replace(':', ',');

        if (existCustomExpression()) {
            separator = getCustomExpression();
            expression = expression.substring(5);
        }

        numbers = expression.split(Pattern.quote(String.valueOf(separator)));

        validateSeparators();
        validateExpressionStartAndEndWithNumber();
        validateSeparatorFollowedByNumber();

        for (String number : numbers) {
            result += Integer.parseInt(number);
        }

        return result;
    }

    private void validateExpressionStartAndEndWithNumber() {
        if (!(expression.matches("^[0-9].*") && expression.matches(".*[0-9]$"))) {
            throw new IllegalArgumentException("문자열은 숫자로 시작하고 끝나야 합니다.");
        }
    }

    private boolean existCustomExpression() {
        if (expression.length() < 5) {
            return false;
        }

        return expression.contains("//") && expression.contains("\\n");
    }

    private char getCustomExpression() {
        if (expression.charAt(0) != '/' || expression.charAt(1) != '/'
                || expression.charAt(3) != '\\' || expression.charAt(4) != 'n') {
            throw new IllegalArgumentException("올바른 커스텀 문자열 형식이 아닙니다.");
        }
        return expression.charAt(2);
    }

    private void validateSeparators() {
        if (!expression.matches("^[0-9" + separator + "]+$")) {
            throw new IllegalArgumentException("구분자와 숫자 이외의 문자가 있습니다.");
        }
    }

    private void validateSeparatorFollowedByNumber() {
        for (String num : numbers) {
            if (!num.matches("^[0-9]+$")) {
                throw new IllegalArgumentException("구분자는 연속해서 등장할 수 없습니다.");
            }
        }
    }

}
