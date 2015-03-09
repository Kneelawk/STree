package com.kneelawk.stree.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Set;

import com.kneelawk.stree.EndSTreeNode;
import com.kneelawk.stree.MapSTreeNode;
import com.kneelawk.stree.STreeNode;

public class MapSTreeNodeInfoProvider implements STreeInfoProvider {
	
	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo) throws IOException {
		MapSTreeNode node = (MapSTreeNode) objectToWrite;
		Set<Entry<String, STreeNode>> nodeSet = node.entrySet();
		for(Entry<String, STreeNode> entry : nodeSet){
			STreeNode.writeSTreeNode(entry.getValue(), streamToWriteTo);
			streamToWriteTo.writeUTF(entry.getKey());
		}
		STreeNode.writeSTreeNode(new EndSTreeNode(), streamToWriteTo);
	}
	
	public MapSTreeNode read(DataInput streamToReadFrom) throws IOException {
		MapSTreeNode node = new MapSTreeNode();
		STreeNode innerNode;
		while((innerNode = STreeNode.readSTreeNode(streamToReadFrom)).getInfoProvider().getSTreeID() != new EndSTreeNode().getInfoProvider().getSTreeID()){
			String name = streamToReadFrom.readUTF();
			node.put(name, innerNode);
		}
		return node;
	}
	
	public byte getSTreeID() {
		return 1;
	}
}
