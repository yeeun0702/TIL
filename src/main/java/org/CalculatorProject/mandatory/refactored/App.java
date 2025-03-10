package org.CalculatorProject.mandatory.refactored;

import org.CalculatorProject.mandatory.refactored.controller.CalculatorController;
import org.CalculatorProject.mandatory.refactored.model.Calculator;
import org.CalculatorProject.mandatory.refactored.view.InputView;
import org.CalculatorProject.mandatory.refactored.view.OutputView;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CalculatorController calculatorController = new CalculatorController(calculator, inputView, outputView);
        calculatorController.executeCalculator();
    }

}
