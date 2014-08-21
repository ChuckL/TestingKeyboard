package com.harms.johnathan.testingkeyboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.android.testingkeyboard.R;

public class SoftKeyboard extends InputMethodService
        implements KeyboardView.OnKeyboardActionListener {

    private InputMethodManager mInputMethodManager;

    private KeyboardView inputView;
    private TestingKeyboard testingKeyboard;

    @Override
    public void onCreate() {
        super.onCreate();
        mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
    }

    @Override public void onFinishInput() {
        super.onFinishInput();

        if (inputView != null) {
            inputView.closing();
        }
    }

    @Override
    public void onInitializeInterface() {
        testingKeyboard = new TestingKeyboard(this, R.xml.testing);
    }

    @Override
    public View onCreateInputView() {
        inputView = (KeyboardView) getLayoutInflater().inflate(
                R.layout.input, null);
        inputView.setPreviewEnabled(false);
        inputView.setOnKeyboardActionListener(this);
        inputView.setKeyboard(testingKeyboard);
        return inputView;
    }

    /**
     * Helper method for displaying the input method picker
     */
    private void showInputMethodPicker() {
        if (mInputMethodManager != null) {
            mInputMethodManager.showInputMethodPicker();
        }
    }

    // Implementation of KeyboardViewListener

    @Override
    public void onPress(int primaryCode) {

    }

    @Override
    public void onRelease(int primaryCode) {

    }

    public void onKey(int primaryCode, int[] keyCodes) {
        if (primaryCode == Keyboard.KEYCODE_MODE_CHANGE
                && inputView != null) {
            showInputMethodPicker();
        }
    }

    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}
