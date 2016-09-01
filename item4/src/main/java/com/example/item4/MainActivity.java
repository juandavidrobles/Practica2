package com.example.item4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText eLogin, ePassword, ePassword2, eCorreo;
    TextView eMLogin, eMPassword, eMPassword2, eMCorreo;
    DatePicker dFecha;
    Spinner ciudad;
    CheckBox cBailar, cTocarinstrumento, cJugar, cEjercitarse;
    String sexo="", stringCiudad;
    TextView eMFecha, eMSexo, eMciudad, eMHobbies;
    Button bAceptar;
    boolean vacio, passwordEquals, bBailar=false, bEjercitarse=false, bJugar=false, bTocar=false;


    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ciudad = (Spinner) findViewById(R.id.sCiudad);

        adapter=ArrayAdapter.createFromResource(this,R.array.Ciudad,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ciudad.setAdapter(adapter);

        ciudad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                stringCiudad=parent.getItemAtPosition(position)+"";
                //Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+"selected",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bAceptar=(Button) findViewById(R.id.bAceptar);

        eLogin=(EditText) findViewById(R.id.eLogin);
        ePassword=(EditText) findViewById(R.id.ePassword);
        ePassword2=(EditText) findViewById(R.id.ePassword2);
        eCorreo=(EditText) findViewById(R.id.eCorreo);

        eMLogin=(TextView) findViewById(R.id.eMLogin);
        eMPassword=(TextView) findViewById(R.id.eMPassword);
        eMPassword2=(TextView) findViewById(R.id.eMPassword2);
        eMCorreo=(TextView) findViewById(R.id.eMCorreo);

        dFecha=(DatePicker) findViewById(R.id.dFecha);

        eMFecha=(TextView) findViewById(R.id.eMFecha);

        eMSexo=(TextView) findViewById(R.id.eMSexo);

        eMciudad=(TextView) findViewById((R.id.eMCiudad));

        eMHobbies=(TextView) findViewById(R.id.eMHobbies);

        cBailar=(CheckBox) findViewById(R.id.cBailar);
        cEjercitarse=(CheckBox) findViewById(R.id.cEjercitarse);
        cTocarinstrumento=(CheckBox) findViewById(R.id.cTocarinstrumento);
        cJugar=(CheckBox) findViewById(R.id.cJugar);




        bAceptar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                eMLogin.setText("");
                eMPassword.setText("");
                eMPassword2.setText("");
                eMCorreo.setText("");
                eMFecha.setText("");
                eMSexo.setText("");
                eMHobbies.setText("");
                eMciudad.setText("");

                vacio=TextUtils.isEmpty(eLogin.getText().toString())||
                        TextUtils.isEmpty(ePassword.getText().toString())||
                        TextUtils.isEmpty(ePassword2.getText().toString())||
                        TextUtils.isEmpty(eCorreo.getText().toString())||
                        TextUtils.isEmpty(sexo);

                /*if (vacio==true){
                    Toast.makeText(getBaseContext(),"Vacio is True",Toast.LENGTH_LONG).show();

                }*/

                passwordEquals=ePassword.getText().toString().equals(ePassword2.getText().toString());

                if (passwordEquals==false){
                    Toast.makeText(getBaseContext(),"Contraseñas no concuerdan",Toast.LENGTH_LONG).show();
                }



                if(TextUtils.isEmpty(eLogin.getText().toString())){
                    eLogin.setError("Campo no puede quedar vacio");
                }
                if(TextUtils.isEmpty(ePassword.getText().toString())){
                    ePassword.setError("Campo no puede quedar vacio");
                }
                if(TextUtils.isEmpty(ePassword2.getText().toString())){
                    ePassword2.setError("Campo no puede quedar vacio");
                }
                if(TextUtils.isEmpty(eCorreo.getText().toString())){
                    eCorreo.setError("Campo no puede quedar vacio");
                }

                if (sexo.equals("")){
                    Toast.makeText(getBaseContext(),"Ingrese su Sexo",Toast.LENGTH_LONG).show();
                }



                if ((vacio==false)&&(passwordEquals==true)){
                    eMLogin.setText(eLogin.getText().toString());
                    eMPassword.setText(ePassword.getText().toString());
                    eMPassword2.setText(ePassword2.getText().toString());
                    eMCorreo.setText(eCorreo.getText().toString());

                    eMSexo.setText(sexo);

                    eMFecha.setText(Integer.toString(dFecha.getDayOfMonth())+"/" +
                            (Integer.toString(dFecha.getMonth()+1))+"/" +
                            Integer.toString(dFecha.getYear()));

                    eMciudad.setText(ciudad.getContentDescription());

                    eMciudad.setText(stringCiudad);

                    eMHobbies.setText("");

                    if (bBailar){
                        eMHobbies.setText("Bailar\n");
                    }
                    if (bTocar){
                        eMHobbies.setText(eMHobbies.getText().toString()+"Tocar instrumento\n");
                    }
                    if (bEjercitarse){
                        eMHobbies.setText(eMHobbies.getText().toString()+"Ejercitarse\n");
                    }
                    if (bJugar){
                        eMHobbies.setText(eMHobbies.getText().toString()+"Jugar videojuegos\n");
                    }
                    if ((bBailar||bEjercitarse||bJugar||bTocar)==false){
                        eMHobbies.setText("Ninguno");
                    }
                }


            }
        });

    }

    public void click(View view){
        switch(view.getId()){
            case R.id.rMasculino:
                sexo="Masculino";
                break;
            case R.id.rFemenino:
                sexo="Femenino";
                break;
        }
    }

    public void checkboxClick(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.cBailar:
                if(checked){
                    bBailar=true;
                }else{
                    bBailar=false;
                }
                break;
            case R.id.cEjercitarse:
                if(checked){
                    bEjercitarse=true;
                }else{
                    bEjercitarse=false;
                }
                break;
            case R.id.cJugar:
                if(checked){
                    bJugar=true;
                }else{
                    bJugar=false;
                }
                break;
            case R.id.cTocarinstrumento:
                if(checked){
                    bTocar=true;
                }else {
                    bTocar=false;
                }
                break;
        }
    }

}
