package com.akvone.dlcifmo.EnrollModule;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.akvone.dlcifmo.R;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EnrollDatePickerFragment extends DialogFragment implements  DatePickerDialog.OnDateSetListener{

    private OnFragmentInteractionListener mListener;

    public EnrollDatePickerFragment() {
        // Required empty public constructor
    }

    public void setListener(OnFragmentInteractionListener mListener) {
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // создаем DatePickerDialog и возвращаем его

        DatePickerDialog picker = new DatePickerDialog(getActivity(), R.style.DialogTheme, this,
                year, month, day);

        return picker;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Calendar today = new GregorianCalendar();
        Calendar date = new GregorianCalendar(year, monthOfYear, dayOfMonth);
        if (today.after(date)){
            Toast.makeText(getContext(), "Нельзя выбрать прошедшую дату.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mListener != null) {
            mListener.sendDate(dayOfMonth, monthOfYear, year);

        }
    }

}
