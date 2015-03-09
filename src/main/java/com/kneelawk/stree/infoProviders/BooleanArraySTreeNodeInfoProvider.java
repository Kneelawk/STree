package com.kneelawk.stree.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.kneelawk.stree.BooleanArraySTreeNode;
import com.kneelawk.stree.STreeNode;

public class BooleanArraySTreeNodeInfoProvider implements STreeInfoProvider {

	@Override
	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo)
			throws IOException {
		BooleanArraySTreeNode node = (BooleanArraySTreeNode) objectToWrite;
		boolean[] data = node.getValue();
		streamToWriteTo.writeInt(data.length);
		for(int i = 0; i < data.length; i++){
			streamToWriteTo.writeBoolean(data[i]);
		}
	}

	@Override
	public BooleanArraySTreeNode read(DataInput streamToReadFrom) throws IOException {
		int length = streamToReadFrom.readInt();
		boolean[] data = new boolean[length];
		for(int i = 0; i < length; i++){
			data[i] = streamToReadFrom.readBoolean();
		}
		return new BooleanArraySTreeNode(data);
	}

	@Override
	public byte getSTreeID() {
		return 15;
	}

}
