package com.kneelawk.stree;

import com.kneelawk.stree.infoProviders.LongSTreeNodeInfoProvider;
import com.kneelawk.stree.infoProviders.STreeInfoProvider;

public class LongSTreeNode extends STreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8440802353133332221L;
	/**
	 * the LongSTreeNode's data
	 */
	public long data = 0;
	
	/**
	 * nothing happens here
	 */
	public LongSTreeNode() {
		
	}
	
	public LongSTreeNode(long l) {
		data = l;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long getValue() {
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object o) {
		data = (Long) o;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return new LongSTreeNodeInfoProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		return "<LongSTreeNode>:" + data;
	}

}
