package com.example.ftrani.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Bundle extras = getIntent().getExtras();

        ImageView imgFoto = (ImageView)findViewById(R.id.imgDetalleFoto);
        TextView tvNombre = (TextView)findViewById(R.id.tvDetalleNombre);
        TextView tvTelefono = (TextView)findViewById(R.id.tvDetalleTelefono);
        TextView tvEmail = (TextView)findViewById(R.id.tvDetalleEmail);
        Button btnCerrar = (Button)findViewById(R.id.btnCerrar);

        tvNombre.setText(extras.getString("KEY_NOMBRE"));
        tvTelefono.setText(extras.getString("KEY_TELEFONO"));
        tvEmail.setText(extras.getString("KEY_EMAIL"));
        imgFoto.setImageResource(extras.getInt("KEY_FOTO"));

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
