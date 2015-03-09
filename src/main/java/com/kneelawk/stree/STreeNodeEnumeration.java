package com.kneelawk.stree;

import java.util.Enumeration;
import java.util.Iterator;

class STreeNodeEnumeration<T> implements Enumeration<T> {
	private Iterator<T> it;

	public STreeNodeEnumeration(Iterator<T> iterator) {
		it = iterator;
	}

	@Override
	public boolean hasMoreElements() {
		return it.hasNext();
	}

	@Override
	public T nextElement() {
		return it.next();
	}
}
