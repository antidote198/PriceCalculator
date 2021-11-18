package com.example.pricecalculator;


import android.os.Bundle;
import android.text.TextUtils;
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

public class Frag1 extends Fragment{

    private EditText frag1EditText1;
    private EditText frag1EditText2;
    private TextView totalPrice;
    private Button calculate, clearAll;
    private LinearLayout linearLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1_layout,container,false);

        calculate = view.findViewById(R.id.button);
        clearAll = view.findViewById(R.id.button2);
        frag1EditText1 = view.findViewById(R.id.frag1EditText1);
        frag1EditText2 = view.findViewById(R.id.frag1EditText2);
        totalPrice = view.findViewById(R.id.totalPrice);
        linearLayout = view.findViewById(R.id.linear1);

        linearLayout.setVisibility(View.INVISIBLE);



        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(frag1EditText1.length() == 0 && frag1EditText2.length() == 0){
                    //Do Nothing
                }
                else{
                    frag1EditText1.setText("");
                    frag1EditText2.setText("");
                    Toast.makeText(getActivity(),"ALL FIELDS CLEARED",Toast.LENGTH_SHORT).show();
                }
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(frag1EditText1.length() == 0 || frag1EditText2.length() == 0){
                    Toast.makeText(getActivity(),"INPUT ALL FIELDS",Toast.LENGTH_SHORT).show();
                }
                else{
                    double input1, input2, price, gramToKilo;

                    input1 = Double.parseDouble(frag1EditText1.getText().toString());
                    input2 = Double.parseDouble(frag1EditText2.getText().toString());

                    gramToKilo = input2 / 1000;

                    price = gramToKilo * input1;

                    linearLayout.setVisibility(View.VISIBLE);

                    totalPrice.setText(String.format("%.2f", price));
                }
            }
        });
        return view;
    }
}
