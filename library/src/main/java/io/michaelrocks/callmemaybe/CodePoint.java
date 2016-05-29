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

class CodePoint {
  private static final char[] chars = new char[] { 0, 0 };

  private CodePoint() {
    // Nothing to do.
  }

  public static char toDigitChar(final int codePoint) {
    final int digitCodePoint = Character.charCount(codePoint) == 1 ? codePoint : Character.digit(codePoint, 10);
    //noinspection ResultOfMethodCallIgnored
    Character.toChars(digitCodePoint, chars, 0);
    return chars[0];
  }
}
