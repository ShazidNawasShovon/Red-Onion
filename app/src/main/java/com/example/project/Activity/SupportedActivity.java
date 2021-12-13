package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.project.Adapter.JSONAdapter;
import com.example.project.Domain.JSONDomain;
import com.example.project.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SupportedActivity extends AppCompatActivity {
    RecyclerView recyclerView ;
    List<JSONDomain> jsonDomains;
    JSONAdapter adapter;
    private static String JSON_URL="https://api.npoint.io/b722a1dfa95c1b184bab" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supported);
        recyclerView=findViewById(R.id.clientList);
        jsonDomains=new ArrayList<>();

        extractClients();



        bottomNavigation();
    }



    private void extractClients(){
        RequestQueue queue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject clientObject = response.getJSONObject(i);

                        JSONDomain jsonDomain = new JSONDomain();
                        jsonDomain.setTitle(clientObject.getString("name").toString());

                        jsonDomain.setDetails(clientObject.getString("aboutCharacter").toString());
                        jsonDomain.setCoverImage(clientObject.getString("img"));

                        jsonDomain.setURL(clientObject.getString("url"));

                        jsonDomains.add(jsonDomain);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new JSONAdapter(getApplicationContext(), jsonDomains);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse: " + error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);
    }
    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout supportBtn= findViewById(R.id.supportBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SupportedActivity.this, CartListActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SupportedActivity.this, MainActivity.class));
            }
        });
        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SupportedActivity.this,SupportedActivity.class));
            }
        });
    }
}
