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

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EditText;

public class PhoneEditText extends EditText {
  public PhoneEditText(final Context context) {
    super(context);
    initialize(null, 0, 0);
  }

  public PhoneEditText(final Context context, final AttributeSet attrs) {
    super(context, attrs);
    initialize(attrs, 0, 0);
  }

  public PhoneEditText(final Context context, final AttributeSet attrs, final int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    initialize(attrs, defStyleAttr, 0);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public PhoneEditText(final Context context, final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    initialize(attrs, defStyleAttr, defStyleRes);
  }

  private void initialize(final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
    final TypedArray array =
        getContext().obtainStyledAttributes(attrs, R.styleable.PhoneEditText, defStyleAttr, defStyleRes);
    initializeFromTypedArray(array);
    array.recycle();
  }

  private void initializeFromTypedArray(final TypedArray array) {
    final FormatParameters parameters = FormatParameters.newBuilder()
        .region(array.getString(R.styleable.PhoneEditText_cmm_region))
        .build();
    CallMeMaybe.attachTo(this, parameters);
  }
}
