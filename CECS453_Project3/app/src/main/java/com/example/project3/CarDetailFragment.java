/**
 * CECS 453
 * June 24, 2020
 * CarDetailFragment.java
 * Authors: Ricky Tan & Daniel Mendez
 */

package com.example.project3;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Handles the horizontal layout of the app
 */
public class CarDetailFragment extends Fragment {

    private TextView make_model_txt;
    private TextView car_info_txt;
    private TextView last_update_txt;
    private TextView price_txt;
    private ImageView car_pic_img;

    String imageURL;
    String last_update;
    String price;
    String vehicle_description;
    ViewGroup v;
    String name;
    String url = "https://thawing-beach-68207.herokuapp.com/cars/";

    private String mParam1;
    private String mParam2;
    private ProgressDialog pDialog;
    private String TAG = MainActivity.class.getSimpleName();
    private String id;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public CarDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CarDetailFragment.
     */
    public static CarDetailFragment newInstance(String id,String name) {
        CarDetailFragment fragment = new CarDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, id);
        args.putString(ARG_PARAM2, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        url+=mParam1;
        name =mParam2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = (ViewGroup) inflater.inflate(R.layout.fragment_car_detail, container, false);
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_car_detail, container, false);
        make_model_txt = root.findViewById(R.id.make_model_txt);
        car_info_txt = root.findViewById(R.id.car_info_txt);
        last_update_txt =root.findViewById(R.id.last_update_txt);
        price_txt = root.findViewById(R.id.price_txt);
        car_pic_img =root.findViewById(R.id.car_pic_img);
        new GetMakes().execute();
        return inflater.inflate(R.layout.fragment_car_detail ,container, false);
    }

    private class GetMakes extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(getActivity());
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
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() { }
                    });
                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                getActivity().runOnUiThread(new Runnable() {
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
            new CarDetailFragment.DownloadImageTask((ImageView) getActivity().findViewById(R.id.car_pic_img)).execute(imageURL);

            make_model_txt = getActivity().findViewById(R.id.make_model_txt);
            car_info_txt =  getActivity().findViewById(R.id.car_info_txt);
            last_update_txt = getActivity().findViewById(R.id.last_update_txt);
            price_txt =  getActivity().findViewById(R.id.price_txt);
            car_pic_img = getActivity().findViewById(R.id.car_pic_img);

            make_model_txt.setText(name);
            car_info_txt.setText(vehicle_description);
            last_update_txt.setText(getResources().getString(R.string.last_update) + ":\n" + last_update);
            price_txt.setText(getResources().getString(R.string.price) + ": $" + price);
            new CarDetailFragment.DownloadImageTask((ImageView) getActivity().findViewById(R.id.car_pic_img)).execute(imageURL);
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