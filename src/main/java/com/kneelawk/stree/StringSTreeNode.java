package com.kneelawk.stree;

import com.kneelawk.stree.infoProviders.STreeInfoProvider;
import com.kneelawk.stree.infoProviders.StringSTreeNodeInfoProvider;

public class StringSTreeNode extends STreeNode implements CharSequence {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1806384892232942151L;
	/**
	 * the StringSTreeNode's data
	 */
	public String data = "";
	
	/**
	 * nothing happens here
	 */
	public StringSTreeNode() {
		
	}
	
	public StringSTreeNode(String s) {
		if(s != null) data = s;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getValue() {
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object o) {
		data = (String) o;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return new StringSTreeNodeInfoProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		return "<StringSTreeNode>:" + data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public char charAt(int arg0) {
		return data.charAt(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int length() {
		return data.length();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CharSequence subSequence(int arg0, int arg1) {
		return data.subSequence(arg0, arg1);
	}
}
