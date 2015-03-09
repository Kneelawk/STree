package com.kneelawk.stree;

import java.util.Enumeration;
import java.util.Iterator;

class STreeNodeIterator<T> implements Iterator<T> {
	Enumeration<T> en;

	public STreeNodeIterator(Enumeration<T> enumeration) {
		en = enumeration;
	}

	@Override
	public boolean hasNext() {
		return en.hasMoreElements();
	}

	@Override
	public T next() {
		return en.nextElement();
	}

	@Override
	public void remove() {
		en.nextElement();
	}
}
