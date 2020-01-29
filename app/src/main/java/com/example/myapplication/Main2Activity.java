package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    final String CYCLEVIEPREFS= "cycle_vie_prefs" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences settings = getSharedPreferences(CYCLEVIEPREFS, Context.MODE_PRIVATE);
       //String v= settings.getString("cle", "");

        Intent intent = getIntent();
        String v = "";
        if (intent!= null) v=intent.getStringExtra("cle");

        popUp(v);
        Log.i("Main2Activity", v);

    }

        /** =============================================================
         * Exécuté que l'activité arrêtée via un "stop" redémarre.
         *
         * La fonction onRestart() est suivie de la fonction onStart().
         */
        @Override
        protected void onRestart() {
            super.onRestart();
            popUp("onRestart()");
        }
        /** ==============================================================
         * Exécuté lorsque l'activité devient visible à l'utilisateur.
         *
         * La fonction onStart() est suivie de la fonction onResume().
         */
        @Override
        protected void onStart() {
            super.onStart();
            popUp("onStart()");
        }
        /** ==============================================================
         * Exécutée à chaque passage en premier plan de l'activité.
         * Ou bien, si l'activité passe à nouveau en premier
         * (si une autre activité était passée en premier plan entre temps).
         *
         * La fonction onResume() est suivie de l'exécution de l'activité.
         */
        @Override
        protected void onResume() {

            super.onResume();
            popUp("onResume()");
        }
        /** =============================================================
         * La fonction onPause() est suivie :
         * - d'un onResume() si l'activité passe à nouveau en premier plan
         * - d'un onStop() si elle devient invisible à l'utilisateur
         *
         * L'exécution de la fonction onPause() doit être rapide,
         * car la prochaine activité ne démarrera pas tant que l'exécution
         * de la fonction onPause() n'est pas terminée.
         */
        @Override
        protected void onPause() {

            super.onPause();
            if (isFinishing()) {
                popUp("onPause, l'utilisateur à demandé la fermeture via un finish()");
            } else {
                popUp("onPause, l'utilisateur n'a pas demandé la fermeture via un finish()");
            }

        }
        @Override
        protected void onStop() {
            super.onStop();
            popUp("onStop()");
        }
        /** =============================================================
         * Cette fonction est exécutée lorsque l'activité se termine ou bien lorsque
         * le système décide de l'arrêter.
         *
         * La fonction onCreate() devra à nouveau être exécutée pour obtenir à nouveau l'activité.
         */
        @Override
        protected void onDestroy() {
            super.onDestroy();
            popUp("onDestroy()");
        }
        //=================================================================



        public void popUp(String message) {
            Toast.makeText(this, message + " act2", Toast.LENGTH_LONG).show();
        }




    }


