package com.danicc.sendmessage.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.danicc.sendmessage.R;
import com.danicc.sendmessage.SendMessageAplication;
import com.danicc.sendmessage.data.Message;
import com.danicc.sendmessage.databinding.ActivitySendMessageBinding;


/**
 * <h1>Proyecto SendMessage<h1/>
 * En este proyecto aprenderemos a realizar las siguientes operaciones
 * <ul>
 *     <li>Crear un evento en un  Button en codigo XML<li/>
 *     <li>Crear un Listener del evento OnClick<li/>
 *     <li>Crear un Intent y un  bundle para enviar información entre activities<li/>
 *     <li>Ciclo de vida de una activity<li/>
 *     <li>Manejar la pila de Actividades<li/>
 *     <ul/>
 *
 * @author Dani casado
 * @version 1.0
 * @see android.widget.Button
 * @see android.app.Activity
 * @see android.content.Intent
 * @see android.os.Bundle
 */
public class SendMessageActivity extends AppCompatActivity {
    private sendOnclickListener delegate;
    private static final String TAG = "SendMessageActivity";
    private ActivitySendMessageBinding binding;
    private SendMessageAplication aplicacion;
    //region Ciclo de vida activity
    //Metodo que se ejecuta cuando se crea la activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        delegate = new sendOnclickListener();
        aplicacion = (SendMessageAplication) getApplication();


        binding.setMessage(new Message(aplicacion.getUser()));

        //Se establece el listener al boton mediante una clase anonimma
        binding.btnSend.setOnClickListener(view -> sendMessage());

        Log.d(TAG, "SendMessageActivity -> onCreate()");
    }

    //metodo que ejecuta el setonclickListener del boton
    public void sendMessage() {
        //TODO se modificará este ejercicio para estudiar viewBinding y Databinding

        //1. Crear el contenedor para añadir los datos
        Bundle bundle = new Bundle();
        //1.1 Pasar campo a campo
        //bundle.putString("user", binding.getMessage().getUser().toString());
        //bundle.putString("message",binding.getMessage().getContent());

        //1.2 Pasar directamente un objeto de la clase message
        bundle.putParcelable("message", binding.getMessage());
        //2. crear el objeto intent Explicito porque se conoce la actividad
        //destino
        Intent intent = new Intent(this, ViewMessageActivity.class);
        intent.putExtras(bundle);

        //3. Inicia la transicion entre la actividad origen y destino
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessageActivity -> onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessageActivity -> onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessageActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessageActivity -> onPause()");
    }

    /**
     * Este metodo se ejecuta cuando se destruye la activity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "SendMessageActivity -> onDestroy()");
    }

    //endregion

//region menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    //este metodo se llama cuando se pulsa sobre una opcion del menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_aboutus:
                Intent intent = new Intent(this,AboutActivity.class);
                startActivity(intent);
                return true;

        }
        return true;
    }
//end region
    /**
     * Metodo llamado al pulsar sobre el boton
     *
     *
     * @param view
     */
    public void sendMessage(View view) {
        sendMessage();
    }
    /**
     * esta clase no anonima implementa el listener que responde siempre al evento OnClick
     */
    class sendOnclickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Toast.makeText(SendMessageActivity.this, "Este evento se ejecuta a traves de un delegado", Toast.LENGTH_SHORT).show();
        }
    }
}