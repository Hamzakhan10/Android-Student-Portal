package com.example.hamzakhan.ucpportal;

import android.content.Context;
import android.graphics.Paint;
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

/**
 * Created by Hamza khan on 14/12/2017.
 */
public class Annoucement_adapter extends ArrayAdapter {
    List list=new ArrayList();
    public Annoucement_adapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(get_announcements object) {
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
         annoucement_holder annoucement_holder;

        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout_annoucements,parent,false);
            annoucement_holder=new  annoucement_holder();
            annoucement_holder.tx_ann1=(TextView) row.findViewById(R.id.tx_ann1);
            annoucement_holder.tx_ann2=(TextView)row.findViewById(R.id.tx_ann2);
            annoucement_holder.tx_ann3=(TextView)row.findViewById(R.id.tx_ann3);
            row.setTag(annoucement_holder);
        }
        else
        {
            annoucement_holder=( annoucement_holder) row.getTag();
        }
        get_announcements get_announcements=(get_announcements) this.getItem(position);
        annoucement_holder.tx_ann2.setText(get_announcements.getSubject());
        annoucement_holder.tx_ann1.setText(get_announcements.getAnnoucment());
        annoucement_holder.tx_ann3.setText(get_announcements.getDate());
        annoucement_holder.tx_ann2.setPaintFlags( annoucement_holder.tx_ann2.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);


        return row;
    }

    static class annoucement_holder
    {
        TextView tx_ann1,tx_ann2,tx_ann3;
    }
}
