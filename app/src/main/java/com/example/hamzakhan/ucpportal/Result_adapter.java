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
public class Result_adapter extends ArrayAdapter {
    List list=new ArrayList();
    public Result_adapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(Get_result object) {
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
        Result_holder result_holder;

        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout_result,parent,false);
            result_holder=new Result_holder();
            result_holder.tx_ann2=(TextView)row.findViewById(R.id.tx_ann2);
            result_holder.tx_ann3=(TextView)row.findViewById(R.id.tx_ann3);
            result_holder.tx_ann4=(TextView)row.findViewById(R.id.tx_ann4);
            result_holder.tx_ann5=(TextView)row.findViewById(R.id.tx_ann5);
            result_holder.tx_ann6=(TextView)row.findViewById(R.id.tx_ann6);
            result_holder.tx_ann7=(TextView)row.findViewById(R.id.tx_ann7);
            result_holder.tx_ann8=(TextView)row.findViewById(R.id.tx_ann8);
            result_holder.tx_ann9=(TextView)row.findViewById(R.id.tx_ann9);
            result_holder.tx_ann10=(TextView)row.findViewById(R.id.tx_ann10);
            result_holder.tx_ann11=(TextView)row.findViewById(R.id.tx_ann11);
            result_holder.tx_ann12=(TextView)row.findViewById(R.id.tx_ann12);
            result_holder.tx_ann13=(TextView)row.findViewById(R.id.tx_ann13);
            row.setTag(result_holder);
        }
        else
        {
            result_holder=( Result_holder) row.getTag();
        }
       Get_result get_result=(Get_result) this.getItem(position);
        result_holder.tx_ann2.setText(get_result.getQuiz1());
        result_holder.tx_ann3.setText(get_result.getQuiz2());
        result_holder.tx_ann4.setText(get_result.getQuiz3());
        result_holder.tx_ann5.setText(get_result.getQuiz4());
        result_holder.tx_ann6.setText(get_result.getAss1());
        result_holder.tx_ann7.setText(get_result.getAss2());
        result_holder.tx_ann8.setText(get_result.getAss3());
        result_holder.tx_ann9.setText(get_result.getAss4());
        result_holder.tx_ann10.setText(get_result.getMid());
        result_holder.tx_ann11.setText(get_result.getFinals());
        result_holder.tx_ann12.setText(get_result.getProject());
        result_holder.tx_ann13.setText(get_result.getOther());



        return row;
    }

    static class Result_holder
    {
        TextView tx_ann2,tx_ann3,tx_ann4,tx_ann5,tx_ann6,tx_ann7,tx_ann8,tx_ann9,tx_ann10,tx_ann11,tx_ann12,tx_ann13;
    }
}
