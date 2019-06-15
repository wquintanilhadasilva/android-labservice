package com.example.labservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View view){
        Intent it = new Intent( this,ServicoTest.class); // "SERVICO_TEST"
        it.putExtra("aas", "sdvsd");
        startService(it);
    }

    public void stopService(View view){
        Intent it = new Intent(this, ServicoTest.class); //"SERVICO_TEST"
        stopService(it);
    }

}
