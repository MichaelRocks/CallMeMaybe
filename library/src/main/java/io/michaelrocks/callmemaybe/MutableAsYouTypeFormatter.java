/*
 * Copyright 2017 Michael Rozumyanskiy
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

import android.text.TextUtils;

import io.michaelrocks.libphonenumber.android.AsYouTypeFormatter;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;

class MutableAsYouTypeFormatter {
  private final PhoneNumberUtil phoneNumberUtil;
  private String region;
  private AsYouTypeFormatter formatter;
  private boolean isEmpty = true;

  MutableAsYouTypeFormatter(final PhoneNumberUtil phoneNumberUtil) {
    this.phoneNumberUtil = phoneNumberUtil;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(final String region) {
    if (!TextUtils.equals(this.region, region)) {
      this.region = region;
      formatter = null;
      isEmpty = true;
    }
  }

  public int getRememberedPosition() {
    return getAsYouTypeFormatter().getRememberedPosition();
  }

  public void clear() {
    getAsYouTypeFormatter().clear();
    isEmpty = true;
  }

  public String inputDigit(final char nextChar) {
    return inputDigit(nextChar, false);
  }

  public String inputDigit(final char nextChar, final boolean rememberPosition) {
    final AsYouTypeFormatter formatter = getAsYouTypeFormatter();
    if (isEmpty && !isValidRegion()) {
      formatter.inputDigit('+');
    }

    isEmpty = false;

    if (rememberPosition) {
      return formatter.inputDigitAndRememberPosition(nextChar);
    } else {
      return formatter.inputDigit(nextChar);
    }
  }

  private AsYouTypeFormatter getAsYouTypeFormatter() {
    if (formatter == null) {
      formatter = phoneNumberUtil.getAsYouTypeFormatter(isValidRegion() ? region : "US");
    }
    return formatter;
  }

  private boolean isValidRegion() {
    return region != null;
  }
}
