package com.virjanand.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random;
    int randomNr;

    public void clickGuess(View view) {
        int guessedNumber = Integer.
                parseInt(((EditText) findViewById(R.id.guessedNumberEditText))
                        .getText()
                        .toString());

        if (guessedNumber > randomNr) {
            Toast.makeText(this, "Lower", Toast.LENGTH_SHORT).show();
        } else if (guessedNumber < randomNr) {
            Toast.makeText(this, "Higher", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You won!", Toast.LENGTH_SHORT).show();
            randomNr = getRandomNr();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = new Random();
        randomNr = getRandomNr();
    }

    private int getRandomNr() {
        return random.nextInt(20) + 1;
    }
}
