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

public class SecondFragment extends Fragment {

    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.second_fragment_layout,
                container, false);

        button = view.findViewById(R.id.second_fragment_button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (button.isEnabled()){
                    button.setEnabled(false);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    ThirdFragment threeButtonsFragment = new ThirdFragment();
                    fragmentTransaction.add(R.id.second_fragment_container2, threeButtonsFragment);
                    fragmentTransaction.commit();
                }
            }
        });

        return view;
    }
}
