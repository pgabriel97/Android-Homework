package com.example.tema_1_fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ThirdFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_fragment_layout,
                container, false);

        Button replaceButton = view.findViewById(R.id.replace_button);
        Button removeButton = view.findViewById(R.id.remove_button);
        Button closeButton = view.findViewById(R.id.close_button);

        replaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FinalFragment emptyFragment = new FinalFragment();
                fragmentTransaction.replace(R.id.second_fragment_container2, emptyFragment);
                fragmentTransaction.commit();
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                SecondFragment fragmentToRemove =
                        (SecondFragment) getActivity().getSupportFragmentManager().
                                findFragmentById(R.id.second_fragment_container1);

                if (fragmentToRemove != null)
                    fragmentTransaction.remove(fragmentToRemove);
                fragmentTransaction.commit();
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finishAffinity();
            }
        });
        return view;
    }
}
