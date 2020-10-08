package com.example.trabalhonum;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;
import java.math.*;

public class MainActivity extends AppCompatActivity {


    EditText txtNum;
    Button btnEx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum = findViewById(R.id.txtNum);
        btnEx = findViewById(R.id.btnEx);

        btnEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numVerification =txtNum.getText().toString();
                boolean podeCalc = true;
                String tipoNum = "";
                int numero = 0;
                if(TextUtils.isEmpty(numVerification))
                {
                    podeCalc = false;
                    txtNum.setError("Este campo é obrigatório");
                } else
                    {

                        numero = Integer.parseInt(txtNum.getText().toString());
                        if(numero%2 == 0)
                        {
                            tipoNum = "Par";
                        }
                        else
                            {
                                tipoNum = "Impar";
                            }
                    }

                if(podeCalc)
                {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Resultados");
                    dialog.setMessage("O número é: " + tipoNum.toString() + "\n" +
                            numero + " X 2 = " + (numero*2) + "\n" +
                            "Raiz Quadrada = " + (double)Math.sqrt(numero));
                    dialog.setNeutralButton("Fechar", null);
                    dialog.show();
                }

            }
        });
    }
}