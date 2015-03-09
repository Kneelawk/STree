package com.kneelawk.stree;

import java.io.File;

import com.kneelawk.stree.infoProviders.FileSTreeNodeInfoProvider;
import com.kneelawk.stree.infoProviders.STreeInfoProvider;

public class FileSTreeNode extends STreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6847730889021524253L;
	/**
	 * the FileSTreeNode's data
	 */
	public File data = null;
	
	/**
	 * initializes data
	 */
	public FileSTreeNode() {
		data = new File("");
	}
	
	public FileSTreeNode(String filename) {
		data = new File(filename);
	}
	
	public FileSTreeNode(File f) {
		data = f;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getValue() {
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object o) {
		data = (File) o;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return new FileSTreeNodeInfoProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		return "<FileSTreeNode>:" + data.getAbsolutePath();
	}

}
