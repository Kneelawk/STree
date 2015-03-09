package com.kneelawk.stree;

import com.kneelawk.stree.infoProviders.IntSTreeNodeInfoProvider;
import com.kneelawk.stree.infoProviders.STreeInfoProvider;

public class IntSTreeNode extends STreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = 626946557779841442L;
	/**
	 * IntSTreeNode's data
	 */
	public int data = 0;
	
	/**
	 * nothing happens here
	 */
	public IntSTreeNode() {
		
	}
	
	public IntSTreeNode(int i) {
		data = i;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer getValue() {
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object o) {
		data = (Integer) o;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return new IntSTreeNodeInfoProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		return "<IntSTreeNode>:" + data;
	}

}
