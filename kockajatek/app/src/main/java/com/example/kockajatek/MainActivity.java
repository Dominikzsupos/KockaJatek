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
    TextView eredmeny, probal;
    Button button,ujra;

    int i = 0;
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
        probal = findViewById(R.id.probal);

        button.setOnClickListener(v -> dob());
        ujra.setOnClickListener(v -> uj());

    }

    private void dob() {

        dob1.setVisibility(View.VISIBLE);
        dob2.setVisibility(View.VISIBLE);
        probal.setVisibility(View.VISIBLE);

        Random random = new Random();
        i++;
        // dobas1
        int dobas1 = random.nextInt(6) + 1;
        dob1.setImageResource(diceImages[dobas1 - 1]);

        // dobas2
        int dobas2 = random.nextInt(6) + 1;
        dob2.setImageResource(diceImages[dobas2 - 1]);

        int osszeg = dobas1 + dobas2;
        eredmeny.setText("EREDMÉNY:   " + osszeg);
        probal.setText("Próbálkozások: "+i);
        //gameover
        if (osszeg == 7) {
            eredmeny.setText("Vége a játéknak! (7)");
            button.setEnabled(false);  // letiltja a gombot
            button.setVisibility(View.INVISIBLE);
            ujra.setVisibility(View.VISIBLE);
            ujra.setEnabled(true);
        }


    }

    private void uj(){
        eredmeny.setText("");
        button.setEnabled(true);
        ujra.setEnabled(false);
        button.setVisibility(View.VISIBLE);
        ujra.setVisibility(View.INVISIBLE);
        dob1.setVisibility(View.INVISIBLE);
        dob2.setVisibility(View.INVISIBLE);
        probal.setVisibility(View.INVISIBLE);
        i = 0;
    }

}
