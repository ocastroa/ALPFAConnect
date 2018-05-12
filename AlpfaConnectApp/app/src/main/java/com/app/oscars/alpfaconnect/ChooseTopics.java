package com.app.oscars.alpfaconnect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseTopics extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_topics);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bDone:
                Intent intent = new Intent(ChooseTopics.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}