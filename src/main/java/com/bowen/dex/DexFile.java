package com.bowen.dex;

import java.nio.ByteBuffer;

public class DexFile {

    // header reference from https://source.android.com/devices/tech/dalvik/dex-format#header-item
    private U1[] magic;
    private U4 checksum;
    private U1[] signature;
    private U4 fileSize;
    private U4 headerSize;
    private U4 endianTag;
    private U4 linkSize;
    private U4 linkOffset;
    private U4 mapOffset;
    private U4 stringIdsSize;
    private U4 stringIdsOffset;
    private U4 typeIdsSize;
    private U4 typeIdsOffset;
    private U4 protoIdsSize;
    private U4 protoIdsOffset;
    private U4 fieldIdsSize;
    private U4 fieldIdsOffset;
    private U4 methodIdsSize;
    private U4 methodIdsOffset;
    private U4 classDefsSize;
    private U4 classDefsOffset;

    public void read(ByteBuffer byteBuffer) {
        DexReader dexReader = new DexReader(byteBuffer);

        magic = dexReader.readU1s(8);
        checksum = dexReader.readU4();
        signature = dexReader.readU1s(20);
        fileSize = dexReader.readU4();
        headerSize = dexReader.readU4();
        endianTag = dexReader.readU4();
        linkSize = dexReader.readU4();
        linkOffset = dexReader.readU4();
        mapOffset = dexReader.readU4();
        stringIdsSize = dexReader.readU4();
        stringIdsOffset = dexReader.readU4();
        typeIdsSize = dexReader.readU4();
        typeIdsOffset = dexReader.readU4();
        protoIdsSize = dexReader.readU4();
        protoIdsOffset = dexReader.readU4();
        fieldIdsSize = dexReader.readU4();
        fieldIdsOffset = dexReader.readU4();
        methodIdsSize = dexReader.readU4();
        methodIdsOffset = dexReader.readU4();
        classDefsSize = dexReader.readU4();
        classDefsOffset = dexReader.readU4();
    }
}
