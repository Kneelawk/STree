package com.kneelawk.stree;

import com.kneelawk.stree.infoProviders.STreeInfoProvider;
import com.kneelawk.stree.infoProviders.ShortSTreeNodeInfoProvider;

public class ShortSTreeNode extends STreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8041731765800987488L;
	/**
	 * the ShortSTreeNode's data
	 */
	public short data = 0;
	
	/**
	 * nothing happens here
	 */
	public ShortSTreeNode() {
		
	}
	
	public ShortSTreeNode(short s) {
		data = s;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Short getValue() {
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object o) {
		data = (Short) o;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return new ShortSTreeNodeInfoProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		return "<ShortSTreeNode>:" + data;
	}

}
