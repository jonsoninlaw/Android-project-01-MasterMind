package fr.soninlaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView numbersShow = findViewById(R.id.playerGuess);
        final Button button0 = findViewById(R.id.button0);
        final Button button1 = findViewById(R.id.button1);
        final Button button2 = findViewById(R.id.button2);
        final Button button3 = findViewById(R.id.button3);
        final Button button4 = findViewById(R.id.button4);
        final Button button5 = findViewById(R.id.button5);
        final TextView answerText = findViewById(R.id.answerText);
        final TextView previousTries = findViewById(R.id.previousTries);

        final Master master = new Master();

        numbersShow.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (numbersShow.getText().toString().length() == 5) {
                    int[] answer = new int[5];
                    for (int i = 0; i < 5; i++) {
                        answer[i] = Character.getNumericValue(numbersShow.getText().toString().charAt(i));
                    }
                    answerText.setText(master.compareMind(answer));
                    previousTries.setText(numbersShow.getText().toString() + "\n" + previousTries.getText());
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numbersShow.getText().toString().length() >= 5) {
                    numbersShow.setText("0");
                }
                else {
                    numbersShow.setText(numbersShow.getText().toString() + 0);
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numbersShow.getText().toString().length() >= 5) {
                    numbersShow.setText("1");
                }
                else {
                    numbersShow.setText(numbersShow.getText().toString() + 1);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numbersShow.getText().toString().length() >= 5) {
                    numbersShow.setText("2");
                }
                else {
                    numbersShow.setText(numbersShow.getText().toString() + 2);
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numbersShow.getText().toString().length() >= 5) {
                    numbersShow.setText("3");
                }
                else {
                    numbersShow.setText(numbersShow.getText().toString() + 3);
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numbersShow.getText().toString().length() >= 5) {
                    numbersShow.setText("4");
                }
                else {
                    numbersShow.setText(numbersShow.getText().toString() + 4);
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numbersShow.getText().toString().length() >= 5) {
                    numbersShow.setText("5");
                }
                else {
                    numbersShow.setText(numbersShow.getText().toString() + 5);
                }
            }
        });


    }
}
