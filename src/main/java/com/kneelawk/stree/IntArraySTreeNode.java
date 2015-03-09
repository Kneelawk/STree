package com.kneelawk.stree;

import com.kneelawk.stree.infoProviders.IntArraySTreeNodeInfoProvider;
import com.kneelawk.stree.infoProviders.STreeInfoProvider;

public class IntArraySTreeNode extends STreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1684665798572198878L;
	/**
	 * the IntArraySTreeNode's data
	 */
	public int[] data;
	
	/**
	 * nothing happens here
	 */
	public IntArraySTreeNode(){
		
	}
	
	public IntArraySTreeNode(int[] is){
		data = is;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int[] getValue() {
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object o) {
		data = (int[]) o;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return new IntArraySTreeNodeInfoProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		String s = "";
		s += "<IntArraySTreeNode>:[\n";
		for(int i = 0; i < data.length; i++){
			s += indent(indent + 1) + i + ":<int>:" + data[i] + "\n";
		}
		s += indent(indent) + "]";
		return s;
	}

}
