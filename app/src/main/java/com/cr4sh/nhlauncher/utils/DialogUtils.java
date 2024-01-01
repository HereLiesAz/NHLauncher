package com.cr4sh.nhlauncher.utils;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.FragmentManager;

import com.cr4sh.nhlauncher.BluetoothPager.BluetoothFragment1;
import com.cr4sh.nhlauncher.MainActivity;
import com.cr4sh.nhlauncher.NHLManager;
import com.cr4sh.nhlauncher.WPSAttack;
import com.cr4sh.nhlauncher.dialogs.AppsDialog;
import com.cr4sh.nhlauncher.dialogs.ButtonMenuDialog;
import com.cr4sh.nhlauncher.dialogs.DeleteToolDialog;
import com.cr4sh.nhlauncher.dialogs.EditableDialog;
import com.cr4sh.nhlauncher.dialogs.FirstSetupDialog;
import com.cr4sh.nhlauncher.dialogs.MissingActivityDialog;
import com.cr4sh.nhlauncher.dialogs.NewToolDialog;
import com.cr4sh.nhlauncher.dialogs.NhlColorPickerDialog;
import com.cr4sh.nhlauncher.dialogs.PermissionDialog;
import com.cr4sh.nhlauncher.dialogs.ScanTimeDialog;
import com.cr4sh.nhlauncher.dialogs.ThrottlingDialog;
import com.cr4sh.nhlauncher.dialogs.WpsCustomPinDialog;

// This class creates and opens Dialogs
public class DialogUtils {

    private final FragmentManager fragmentManager;
    private final MainActivity mainActivity = NHLManager.getInstance().getMainActivity();

    public DialogUtils(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void openEditableDialog(String name, String cmd) {
        mainActivity.executor.execute(() -> {
            EditableDialog editableDialog = new EditableDialog();
            // Input as an argument.
            Bundle args = new Bundle();
            args.putString("name", name);
            args.putString("cmd", cmd);
            editableDialog.setArguments(args);
            // Display our dialog!
            editableDialog.show(fragmentManager, "EditableDialog");
        });
    }


    public void openNewToolDialog(String category) {
        mainActivity.executor.execute(() -> {
            NewToolDialog ntDialog = new NewToolDialog();
            // ARGS!
            Bundle args = new Bundle();
            args.putString("category", category);
            ntDialog.setArguments(args);
            // Display our dialog!
            ntDialog.show(fragmentManager, "NewToolDialog");
        });
    }

    public void openDeleteToolDialog(String name) {
        mainActivity.executor.execute(() -> {
            DeleteToolDialog dtDialog = new DeleteToolDialog();
            // ARGS!
            Bundle args = new Bundle();
            args.putString("name", name);
            dtDialog.setArguments(args);
            // Display our dialog!
            dtDialog.show(fragmentManager, "DeleteToolDialog");
        });
    }

    public void openAppsDialog() {
        mainActivity.executor.execute(() -> {
            AppsDialog apDialog = new AppsDialog();
            // Display our dialog!
            apDialog.show(fragmentManager, "AppsDialog");
        });
    }

    public void openFirstSetupDialog() {
        mainActivity.executor.execute(() -> {
            FirstSetupDialog fsDialog = new FirstSetupDialog();
            // Display our dialog!
            fsDialog.show(fragmentManager, "FirstSetupDialog");
        });
    }


    public void openPermissionsDialog() {
        mainActivity.executor.execute(() -> {
            PermissionDialog pmDialog = new PermissionDialog();
            // Display our dialog!
            pmDialog.show(fragmentManager, "PermissionsDialog");
        });
    }


    public void openMissingActivityDialog() {
        mainActivity.executor.execute(() -> {
            MissingActivityDialog maDialog = new MissingActivityDialog();
            // Display our dialog!
            maDialog.show(fragmentManager, "MissingActivityDialog");
        });
    }

    public void openButtonMenuDialog(MainActivity myActivity) {
        mainActivity.executor.execute(() -> {
            ButtonMenuDialog bmDialog = new ButtonMenuDialog(myActivity);
            // ARGS!
//            Bundle args = new Bundle();
//            args.putString("category", category);
//            bmDialog.setArguments(args);
            // Display our dialog!
            bmDialog.show(fragmentManager, "ButtonMenuDialog");
        });
    }


    public void openNhlColorPickerDialog(Button button, ImageView alpha, String colorShade) {
        mainActivity.executor.execute(() -> {
            NhlColorPickerDialog nhlcpDialog = new NhlColorPickerDialog(button, alpha, colorShade);
            // Display our dialog!
            nhlcpDialog.show(fragmentManager, "NhlColorPickerDialog");
        });
    }

    public void openThrottlingDialog() {
        mainActivity.executor.execute(() -> {
            ThrottlingDialog thDialog = new ThrottlingDialog();
            // Display our dialog!
            thDialog.show(fragmentManager, "PermissionsDialog");
        });
    }

    public void openWpsCustomSetting(int number, WPSAttack activity) {
        mainActivity.executor.execute(() -> {
            WpsCustomPinDialog pinDialog = new WpsCustomPinDialog(activity);
            Bundle args = new Bundle();
            args.putInt("option", number);
            pinDialog.setArguments(args);
            // Display our dialog!
            pinDialog.show(fragmentManager, "PermissionsDialog");
        });
    }

    public void openScanTimeDialog(int number, BluetoothFragment1 activity) {
        mainActivity.executor.execute(() -> {
            ScanTimeDialog pinDialog = new ScanTimeDialog(activity);
            Bundle args = new Bundle();
            args.putInt("option", number);
            pinDialog.setArguments(args);
            // Display our dialog!
            pinDialog.show(fragmentManager, "PermissionsDialog");
        });
    }
}