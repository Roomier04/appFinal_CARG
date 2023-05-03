package com.example.appfinal_carg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class consulta extends AppCompatActivity {

    public TextView tvSalidaPrecio;
    public ListView lvProductos;

    private String[] productos = {"Clash Royale", "Clash of Clans", "Hay Day", "Brawl Stars", "Boom Beach"};
    private  String[] precios = {"2016", "2012", "2012", "2018", "2014"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        //integracion de XML a JAVA
        tvSalidaPrecio=findViewById(R.id.tvSalidaPrecio);
        lvProductos=(ListView)findViewById(R.id.lvProductos);

        //adaptacion de arreglo de precios y arreglo de productos mediante un ADAPTER
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,productos);
        lvProductos.setAdapter(adapter); //integre los datos de productos en la lista
        //programacion de evento click se deterima el precio a un producto
        lvProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                tvSalidaPrecio.setText("Año de Lanzamiento: "+precios[position]);
            }
        });
    }
}