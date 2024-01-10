package com.example.listviewyjsonapirestdata;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class javapaises {
    String Nombre;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getUrlLogo() {
        return UrlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        UrlLogo = urlLogo;
    }

    String UrlLogo;

    public javapaises(String countryCode, JSONObject countryData) throws JSONException {
        Nombre = countryData.getString("Name");
        UrlLogo = "http://www.geognos.com/api/en/countries/flag/" + countryCode + ".png";
    }

    public static ArrayList<javapaises> JsonObjectsBuild(JSONObject datos) throws JSONException {
        ArrayList<javapaises> lstpaises = new ArrayList<>();
        Iterator<String> keys = datos.keys();
        while (keys.hasNext()) {
            String countryCode = keys.next();
            JSONObject countryData = datos.getJSONObject(countryCode);
            lstpaises.add(new javapaises(countryCode, countryData));
        }
        return lstpaises;
    }
}

