package com.example.labservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ServicoTest extends Service {

    public List<Worker> threads = new ArrayList<>();


    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.i("Script", "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.i("Script", "onStartCommand()");

        // No caso a thread separada é quem vai ficar rodando
        Worker w = new Worker(startId);
        w.start();
        threads.add(w);

        return(super.onStartCommand(intent, flags, startId));
        // START_NOT_STICKY
        // START_STICKY
        // START_REDELIVER_INTENT
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

        for(int i = 0, tam = threads.size(); i < tam; i++){
            threads.get(i).ativo = false;
        }
    }

    /**
     * Classe que executa a tarefa dentro de uma thread separada
     */
    class Worker extends Thread{
        public int count = 0;
        public int startId;
        public boolean ativo = true;

        public Worker(int startId){
            this.startId = startId;
        }

        public void run(){
            while(ativo){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                count++;
                Log.i("Script", "COUNT: "+count);
            }
            stopSelf(startId);
        }
    }

}
