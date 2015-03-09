package com.kneelawk.stree;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

class MapSTreeNodeEnumeration implements Enumeration<STreeNode> {
	private Iterator<Entry<String, STreeNode>> iterator;

	public MapSTreeNodeEnumeration(HashMap<String, STreeNode> h) {
		iterator = h.entrySet().iterator();
	}

	public boolean hasMoreElements() {
		return iterator.hasNext();
	}

	public STreeNode nextElement() {
		return iterator.next().getValue();
	}
}
