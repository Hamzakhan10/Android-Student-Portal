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
public class Catalog_adapter extends ArrayAdapter {
    List list=new ArrayList();
    public Catalog_adapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(Course_catalog_get object) {
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
        Catalog_holder catalog_holder;

        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.catalog_layout_list,parent,false);
            catalog_holder=new Catalog_holder();
            catalog_holder.textView1=(TextView) row.findViewById(R.id.tx_ann1);
            catalog_holder.textView2=(TextView)row.findViewById(R.id.tx_ann2);
            catalog_holder.textView3=(TextView)row.findViewById(R.id.tx_ann3);
            catalog_holder.textView4=(TextView)row.findViewById(R.id.tx_ann4);
            catalog_holder.textView5=(TextView)row.findViewById(R.id.tx_ann5);
            catalog_holder.textView6=(TextView)row.findViewById(R.id.tx_ann6);
            catalog_holder.textView7=(TextView)row.findViewById(R.id.tx_ann7);
            row.setTag(catalog_holder);
        }
        else
        {
            catalog_holder=( Catalog_holder) row.getTag();
        }
        Course_catalog_get course_catalog_get=(Course_catalog_get) this.getItem(position);

            catalog_holder.textView1.setText(course_catalog_get.getOc_names());
            catalog_holder.textView2.setText(course_catalog_get.getQuiz());
            catalog_holder.textView3.setText(course_catalog_get.getAss());
            catalog_holder.textView4.setText(course_catalog_get.getMidterm());
            catalog_holder.textView5.setText(course_catalog_get.getFinals());
            catalog_holder.textView6.setText(course_catalog_get.getProject());
            catalog_holder.textView7.setText(course_catalog_get.getOthers());




        return row;
    }

    static class Catalog_holder
    {
        TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7;
    }
}
