package com.cr4sh.nhlauncher.dialogs;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.cr4sh.nhlauncher.DBHandler;
import com.cr4sh.nhlauncher.DialogUtils;
import com.cr4sh.nhlauncher.Item;
import com.cr4sh.nhlauncher.MainActivity;
import com.cr4sh.nhlauncher.MainUtils;
import com.cr4sh.nhlauncher.MyPreferences;
import com.cr4sh.nhlauncher.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ButtonMenuDialog extends AppCompatDialogFragment {

    MainActivity myActivity;

    public ButtonMenuDialog(MainActivity activity) {
        this.myActivity = activity;
    }
    @SuppressLint("SetTextI18n")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.button_menu_dialog, container, false);

        MainUtils mainUtils = new MainUtils(myActivity);
        MyPreferences myPreferences = new MyPreferences(myActivity);

        LinearLayout bkg = view.findViewById(R.id.custom_theme_dialog_background);
        TextView title = view.findViewById(R.id.dialog_title);
        Button option1 = view.findViewById(R.id.option1);
        Button option2 = view.findViewById(R.id.option2);
        Button option3 = view.findViewById(R.id.option3);
        Button option4 = view.findViewById(R.id.option4);
        Button cancelButton = view.findViewById(R.id.cancel_button);
        DialogUtils dialogUtils = new DialogUtils(requireActivity().getSupportFragmentManager());

        // Apply custom themes
        bkg.setBackgroundColor(Color.parseColor(myPreferences.color20()));
        title.setTextColor(Color.parseColor(myPreferences.color80()));

        option1.setBackgroundColor(Color.parseColor(myPreferences.color50()));
        option1.setTextColor(Color.parseColor(myPreferences.color80()));
        option1.setTextColor(Color.parseColor(myPreferences.color80()));
        option2.setTextColor(Color.parseColor(myPreferences.color80()));
        option2.setBackgroundColor(Color.parseColor(myPreferences.color50()));
        option3.setTextColor(Color.parseColor(myPreferences.color80()));
        option3.setBackgroundColor(Color.parseColor(myPreferences.color50()));
        option4.setTextColor(Color.parseColor(myPreferences.color80()));
        option4.setBackgroundColor(Color.parseColor(myPreferences.color50()));

        cancelButton.setBackgroundColor(Color.parseColor(myPreferences.color80()));
        cancelButton.setTextColor(Color.parseColor(myPreferences.color50()));


        title.setText(myActivity.buttonName.toUpperCase() + " " + requireActivity().getResources().getString(R.string.options).toUpperCase());

        option1.setOnClickListener(view1 -> {
            dialogUtils.openEditableDialog(myActivity.buttonName, myActivity.buttonCmd);
            Objects.requireNonNull(getDialog()).cancel();
        });

        option2.setOnClickListener(view12 -> {
            mainUtils.addFavourite();
            Objects.requireNonNull(getDialog()).cancel();
        });

        option3.setOnClickListener(view1 -> {
            if (!MainActivity.disableMenu) {
                dialogUtils.openNewToolDialog(myActivity.buttonCategory);
            } else {
                Toast.makeText(myActivity, getResources().getString(R.string.get_out), Toast.LENGTH_SHORT).show();
            }
            Objects.requireNonNull(getDialog()).cancel();
        });

        option4.setOnClickListener(view1 -> {
            dialogUtils.openDeleteToolDialog(myActivity.buttonName);
            Objects.requireNonNull(getDialog()).cancel();
        });

        cancelButton.setOnClickListener(view1 -> Objects.requireNonNull(getDialog()).cancel());

        return view;

    }
}
