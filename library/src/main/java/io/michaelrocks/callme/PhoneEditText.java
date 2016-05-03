package io.michaelrocks.callme;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

public class PhoneEditText extends EditText {
  public PhoneEditText(final Context context) {
    super(context);
  }

  public PhoneEditText(final Context context, final AttributeSet attrs) {
    super(context, attrs);
  }

  public PhoneEditText(final Context context, final AttributeSet attrs, final int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public PhoneEditText(final Context context, final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }

  {
    CallMe.applyTo(this);
  }
}
