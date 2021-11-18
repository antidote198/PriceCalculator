package com.example.pricecalculator;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag2 extends Fragment {

    private EditText frag2EditText1;
    private EditText frag2EditText2;
    private TextView totalWeightGram, totalWeightKilo;
    private Button calculate, clearAll;
    private LinearLayout linearLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag2_layout,container,false);

        calculate = view.findViewById(R.id.frag2button);
        clearAll = view.findViewById(R.id.frag2button2);
        frag2EditText1 = view.findViewById(R.id.frag2EditText1);
        frag2EditText2 = view.findViewById(R.id.frag2EditText2);
        totalWeightGram = view.findViewById(R.id.totalWeight);
        totalWeightKilo = view.findViewById(R.id.totalWeightKilo);
        linearLayout = view.findViewById(R.id.linear2);

        linearLayout.setVisibility(View.INVISIBLE);

        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(frag2EditText1.length() == 0 && frag2EditText2.length() == 0){
                    //Do Nothing
                }
                else{
                    frag2EditText1.setText("");
                    frag2EditText2.setText("");
                    Toast.makeText(getActivity(),"ALL FIELDS CLEARED",Toast.LENGTH_SHORT).show();
                }
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(frag2EditText1.length() == 0 || frag2EditText2.length() == 0){
                    Toast.makeText(getActivity(),"INPUT ALL FIELDS",Toast.LENGTH_SHORT).show();
                }
                else{

                    double input1, input2, weight1, weight2;

                    input1 = Double.parseDouble(frag2EditText1.getText().toString());
                    input2 = Double.parseDouble(frag2EditText2.getText().toString());

                    weight2 = input2 / input1;
                    weight1 = weight2 * 1000;

                    linearLayout.setVisibility(View.VISIBLE);

                    totalWeightGram.setText(String.format("%.2f", weight1));
                    totalWeightKilo.setText(String.format("%.4f", weight2));
                }
            }
        });
        return view;
    }
}
