package com.example.appfinal_carg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class modificar extends AppCompatActivity {

    public EditText etNumeroAL, etNombreAL, etApellidosAL, etPuestoAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        etNumeroAL = findViewById(R.id.etNumeroAL);
        etNombreAL = findViewById(R.id.etNombreAL);
        etApellidosAL = findViewById(R.id.etPuestoAL);
        etPuestoAL = findViewById(R.id.etDiasAL);

    }

    public void consultaProducto(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();//objetos de base de datos se reescribible

        //se asigna una variable para busqueda y consulta por campo distintivo
        String codigoConsulta = etNumeroAL.getText().toString();
        //Cursor recorre los campos de una tabla hasta encontralo por campo distintivo
        Cursor fila = bd.rawQuery("SELECT nom, pues, dias FROM empleado WHERE num="+codigoConsulta,null);

        if(fila.moveToFirst()){//si condicion es verdadera, es decir, encontro un campo y sus datos
            etNombreAL.setText(fila.getString(0));
            etApellidosAL.setText(fila.getString(1));
            etPuestoAL.setText(fila.getString(2));
            Toast.makeText(this,"Registro encontrado de forma EXITOSA",Toast.LENGTH_LONG).show();
        }else{//condicion falsa si no encontro un registro
            Toast.makeText(this,"No existe Articulo con ese Codigo\nVerifica",Toast.LENGTH_LONG).show();
            bd.close();
        }

    }//termina metodo consulta producto

    public void modificarProductos(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();//objetos de base de datos  reescribible

        //se declaran variables que vienen desde formulario sus datos
        String Numero = etNumeroAL.getText().toString();
        String Nombre = etNombreAL.getText().toString();
        String Apellido = etApellidosAL.getText().toString();
        String Puesto = etPuestoAL.getText().toString();
        //se genera un contenedor para almacenar los valores anteriores
        ContentValues registro=new ContentValues();
        registro.put("num",Numero);
        registro.put("nom",Nombre);
        registro.put("pues",Apellido);
        registro.put("dias",Puesto);
        //Se crea la variable que contine la instruccion SQL encargada de modificar y almacenar valor 1 si edito
        int cant = bd.update("empleado",registro,"num="+Numero,null);
        bd.close();
        if(cant==1) {//condicion si realizo modificacion
            Toast.makeText(this,"Registro actualizado de forma correcta",Toast.LENGTH_LONG).show();
            //Se limpian los campos de texto
            etNumeroAL.setText(null);
            etNombreAL.setText(null);
            etApellidosAL.setText(null);
            etPuestoAL.setText(null);


        }else {//contrario a no modificacion
            Toast.makeText(this,"Error\nNo se modifico registro",Toast.LENGTH_LONG).show();
        }
    } //termina metodo

    public void regresar(View view){
        Intent intent1 = new Intent(view.getContext(),Menu.class);
        startActivityForResult(intent1,0);
    }
}