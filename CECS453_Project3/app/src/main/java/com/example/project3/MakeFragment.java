/**
 * CECS 453
 * June 24, 2020
 * MakeFragment.java
 * Authors: Ricky Tan & Daniel Mendez
 */

package com.example.project3;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Ensures that the make spinner, which is located in a fragment, is properly updated
 * Every time a new make is selected in the spinner, it gets updated accordingly
 */
public class MakeFragment extends Fragment {

    private static String makesURL = "https://thawing-beach-68207.herokuapp.com/carmakes";
    private ProgressDialog pDialog;
    private String TAG = MainActivity.class.getSimpleName();

    HashMap<String, String> idMap;
    ArrayList<String> makeList;
    OnChangeListener spinnerListener;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public MakeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        idMap = new HashMap<String,String>();
        makeList = new ArrayList<>();
        new GetMakes().execute();
        return inflater.inflate(R.layout.fragment_make, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            spinnerListener = (OnChangeListener) getActivity();
        } catch (ClassCastException e) { throw new ClassCastException(context.toString() + " must implement onButtonPressed"); }
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
            String jsonStr = sh.makeServiceCall(makesURL);
            ArrayList<String> tmpList = new ArrayList<>();
            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    // Getting JSON Array node
                    JSONArray contacts = new JSONArray(jsonStr);
                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);
                        String id = c.getString("id");
                        String name = c.getString("vehicle_make");
                        // modelMap.put(Integer.valueOf(i).toString(), tmp);
                        idMap.put(name, id);
                        makeList.ensureCapacity(Integer.valueOf(id));
                        makeList.add(name);
                    }
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
            if (pDialog.isShowing()) pDialog.dismiss();
            final Spinner makeSpin = getActivity().findViewById(R.id.make_spinner);
            ArrayAdapter<String> makeArray;
            makeArray = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, makeList);
            makeArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            makeSpin.setAdapter(makeArray);
            makeSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) { spinnerListener.modelUpdate(idMap.get(makeSpin.getSelectedItem().toString())); }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) { }
            });
        }
    }
}