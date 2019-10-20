package fr.soninlaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    static Master master = new Master();



    private void destination(TextView[] playerGuess, String number) {
        if (playerGuess[4].getText().toString().length() != 0) {
            playerGuess[0].setText("");
            playerGuess[1].setText("");
            playerGuess[2].setText("");
            playerGuess[3].setText("");
            playerGuess[4].setText("");
        }
        if (playerGuess[0].getText().toString().length() == 0) {
            playerGuess[0].setText(number);
        }
        else if (playerGuess[1].getText().toString().length() == 0) {
            playerGuess[1].setText(number);
        }
        else if (playerGuess[2].getText().toString().length() == 0) {
            playerGuess[2].setText(number);
        }
        else if (playerGuess[3].getText().toString().length() == 0) {
            playerGuess[3].setText(number);
        }
        else {
            playerGuess[4].setText(number);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent main = getIntent();
        String name = main.getStringExtra("name");

        final TextView firstNumber = findViewById(R.id.firstNumber);
        final TextView secondNumber = findViewById(R.id.secondNumber);
        final TextView thirdNumber = findViewById(R.id.thirdNumber);
        final TextView fourthNumber = findViewById(R.id.fourthNumber);
        final TextView fifthNumber = findViewById(R.id.fifthNumber);
        final TextView[] playerGuess = {firstNumber, secondNumber, thirdNumber, fourthNumber, fifthNumber};

        final TextView goodLuck = findViewById(R.id.goodLuckText);
        goodLuck.setText("Good luck " + name + " !");

        final Button button0 = findViewById(R.id.button0);
        final Button button1 = findViewById(R.id.button1);
        final Button button2 = findViewById(R.id.button2);
        final Button button3 = findViewById(R.id.button3);
        final Button button4 = findViewById(R.id.button4);
        final Button button5 = findViewById(R.id.button5);
        final TextView answerText = findViewById(R.id.answerText);
        final TextView previousTries = findViewById(R.id.previousTries);
        final Button restartButton = findViewById(R.id.restart_button);

        fifthNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (fifthNumber.getText().toString().length() != 0) {
                    int[] answer = new int[5];
                    answer[0] = Integer.parseInt(firstNumber.getText().toString());
                    answer[1] = Integer.parseInt(secondNumber.getText().toString());
                    answer[2] = Integer.parseInt(thirdNumber.getText().toString());
                    answer[3] = Integer.parseInt(fourthNumber.getText().toString());
                    answer[4] = Integer.parseInt(fifthNumber.getText().toString());

                    String answerPrint = "";
                    for (int elt : answer) {
                        answerPrint += Integer.toString(elt);
                    }

                    answerText.setText(master.compareMind(answer));
                    previousTries.setText(answerPrint + "   -->  bon(s) : " + master.getGoodNumbers() + "  placé(s) : " + master.getPlacedNumbers() + "\n" + previousTries.getText());

                    if (master.isWin()) {
                        restartButton.setVisibility(View.VISIBLE);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destination(playerGuess,"0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destination(playerGuess,"1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destination(playerGuess,"2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destination(playerGuess,"3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destination(playerGuess,"4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destination(playerGuess,"5");
            }
        });

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartButton.setVisibility(View.GONE);
                master = new Master();
                firstNumber.setText("");
                secondNumber.setText("");
                thirdNumber.setText("");
                fourthNumber.setText("");
                fifthNumber.setText("");
                answerText.setText("Try to do better !");
                previousTries.setText("");
            }
        });
    }
}
