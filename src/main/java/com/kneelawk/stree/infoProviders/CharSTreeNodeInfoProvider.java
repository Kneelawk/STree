package com.kneelawk.stree.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.kneelawk.stree.CharSTreeNode;
import com.kneelawk.stree.STreeNode;

public class CharSTreeNodeInfoProvider implements STreeInfoProvider {

	@Override
	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo)
			throws IOException {
		CharSTreeNode node = (CharSTreeNode) objectToWrite;
		streamToWriteTo.writeChar(node.getValue());
	}

	@Override
	public CharSTreeNode read(DataInput streamToReadFrom) throws IOException {
		return new CharSTreeNode(streamToReadFrom.readChar());
	}

	@Override
	public byte getSTreeID() {
		return 13;
	}

}
