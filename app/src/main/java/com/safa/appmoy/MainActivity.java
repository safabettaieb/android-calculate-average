package com.safa.appmoy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText note1;
    private EditText note2;
    private EditText note3;
    private EditText coef1;
    private EditText coef2;
    private EditText coef3;
    private Button btnCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note1 = findViewById(R.id.n1);
        note2 = findViewById(R.id.n2);
        note3 = findViewById(R.id.n3);

        coef1 = findViewById(R.id.c1);
        coef2 = findViewById(R.id.c2);
        coef3 = findViewById(R.id.c3);

        btnCal = findViewById(R.id.btnCal);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(note1.getText().toString().isEmpty())
                        && !(note2.getText().toString().isEmpty())
                        && !(note3.getText().toString().isEmpty())
                        && !(coef1.getText().toString().isEmpty())
                        && !(coef2.getText().toString().isEmpty())
                        && !(coef3.getText().toString().isEmpty())
                ) {

                    float n1 = Float.parseFloat(note1.getText().toString());

                    float n2 = Float.parseFloat(note2.getText().toString());
                    float n3 = Float.parseFloat(note3.getText().toString());

                    int c1 = Integer.parseInt(coef1.getText().toString());
                    int c2 = Integer.parseInt(coef2.getText().toString());
                    int c3 = Integer.parseInt(coef3.getText().toString());
                    float c = calMoy(n1, c1, n2, c2, n3, c3);
                    //Toast.makeText(getApplicationContext(), "la moyenne generale est : " + c, Toast.LENGTH_SHORT).show();
                    if (c >= 10) {
                        Intent succAct = new Intent(getApplicationContext(), successActivity.class);
                        succAct.putExtra("mesg","félicitation votre moyenne est :"+c);
                        startActivity(succAct);
                    } else {

                        Intent failAct = new Intent(getApplicationContext(), failActivity.class);
                        failAct.putExtra("mesg", "Désole votre moyenne est : "+c);
                        startActivity(failAct);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "remplir les notes et les coefficients", Toast.LENGTH_SHORT).show();


                }


            }
        });

    }

    private float calMoy(float n1, int c1, float n2, int c2, float n3, int c3) {
        int sumCoef = c1 + c2 + c3;
        float moy = ((n1 * c1) + (n2 * c2) + (n3 * c3)) / sumCoef;
        return moy;
    }
}
