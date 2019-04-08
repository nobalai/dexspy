package com.bowen.common;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Leb128Test {

  @Test
  public void unsignedSize() {
    int size1 = 0b1000000;
    assertThat(Leb128.unsignedLeb128Size(size1), is(1));

    int size2 = 0b10000000;
    assertThat(Leb128.unsignedLeb128Size(size2), is(2));
  }

  @Test
  public void signedSize() {
    int size1 = 0b100000;
    assertThat(Leb128.signedLeb128Size(size1), is(1));

    int negativeSize1 = -size1;
    assertThat(Leb128.signedLeb128Size(negativeSize1), is(1));

    int size2 = 0b1000000;
    assertThat(Leb128.signedLeb128Size(size2), is(2));

    int negativeSize2 = -size2;
    assertThat(Leb128.signedLeb128Size(negativeSize2), is(1));
  }

  @Test
  public void readUnsignedValue() {
    ByteBuffer oneByteBuf = ByteBuffer.wrap(new byte[] {0b01000000});
    ByteBuffer twoBytesBuf = ByteBuffer.wrap(new byte[] {(byte) 0b11000000, 0b01000000}); // LSB

    assertThat(Leb128.readUnsignedLeb128(oneByteBuf), is(0b01000000));
    assertThat(Leb128.readUnsignedLeb128(twoBytesBuf), is(0b010000001000000));
  }

  @Test
  public void readSignedValue() {
    ByteBuffer oneByteBuf = ByteBuffer.wrap(new byte[] {0b01000000});
    ByteBuffer twoBytesBuf = ByteBuffer.wrap(new byte[] {(byte) 0b11000000, 0b01000000});

    assertThat(Leb128.readSignedLeb128(oneByteBuf), is(0b11000000 | 0xFFFFFF00));
    assertThat(Leb128.readSignedLeb128(twoBytesBuf), is(0b1110000001000000 | 0xFFFF0000));
  }

  @Test
  public void writeUnsignedValue() throws BufferOverflowException {
    ByteBuffer oneByteBuf = ByteBuffer.allocate(1);

    Leb128.writeUnsignedLeb128(oneByteBuf, 0b01000000);
    oneByteBuf.rewind();

    assertThat(oneByteBuf.get(), is((byte) 0b01000000));

    ByteBuffer twoBytesBuf = ByteBuffer.allocate(2);

    Leb128.writeUnsignedLeb128(twoBytesBuf, 0b010000001000000);
    twoBytesBuf.rewind();

    assertThat(twoBytesBuf.order(ByteOrder.LITTLE_ENDIAN).getShort(), is((short) 0b0100000011000000));
  }

  @Test
  public void writeSignedValue() {
    ByteBuffer twoBytesBuf = ByteBuffer.allocate(2);

    Leb128.writeSignedLeb128(twoBytesBuf, 0b01000000);
    twoBytesBuf.rewind();

    assertThat(twoBytesBuf.order(ByteOrder.LITTLE_ENDIAN).getShort(), is((short) 0b011000000));

    ByteBuffer fourBytesBuf = ByteBuffer.allocate(4);

    Leb128.writeSignedLeb128(fourBytesBuf, 0b10000001000000);
    fourBytesBuf.rewind();

    assertThat(fourBytesBuf.order(ByteOrder.LITTLE_ENDIAN).getInt(), is(0b01100000011000000));
  }
}
