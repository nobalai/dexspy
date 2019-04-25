package com.bowen.dex;

public class DexParser {

  public static DexHeader getHeader(DexReader dexReader) {
    return new DexHeader(dexReader.readU1s(8), dexReader.readU4(), dexReader.readU1s(20),
        dexReader.readU4(), dexReader.readU4(), dexReader.readU4(), dexReader.readU4(), dexReader.readU4(),
        dexReader.readU4(), dexReader.readU4(), dexReader.readU4(), dexReader.readU4(), dexReader.readU4(),
        dexReader.readU4(), dexReader.readU4(), dexReader.readU4(), dexReader.readU4(), dexReader.readU4(),
        dexReader.readU4(), dexReader.readU4(), dexReader.readU4());
  }
}