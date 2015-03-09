package com.kneelawk.stree.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.kneelawk.stree.LongSTreeNode;
import com.kneelawk.stree.STreeNode;

public class LongSTreeNodeInfoProvider implements STreeInfoProvider {

	@Override
	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo)
			throws IOException {
		LongSTreeNode node = (LongSTreeNode) objectToWrite;
		streamToWriteTo.writeLong(node.getValue());
	}

	@Override
	public LongSTreeNode read(DataInput streamToReadFrom) throws IOException {
		return new LongSTreeNode(streamToReadFrom.readLong());
	}

	@Override
	public byte getSTreeID() {
		return 9;
	}
}
