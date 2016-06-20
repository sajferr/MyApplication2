package com.example.m.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by m on 2016-06-20.
 */
public class DetailsFragment extends Fragment {

    public  static DetailsFragment  newInstance (int index){

        DetailsFragment details = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt("index",index);
        details.setArguments(args);
return details;
    };

    public int getShowIndex() {
     return getArguments().getInt("index",0);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ScrollView skrol = new ScrollView(getActivity());
        TextView tekst = new TextView(getActivity());
       int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,4,getActivity().getResources().getDisplayMetrics());
tekst.setPadding(padding,padding,padding,padding);
skrol.addView(tekst);
        tekst.setText(SuperHeroes.HISTORY[getShowIndex()]);
        return skrol;
    }
}
