package com.kneelawk.stree.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.kneelawk.stree.ByteArraySTreeNode;
import com.kneelawk.stree.STreeNode;

public class ByteArraySTreeNodeInfoProvider implements
		STreeInfoProvider {

	@Override
	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo)
			throws IOException {
		ByteArraySTreeNode node = (ByteArraySTreeNode) objectToWrite;
		streamToWriteTo.writeInt(node.getValue().length);
		streamToWriteTo.write(node.getValue());
	}

	@Override
	public ByteArraySTreeNode read(DataInput streamToReadFrom)
			throws IOException {
		int length = streamToReadFrom.readInt();
		byte[] data = new byte[length];
		streamToReadFrom.readFully(data);
		return new ByteArraySTreeNode(data);
	}

	@Override
	public byte getSTreeID() {
		return 3;
	}

}
