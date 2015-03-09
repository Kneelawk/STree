package com.kneelawk.stree.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.kneelawk.stree.STreeNode;
import com.kneelawk.stree.StringSTreeNode;

public class StringSTreeNodeInfoProvider implements STreeInfoProvider {

	@Override
	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo)
			throws IOException {
		StringSTreeNode node = (StringSTreeNode) objectToWrite;
		streamToWriteTo.writeUTF(node.getValue());
	}

	@Override
	public StringSTreeNode read(DataInput streamToReadFrom) throws IOException {
		return new StringSTreeNode(streamToReadFrom.readUTF());
	}

	@Override
	public byte getSTreeID() {
		return 11;
	}

}
