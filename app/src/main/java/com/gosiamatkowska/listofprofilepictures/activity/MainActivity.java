package com.gosiamatkowska.listofprofilepictures.activity;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gosiamatkowska.listofprofilepictures.fragment.ListFragment;
import com.gosiamatkowska.listofprofilepictures.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new ListFragment();
        getFragmentManager().beginTransaction()
                            .add(R.id.fragment_container, fragment)
                            .commit();
    }
}
