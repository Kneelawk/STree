package com.kneelawk.stree.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.kneelawk.stree.FloatSTreeNode;
import com.kneelawk.stree.STreeNode;

public class FloatSTreeNodeInfoProvider implements
		STreeInfoProvider {

	@Override
	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo)
			throws IOException {
		FloatSTreeNode node = (FloatSTreeNode) objectToWrite;
		streamToWriteTo.writeFloat(node.getValue());
	}

	@Override
	public FloatSTreeNode read(DataInput streamToReadFrom)
			throws IOException {
		return new FloatSTreeNode(streamToReadFrom.readFloat());
	}

	@Override
	public byte getSTreeID() {
		return 6;
	}

}
