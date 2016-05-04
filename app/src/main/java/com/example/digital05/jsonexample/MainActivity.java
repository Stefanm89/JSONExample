package com.example.digital05.jsonexample;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String urlJsonObj = "http://api.androidhive.info/volley/person_object.json";
    private String urlJsonArray = "http://api.androidhive.info/volley/person_array.json";

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button btnMakeObjRequest, btnMakeArrayRequest;

    private ProgressDialog pDialog;
    private TextView txtResponse;

    private String jsonResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMakeObjRequest = (Button) findViewById(R.id.btnObjRequest);
        btnMakeArrayRequest = (Button) findViewById(R.id.btnArrayRequest);
        txtResponse = (TextView) findViewById(R.id.txtResponse);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        btnMakeObjRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeJsonObjectRequest();
            }
        });

        btnMakeArrayRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeJsonArrayRequest();
            }
        });

    }

    private void makeJsonObjectRequest(){

    }

    private void makeJsonArrayRequest(){

    }

    private void showpDialog(){
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog(){
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
