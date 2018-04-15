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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamza khan on 03/12/2017.
 */

public class day_adapter extends ArrayAdapter {
    List list=new ArrayList();
    public day_adapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(days object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row=convertView;
        dayholder dayholder;

        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout_json,parent,false);
            dayholder=new dayholder();
            dayholder.tx_1=(TextView) row.findViewById(R.id.tx_1);
            dayholder.tx_2=(TextView) row.findViewById(R.id.tx_2);
            dayholder.tx_3=(TextView) row.findViewById(R.id.tx_3);
            dayholder.tx_5=(TextView) row.findViewById(R.id.tx_5);
            row.setTag(dayholder);
        }
        else
        {
            dayholder=(dayholder) row.getTag();
        }
        days days=(days) this.getItem(position);
        dayholder.tx_1.setText(days.getDay());
        dayholder.tx_2.setText(days.getTime());
        dayholder.tx_3.setText(days.getR_no());
        dayholder.tx_5.setText(days.getOc_names());
        dayholder.tx_5.setPaintFlags( dayholder.tx_5.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        return row;
    }

    static class dayholder
    {
        TextView tx_1,tx_2,tx_3,tx_5;
    }
}
