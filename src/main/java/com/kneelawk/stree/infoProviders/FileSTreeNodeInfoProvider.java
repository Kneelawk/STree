package com.kneelawk.stree.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;

import com.kneelawk.stree.FileSTreeNode;
import com.kneelawk.stree.STreeNode;

public class FileSTreeNodeInfoProvider implements STreeInfoProvider {

	@Override
	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo)
			throws IOException {
		FileSTreeNode node = (FileSTreeNode) objectToWrite;
		streamToWriteTo.writeUTF(node.getValue().getAbsolutePath());
	}

	@Override
	public FileSTreeNode read(DataInput streamToReadFrom) throws IOException {
		return new FileSTreeNode(new File(streamToReadFrom.readUTF()));
	}

	@Override
	public byte getSTreeID() {
		return 14;
	}

}
