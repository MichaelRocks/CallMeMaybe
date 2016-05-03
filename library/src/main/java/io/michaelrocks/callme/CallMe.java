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

package io.michaelrocks.callme;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

public class CallMe {
  private CallMe() {
    // Nothing to do.
  }

  public static void applyTo(final TextView textView) {
    textView.setInputType(EditorInfo.TYPE_CLASS_PHONE);
    textView.setEditableFactory(new Editable.Factory() {
      @Override
      public Editable newEditable(final CharSequence source) {
        return new PhoneStringBuilder(source);
      }
    });
  }
}
