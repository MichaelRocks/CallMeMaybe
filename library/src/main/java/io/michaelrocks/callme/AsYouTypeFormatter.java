package io.michaelrocks.callme;

import com.google.i18n.phonenumbers.PhoneNumberUtil;

class AsYouTypeFormatter {
  private com.google.i18n.phonenumbers.AsYouTypeFormatter formatter;

  public AsYouTypeFormatter() {
    this(PhoneNumberUtil.getInstance());
  }

  public AsYouTypeFormatter(final PhoneNumberUtil phoneNumberUtil) {
    formatter = phoneNumberUtil.getAsYouTypeFormatter("US");
  }

  public int getRememberedPosition() {
    return formatter.getRememberedPosition();
  }

  public void clear() {
    formatter.clear();
  }

  public String inputDigit(final char nextChar) {
    return inputDigit(nextChar, false);
  }

  public String inputDigit(final char nextChar, final boolean rememberPosition) {
    if (rememberPosition) {
      return formatter.inputDigitAndRememberPosition(nextChar);
    } else {
      return formatter.inputDigit(nextChar);
    }
  }
}
