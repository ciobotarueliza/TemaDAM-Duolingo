package com.example.duolingo_ciobotarueliza;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {
    public void read(String urlpath, IResponse response) {
        try {
            URL url = new URL(urlpath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream input = connection.getInputStream();
            InputStreamReader inputReader = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(inputReader);

            StringBuilder result=new StringBuilder();
            String line="";
            while((line=reader.readLine())!=null) {
                result.append(line);
            }
            Log.v("rezultat", result.toString());

            reader.close();
            inputReader.close();
            input.close();

            List<Curs> list=parsare(result.toString());
            response.onSucces(list);



        } catch (MalformedURLException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            response.onError(e.getMessage());

        }
    }

    private List<Curs> parsare(String jsonString){

        List<Curs>list=new ArrayList<>();
        try
        {
            JSONObject jsonObject=new JSONObject(jsonString);
            JSONArray array = jsonObject.getJSONArray("cursuri");
            for(int i=0;i< array.length();i++){
                JSONObject currentObject=array.getJSONObject(i);
                String limba=currentObject.getString("limba");
                String nivel=currentObject.getString("nivel");
                int nrOre=currentObject.getInt("nrOre");


                Curs c1 = new Curs(limba, nivel, nrOre);
                list.add(c1);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
    }
}
