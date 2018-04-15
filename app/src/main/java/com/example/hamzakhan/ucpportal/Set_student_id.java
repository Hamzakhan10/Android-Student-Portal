package com.example.hamzakhan.ucpportal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamza khan on 14/12/2017.
 */
public class Set_student_id extends ArrayAdapter {
    List list=new ArrayList();
    public Set_student_id(Context context, int resource) {
        super(context, resource);
    }


    public void add(Get_student_id object) {
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
       Id_holder id_holder;

        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.menu_header,parent,false);
            id_holder=new Id_holder();
            id_holder.textView=(TextView)row.findViewById(R.id.textView);
            row.setTag(id_holder);
        }
        else
        {
            id_holder=( Id_holder) row.getTag();
        }
        Get_student_id get_student_id=(Get_student_id) this.getItem(position);
        id_holder.textView.setText(get_student_id.getId());




        return row;
    }

    static class Id_holder
    {
        TextView textView;
    }
}
