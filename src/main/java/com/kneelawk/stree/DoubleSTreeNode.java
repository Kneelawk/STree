package com.kneelawk.stree;

import com.kneelawk.stree.infoProviders.DoubleSTreeNodeInfoProvider;
import com.kneelawk.stree.infoProviders.STreeInfoProvider;

public class DoubleSTreeNode extends STreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7903491171412276785L;
	/**
	 * the DoubleSTreeNode's data
	 */
	public double data = 0;
	
	/**
	 * nothing happens
	 */
	public DoubleSTreeNode() {
		
	}
	
	public DoubleSTreeNode(double d) {
		data = d;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double getValue() {
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object o) {
		data = (Double) o;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return new DoubleSTreeNodeInfoProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		return "<DoubleSTreeNode>:" + data;
	}

}
