package com.bowen.dex;

// TODO: Apply builder pattern 
public class DexHeader {

  final U1[] magic;
  final U4 checksum;
  final U1[] signature;
  final U4 fileSize;
  final U4 headerSize;
  final U4 endianTag;
  final U4 linkSize;
  final U4 linkOffset;
  final U4 mapOffset;
  final U4 stringIdsSize;
  final U4 stringIdsOffset;
  final U4 typeIdsSize;
  final U4 typeIdsOffset;
  final U4 protoIdsSize;
  final U4 protoIdsOffset;
  final U4 fieldIdsSize;
  final U4 fieldIdsOffset;
  final U4 methodIdsSize;
  final U4 methodIdsOffset;
  final U4 classDefsSize;
  final U4 classDefsOffset;

  public DexHeader(U1[] magic, U4 checksum, U1[] signature, U4 fileSize, U4 headerSize, U4 endianTag, U4 linkSize,
      U4 linkOffset, U4 mapOffset, U4 stringIdsSize, U4 stringIdsOffset, U4 typeIdsSize, U4 typeIdsOffset,
      U4 protoIdsSize, U4 protoIdsOffset, U4 fieldIdsSize, U4 fieldIdsOffset, U4 methodIdsSize, U4 methodIdsOffset,
      U4 classDefsSize, U4 classDefsOffset) {
    this.magic = magic;
    this.checksum = checksum;
    this.signature = signature;
    this.fileSize = fileSize;
    this.headerSize = headerSize;
    this.endianTag = endianTag;
    this.linkSize = linkSize;
    this.linkOffset = linkOffset;
    this.mapOffset = mapOffset;
    this.stringIdsSize = stringIdsSize;
    this.stringIdsOffset = stringIdsOffset;
    this.typeIdsSize = typeIdsSize;
    this.typeIdsOffset = typeIdsOffset;
    this.protoIdsSize = protoIdsSize;
    this.protoIdsOffset = protoIdsOffset;
    this.fieldIdsSize = fieldIdsSize;
    this.fieldIdsOffset = fieldIdsOffset;
    this.methodIdsSize = methodIdsSize;
    this.methodIdsOffset = methodIdsOffset;
    this.classDefsSize = classDefsSize;
    this.classDefsOffset = classDefsOffset;
  }
}
