package calculator;

public class CalculatorController {

    private final CalculatorView calculatorView;

    public CalculatorController(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
    }

    public void run() {
        String expression = calculatorView.input();
        Calculator calculator = new Calculator(expression);
        try {
            calculator.calculate();
            calculatorView.output(calculator.result);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
