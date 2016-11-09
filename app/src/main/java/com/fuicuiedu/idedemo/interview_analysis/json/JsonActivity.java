package com.fuicuiedu.idedemo.interview_analysis.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.fuicuiedu.idedemo.interview_analysis.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonActivity extends AppCompatActivity {

    //appkey = ff49b2a6cee5196226f2696813e266bd

    String json = "{\n" +
            "\t\t    \"resultcode\": \"200\",\n" +
            "\t\t    \"reason\": \"SUCCESSED!\",\n" +
            "\t\t    \"result\": [\n" +
            "\t\t        {\n" +
            "\t\t            \"city\": \"苏州\",  /*城市*/\n" +
            "\t\t            \"PM2.5\": \"73\",  /*PM2.5指数*/\n" +
            "\t\t            \"AQI\": \"98\",    /*空气质量指数*/\n" +
            "\t\t            \"quality\": \"良\", /*空气质量*/\n" +
            "\t\t            \"PM10\": \"50\",/*PM10*/\n" +
            "\t\t            \"CO\": \"0.79\",  /*一氧化碳*/\n" +
            "\t\t            \"NO2\": \"65\",  /*二氧化氮*/\n" +
            "\t\t            \"O3\": \"28\",    /*臭氧*/\n" +
            "\t\t            \"SO2\": \"41\",  /*二氧化硫*/\n" +
            "\t\t            \"time\": \"2014-12-26 11:48:40\"/*更新时间*/  \n" +
            "\t\t        }\n" +
            "\t\t    ],\n" +
            "\t\t    \"error_code\": 0\n" +
            "\t\t}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("result");
            for (int i = 0;i<jsonArray.length();i++){
                JSONObject object = jsonArray.getJSONObject(i);
                Log.e("jsonobject" , object.toString());

            }
            Log.e("json" , jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
