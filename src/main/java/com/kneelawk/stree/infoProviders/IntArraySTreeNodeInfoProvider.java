package com.kneelawk.stree.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.kneelawk.stree.IntArraySTreeNode;
import com.kneelawk.stree.STreeNode;

public class IntArraySTreeNodeInfoProvider implements STreeInfoProvider {

	@Override
	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo)
			throws IOException {
		IntArraySTreeNode node = (IntArraySTreeNode) objectToWrite;
		int[] data = node.getValue();
		streamToWriteTo.writeInt(data.length);
		for(int i = 0; i < data.length; i++){
			streamToWriteTo.writeInt(data[i]);
		}
	}

	@Override
	public IntArraySTreeNode read(DataInput streamToReadFrom)
			throws IOException {
		int length = streamToReadFrom.readInt();
		int[] data = new int[length];
		for(int i = 0; i < length; i++){
			data[i] = streamToReadFrom.readInt();
		}
		return new IntArraySTreeNode(data);
	}

	@Override
	public byte getSTreeID() {
		return 7;
	}

}
