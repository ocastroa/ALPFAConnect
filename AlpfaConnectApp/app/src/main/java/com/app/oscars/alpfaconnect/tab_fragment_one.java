package com.app.oscars.alpfaconnect;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class tab_fragment_one extends Fragment implements View.OnClickListener {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(com.app.oscars.alpfaconnect.R.layout.tab_fragment_one, container, false);

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
