package com.example.atvd_01_ex2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
/*
 *@author:<Raissa Farias>
 */
public class MainActivity extends AppCompatActivity {

    private EditText etValorA;
    private EditText etValorB;
    private EditText etValorC;
    private TextView tvResX1;
    private TextView tvResX2;
    private TextView tvResDelta;

    private TextView tvInf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.atvd_1_ex2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etValorA = findViewById(R.id.etValorA);
        etValorB = findViewById(R.id.etValorB);
        etValorC = findViewById(R.id.etValorC);
        Button btnCalc = findViewById(R.id.bntCalc);
        tvResX1 = findViewById(R.id.tvResX1);
        tvResX2 = findViewById(R.id.tvResX2);
        tvResDelta = findViewById(R.id.tvResDelta);
        tvInf = findViewById(R.id.tvInf);

        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc(){

        float ValorA = Float.parseFloat(etValorA.getText().toString());
        float ValorB = Float.parseFloat(etValorB.getText().toString());
        float ValorC = Float.parseFloat(etValorC.getText().toString());
        float Delta = (ValorB * ValorB) - (4 * ValorA * ValorC);
        String DeltaR =getString(R.string.Delta) + " " + Delta;
        tvResDelta.setText(DeltaR);



        if (Delta < 0 || ValorA == 0){

            String inf = getString(R.string.info) + " ";
            tvInf.setText(inf);

        }else{
            float x1 = (float) ((-ValorB + Math.sqrt(Delta)) / (2 * ValorA));
            float x2 = (float) ((-ValorB - Math.sqrt(Delta)) / (2 * ValorA));


            String r1 = getString(R.string.x1) + " " +x1 ;
            tvResX1.setText(r1);
            String r2 = getString(R.string.x2) + " " +x2;
            tvResX2.setText(r2);
        }

        etValorA.setText("");
        etValorB.setText("");
        etValorC.setText("");

    }
}