package com.example.appfinal_carg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class altaConsulta extends AppCompatActivity {

    public EditText etNumeroAL, etNombreAL, etPuestoAL, etApellidoAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_consulta);

        etNumeroAL = findViewById(R.id.etNumeroAL);
        etNombreAL = findViewById(R.id.etNombreAL);
        etApellidoAL = findViewById(R.id.etPuestoAL);
        etPuestoAL = findViewById(R.id.etDiasAL);
    }

    public void altaEmpleado(View view){
        //par abrir programa BOSqlite y generar la base de datos llamada administracion
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase(); //para que la BD sea reescribible (CRUD)
        //Guardar los valores en la variable del formulario
        String Numero = etNumeroAL.getText().toString();
        String Nombre = etNombreAL.getText().toString();
        String Apellido = etApellidoAL.getText().toString();
        String Puesto = etPuestoAL.getText().toString();

        //Para guardar datos en la tabla articulo utilizando un contenedor en valores de varibales
        ContentValues registro = new ContentValues();
        registro.put("num",Numero);
        registro.put("nom",Nombre);
        registro.put("pues",Apellido);
        registro.put("dias",Puesto);

        bd.insert("empleado",null,registro);
        etNumeroAL.setText(null);
        etNombreAL.setText(null);
        etApellidoAL.setText(null);
        etPuestoAL.setText(null);

        //confirmar que se dio de alta
        Toast.makeText(this,"Exito al ingresar los datos",Toast.LENGTH_LONG).show();
    }

    public void regresar(View view){
        Intent intent1 = new Intent(view.getContext(),Menu.class);
        startActivityForResult(intent1,0);
    }
}