package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button envoyer = null;
    Button reset = null;
    EditText taille = null;
    EditText poids = null;
    CheckBox commentaire = null;
    RadioGroup group = null;
    TextView result = null;
    RadioButton meter = null;

    private final String texteInit = "Cliquez sur le bouton « Calculer l'IMC » pour obtenir un résultat.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // On récupère toutes les vues dont on a besoin
        envoyer = (Button)findViewById(R.id.calcul);
        reset = (Button)findViewById(R.id.reset);
        taille = (EditText)findViewById(R.id.taille);
        poids = (EditText)findViewById(R.id.poids);
        commentaire = (CheckBox)findViewById(R.id.commentaire);
        group = (RadioGroup)findViewById(R.id.group);
        result = (TextView)findViewById(R.id.result);
        meter = (RadioButton) findViewById(R.id.radio_metre);

        // On attribue un listener adapté aux vues qui en ont besoin

        envoyer.setOnClickListener(envoyerListener);

        reset.setOnClickListener(resetListener);

        commentaire.setOnClickListener(checkedListener);

        taille.setOnKeyListener(modifListener);
        poids.setOnKeyListener(modifListener);




    }

    View.OnClickListener envoyerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //  on récupère la taille
            String t = taille.getText().toString();
            // On récupère le poids
            String p = poids.getText().toString();
            float tValue = Float.valueOf(t);

            // Puis on vérifie que la taille est cohérente
            if (tValue <= 0)
                Toast.makeText(MainActivity.this, "La taille doit être positive", Toast.LENGTH_SHORT).show();
            else {
                float pValue = Float.valueOf(p);
                if (pValue <= 0)
                    Toast.makeText(MainActivity.this, "Le poids doit etre positif", Toast.LENGTH_SHORT).show();
                else {
                    // Si l'utilisateur a indiqué que la taille était en centimètres
                    // On vérifie que la Checkbox sélectionnée est la deuxième à l'aide de son identifiant
                    if (group.getCheckedRadioButtonId() == R.id.radio_centimetre)
                        tValue = tValue / 100;
                    float imc = pValue / (tValue * tValue);
                    String resultat = "Votre IMC est " + imc + " . ";


                    if(commentaire.isChecked()) resultat += interpreteIMC(imc);


                    result.setText(resultat);
                }
            }

        }
    };
    View.OnClickListener resetListener;

    {
        resetListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poids.getText().clear();
                taille.getText().clear();
                result.setText(texteInit);
            }
        };
    }

    View.OnClickListener checkedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(((CheckBox)v).isChecked()) {
                result.setText(texteInit);
            }
        }

    };
/**private TextWatcher textWatcher = new TextWatcher() {

@Override
public void onTextChanged(CharSequence s, int start, int before, int count) {
        result.setText(texteInit);
        }

@Override
public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

@Override
public void afterTextChanged(Editable s) {}
        };
 */

// Se lance à chaque fois qu'on appuie sur une touche en étant sur un EditText
private View.OnKeyListener modifListener = new View.OnKeyListener() {
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        String taille2 = taille.getText().toString();
        if (taille2.contains(".")){
            if (!meter.isChecked()) meter.setChecked(true);
        }
        // On remet le texte à sa valeur par défaut
        result.setText(texteInit);
        return false;
    }
};


public String interpreteIMC(float imc) {
    String interpretation;

    if (imc < 16.5) interpretation = "famine";
    else { if (imc < 18.5) interpretation = "maigreur";
        else { if (imc < 25) interpretation = "corpulence normale";
            else { if (imc < 30) interpretation = "surpoids";
                else { if (imc < 35) interpretation = "obesite moderee";
                    else { if (imc < 40) interpretation = "obesite severe";
                        else { interpretation = "obesite morbide ou massive";
                        }
                    }
                }
            }
        }
    }


    return interpretation;

}

}
