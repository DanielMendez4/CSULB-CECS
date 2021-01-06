/**
 * CECS 453
 * June 24, 2020
 * CarDetailActivity.java
 * Authors: Ricky Tan & Daniel Mendez
 */

package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Handles the vertical layout for the app
 */
public class CarDetailActivity extends AppCompatActivity {

    private TextView make_model_txt;
    private TextView car_info_txt;
    private TextView last_update_txt;
    private TextView price_txt;
    private ImageView car_pic_img;

    String imageURL;
    String last_update;
    String price;
    String vehicle_description;
    String url = "https://thawing-beach-68207.herokuapp.com/cars/";

    private ProgressDialog pDialog;
    private String TAG = MainActivity.class.getSimpleName();

    public CarDetailActivity() { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_detail);
        Intent i = getIntent();
        url += i.getStringExtra("id");

        make_model_txt = findViewById(R.id.make_model_txt);
        car_info_txt = findViewById(R.id.car_info_txt);
        last_update_txt = findViewById(R.id.last_update_txt);
        price_txt = findViewById(R.id.price_txt);
        car_pic_img = findViewById(R.id.car_pic_img);

        make_model_txt.setText(i.getStringExtra("name"));
        new GetMakes().execute();
    }

    private class GetMakes extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(CarDetailActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            HttpHandler mh = new HttpHandler();
            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);
            ArrayList<String> tmpList = new ArrayList<>();
            Log.e(TAG, "Response from listURL: " + jsonStr);
            if (jsonStr != null) {
                try {
                    // Getting JSON Array node
                    JSONArray contacts =  new JSONArray(jsonStr);
                    // Looping through all contacts
                    JSONObject c = contacts.getJSONObject(0);
                    vehicle_description = c.getString("veh_description");
                    price = c.getString("price");
                    last_update = c.getString("updated_at");
                    imageURL = c.getString("image_url");
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                      runOnUiThread(new Runnable() {
                        @Override
                        public void run() { }
                    });
                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                 runOnUiThread(new Runnable() {
                    @Override
                    public void run() { }
                });
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing()) pDialog.dismiss();
            new DownloadImageTask((ImageView) findViewById(R.id.car_pic_img)).execute(imageURL);
            car_info_txt.setText(vehicle_description);
            last_update_txt.setText(getResources().getString(R.string.last_update) + ":\n" + last_update);
            price_txt.setText(getResources().getString(R.string.price) + ": $" + price);
        }
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }
        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}