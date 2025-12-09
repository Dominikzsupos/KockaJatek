package com.example.kockajatek;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    ImageView dob1, dob2;
    TextView eredmeny;
    Button button,ujra;

    int[] diceImages = {
            R.drawable.dobo1,
            R.drawable.dobo2,
            R.drawable.dobo3,
            R.drawable.dobo4,
            R.drawable.dobo5,
            R.drawable.dobo6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        dob1 = findViewById(R.id.dob1);
        dob2 = findViewById(R.id.dob2);
        eredmeny = findViewById(R.id.eredmeny);
        button = findViewById(R.id.button);
        ujra = findViewById((R.id.ujra));

        button.setOnClickListener(v -> dob());
        ujra.setOnClickListener(v -> uj());

    }

    private void dob() {
        Random random = new Random();

        // dobas1
        int dobas1 = random.nextInt(6) + 1;
        dob1.setImageResource(diceImages[dobas1 - 1]);

        // dobas2
        int dobas2 = random.nextInt(6) + 1;
        dob2.setImageResource(diceImages[dobas2 - 1]);

        int osszeg = dobas1 + dobas2;
        eredmeny.setText("EREDMÉNY:   " + osszeg);

        //gameover
        if (osszeg == 7) {
            eredmeny.setText("Vége a játéknak! (7)");
            button.setEnabled(false);  // letiltja a gombot
            button.setVisibility(View.GONE);
            ujra.setVisibility(View.VISIBLE);

        }


    }

    private void uj(){
        eredmeny.setText("");
        button.setEnabled(true);
        button.setVisibility(View.VISIBLE);
        ujra.setVisibility(View.GONE);
    }

}
