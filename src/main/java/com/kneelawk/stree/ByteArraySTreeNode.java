package com.kneelawk.stree;

import com.kneelawk.stree.infoProviders.ByteArraySTreeNodeInfoProvider;
import com.kneelawk.stree.infoProviders.STreeInfoProvider;

public class ByteArraySTreeNode extends STreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = 727276588274530055L;
	/**
	 * the ByteArraySTreeNode's data
	 */
	public byte[] data;
	
	/**
	 * initializes data
	 */
	public ByteArraySTreeNode(){
		data = new byte[0];
	}
	
	public ByteArraySTreeNode(byte[] byteData){
		data = byteData;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public byte[] getValue() {
		return data;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object o) {
		data = (byte[]) o;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return new ByteArraySTreeNodeInfoProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		String s = "";
		s += "<ByteArraySTreeNode>:[\n";
		for(int i = 0; i < data.length; i++){
			s += indent(indent + 1) + i + ":<byte>:" + data[i] + "\n";
		}
		s += indent(indent) + "]";
		return s;
	}
}
