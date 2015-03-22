package com.project.coursera.dailyselfie;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by root on 21/03/15.
 */
public class SelfiesListAdapter extends ArrayAdapter {
    List<Selfie> selfies;
    Context ctx;
    public SelfiesListAdapter(List selfies, Context ctx) {
        super(ctx,R.layout.selfie_item,selfies);
        this.selfies=selfies;
        this.ctx=ctx;

    }
    @Override
    public int getCount() {
        return selfies.size();
    }

    @Override
    public Object getItem(int position) {
        return selfies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public List<Selfie> getSelfiesList(){
        return selfies;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) view = ((Activity)ctx).getLayoutInflater().inflate(R.layout.selfie_item, null);

        TextView selfieName= (TextView) view.findViewById(R.id.photo_name);
        TextView selfieDayWeek= (TextView) view.findViewById(R.id.day_week);
        TextView selfieDate= (TextView) view.findViewById(R.id.photo_date);
        Selfie selfie=selfies.get(position);
        selfieName.setText(selfie.getName());
        selfieDayWeek.setText(" "+selfie.getDayWeek());
        selfieDate.setText(selfie.getDatetime().toString());

        return view;
    }
}