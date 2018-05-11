package com.app.oscars.alpfaconnect;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by oscar on 1/6/2017.
 * Creates the second tab fragment
 */

public class tab_fragment_three extends Fragment implements View.OnClickListener {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(com.app.oscars.alpfaconnect.R.layout.tab_fragment_three, container, false);

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
