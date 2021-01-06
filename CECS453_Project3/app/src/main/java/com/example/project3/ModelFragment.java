/**
 * CECS 453
 * June 24, 2020
 * ModelFragment.java
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
 * Ensures that the model spinner, which is located in a fragment, is properly updated
 * Every time a new model is selected in the spinner, it gets updated accordingly
 * Every time a new make is selected, the available models are put into the spinner
 */
public class ModelFragment extends Fragment {

    HashMap<String,String> idMap;
    ArrayList<String> modelList;
    OnChangeListener spinnerListener;
    String makeId;
    String url = "https://thawing-beach-68207.herokuapp.com/carmodelmakes/";

    private static final String ARG_PARAM1 = "param1";
    private ProgressDialog pDialog;
    private String mParam1;
    private String TAG = MainActivity.class.getSimpleName();

    public ModelFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @param param1 Parameter 1.
     * @return A new instance of fragment ModelFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ModelFragment newInstance(String param1) {
        ModelFragment fragment = new ModelFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        idMap = new HashMap<>();
        modelList = new ArrayList<>();
        if(mParam1 == null) mParam1 = "10";
        if (getArguments() != null) { mParam1 = getArguments().getString(ARG_PARAM1); }
        makeId = mParam1;
        url+=mParam1;
        new GetMakes().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_model2, container, false);
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
            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);
            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    // Getting JSON Array node
                    JSONArray contacts = new JSONArray(jsonStr);
                    // Looping through all contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);
                        String id = c.getString("id");
                        String name = c.getString("model");
                        modelList.add(name);
                        idMap.put(name,id);
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
            // Dismiss the progress dialog
            if (pDialog.isShowing()) pDialog.dismiss();
            // Updating parsed JSON data into ListView
            final  Spinner modelSpin = getActivity().findViewById(R.id.model_spinner);
            ArrayAdapter<String> modelArray;
            modelArray = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, modelList);
            modelArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            modelSpin.setAdapter(modelArray);
            modelSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) { spinnerListener.listUpdate(makeId,idMap.get(modelSpin.getSelectedItem().toString())); }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) { }
            });
        }
    }
}