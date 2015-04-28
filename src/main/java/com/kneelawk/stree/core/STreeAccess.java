package com.kneelawk.stree.core;

public interface STreeAccess<T> {
	public abstract boolean containsNode(T key);

	public abstract STreeNode getNode(T key);

	public abstract void putNode(T key, STreeNode node);
}
