package com.kneelawk.stree;

import com.kneelawk.stree.infoProviders.FloatSTreeNodeInfoProvider;
import com.kneelawk.stree.infoProviders.STreeInfoProvider;

public class FloatSTreeNode extends STreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3376109010836212208L;
	/**
	 * the FloatSTreeNode's data
	 */
	public float data = 0f;
	
	/**
	 * nothing happens here
	 */
	public FloatSTreeNode(){
		
	}
	
	public FloatSTreeNode(float f){
		data = f;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Float getValue() {
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object o) {
		data = (Float) o;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return new FloatSTreeNodeInfoProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		return "<FloatSTreeNode>:" + data;
	}

}
