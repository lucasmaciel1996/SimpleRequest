package com.example.simplerequestbio;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simplerequestbio.R;

public class MainActivity extends AppCompatActivity {

    EditText txt_renach;
    EditText txt_cpf;
    TextView txt_biometria;
    TextView txt_result;
    Button btn_request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_cpf = (EditText) findViewById(R.id.txt_cpf);
        txt_renach = (EditText) findViewById(R.id.txt_renach);
        txt_biometria = (TextView) findViewById(R.id.txt_biometria);
        txt_result = (TextView) findViewById(R.id.txt_result);
        btn_request = (Button) findViewById(R.id.btn_request);


        btn_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_result.setText("REQUEST SERVER...");
            }
        });
    }
}
