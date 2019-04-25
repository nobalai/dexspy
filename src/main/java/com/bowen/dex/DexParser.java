package com.bowen.dex;

public class DexParser {

  public static DexHeader getHeader(DexReader dexReader) {
    return new DexHeader(dexReader.readU1s(8), dexReader.readU4(), dexReader.readU1s(20),
        dexReader.readU4(), dexReader.readU4(), dexReader.readU4(), dexReader.readU4(), dexReader.readU4(),
        dexReader.readU4(), dexReader.readU4(), dexReader.readU4(), dexReader.readU4(), dexReader.readU4(),
        dexReader.readU4(), dexReader.readU4(), dexReader.readU4(), dexReader.readU4(), dexReader.readU4(),
        dexReader.readU4(), dexReader.readU4(), dexReader.readU4());
  }

  public static StringIds getStringIds(DexHeader header, DexReader reader) {
    U4[] offsets = new U4[header.stringIdsSize.get()];

    for (int i = 0; i < header.stringIdsSize.get(); i++) {
      offsets[i] = reader.readU4();
    }

    return new StringIds(header.stringIdsSize, offsets);
  }
}