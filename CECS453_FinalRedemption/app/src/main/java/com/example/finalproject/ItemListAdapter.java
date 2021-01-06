package com.example.finalproject;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
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
import java.util.LinkedList;
import java.util.Scanner;

import static android.widget.Toast.LENGTH_LONG;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {

    private final ArrayList<String> mItemList;
    private LayoutInflater mInflater;
    DBHelper db;
    String ele;
    int pos;
    int id;
    public ItemListAdapter(Context context, ArrayList<String> itemList, int userid) {
        mInflater = LayoutInflater.from(context);
        db = new DBHelper(context);
        this.mItemList = itemList;
        this.id = userid;
    }

    @NonNull
    @Override
    public ItemListAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.itemlist_item, parent, false);
        return new ItemViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.ItemViewHolder holder, int position) {
        String mCurrent = mItemList.get(position);
        holder.itemItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() { return mItemList.size(); }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView itemItemView;
        final ItemListAdapter mAdapter;

        public ItemViewHolder(View itemView, ItemListAdapter adapter) {
            super(itemView);
            itemItemView = itemView.findViewById(R.id.item);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            pos = mPosition;
            ele = mItemList.get(mPosition);
            AlertDialog confirm = AskOption();
            confirm.show();
        }
    }

    private AlertDialog AskOption()
    {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(mInflater.getContext())
                // set message, title, and icon
                .setTitle(ele)
                .setMessage("Select from options below")



                .setNeutralButton("Edit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {


                        AlertDialog.Builder builder = new AlertDialog.Builder(mInflater.getContext());
                        builder.setTitle("Enter new price or delete");


                        final EditText input = new EditText(mInflater.getContext());

                        input.setInputType(InputType.TYPE_CLASS_TEXT );
                        builder.setView(input);


                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {




                                db.updateItem(new Scanner(ele).next(),input.getText().toString());
                                mItemList.remove(pos);
                                mItemList.add(new Scanner(ele).next() + input.getText().toString());
                                db.updateQuantityPrice(new Scanner(ele).next(),input.getText().toString());
                                ItemListAdapter.this.notifyDataSetChanged();
                                dialog.dismiss();
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.cancel();
                            }
                        });
                        builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                try {
                                    if (db.getQuantity(new Scanner(ele).next(), id + "") == 0) {
                                        db.deleteItem((new Scanner(ele).next()));
                                        mItemList.remove(pos);
                                        db.deleteItem(new Scanner(ele).next());
                                        ItemListAdapter.this.notifyDataSetChanged();
                                        dialog.dismiss();
                                    }
                                } catch ( Exception e) {
                                    db.deleteItem((new Scanner(ele).next()));
                                    mItemList.remove(pos);
                                    db.deleteItem(new Scanner(ele).next());
                                    ItemListAdapter.this.notifyDataSetChanged();
                                    dialog.dismiss();
                                }
                            }

                        });
                        builder.show();

                        dialog.dismiss();

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                })
                .setPositiveButton("Add purchase", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mInflater.getContext());
                        builder.setTitle("Enter quantity!");

// Set up the input
                        final EditText input = new EditText(mInflater.getContext());
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        builder.setView(input);
                        final Scanner parse = new Scanner(ele);
                        final   String name = parse.next();
                        final  String price = parse.next();

// Set up the buttons
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                int mYear, mMonth, mDay, mHour, mMinute;

                                final EditText txtDate, txtTime;
                                txtDate= new EditText(input.getContext());

                                final Calendar c = Calendar.getInstance();
                                mYear = c.get(Calendar.YEAR);
                                mMonth = c.get(Calendar.MONTH);
                                mDay = c.get(Calendar.DAY_OF_MONTH);
                                final String x;

                                DatePickerDialog datePickerDialog = new DatePickerDialog(txtDate.getContext(),
                                        new DatePickerDialog.OnDateSetListener() {

                                            @Override
                                            public void onDateSet(DatePicker view, int year,
                                                                  int monthOfYear, int dayOfMonth) {

                                                txtDate.setText(year + "-" + (monthOfYear) + "-" + dayOfMonth);
                                                long x = db.insertItemPurchase(id + "", name, input.getText().toString(), price, txtDate.getText().toString());
                                                Toast.makeText(txtDate.getContext(), x + "", LENGTH_LONG).show();

                                            }
                                        }, mYear, mMonth, mDay);
                                datePickerDialog.show();



                            }
                        });


                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                        builder.show();
                        dialog.dismiss();

                    }
                })
                .create();
        return myQuittingDialogBox;
    }
}
