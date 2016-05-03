package io.michaelrocks.callme;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;

class PhoneFormatter {
  private final SpannableStringBuilder buffer = new SpannableStringBuilder();
  private final AsYouTypeFormatter asYouTypeFormatter;

  public PhoneFormatter() {
    this(new AsYouTypeFormatter());
  }

  public PhoneFormatter(final AsYouTypeFormatter asYouTypeFormatter) {
    this.asYouTypeFormatter = asYouTypeFormatter;
  }

  public CharSequence getFormattedPhone() {
    return buffer;
  }

  public int getSelection() {
    return Selection.getSelectionStart(buffer);
  }

  public void format(final Editable to, final int toStart, final int toEnd, final CharSequence from,
      final int fromStart, final int fromEnd) {
    final int selectionStart = Selection.getSelectionStart(to);
    final int selectionEnd = Selection.getSelectionStart(to);

    buffer.clear();
    buffer.append(to);
    if (selectionStart != -1 && selectionEnd != -1) {
      Selection.setSelection(buffer, selectionStart, selectionEnd);
    }
    buffer.replace(toStart, toEnd, from, fromStart, fromEnd);

    if (!TextUtils.isGraphic(buffer)) {
      return;
    }

    formatPhoneNumberInput(buffer);
  }

  private void formatPhoneNumberInput(final Editable input) {
    final int selection = Selection.getSelectionStart(buffer);
    boolean selectionPositionRemembered = false;

    asYouTypeFormatter.clear();
    String phoneNumberText = asYouTypeFormatter.inputDigit('+');

    int offset = 0;
    final int length = input.length();
    while (offset < length) {
      final int codePoint = Character.codePointAt(input, offset);
      if (Character.isDigit(codePoint)) {
        final char digit = CodePoint.toDigitChar(codePoint);
        selectionPositionRemembered = selectionPositionRemembered || offset >= selection;
        phoneNumberText = asYouTypeFormatter.inputDigit(digit, !selectionPositionRemembered);
      }
      offset += Character.charCount(codePoint);
    }

    input.replace(0, input.length(), phoneNumberText);
    if (selection != -1) {
      Selection.setSelection(input,
          selectionPositionRemembered ? asYouTypeFormatter.getRememberedPosition() : phoneNumberText.length());
    }
  }
}
