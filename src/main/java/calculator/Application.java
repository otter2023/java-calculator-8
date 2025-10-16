package calculator;

public class Application {
    public static void main(String[] args) {
        CalculatorView calculatorView = new CalculatorView();
        CalculatorController calculatorController = new CalculatorController(calculatorView);

        calculatorController.run();
    }
}
