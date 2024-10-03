package com.example.educalc;

public class Calculator {

    // TODO: Add the necessary fields and methods to implement the calculator logic for multiple operations at once
    private double firstValue = 0;
    private double secondValue = 0;
    private String currentInput = "";
    private String operator = "";
    private boolean isOperatorSet = false;

    // Handle number input
    public void inputNumber(String number) {
        if (isOperatorSet) {
            currentInput = "";  // Clear current input after operator is set
            isOperatorSet = false;
        }
        currentInput += number;
    }

    // Get the current input (to be displayed in the TextView)
    public String getCurrentInput() {
        return currentInput.isEmpty() ? "0" : currentInput;
    }

    // Set the operator (e.g., +, -, *, /)
    public void setOperator(String operator) {
        if (!currentInput.isEmpty()) {
            firstValue = Double.parseDouble(currentInput);
            this.operator = operator;
            isOperatorSet = true;
        }
    }

    // Perform the calculation
    public double performCalculation() {
        if (!currentInput.isEmpty()) {
            secondValue = Double.parseDouble(currentInput);

            switch (operator) {
                case "+":
                    firstValue = add(firstValue, secondValue);
                    break;
                case "-":
                    firstValue = subtract(firstValue, secondValue);
                    break;
                case "*":
                    firstValue = multiply(firstValue, secondValue);
                    break;
                case "/":
                    if (secondValue != 0) {
                        firstValue = divide(firstValue, secondValue);
                    } else {
                        return Double.NaN;
                    }
                    break;
            }

            currentInput = String.valueOf(firstValue);
            return firstValue;
        }

        return 0;
    }

    // Clear the calculator state
    public void clear() {
        // TODO: Implement clear
        return;
    }

    // Functionality methods for each operation
    private double add(double first, double second) {
        // TODO: Implement addition
        return 0;
    }

    private double subtract(double first, double second) {
        // TODO: Implement subtraction
        return 0;
    }

    private double multiply(double first, double second) {
        // TODO: Implement multiplication
        return 0;
    }

    private double divide(double first, double second) {
        // TODO: Implement division
        return 0;
    }
}
