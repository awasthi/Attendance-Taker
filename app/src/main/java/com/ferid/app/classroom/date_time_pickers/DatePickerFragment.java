package com.ferid.app.classroom.date_time_pickers;

import android.app.DatePickerDialog;
import android.app.Dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import com.ferid.app.classroom.interfaces.BackNavigationListener;

import java.util.Calendar;

/**
 * Created by ferid.cafer on 5/7/2015.
 */
public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    private BackNavigationListener backNavigationListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        backNavigationListener = (BackNavigationListener) getActivity();

        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        if (backNavigationListener != null)
            backNavigationListener.OnPress(day, month, year);

        dismiss();
    }
}