package com.example.m.myapplication;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by m on 2016-06-20.
 */
public class TitlesFragment extends ListFragment {

    ArrayAdapter<String>adapter;
boolean mDue = false;
    int czySave = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_activated_2,SuperHeroes.HEROES);
        setListAdapter(adapter);
        View widok = getActivity().findViewById(R.id.details);
        mDue=(widok!=null)&&(widok.getVisibility()==View.VISIBLE);
        if(savedInstanceState!=null){

            czySave=savedInstanceState.getInt("curChoice",0);

        }
        if(mDue){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(czySave);




        }



    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice",czySave);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        showDetails(position);
    }

    private void showDetails(int czySave2) {
        czySave=czySave2;
        if(mDue){
            getListView().setItemChecked(czySave2,true);
                DetailsFragment details = (DetailsFragment)getFragmentManager().findFragmentById(R.id.details);
                     if(details==null||details.getShowIndex()!=czySave2){
                         details=DetailsFragment.newInstance(czySave2);
                         FragmentTransaction ft = getFragmentManager().beginTransaction();
                         ft.replace(R.id.details,details);
                         ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                         ft.commit();
                     }
            else{

                         Intent intent = new Intent();
                         intent.setClass(getActivity(),DetailsActivity.class);
                         intent.putExtra("index",czySave2);
                         startActivity(intent);

                     }

        }




    }
}
