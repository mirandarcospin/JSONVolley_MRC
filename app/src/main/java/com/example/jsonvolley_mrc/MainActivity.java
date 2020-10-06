//package com.example.jsonvolley_mrc;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.widget.TextView;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class MainActivity extends AppCompatActivity {
//
//    List<JSONObject> ITEMS = new ArrayList<JSONObject>();
//    Map<String, JSONObject> ITEM_MAP = new HashMap<String, JSONObject>();
//    private TextView mTextViewResult;
//    private RequestQueue mQueue;
//
//    public MainActivity(String country, String number, String des) {
//
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.item_detail);
//
//        mTextViewResult = findViewById(R.id.text_view_result);
////        Button buttonParse = findViewById(R.id.button_parse);
//
//        mQueue = Volley.newRequestQueue(this);
////        buttonParse.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
//                jsonParse();
////            }
////        });
//    }
//
//    private void jsonParse(){
//        String url = "https://api.jsonbin.io/b/5f7bcaff302a837e95754641";
//
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                //Reads the JSON array
//                try {
//                    JSONArray jsonArray = response.getJSONArray("countriesCoffee");
//
//                    for(int i = 0; i < jsonArray.length(); i++){
//                        JSONObject coffee = jsonArray.getJSONObject(i);
//
//                         String country = coffee.getString("country");
//                         int number = coffee.getInt("number");
//                         String des = coffee.getString("description");
//
//                         //ITEMS.add(new MainActivity("country", "number", "des"));
//                         ITEMS.add(coffee);
//                         ITEM_MAP.put("country", coffee);
//
//                         mTextViewResult.append(country + ", " + String.valueOf(number) + ", " + des + "\n\n");
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });
//
//        mQueue.add(request);
//    }
//
//
//}