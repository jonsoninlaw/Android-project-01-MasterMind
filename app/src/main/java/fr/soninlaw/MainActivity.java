package fr.soninlaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static Master master = new Master();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button startButton = findViewById(R.id.startButton);
        final EditText nameField = findViewById(R.id.nameField);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameField.getText().length() == 0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Merci d'entrer au moins un caractère !", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP| Gravity.CENTER, 0, 500);
                    toast.show();
                }
                else {
                    Intent game = new Intent(MainActivity.this, GameActivity.class);
                    game.putExtra("name", nameField.getText().toString());
                    startActivity(game);
                }
            }
        });


    }
}
