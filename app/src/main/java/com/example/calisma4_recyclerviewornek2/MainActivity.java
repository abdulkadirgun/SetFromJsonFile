package com.example.calisma4_recyclerviewornek2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcv;
    private List<Object> depo = new ArrayList<>();

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv = (RecyclerView) findViewById(R.id.rv);
        rcv.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        rcv.setLayoutManager(layoutManager);


        mAdapter = new RVAdapter(this,depo);
        rcv.setAdapter(mAdapter);

        doldur();
    }

    private void doldur() {
        try{
        String jsonGelen = jsonOku();
        JSONArray jsonArray = new JSONArray(jsonGelen);

        for(int i=0; i<jsonArray.length(); i++){
            JSONObject obj = jsonArray.getJSONObject(i);

            String  id = obj.getString("id");
            String title = obj.getString("title");
            String fact = obj.getString("fact");
            String source = obj.getString("source");

            Card mCard = new Card(id,title,fact,source);
            depo.add(mCard);
        }}
        catch(JSONException | IOException e){
            Log.d("hatalar var", "doldur: hatalı ");;
        }
    }

    private String jsonOku() throws IOException {
        InputStream inputStream = null;
        StringBuilder sb = new StringBuilder();
        try{

            String satir = null;
            inputStream = getResources().openRawResource(R.raw.uf);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));

            while ((satir = bufferedReader.readLine()) != null) {
                sb.append(satir);
            }
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return new String(sb);
    }


}