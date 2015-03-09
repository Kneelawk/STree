package com.kneelawk.stree;

import com.kneelawk.stree.infoProviders.BooleanArraySTreeNodeInfoProvider;
import com.kneelawk.stree.infoProviders.STreeInfoProvider;

public class BooleanArraySTreeNode extends STreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = -70858620691998810L;
	/**
	 * the BooleanArraySTreeNode's data
	 */
	public boolean[] data;
	
	/**
	 * initializes data
	 */
	public BooleanArraySTreeNode() {
		data = new boolean[0];
	}
	
	public BooleanArraySTreeNode(boolean[] bs) {
		data = bs;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean[] getValue() {
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object o) {
		data = (boolean[]) o;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return new BooleanArraySTreeNodeInfoProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		String s = "";
		s += "<BooleanArraySTreeNode>:[\n";
		for(int i = 0; i < data.length; i++){
			s += indent(indent + 1) + i + ":<boolean>:" + data[i] + "\n";
		}
		s += indent(indent) + "]";
		return s;
	}
}
