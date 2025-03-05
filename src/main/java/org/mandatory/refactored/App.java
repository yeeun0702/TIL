package org.mandatory.refactored;

import org.mandatory.refactored.controller.CalculatorController;
import org.mandatory.refactored.model.Calculator;
import org.mandatory.refactored.view.InputView;
import org.mandatory.refactored.view.OutputView;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CalculatorController calculatorController = new CalculatorController(calculator, inputView, outputView);
        calculatorController.executeCalculator();
    }

}
