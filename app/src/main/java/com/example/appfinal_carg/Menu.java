package com.example.appfinal_carg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void alta(View view){
        Intent intent1 = new Intent(view.getContext(),altaConsulta.class);
        startActivityForResult(intent1,0);
    }

    public void consulta(View view){
        Intent intent1 = new Intent(view.getContext(),consulta.class);
        startActivityForResult(intent1,0);
    }

    public void modificar(View view){
        Intent intent1 = new Intent(view.getContext(),modificar.class);
        startActivityForResult(intent1,0);
    }

    public void baja(View view){
        Intent intent1 = new Intent(view.getContext(),baja.class);
        startActivityForResult(intent1,0);
    }

}