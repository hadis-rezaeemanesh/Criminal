package com.example.criminal.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.criminal.controller.fragment.CrimeDetailFragment;

import java.util.UUID;

public class CrimeDetailActivity extends SingleFragmentActivity {

    public static final String EXTRA_CRIME_ID = "com.example.criminal.crimeId";
    public static final String ARGS_CRIME_ID = "crimeId";

    /**
     * intent for start CrimeDetailActivity with extra
     * the coresponding crime detail in this Activity
     * @param context  src object of context for intent
     * @param crimeId  extra needed for this activity to work properly. id of the crime.
     * @return  the new intent for starting this activity properly.
     */

    public static Intent newIntent(Context context, UUID crimeId){
        Intent intent = new Intent(context, CrimeDetailActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

    @Override
    public Fragment createFragment() {
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);

       /* CrimeDetailFragment crimeDetailFragment = new CrimeDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARGS_CRIME_ID, crimeId);
        crimeDetailFragment.setArguments(args);*/
       CrimeDetailFragment crimeDetailFragment = CrimeDetailFragment.newInstance(crimeId);
        return crimeDetailFragment;
    }
}