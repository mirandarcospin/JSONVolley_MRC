package com.example.jsonvolley_mrc.dummy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.jsonvolley_mrc.R;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DummyContent extends AppCompatActivity {

    public static JSONArray ITEM_MAP = new JSONArray();
    public static List<DummyContent> ITEMS = new ArrayList<>();
    public static List<org.json.JSONObject> DummyItems = (List<JSONObject>) new JSONObject();

    private TextView mTextViewResult;
    private RequestQueue mQueue;

    public String country;
    public int number;
    public String des;
    public DummyContent(String country, int number, String des) {
        this.country = country;
        this.number = number;
        this.des = des;
    }
    @Override
    public String toString() {
        return des;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);

        mTextViewResult = findViewById(R.id.item_detail);

        mQueue = Volley.newRequestQueue(this);
        jsonParse();
    }

    private void jsonParse(){
        String url = "https://api.jsonbin.io/b/5f7bcaff302a837e95754641";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //Reads the JSON array
                try {
                    JSONArray jsonArray = response.getJSONArray("countriesCoffee");

                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject coffee = jsonArray.getJSONObject(i);

//                        String country = coffee.getString("country");
//                        int number = coffee.getInt("number");
//                        String des = coffee.getString("description");
                        country = coffee.getString("country");
                        number = coffee.getInt("number");
                        des = coffee.getString("description");

                        //ITEMS.add(new MainActivity("country", "number", "des"));
                        ITEMS.add(i, new DummyContent(country,number,des));
                        DummyItems.add(coffee);
                        ITEM_MAP.put(coffee);

                        mTextViewResult.append(country + ", " + String.valueOf(number) + ", " + des + "\n\n");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }

    public class DummyItem {
        public String country;
        public int number;
        public String des;

        public DummyItem(String country, int number, String des) {
            this.country = country;
            this.number = number;
            this.des = des;
        }



    }
}