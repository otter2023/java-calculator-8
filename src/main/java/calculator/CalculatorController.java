package calculator;

public class CalculatorController {

    private final CalculatorView calculatorView;

    public CalculatorController(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
    }

    public void run() {
        String expression = calculatorView.input();
        Calculator calculator = new Calculator(expression);
        int result = calculator.calculate();
        calculatorView.output(result);
    }
}
