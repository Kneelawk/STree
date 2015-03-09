package com.kneelawk.stree.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.kneelawk.stree.STreeNode;
import com.kneelawk.stree.ShortSTreeNode;

public class ShortSTreeNodeInfoProvider implements STreeInfoProvider {

	@Override
	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo)
			throws IOException {
		ShortSTreeNode node = (ShortSTreeNode) objectToWrite;
		streamToWriteTo.writeShort(node.getValue());
	}

	@Override
	public ShortSTreeNode read(DataInput streamToReadFrom) throws IOException {
		return new ShortSTreeNode(streamToReadFrom.readShort());
	}

	@Override
	public byte getSTreeID() {
		return 10;
	}

}
