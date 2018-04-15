package com.example.hamzakhan.ucpportal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import android.graphics.Color;


/**
 * Created by Hamza khan on 14/12/2017.
 */
public class Attendance_adapter extends ArrayAdapter {
    List list=new ArrayList();
    public Attendance_adapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(Get_attendance object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row=convertView;
        Attendance_holder attendance_holder;

        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.attendance_layout,parent,false);
            attendance_holder=new Attendance_holder();
            attendance_holder.textView2=(TextView)row.findViewById(R.id.textView2);
            attendance_holder.textView3=(TextView)row.findViewById(R.id.textView3);
            row.setTag(attendance_holder);
        }
        else
        {
            attendance_holder=( Attendance_holder) row.getTag();
        }
       Get_attendance get_attendance=(Get_attendance) this.getItem(position);
        if(get_attendance.getStatus().equals("Absent")) {
            attendance_holder.textView2.setTextColor(Color.RED);
            attendance_holder.textView2.setText(get_attendance.getStatus());
            attendance_holder.textView3.setText(get_attendance.getDate());
        }
        else
        {   attendance_holder.textView2.setTextColor(Color.BLUE);
            attendance_holder.textView2.setText(get_attendance.getStatus());
            attendance_holder.textView3.setText(get_attendance.getDate());
        }


        return row;
    }

    static class Attendance_holder
    {
        TextView textView2,textView3;
    }
}
