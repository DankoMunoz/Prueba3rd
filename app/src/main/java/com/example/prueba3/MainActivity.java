package com.example.prueba3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_resultado,btn_votar;
    RadioButton rd_nulo,rd_boric,rd_kast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_resultado=(Button) findViewById(R.id.btn_resultados);
        btn_votar=(Button) findViewById(R.id.btn_votar);
        rd_nulo=(RadioButton) findViewById(R.id.rd_nulo);
        rd_boric=(RadioButton) findViewById(R.id.rd_boric);
        rd_kast=(RadioButton) findViewById(R.id.rd_kast);


        btn_votar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rd_nulo.isChecked()){
                    SQLiteDatabase db;
                    DBhelper conn= new DBhelper(getApplicationContext());
                    db=conn.getReadableDatabase();
                    ContentValues cv= new ContentValues();
                    cv.put("id_pais",rd_nulo.getText().toString());
                }
                Intent I= new Intent(getApplicationContext(),Contador.class);
                startActivity(I);
                Toast.makeText(getApplicationContext(),"Registro Insertado",Toast.LENGTH_SHORT).show();
            }
        });
        btn_resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent I= new Intent(getApplicationContext(),Contador.class);
                startActivity(I);


            }
        });


    }
}