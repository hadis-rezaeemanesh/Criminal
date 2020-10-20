package com.example.criminal.controller.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.example.criminal.R;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatePickerFragment extends DialogFragment {

    public static final String ARGS_CRIME_DATE = "crimeDate";
    public static final String EXTRA_USER_SELECTED_DATE = "com.example.criminal.userSelectedDate";
    private Date mCrimeDate;

    private DatePicker mDatePicker;

    public DatePickerFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DatePickerFragment newInstance(Date crimeDate) {
        DatePickerFragment fragment = new DatePickerFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARGS_CRIME_DATE, crimeDate);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrimeDate = (Date) getArguments().getSerializable(ARGS_CRIME_DATE);
    }



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view = inflater.inflate(R.layout.fragment_date_picker, null);
        findViews(view);
        initViews();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle(R.string.date_picker_title)
                .setIcon(R.mipmap.ic_launcher)
                .setView(view)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Date userSelectedDate = extractDateFromDatePicker();

                        sendResult(userSelectedDate);

                        /*Fragment fragment = getTargetFragment();
                        if (fragment != null && fragment instanceof CrimeDetailFragment){
                            CrimeDetailFragment crimeDetailFragment = (CrimeDetailFragment) fragment;

                            crimeDetailFragment.updateCrimeDate(userSelectedDate);
                        }*/
                    }
                });

        AlertDialog dialog = builder.create();
        return dialog;


    }

    private void findViews(View view) {
        mDatePicker = view.findViewById(R.id.date_picker_crime);
    }

    private void initViews(){
        initDatePicker();

    }

    private void initDatePicker() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mCrimeDate);
        int year = calendar.get(calendar.YEAR);
        int monthOfYear = calendar.get(calendar.MONTH);
        int dayOFMonth = calendar.get(calendar.DAY_OF_MONTH);
        mDatePicker.init(year, monthOfYear, dayOFMonth, null);
    }

    private Date extractDateFromDatePicker() {
        int year = mDatePicker.getYear();
        int month = mDatePicker.getMonth();
        int dayOfMonth = mDatePicker.getDayOfMonth();
        GregorianCalendar calendar = new GregorianCalendar(year, month, dayOfMonth);
        return calendar.getTime();
    }

    private void sendResult(Date userSelectedDate){

        Fragment fragment = getTargetFragment();
        int requestCode = getTargetRequestCode();
        int resultCode = Activity.RESULT_OK;
        Intent intent = new Intent();
        intent.putExtra(EXTRA_USER_SELECTED_DATE, userSelectedDate);

        fragment.onActivityResult(requestCode, resultCode, intent );
    }
}