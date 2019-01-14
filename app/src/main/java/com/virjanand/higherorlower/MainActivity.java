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

        String message;
        if (guessedNumber > randomNr) {
            message = "Lower";
        } else if (guessedNumber < randomNr) {
            message = "Higher";
        } else {
            message = "You got it!";
            randomNr = getRandomNr();
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
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
