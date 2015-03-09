package com.kneelawk.stree.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.kneelawk.stree.IntSTreeNode;
import com.kneelawk.stree.STreeNode;

public class IntSTreeNodeInfoProvider implements STreeInfoProvider {

	@Override
	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo)
			throws IOException {
		IntSTreeNode node = (IntSTreeNode) objectToWrite;
		streamToWriteTo.writeInt(node.getValue());
	}

	@Override
	public IntSTreeNode read(DataInput streamToReadFrom) throws IOException {
		return new IntSTreeNode(streamToReadFrom.readInt());
	}

	@Override
	public byte getSTreeID() {
		return 8;
	}

}
