package com.example.discountcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public double o,d,discountfinal,finald,s;
    public String original,discount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv=findViewById(R.id.textView);
        TextView tv2=findViewById(R.id.textView2);

        Button btn =findViewById(R.id.Button);
        com.google.android.material.textfield.TextInputEditText original_ed = findViewById(R.id.edor);
        com.google.android.material.textfield.TextInputLayout original_la = findViewById(R.id.originalprice);
        com.google.android.material.textfield.TextInputEditText dis_ed = findViewById(R.id.eddiscount);
        com.google.android.material.textfield.TextInputLayout dis_la = findViewById(R.id.discount);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 original =original_ed.getText().toString();
                 discount =dis_ed.getText().toString();

                if (TextUtils.isEmpty(original_ed.getText().toString()) ||TextUtils.isEmpty(dis_ed.getText().toString())){
                    Toast.makeText(getBaseContext(), "some Field Is Required", Toast.LENGTH_SHORT).show();

                }else{
                    o=Double.parseDouble(original);
                    d=Double.parseDouble(discount);
                    // s= d - 100;

                    discountfinal= (d * o) /100;
                    finald=o-discountfinal;

                    tv2.setText("You pay:"+Double.toString(finald));
                    tv.setText("You Save:"+Double.toString(discountfinal));
                }
                if (TextUtils.isEmpty(original_ed.getText().toString())){
                    original_la.setHelperText("Required*");

                }else{
                    original_la.setHelperText("");

                }
                if (TextUtils.isEmpty(dis_ed.getText().toString())){
                    dis_la.setHelperText("Required*");
                }else{
                    dis_la.setHelperText("");

                }

            }
        });
    }
}