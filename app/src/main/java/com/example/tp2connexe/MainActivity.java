package com.example.tp2connexe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    Button btn0 = null;
    Button btn1 = null;
    Button btn2 =null;
    Button btn3 = null;
    Button btn4 = null;
    Button btn5= null;
    Button btn6 = null;
    Button btn7 = null;
    Button btn8 = null;
    Button btn9 = null;
    Button btnEgal = null;
    Button btnPlus = null;
    Button btnMoins = null;
    Button btnMulti = null;
    Button btnDiv = null;
    Button btnNeg = null;
    Button btnEff = null;
    Button btnM = null;
    Button btnMR = null;
    Button btnPoint =null;
    EditText ecran= null;


    private boolean update =false;
    private double c;
    private boolean clicOperateur=false;
    private String operateur ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDiv = findViewById(R.id.btnDiv);
        btnEff = findViewById(R.id.btnEff);
        btnEgal = findViewById(R.id.btnEgal);
        btnPlus = findViewById(R.id.btnPlus);
        btnPoint = findViewById(R.id.btnPoint);
        btnNeg = findViewById(R.id.btnNeg);
        btnMoins = findViewById(R.id.btnMoins);
        btnMulti = findViewById(R.id.btnMulti);
        btnM = findViewById(R.id.btnM);
        btnMR = findViewById(R.id.btnMR);

        ecran = findViewById(R.id.ecran);

        btn1.setOnClickListener(unListener);
        btn2.setOnClickListener(deuxListener);
        btn3.setOnClickListener(troisListener);
        btn4.setOnClickListener(quatreListener);
        btn5.setOnClickListener(cinqListener);
        btn6.setOnClickListener(sixListener);
        btn7.setOnClickListener(septListener);
        btn8.setOnClickListener(huitListener);
        btn9.setOnClickListener(neufListener);
        btnEgal.setOnClickListener(egalListener);
        btnPlus.setOnClickListener(plusListener);
        btnMoins.setOnClickListener(moinsListener);
        btnDiv.setOnClickListener(divListener);
        btnMulti.setOnClickListener(multiListener);
        btnNeg.setOnClickListener(negListener);
        btnEff.setOnClickListener(effListener);
        btnM.setOnClickListener(mListener);
        btnMR.setOnClickListener(mrListener);
        btnPoint.setOnClickListener(pointListener);




    }

    View.OnClickListener unListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            chiffreClick("1");
        }
    };

    View.OnClickListener deuxListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                chiffreClick("2");
        }
    };

    View.OnClickListener troisListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            chiffreClick("3");

        }
    };View.OnClickListener quatreListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            chiffreClick("4");
        }
    };View.OnClickListener cinqListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            chiffreClick("5");

        }
    };
    View.OnClickListener sixListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            chiffreClick("6");
        }
    };
    View.OnClickListener septListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            chiffreClick("7");
        }
    };
    View.OnClickListener huitListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            chiffreClick("8");
        }
    };
    View.OnClickListener neufListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            chiffreClick("9");
        }
    };
    View.OnClickListener egalListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            egalClick();
        }
    };
    View.OnClickListener effListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            effClick();
        }
    };
    View.OnClickListener plusListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            plusClick();

        }
    };
    View.OnClickListener moinsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            moinsClick();

        }
    };
    View.OnClickListener multiListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mulClick();

        }
    };
    View.OnClickListener divListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            divClick();

        }
    };

    View.OnClickListener negListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            negClick();
        }
    };
    View.OnClickListener pointListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            chiffreClick(".");

        }
    };
    View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    View.OnClickListener mrListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    public void chiffreClick(String str) {
        if(update){
            update = false;
        }else{
            if(!ecran.getText().equals("0")) {
                str = ecran.getText() + str;
            }
        }
        ecran.setText(str);
    }


    public void plusClick(){

        if(clicOperateur){
            calcul();
            ecran.setText(valueOf(c));
        }else{
            c = Double.valueOf(ecran.getText().toString());
            clicOperateur = true;
        }
        operateur = "+";
        update = true;
    }

    //voici la méthode qui est  exécutée lorsqu'on clique sur le bouton -
    public void moinsClick(){
        if(clicOperateur){
            calcul();
            ecran.setText(valueOf(c));
        }else{
            c = Double.valueOf(ecran.getText().toString());
            clicOperateur = true;
        }
        operateur = "-";
        update = true;
    }

    //voici la méthode qui est  exécutée lorsqu'on clique sur le bouton *
    public void mulClick(){
        if(clicOperateur){
            calcul();
            ecran.setText(valueOf(c));
        }else{
            c = Double.valueOf(ecran.getText().toString());
            clicOperateur = true;
        }
        operateur = "*";
        update = true;
    }

    //voici la méthode qui est  exécutée lorsqu'on clique sur le bouton /
    public void divClick(){
        if(clicOperateur){
            calcul();
            ecran.setText(valueOf(c));
        }else{
            c = Double.valueOf(ecran.getText().toString());
            clicOperateur = true;
        }
        operateur = "/";
        update = true;
    }

    //voici la méthode qui est  exécutée lorsqu'on clique sur le bouton =
    public void egalClick(){
        calcul();
        update = true;
        clicOperateur = false;
    }

    //voici la méthode qui est  exécutée lorsque l'on clique sur le bouton C
    public void resetClick(){
        clicOperateur = false;
        update = true;
        c = 0;
        operateur = "";
        ecran.setText("");
    }

    private void negClick() {


    }

    private void effClick() {

        clicOperateur = false;
        update = true;
        c = 0;
        operateur = "";
        ecran.setText("");


    }




    //Voici la méthode qui fait le calcul qui a été demandé par l'utilisateur
    private void calcul(){
        if(operateur.equals("+")){
            c = c + Double.valueOf(ecran.getText().toString());
            ecran.setText(valueOf(c));
        }

        if(operateur.equals("-")){
            c = c - Double.valueOf(ecran.getText().toString());
            ecran.setText(valueOf(c));
        }

        if(operateur.equals("*")){
            c = c * Double.valueOf(ecran.getText().toString());
            ecran.setText(valueOf(c));
        }

        if(operateur.equals("/")){
            try{
                c = c / Double.valueOf(ecran.getText().toString());
                ecran.setText(valueOf(c));
            }catch(ArithmeticException e){
                ecran.setText("0");
            }
        }
    }



}
