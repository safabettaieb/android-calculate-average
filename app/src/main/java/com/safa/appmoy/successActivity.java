package com.safa.appmoy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class successActivity extends AppCompatActivity {

    private TextView msg;
    private Button btnMesg;
    private String m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        msg = findViewById(R.id.mesg);
        btnMesg = findViewById(R.id.btnMesg);
        Intent intentSucc = getIntent();
        m = intentSucc.getStringExtra("mesg");
        msg.setText(m);

        btnMesg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,m);
                sendIntent.setType("text/plain");
                if(sendIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(sendIntent);
                }else{
                    Toast.makeText(getApplicationContext(),"l'action d'envoi n'a pas pu être effectuée",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
