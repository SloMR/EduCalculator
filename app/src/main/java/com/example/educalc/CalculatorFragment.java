package com.example.educalc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class CalculatorFragment extends Fragment {

    private TextView resultTextView;
    private Calculator calculator;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        resultTextView = view.findViewById(R.id.text_result);
        calculator = new Calculator();
        setupButtons(view);
        return view;
    }

    private void setupButtons(View view) {
        int[] numberButtonIds = {
                R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3,
                R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7,
                R.id.button_8, R.id.button_9
        };
        int[] operatorButtonIds = {
                R.id.button_add, R.id.button_subtract, R.id.button_multiply, R.id.button_divide
        };

        View.OnClickListener numberListener = v -> {
            Button button = (Button) v;
            calculator.inputNumber(button.getText().toString());
            resultTextView.setText(calculator.getCurrentInput());
        };

        View.OnClickListener operatorListener = v -> {
            Button button = (Button) v;
            calculator.setOperator(button.getText().toString());
        };

        for (int id : numberButtonIds) {
            view.findViewById(id).setOnClickListener(numberListener);
        }

        for (int id : operatorButtonIds) {
            view.findViewById(id).setOnClickListener(operatorListener);
        }

        view.findViewById(R.id.button_equals).setOnClickListener(v -> {
            double result = calculator.performCalculation();
            resultTextView.setText(String.valueOf(result));
        });

        view.findViewById(R.id.button_clear).setOnClickListener(v -> {
            // TODO: Clear the operator TextView
        });
    }
}
