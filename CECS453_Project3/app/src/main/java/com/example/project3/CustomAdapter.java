package com.example.project3;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {

    OnChangeListener mainActivity;
    ArrayList<String> vehicleList;
    Context context;
    HashMap<String,String> idMap;

    public CustomAdapter(Context context, ArrayList<String> vehicleList, HashMap<String,String> idMap, OnChangeListener a) {
        this.context = context;
        this.vehicleList = vehicleList;
        this.idMap = idMap;
        this.mainActivity = a;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, padding and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("VehicleView") final int position) {

        final Context c =  holder.vehicleName.getContext();
        final MyViewHolder hold = holder;
        holder.vehicleName.setText(vehicleList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!hold.vehicleName.getResources().getBoolean(R.bool.portrait_only)) { mainActivity.wideScreenSwitch( idMap.get(vehicleList.get(position)),vehicleList.get(position)); }
                else {
                    Intent intent = new Intent(c , CarDetailActivity.class);
                    intent.putExtra("id", idMap.get(vehicleList.get(position)));
                    intent.putExtra("name", vehicleList.get(position));
                    c.startActivity(intent);;
                }
            }
        });
    }

    @Override
    public int getItemCount() { return vehicleList.size(); }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView vehicleName;
        public MyViewHolder(View vehicleView) {
            super(vehicleView);
            vehicleName = (TextView) vehicleView.findViewById(R.id.name);
        }
    }
}