package com.kneelawk.stree;

import com.kneelawk.stree.infoProviders.CharSTreeNodeInfoProvider;
import com.kneelawk.stree.infoProviders.STreeInfoProvider;

public class CharSTreeNode extends STreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = -436651726480423114L;
	/**
	 * the CharSTreeNode's data
	 */
	public char data = 0;
	
	/**
	 * nothing happens here
	 */
	public CharSTreeNode() {
		
	}
	
	public CharSTreeNode(char c) {
		data = c;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Character getValue() {
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object o) {
		data = (Character) o;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return new CharSTreeNodeInfoProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		return "<CharSTreeNode>:" + data;
	}

}
