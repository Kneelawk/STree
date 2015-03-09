package com.kneelawk.stree.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.kneelawk.stree.ListSTreeNode;
import com.kneelawk.stree.STreeNode;

public class ListSTreeNodeInfoProvider implements STreeInfoProvider {

	@Override
	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo) throws IOException {
		ListSTreeNode node = (ListSTreeNode) objectToWrite;
		streamToWriteTo.writeInt(node.size());
		for(int i = 0; i < node.size(); i++){
			STreeNode.writeSTreeNode(node.get(i), streamToWriteTo);
		}
	}

	@Override
	public ListSTreeNode read(DataInput streamToReadFrom) throws IOException {
		ListSTreeNode node = new ListSTreeNode();
		int size = streamToReadFrom.readInt();
		for(int i = 0; i < size; i++){
			node.add(STreeNode.readSTreeNode(streamToReadFrom));
		}
		return node;
	}

	@Override
	public byte getSTreeID() {
		return 2;
	}

}
