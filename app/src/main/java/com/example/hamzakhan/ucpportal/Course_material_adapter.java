package com.example.hamzakhan.ucpportal;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Hamza khan on 14/01/2018.
 */

public class Course_material_adapter extends ArrayAdapter<Course_material_get_data> {

    ArrayList<Course_material_get_data> course_material_get_data;
    Context context;
    int resource;

    public Course_material_adapter(Context context, int resource, ArrayList<Course_material_get_data> course_material_get_data) {
        super(context, resource, course_material_get_data);
        this.course_material_get_data= course_material_get_data;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_list_layout_cm, null, true);

        };
        Course_material_get_data course_material_get_data=getItem(position);

        //   ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewProduct);
        // Picasso.with(context).load(R.id.stud_id).into(imageView);



        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        txtName.setText(course_material_get_data.getCourseFile());



        return convertView;
    }
}