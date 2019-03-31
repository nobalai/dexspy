package com.bowen.common;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

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
}