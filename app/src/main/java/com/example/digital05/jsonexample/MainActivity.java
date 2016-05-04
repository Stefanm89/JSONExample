package com.example.digital05.jsonexample;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.digital05.jsonexample.app.AppController;

import org.json.JSONException;
import org.json.JSONObject;

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

    private void makeJsonObjectRequest() {
        showpDialog();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                urlJsonObj, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    String name = response.getString("name");
                    String email = response.getString("email");
                    JSONObject phone = response.getJSONObject("phone");
                    String home = response.getString("home");
                    String mobile = response.getString("mobile");

                    jsonResponse = "";
                    jsonResponse += "Name " + name + "\n\n";
                    jsonResponse += "Email " + email + "\n\n";
                    jsonResponse += "Phone " + phone + "\n\n";
                    jsonResponse += "Home " + home + "\n\n";
                    jsonResponse += "Mobile " + mobile + "\n\n";

                    txtResponse.setText(jsonResponse);
                } catch (JSONException e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                hidepDialog();
            }, new Response.ErrorListener(){

            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjReq);

    }

    private void makeJsonArrayRequest() {

    }

    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
