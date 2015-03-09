package com.kneelawk.stree;

import com.kneelawk.stree.infoProviders.ByteSTreeNodeInfoProvider;
import com.kneelawk.stree.infoProviders.STreeInfoProvider;

public class ByteSTreeNode extends STreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1170154962291192779L;
	/**
	 * the ByteSTreeNode's data
	 */
	public byte data = 0;
	
	/**
	 * nothing happens here
	 */
	public ByteSTreeNode(){
		
	}
	
	public ByteSTreeNode(byte b) {
		data = b;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Byte getValue() {
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object o) {
		data = (Byte) o;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return new ByteSTreeNodeInfoProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		return "<ByteSTreeNode>:" + data;
	}

}
