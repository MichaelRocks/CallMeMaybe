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

import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;

class AsYouTypeFormatter {
  private io.michaelrocks.libphonenumber.android.AsYouTypeFormatter formatter;

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
