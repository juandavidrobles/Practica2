package com.example.item3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static java.lang.Math.*;

public class MainActivity extends AppCompatActivity {
    EditText eOp1, eOp2, eResultado;
    Button bCalcular;
    RadioButton rCirculo, rTriangulo, rCuadrado, rRectangulo;
    RadioGroup rGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        eOp1=(EditText) findViewById(R.id.eOp1);
        eOp2=(EditText) findViewById(R.id.eOp2);
        eResultado=(EditText) findViewById(R.id.eResultado);

        bCalcular=(Button) findViewById(R.id.bCalcular);

        rCirculo=(RadioButton) findViewById(R.id.rCirculo);
        rTriangulo=(RadioButton) findViewById(R.id.rTriangulo);
        rCuadrado=(RadioButton) findViewById(R.id.rCuadrado);
        rRectangulo=(RadioButton) findViewById(R.id.rRectangulo);

        bCalcular.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                float op1=0, op2=0;
                double resultado=0;
                op1=Float.parseFloat(eOp1.getText().toString());
                if (rCirculo.isChecked()){
                    resultado= PI*op1*op1;
                    eResultado.setText(Double.toString(resultado));
                }
                if (rTriangulo.isChecked()){
                    op2=Float.parseFloat(eOp2.getText().toString());
                    resultado=(op1*op2)/2;
                    eResultado.setText(Double.toString(resultado));
                }
                if (rCuadrado.isChecked()){
                    resultado=op1*op1;
                    eResultado.setText(Double.toString(resultado));
                }
                if (rRectangulo.isChecked()){
                    op2=Float.parseFloat(eOp2.getText().toString());
                    resultado=op1*op2;
                    eResultado.setText(Double.toString(resultado));
                }
            }
        });
    }

    public void click(View view){

        switch(view.getId()){
            case R.id.rCirculo:
                eOp1.setHint("Radio");
                eOp2.setVisibility(View.INVISIBLE);
                break;
            case R.id.rTriangulo:
                eOp1.setHint("Base");
                eOp2.setVisibility(View.VISIBLE);
                eOp2.setHint("Altura");
                break;
            case R.id.rCuadrado:
                eOp1.setHint("Lado");
                eOp2.setVisibility(View.INVISIBLE);
                break;
            case R.id.rRectangulo:
                eOp1.setHint("Lado 1");
                eOp2.setVisibility(View.VISIBLE);
                eOp2.setHint("Lado 2");
                break;
        }
    }
}