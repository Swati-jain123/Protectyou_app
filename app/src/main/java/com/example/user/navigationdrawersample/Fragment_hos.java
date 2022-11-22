package com.example.user.navigationdrawersample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Fragment_hos extends Fragment {
    private ImageView maphos;
    FragmentManager fragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hos, container, false);
//        FragmentTransaction tx= fragmentManager.beginTransaction();
//        tx.replace(R.id.framelayout_id,new MessageFragment()).addToBackStack(null).commit();
        maphos= view.findViewById(R.id.maphos);
        maphos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });
        return view;

    }
    private void openMap() {
        Uri uri= Uri.parse("geo:0,0?q= Near by Hospital");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

}

