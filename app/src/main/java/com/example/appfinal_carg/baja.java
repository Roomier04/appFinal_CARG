package com.example.appfinal_carg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class baja extends AppCompatActivity {

    public EditText etNumeroAL, etNombreAL, etApellidosAL, etPuestoAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baja);

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

    public void regresar(View view){
        Intent intent1 = new Intent(view.getContext(),Menu.class);
        startActivityForResult(intent1,0);
    }

    public void eliminarProducto(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();//objetos de base de datos  reescribible

        //se asigna variable para busqueda por campo distitivo caodigo producto
        String codigoBaja = etNumeroAL.getText().toString();
        //Se genera instrtuccion SQL para que se elimine el registro de producto
        int c = bd.delete("empleado","num="+codigoBaja,null);
        if(c==1){
            Toast.makeText(this,"Registro eliminado de BD exitoso\nVerifica Consulta",Toast.LENGTH_LONG).show();
            //Limpia cajas de texto
            this.etNumeroAL.setText("");
            this.etNombreAL.setText("");
            this.etApellidosAL.setText("");
            this.etPuestoAL.setText("");
        }else{
            Toast.makeText(this,"Error\nNo existe Articulo con ese codigo",Toast.LENGTH_LONG).show();
        }

    }//termina metodo para eliminar producto
}