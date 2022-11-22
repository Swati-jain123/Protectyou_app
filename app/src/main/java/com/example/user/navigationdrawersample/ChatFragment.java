package com.example.user.navigationdrawersample;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ChatFragment extends Fragment {
    View view;
    ImageButton phone,call,call1;
     EditText et;
    TextView tt,tt1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_chat_layout,container,false);

        phone=(ImageButton) view.findViewById(R.id.bt_call);
         et=(EditText)view.findViewById(R.id.et_number);
         tt=(TextView)view.findViewById(R.id.et_number1);
         call=(ImageButton)view.findViewById(R.id.bt_call1);
        tt1=(TextView)view.findViewById(R.id.et_number2);
        call1=(ImageButton)view.findViewById(R.id.bt_call2);
        if(ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.CALL_PHONE

            },100);
        }


        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data=et.getText().toString();
                if(data.isEmpty()){
                    Toast.makeText(getActivity(),"Please Enter Number",Toast.LENGTH_LONG).show();
                }
                else {

                    String s = "tel:" + data;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    startActivity(intent);
                }

            }
        });
        call.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String d = "tel:" + "100";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(d));
                startActivity(intent);
            }
        });
        call1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String d = "tel:" + "101";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(d));
                startActivity(intent);
            }
        });

        return view;
    }
}
