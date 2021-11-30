package com.example.prueba3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Contador extends AppCompatActivity {
    Button btn_volvermain;
    EditText blanco,nulo,boric,kast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);
        btn_volvermain=(Button) findViewById(R.id.btn_volvermain);
        blanco=(EditText) findViewById(R.id.txt_blanco);
        nulo=(EditText) findViewById(R.id.txt_nulo);
        boric=(EditText) findViewById(R.id.txt_boric);
        kast=(EditText) findViewById(R.id.txt_kast);
        Integer Votosblanco=0;
        Integer VotosNulo=0;
        Integer Votosboric=0;
        Integer Votoskast=0;

        SQLiteDatabase db;
        DBhelper conn= new DBhelper(getApplicationContext());
        db=conn.getReadableDatabase();
        Cursor c=db.query("voto",null,null,null,null,null,null);
        if(c!=null)
        {
            if(c.moveToFirst()){
                do{
                    if(c.getString(2).equals("Blanco")){
                        Votosblanco++;
                    }
                    if(c.getString(2).equals("Nulo")){
                        VotosNulo++;
                    }
                    if(c.getString(2).equals("Gabriel Boric")){
                        Votosboric++;
                    }
                    if(c.getString(2).equals("Jose Antonio Kast")){
                        Votoskast++;
                    }
                }
                while(c.moveToNext());
            }
            blanco.setText(""+Votosblanco);
            nulo.setText(""+VotosNulo);
            boric.setText(""+Votosboric);
            kast.setText(""+Votoskast);

        }
        btn_volvermain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(I);

            }
        });

    }
}