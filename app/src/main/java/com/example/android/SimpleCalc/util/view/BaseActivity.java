package com.example.android.SimpleCalc.util.view;

import android.annotation.SuppressLint;
import android.widget.Toast;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    private static final int TOAST_LENGTH_DEFAULT = Toast.LENGTH_SHORT;

    protected void showToast(@StringRes final int messageRes) {
        showToast(messageRes, TOAST_LENGTH_DEFAULT);
    }

    protected void showToast(final String message) {
        showToast(message, TOAST_LENGTH_DEFAULT);
    }

    protected void showToast(@StringRes final int messageRes, final int length) {
        showToast(getString(messageRes), length);
    }

    protected void showToast(final String message, final int length) {
        Toast.makeText(this, message, length).show();
    }
}
