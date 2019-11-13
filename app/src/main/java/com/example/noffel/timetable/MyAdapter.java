package com.example.noffel.timetable;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class MyAdapter extends ArrayAdapter<String> {
    private String TimeSQL[];
    String tempSt;
    Cursor cursor;
    String displayTime[];
    public MyAdapter(@NonNull Context context, Cursor cursor, String Time[]) {
        super(context,R.layout.list_single,R.id.list_single_time,Time);
        this.TimeSQL  = Time;
        this.cursor = cursor;
        displayTime = context.getResources().getStringArray(R.array.Time);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        tempSt = cursor.getString(cursor.getColumnIndex(TimeSQL[position]));
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            row = inflater.inflate(R.layout.list_single, parent,false);
        }
        TextView timetv = (TextView) row.findViewById(R.id.list_single_time);
        TextView subtv = (TextView) row.findViewById(R.id.subject);
        TextView roomtv = (TextView) row.findViewById(R.id.room);
//        TextView floortv = (TextView) row.findViewById(R.id.list_single_time);
//        TextView buildingtv = (TextView) row.findViewById(R.id.subject);
//        TextView teachertv = (TextView) row.findViewById(R.id.room);

        if(tempSt != null && !tempSt.contains("null") && !tempSt.equals("")) {
            timetv.setText(displayTime[position]);
            subtv.setText(tempSt.split("-")[0]);
            roomtv.setText(tempSt.split("-")[1]);

        }else{
            timetv.setText(displayTime[position]);
            subtv.setText("");
            roomtv.setText("");
        }
        return row;
    }

}