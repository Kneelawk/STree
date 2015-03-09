package com.kneelawk.stree.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.kneelawk.stree.DoubleSTreeNode;
import com.kneelawk.stree.STreeNode;

public class DoubleSTreeNodeInfoProvider implements
		STreeInfoProvider {

	@Override
	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo)
			throws IOException {
		DoubleSTreeNode node = (DoubleSTreeNode) objectToWrite;
		streamToWriteTo.writeDouble(node.getValue());
	}

	@Override
	public DoubleSTreeNode read(DataInput streamToReadFrom)
			throws IOException {
		return new DoubleSTreeNode(streamToReadFrom.readDouble());
	}

	@Override
	public byte getSTreeID() {
		return 5;
	}

}
