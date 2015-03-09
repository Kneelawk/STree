package com.kneelawk.stree.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.kneelawk.stree.ByteSTreeNode;
import com.kneelawk.stree.STreeNode;

public class ByteSTreeNodeInfoProvider implements
		STreeInfoProvider {

	@Override
	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo)
			throws IOException {
		ByteSTreeNode node = (ByteSTreeNode) objectToWrite;
		streamToWriteTo.writeByte(node.getValue());
	}

	@Override
	public ByteSTreeNode read(DataInput streamToReadFrom)
			throws IOException {
		return new ByteSTreeNode(streamToReadFrom.readByte());
	}

	@Override
	public byte getSTreeID() {
		return 4;
	}

}
