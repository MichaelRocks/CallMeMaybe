package io.michaelrocks.callme;

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
