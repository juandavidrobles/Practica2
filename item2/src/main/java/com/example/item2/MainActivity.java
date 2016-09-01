package com.example.item2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText eOp1, eOp2, eResultado;
    Button bCalcular;
    RadioButton rSuma, rResta, rMultiplicacion, rDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eOp1=(EditText) findViewById(R.id.eOp1);
        eOp2=(EditText) findViewById(R.id.eOp2);
        eResultado=(EditText) findViewById(R.id.eResultado);

        bCalcular=(Button) findViewById(R.id.bCalcular);

        rSuma=(RadioButton) findViewById((R.id.rSuma));
        rResta=(RadioButton) findViewById(R.id.rResta);
        rMultiplicacion=(RadioButton) findViewById(R.id.rMultiplicacion);
        rDivision=(RadioButton) findViewById(R.id.rDivision);

        bCalcular.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                float op1, op2, resultado=0;
                op1=Float.parseFloat(eOp1.getText().toString());
                op2=Float.parseFloat(eOp2.getText().toString());

                if (rSuma.isChecked()){
                    resultado=op1+op2;
                    eResultado.setText(Float.toString(resultado));
                }
                if (rResta.isChecked()){
                    resultado=op1-op2;
                    eResultado.setText(Float.toString(resultado));
                }
                if (rMultiplicacion.isChecked()){
                    resultado=op1*op2;
                    eResultado.setText(Float.toString(resultado));
                }
                if (rDivision.isChecked()){
                    if (op2!=0){
                        resultado=op1/op2;
                        eResultado.setText(Float.toString(resultado));
                    }else{
                        eResultado.setText("Error");
                    }

                }



            }
        });

    }
}
