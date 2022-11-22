package com.example.user.navigationdrawersample;

import android.graphics.drawable.AdaptiveIconDrawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.xmlpull.v1.XmlPullParser;

public class MessageFragment extends Fragment {
    private int intLayout=1;

    View view;
    Button callfragment,gpsfragment,mobilefragment,hospital,about;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_message_layout,container,false);
        callfragment=(Button)view.findViewById(R.id.firstbutton);
        gpsfragment=(Button)view.findViewById(R.id.secondbutton);
        mobilefragment=(Button)view.findViewById(R.id.thirdbutton);
        hospital=(Button)view.findViewById(R.id.fourthbutton);
        about=(Button)view.findViewById(R.id.aboutbutton);
        // et=(EditText)view.findViewById(R.id.et_number);
        callfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int intLayout = 2;
                if(view.getId()==R.id.firstbutton){
                    Fragment ft=new Fragment();
                    FragmentTransaction fm= getActivity().getSupportFragmentManager().beginTransaction();
                    fm.replace(R.id.framelayout_id, new ChatFragment()).addToBackStack(null).commit();
                    callfragment.setVisibility(View.GONE);
                }

            }
        });
        gpsfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.secondbutton){
                    Fragment ft=new Fragment();
                    FragmentTransaction fm= getActivity().getSupportFragmentManager().beginTransaction();
                    fm.replace(R.id.framelayout_id, new NotebooksFragment()).addToBackStack(null).commit();
                    gpsfragment.setVisibility(View.GONE);
                }

            }
        });
        mobilefragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.thirdbutton){
                    Fragment ft=new Fragment();
                    FragmentTransaction fm= getActivity().getSupportFragmentManager().beginTransaction();
                    fm.replace(R.id.framelayout_id, new SettingsFragment()).addToBackStack(null).commit();
                    mobilefragment.setVisibility(View.GONE);
                }

            }
        });
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.fourthbutton){
                    Fragment ft=new Fragment();
                    FragmentTransaction fm= getActivity().getSupportFragmentManager().beginTransaction();
                    fm.replace(R.id.framelayout_id, new Fragment_hos()).addToBackStack(null).commit();
                    hospital.setVisibility(View.GONE);
                }

            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.aboutbutton){
                    Fragment ft=new Fragment();
                    FragmentTransaction fm= getActivity().getSupportFragmentManager().beginTransaction();
                    fm.replace(R.id.framelayout_id, new ProfileFragment()).addToBackStack(null).commit();
                    about.setVisibility(View.GONE);
                }

            }
        });


        return view;
    }


}
