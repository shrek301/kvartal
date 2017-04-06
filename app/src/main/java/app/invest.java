package app;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import app.utils.JSONfunctions;
import app.utils.RecyclerAdapter;
import com.androidbegin.yqltutorial.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class invest extends Activity {
    public static String RANK = "title";
    public static String COUNTRY = "city_title";
    public static String POPULATION = "type";
    public static String FLAG = "picture_path";
    public static String POL = "description";
    public static String NAME = "user_title";
    // Declare Variables
    JSONObject jsonobject;
    JSONArray jsonarray;
    RecyclerView listview;
    RecyclerAdapter adapter;
    ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> arraylist;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from listview_main.xml
        setContentView(R.layout.listview_main);
        // Execute DownloadJSON AsyncTask
        new DownloadJSON().execute();
    }

    // DownloadJSON AsyncTask
    private class DownloadJSON extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //  mProgressDialog = new ProgressDialog(bisnes.this,R.style.MyTheme);
            mProgressDialog = ProgressDialog.show(invest.this, null, null, true);
            mProgressDialog.setContentView(R.layout.elemento_progress_splash);
            mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Create an array
            arraylist = new ArrayList<HashMap<String, String>>();
            // Retrieve JSON Objects from the given URL address
            jsonobject = JSONfunctions
                    .getJSONfromURL("http://api.recrm.ru/json/estate/search?key=3e6d2ce2a14a41f99101cd3e5b74a214&4&group_id=9&start=0&count=2000");

            try {
                // Locate the array name in JSON
                jsonarray = jsonobject.getJSONArray("results");

                for (int i = 0; i < jsonarray.length(); i++) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    jsonobject = jsonarray.getJSONObject(i);
                    // Retrive JSON Objects
                    map.put("title", jsonobject.getString("title"));
                    map.put("city_title", jsonobject.getString("city_title"));
                    map.put("type", String.valueOf(jsonobject.getInt("price_total")));
                    map.put("picture_path", jsonobject.getString("picture_path"));
                    map.put("description", jsonobject.getString("description"));
                    map.put("user_title", jsonobject.getString("user_title"));
                    // Set the JSON Objects into the array
                    arraylist.add(map);
                }
            } catch (JSONException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void args) {
            // Locate the listview in listview_main.xml
            listview = (RecyclerView) findViewById(R.id.listview);
            // Pass the results into ListViewAdapter.java
            adapter = new RecyclerAdapter(invest.this, arraylist);
            // Set the adapter to the ListView

            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }
}