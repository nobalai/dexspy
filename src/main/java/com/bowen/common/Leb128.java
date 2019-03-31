package com.bowen.common;

public final class Leb128 {

  private Leb128() {}

  /**
   * Gets the number of bytes in the unsigned LEB128 encoding of the given value.
   *
   * @param value the value in question
   * @return its write size in bytes
   */
  public static int unsignedLeb128Size(int value) {
    int count = 0;
    int remaining = value;
  
    do {
      remaining >>= 7;
      count++;
    } while (remaining != 0);
  
    return count;
  }

  /**
   * Gets the number of bytes in the signed LEB128 encoding of the given value.
   * 
   * @param value the value in question
   * @return its write size in bytes
   */
  public static int signedLeb128Size(int value) {
    int remaining = value >> 7;
    int count = 0;
    boolean hasMore = true;
    int end = ((value & Integer.MIN_VALUE) == 0) ? 0 : -1;

    while (hasMore) {
        hasMore = (remaining != end)
            || ((remaining & 1) != ((value >> 6) & 1));
        value = remaining;
        remaining >>= 7;
        count++;
    }

    return count;
  }

}
