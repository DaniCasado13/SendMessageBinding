package com.danicc.sendmessage.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import com.danicc.sendmessage.data.Message;

import com.danicc.sendmessage.databinding.ActivityViewMessageBinding;

/**
 * clase que muestra un mensaje de un usuario. Recoge un mensaje que implementa la interfaz Parcelable y serializable
 */
public class ViewMessageActivity extends AppCompatActivity {
    private static final String TAG = "ViewMessageActivity";
    ActivityViewMessageBinding binding;

    //region cilo de vida
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //1. Recoger el Bundle enviado en el intent de SendMessageActivity
        Bundle bundle = getIntent().getExtras();

        Message message = bundle.getParcelable("message");
        binding.setMessage(message);

        Log.d(TAG,"ViewMessageActivity -> onCreate()");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ViewMessageActivity -> onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ViewMessageActivity -> onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ViewMessageActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ViewMessageActivity -> onPause()");
    }

    /**
     * Este metodo se ejecuta cuando se destruye la activity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "ViewMessageActivity -> onDestroy()");
    }
    //endregion
}