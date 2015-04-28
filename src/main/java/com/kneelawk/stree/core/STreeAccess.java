package com.kneelawk.stree.core;

public interface STreeAccess<T> {
	public abstract STreeNode getNode(T key);
	
	public abstract void putNode(T key, STreeNode node);
}
