package com.bowen.common;

import java.nio.ByteBuffer;

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

  /* Reads an unsigned integer from {@code buf}. */
  public static int readUnsignedLeb128(ByteBuffer buf) {
    int result = 0;
    int cur;
    int count = 0;

    do {
      cur = buf.get() & 0xff;
      result |= (cur & 0x7f) << (count * 7);
      count++;
    } while (((cur & 0x80) == 0x80) && count < 5);

    if ((cur & 0x80) == 0x80) {
      throw new RuntimeException("invalid LEB128 sequence.");
    }

    return result;
  }

  /* Reads an signed integer from {@code buf}. */
  public static int readSignedLeb128(ByteBuffer buf) {
    int result = 0;
    int cur;
    int count = 0;
    int signBits = -1;

    do {
      cur = buf.get() & 0xff;
      result |= (cur & 0x7f) << (count * 7);
      signBits <<= 7;
      count++;
    } while ((cur & 0x80) == 0x80 && count < 5);

    if ((cur & 0x80) == 0x80) {
      throw new RuntimeException("invalid LEB128 sequence.");
    }

    // Sign extend if appropriate
    if (((signBits >> 1) & result) != 0) {
      result |= signBits;
    }
  
    return result;
  }

  /**
   * Writes {@code value} as an unsigned integer to {@code buf}, starting at
   * {@code position}. Returns the number of bytes written.
   */
  public static void writeUnsignedLeb128(ByteBuffer buf, int value) {
    int remaining = value >>> 7;
  
    while (remaining != 0) {
        buf.put((byte) ((value & 0x7f) | 0x80));
        value = remaining;
        remaining >>>= 7;
    }
  
    buf.put((byte) (value & 0x7f));
  }

  /**
   * Writes {@code value} as a signed integer to {@code buf}, starting at
   * {@code position}. Returns the number of bytes written.
   */
  public static void writeSignedLeb128(ByteBuffer buf, int value) {
    int remaining = value >> 7;
    boolean hasMore = true;
    int end = ((value & Integer.MIN_VALUE) == 0) ? 0 : -1;

    while (hasMore) {
        hasMore = (remaining != end)
                || ((remaining & 1) != ((value >> 6) & 1));

        buf.put((byte) ((value & 0x7f) | (hasMore ? 0x80 : 0)));
        value = remaining;
        remaining >>= 7;
    }
  }
}
