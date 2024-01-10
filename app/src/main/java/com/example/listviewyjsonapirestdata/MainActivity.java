package com.example.listviewyjsonapirestdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.listviewyjsonapirestdata.WebServices.Asynchtask;
import com.example.listviewyjsonapirestdata.WebServices.WebService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("http://www.geognos.com/api/en/countries/info/all.json",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<javapaises> listapaises = new ArrayList<javapaises>();
        JSONObject response = new JSONObject(result);
        JSONObject resultsObject = response.getJSONObject("Results");
        listapaises = javapaises.JsonObjectsBuild(resultsObject);
        adaptadorpaises adaptadorpaises11 = new adaptadorpaises(this, listapaises);
        ListView lstOpciones = (ListView) findViewById(R.id.listpaises);
        lstOpciones.setAdapter(adaptadorpaises11);
    }
    }
