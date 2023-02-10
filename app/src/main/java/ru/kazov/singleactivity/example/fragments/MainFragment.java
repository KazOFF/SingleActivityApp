package ru.kazov.singleactivity.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ru.kazov.singleactivity.SAFragment;
import ru.kazov.singleactivity.example.MainActivity;
import ru.kazov.singleactivity.example.R;


public class MainFragment extends SAFragment {

    public MainFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_main, container, false);

        TextView textView = view.findViewById(R.id.tv_num);
        textView.setText("FragmentManager stack size: "+((MainActivity) getContext()).getSupportFragmentManager().getBackStackEntryCount());


        Button bt_add_noanim = view.findViewById(R.id.bt_add_noanim);
        bt_add_noanim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragmentNoAnimation(new MainFragment());
            }
        });

        Button bt_add = view.findViewById(R.id.bt_add);
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(new MainFragment());
            }
        });

        Button bt_addAnim = view.findViewById(R.id.bt_add_anim);
        bt_addAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(new MainFragment(), R.anim.rotate_clock, 0, R.anim.rotate_anticlock, 0);
            }
        });

        Button bt_replace_noanim = view.findViewById(R.id.bt_replace_noanim);
        bt_replace_noanim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragmentNoAnimation(new MainFragment());
            }
        });

        Button bt_replace = view.findViewById(R.id.bt_replace);
        bt_replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new MainFragment());
            }
        });

        Button bt_replace_anim = view.findViewById(R.id.bt_replace_anim);
        bt_replace_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new MainFragment(), R.anim.rotate_clock, 0, R.anim.rotate_anticlock, 0);
            }
        });


        return view;
    }
}