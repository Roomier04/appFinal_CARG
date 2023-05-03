package com.example.appfinal_carg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button btnEntrar;
    public EditText etUsuario,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEntrar=findViewById(R.id.btnEntrar);
        etUsuario=findViewById(R.id.etUsuario);
        etPassword=findViewById(R.id.etPassword);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etUsuario.getText().toString().equals("admin") && etPassword.getText().toString().equals("udl123")){//condicion si se cumple es decir es verdadera
                    Intent intent1 = new Intent(view.getContext(),Menu.class);
                    startActivityForResult(intent1,0);
                }else{//condicion falsa
                    Toast.makeText(MainActivity.this,"Usuario y/o Contraseña incorrectos\nVerifica!!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}