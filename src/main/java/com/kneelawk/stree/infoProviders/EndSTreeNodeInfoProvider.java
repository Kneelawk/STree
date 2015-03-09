package com.kneelawk.stree.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;

import com.kneelawk.stree.EndSTreeNode;
import com.kneelawk.stree.STreeNode;

public class EndSTreeNodeInfoProvider implements STreeInfoProvider {
	
	public void write(STreeNode objectToWrite, DataOutput streamToWrightTo) {
		
	}
	
	public EndSTreeNode read(DataInput streamToReadFrom) {
		return new EndSTreeNode();
	}
	
	public byte getSTreeID() {
		return 0;
	}
}
