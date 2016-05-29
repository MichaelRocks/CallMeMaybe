/*
 * Copyright 2016 Michael Rozumyanskiy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.michaelrocks.callmemaybe;

import android.text.Selection;
import android.text.SpannableStringBuilder;

import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;

class PhoneStringBuilder extends SpannableStringBuilder {
  private final PhoneFormatter phoneFormatter;

  public PhoneStringBuilder(final PhoneNumberUtil phoneNumberUtil, final CharSequence source,
      final FormatParameters parameters) {
    this(source, new PhoneFormatter(phoneNumberUtil, parameters));
  }

  PhoneStringBuilder(final CharSequence text, final PhoneFormatter phoneFormatter) {
    this.phoneFormatter = phoneFormatter;
    replace(0, length(), text);
  }

  @Override
  public SpannableStringBuilder delete(final int start, final int end) {
     if (containsDigits(start, end)) {
      return super.delete(start, end);
    }

    final int firstDigitPosition = Math.max(0, indexOfLastDigit(0, start));
    return super.delete(firstDigitPosition, end);
  }

  @Override
  public SpannableStringBuilder replace(final int start, final int end, final CharSequence text,
      final int textStart, final int textEnd) {
    phoneFormatter.format(this, start, end, text, textStart, textEnd);
    final CharSequence phoneNumber = phoneFormatter.getFormattedPhone();
    final SpannableStringBuilder result = super.replace(0, length(), phoneNumber, 0, phoneNumber.length());
    final int selection = phoneFormatter.getSelection();
    if (selection != -1) {
      Selection.setSelection(result, selection);
    }
    return result;
  }

  private boolean containsDigits(final int start, final int end) {
    int offset = start;
    while (offset < end) {
      final int codePoint = Character.codePointAt(this, offset);
      if (Character.isDigit(codePoint)) {
        return true;
      }
      offset += Character.charCount(codePoint);
    }
    return false;
  }

  private int indexOfLastDigit(final int start, final int end) {
    int offset = end;
    while (offset > start) {
      final int codePoint = Character.codePointBefore(this, offset);
      offset -= Character.charCount(codePoint);
      if (Character.isDigit(codePoint)) {
        return offset;
      }
    }
    return -1;
  }
}
