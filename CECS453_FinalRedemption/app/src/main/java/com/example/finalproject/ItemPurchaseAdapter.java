package com.example.finalproject;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.InputType;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import static android.widget.Toast.LENGTH_LONG;

public class ItemPurchaseAdapter extends RecyclerView.Adapter<ItemPurchaseAdapter.ItemViewHolder>  {

    private  ArrayList<String> mItemList;
    private LayoutInflater mInflater;
    Context parent;
    DBHelper db;
    String ele;
    int id;

    public ItemPurchaseAdapter(Context context, ArrayList<String> itemList, int userid) {
        mInflater = LayoutInflater.from(context);
       parent = (context);
       db = new DBHelper(context);
        this.mItemList = itemList;
        this.id = userid;
    }

    @NonNull
    @Override
    public ItemPurchaseAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.itemlist_item, parent, false);
        return new ItemViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemPurchaseAdapter.ItemViewHolder holder, int position) {
        String mCurrent = mItemList.get(position);
        holder.itemItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() { return mItemList.size(); }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final TextView itemItemView;
        final ItemPurchaseAdapter mAdapter;

        public ItemViewHolder(View itemView, ItemPurchaseAdapter adapter) {
            super(itemView);
            itemItemView = itemView.findViewById(R.id.item);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            ele = mItemList.get(mPosition);

            mAdapter.notifyDataSetChanged();

            AlertDialog.Builder builder = new AlertDialog.Builder(mInflater.getContext());
            builder.setTitle("Delete purchase of " + ele + "?");

// Set up the input
            final EditText input = new EditText(mInflater.getContext());
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            builder.setView(input);
            final Scanner parse = new Scanner(ele);
            final   String name = parse.next();
            parse.next();
            final String quantity = parse.next();
            parse.next();
            final String price = parse.next();
            parse.next();
            final String date= parse.next();


// Set up the buttons
            builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //public void deleteQuant(String name,String id, String price, String date, String quantity)
                    db.deleteQuant(name,id+"",price,date,quantity);
                    Toast toast = Toast.makeText(parent,price + " " + date, Toast.LENGTH_LONG);
                    mItemList = db.getItemPurchaseList(id+"");
                    toast.show();
                    mAdapter.notifyDataSetChanged();
                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();





        }



    }


}
