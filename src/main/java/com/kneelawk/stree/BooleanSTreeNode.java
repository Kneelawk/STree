package com.kneelawk.stree;

import com.kneelawk.stree.infoProviders.BooleanSTreeNodeInfoProvider;
import com.kneelawk.stree.infoProviders.STreeInfoProvider;

public class BooleanSTreeNode extends STreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8524016049988676574L;
	/**
	 * this BooleanSTreeNode's data
	 */
	public boolean data = false;
	
	/**
	 * nothing happens here
	 */
	public BooleanSTreeNode() {
		
	}
	
	public BooleanSTreeNode(boolean b) {
		data = b;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean getValue() {
		return data;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object o) {
		data = (Boolean) o;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return new BooleanSTreeNodeInfoProvider();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		return "<BooleanSTreeNode>:" + data;
	}

}
