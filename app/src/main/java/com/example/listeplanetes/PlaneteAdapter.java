package com.example.listeplanetes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaneteAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<String> planetes;

    PlaneteAdapter(ArrayList<String> planetes, Context context){
        this.planetes=planetes;
        this.context= context;
    }




    @Override
    public int getCount() {
        return planetes.size();
    }

    @Override
    public Object getItem(int arg0) {
        return planetes.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)    this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem,null);

        }
        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);



        nomPlanete.setText(planetes.get(position));

        //  installer l'adaptateur pour la liste déroulante (spinner)
        Data data= new Data();
        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(this.context, android.R.layout.simple_spinner_item, data.taillePlanetes);
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox checkBox = (CheckBox) compoundButton.findViewById(R.id.checkbox);

                spinner.setEnabled(!checkBox.isChecked());
                spinadapter.notifyDataSetChanged();

                ViewGroup listview= (ViewGroup) checkBox.getParent().getParent();

                boolean allChecked=true;


                for (int i=0; i<9;i++){
                    ViewGroup x= (ViewGroup) listview.getChildAt(i);
                    CheckBox c =  x.findViewById(R.id.checkbox);
                    if (!c.isChecked()){
                        allChecked= false;
                        break;
                    }
                }

                if (allChecked){
                    ViewGroup root = (ViewGroup) checkBox.getParent().getParent().getParent();
                    Button btnVerifier= root.findViewById(R.id.btnVerifier);
                    btnVerifier.setEnabled(true);
                    Toast.makeText(context,"checked "+ allChecked, Toast.LENGTH_SHORT).show();
                }





            }
        });
        return itemView;

    }

}