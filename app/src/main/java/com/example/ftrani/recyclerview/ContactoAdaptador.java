package com.example.ftrani.recyclerview;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;

    //constructor del adaptador
    public ContactoAdaptador(ArrayList<Contacto> contactos){
        this.contactos = contactos;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflamos el layout y lo pasa al viewholder para generar los views
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
        //obtenemos item de la lista y cargamos en su view
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombre.setText(contacto.getNombre());

        //al hacer clic en un item, ejecuto activity de detalle
        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = v.getContext();

                Intent intent = new Intent(context,DetalleActivity.class);
                intent.putExtra("KEY_NOMBRE",contacto.getNombre());
                intent.putExtra("KEY_EMAIL",contacto.getEmail());
                intent.putExtra("KEY_TELEFONO",contacto.getTelefono());
                intent.putExtra("KEY_FOTO",contacto.getFoto());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        //cantidad de elementos que contiene la lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombre;

        public ContactoViewHolder(View itemView) {
            super(itemView);

            //referencia a controles del layout
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);

        }
    }
}
