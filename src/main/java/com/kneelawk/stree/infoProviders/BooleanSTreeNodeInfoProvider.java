package com.kneelawk.stree.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.kneelawk.stree.BooleanSTreeNode;
import com.kneelawk.stree.STreeNode;

public class BooleanSTreeNodeInfoProvider implements STreeInfoProvider {

	@Override
	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo)
			throws IOException {
		BooleanSTreeNode node = (BooleanSTreeNode) objectToWrite;
		streamToWriteTo.writeBoolean(node.getValue());
	}

	@Override
	public BooleanSTreeNode read(DataInput streamToReadFrom) throws IOException {
		return new BooleanSTreeNode(streamToReadFrom.readBoolean());
	}

	@Override
	public byte getSTreeID() {
		return 12;
	}

}
