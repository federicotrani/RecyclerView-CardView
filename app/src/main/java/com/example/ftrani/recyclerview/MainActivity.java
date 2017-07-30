package com.example.ftrani.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvContactos.setLayoutManager(llm);

        //cargamos lista de contactos
        this.iniciarContactos();

        //definimos adaptador y los asociamos al recycler view
        this.iniciarAdaptador();

    }

    public void iniciarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        rvContactos.setAdapter(adaptador);
    }

    public void iniciarContactos(){
        contactos = new ArrayList<>();

        contactos.add(new Contacto(R.drawable.no_avatar,"Juan Perez","15446677","jperez@correo.com"));
        contactos.add(new Contacto(R.drawable.no_avatar,"Maria Dominguez","15231133","mdominguez@correo.com"));
        contactos.add(new Contacto(R.drawable.no_avatar,"Esteban Cambiaso","15009912","ecambiaso@correo.com"));
        contactos.add(new Contacto(R.drawable.no_avatar,"Sonia Escudero","15563399","sescudero@correo.com"));
        contactos.add(new Contacto(R.drawable.no_avatar,"Juan Perez","15446677","jperez@correo.com"));
        contactos.add(new Contacto(R.drawable.no_avatar,"Maria Dominguez","15231133","mdominguez@correo.com"));
        contactos.add(new Contacto(R.drawable.no_avatar,"Esteban Cambiaso","15009912","ecambiaso@correo.com"));
        contactos.add(new Contacto(R.drawable.no_avatar,"Sonia Escudero","15563399","sescudero@correo.com"));

    }
}
