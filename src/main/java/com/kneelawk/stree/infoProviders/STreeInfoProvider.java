package com.kneelawk.stree.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.kneelawk.stree.STreeNode;

public interface STreeInfoProvider {
	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo) throws IOException;
	public STreeNode read(DataInput streamToReadFrom) throws IOException;
	public byte getSTreeID();
}
