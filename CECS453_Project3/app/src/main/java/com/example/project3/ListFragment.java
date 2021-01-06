/**
 * CECS 453
 * June 24, 2020
 * ListFragment.java
 * Authors: Ricky Tan & Daniel Mendez
 */

package com.example.project3;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Ensures that the list spinner, which is located in a fragment, is properly updated
 * Depending on the selected make and model, the corresponding vehicles are shown
 */
public class ListFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<String> vehicleListFinal;
    HashMap<String,String> idMap;
    OnChangeListener spinnerListener;
    String url = "https://thawing-beach-68207.herokuapp.com/cars/";

    private ProgressDialog pDialog;
    private String mParam1;
    private String mParam2;
    private String TAG = MainActivity.class.getSimpleName();

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
        idMap = new HashMap<String, String>();
        vehicleListFinal = new ArrayList<>();
        url = url + mParam1+"/"+mParam2+"/92603";
        new GetMakes().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        // Inflate the layout for this fragment
        return rootView;
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
            String jsonStr = sh.makeServiceCall(url);
            ArrayList<String> tmpList = new ArrayList<>();
            Log.e(TAG, "Response from listURL: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    // Getting JSON Array node
                    JSONArray contacts = jsonObject.getJSONArray("lists");
                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);
                        String id = c.getString("id");
                        String color =  c.getString("color");
                        String name = "";
                        if(color.equals("NA")) name = i+1 + ". " + c.getString("vehicle_make" ) + " " + c.getString("model");
                        else { name = i+1 + ". " + c.getString("vehicle_make" ) + " " + c.getString("model") + " - " + color; }

                        vehicleListFinal.add(name);
                        idMap.put(name, id);
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
            RecyclerView recyclerView =  getActivity().findViewById(R.id.vehicle_recycler);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager((mLayoutManager));
            CustomAdapter ca = new CustomAdapter(getActivity(), vehicleListFinal,idMap, spinnerListener);
            recyclerView.setAdapter(ca);
        }
    }
}