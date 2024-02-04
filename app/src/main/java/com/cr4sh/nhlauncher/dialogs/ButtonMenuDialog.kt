package com.cr4sh.nhlauncher.dialogs

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialogFragment
import com.cr4sh.nhlauncher.MainActivity
import com.cr4sh.nhlauncher.R
import com.cr4sh.nhlauncher.utils.DialogUtils
import com.cr4sh.nhlauncher.utils.MainUtils
import com.cr4sh.nhlauncher.utils.NHLPreferences
import com.cr4sh.nhlauncher.utils.ToastUtils.showCustomToast
import com.cr4sh.nhlauncher.utils.VibrationUtils.vibrate
import java.util.Locale
import java.util.Objects

class ButtonMenuDialog(private var myActivity: MainActivity) : AppCompatDialogFragment() {
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.button_menu_dialog, container, false)
        val mainUtils = MainUtils(myActivity)
        val nhlPreferences = NHLPreferences(myActivity)
        val bkg = view.findViewById<LinearLayout>(R.id.custom_theme_dialog_background)
        val title = view.findViewById<TextView>(R.id.dialog_title)
        val description = view.findViewById<TextView>(R.id.dialog_description)
        val option1 = view.findViewById<Button>(R.id.option1)
        val option2 = view.findViewById<Button>(R.id.option2)
        val option3 = view.findViewById<Button>(R.id.option3)
        val option4 = view.findViewById<Button>(R.id.option4)
        val cancelButton = view.findViewById<Button>(R.id.cancel_button)
        val dialogUtils = DialogUtils(requireActivity().supportFragmentManager)

        // Apply custom themes
        bkg.setBackgroundColor(Color.parseColor(nhlPreferences.color20()))
        title.setTextColor(Color.parseColor(nhlPreferences.color80()))
        description.setTextColor(Color.parseColor(nhlPreferences.color50()))
        option1.setBackgroundColor(Color.parseColor(nhlPreferences.color50()))
        option1.setTextColor(Color.parseColor(nhlPreferences.color80()))
        option1.setTextColor(Color.parseColor(nhlPreferences.color80()))
        option2.setTextColor(Color.parseColor(nhlPreferences.color80()))
        option2.setBackgroundColor(Color.parseColor(nhlPreferences.color50()))
        option3.setTextColor(Color.parseColor(nhlPreferences.color80()))
        option3.setBackgroundColor(Color.parseColor(nhlPreferences.color50()))
        option4.setTextColor(Color.parseColor(nhlPreferences.color80()))
        option4.setBackgroundColor(Color.parseColor(nhlPreferences.color50()))
        cancelButton.setBackgroundColor(Color.parseColor(nhlPreferences.color80()))
        cancelButton.setTextColor(Color.parseColor(nhlPreferences.color50()))
        title.text = Objects.requireNonNull(myActivity.buttonName).uppercase(Locale.getDefault())
        description.text =
            (Objects.requireNonNull(myActivity.buttonDescription).uppercase(Locale.getDefault())
                ?: option1.setOnClickListener { view1: View? ->
                    vibrate(myActivity, 10)
                    dialogUtils.openEditableDialog(myActivity.buttonName, myActivity.buttonCmd)
                    Objects.requireNonNull(dialog).cancel()
                }) as CharSequence?
        option2.setOnClickListener { view12: View? ->
            vibrate(myActivity, 10)
            mainUtils.addFavourite()
            Objects.requireNonNull(dialog).cancel()
        }
        option3.setOnClickListener {
            vibrate(myActivity, 10)
            if (!MainActivity.disableMenu) {
                dialogUtils.openNewToolDialog(myActivity.buttonCategory)
            } else {
                showCustomToast(requireActivity(), resources.getString(R.string.get_out))
            }
            Objects.requireNonNull(dialog).cancel()
        }
        option4.setOnClickListener {
            vibrate(myActivity, 10)
            dialogUtils.openDeleteToolDialog(myActivity.buttonName)
            Objects.requireNonNull(dialog).cancel()
        }
        cancelButton.setOnClickListener {
            vibrate(myActivity, 10)
            Objects.requireNonNull(dialog).cancel()
        }
        return view
    }
}