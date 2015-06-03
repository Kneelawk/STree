/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Kneelawk
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.kneelawk.stree.core;

import com.kneelawk.stree.core.infoProviders.BooleanArraySTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.STreeInfoProvider;

/**
 * Under normal DataOutput implementations, this is the same as using a
 * ByteArraySTreeNode full of 1s and 0s.
 * 
 * @author Kneelawk
 *
 */

public class BooleanArraySTreeNode extends STreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = -70858620691998810L;
	/**
	 * the BooleanArraySTreeNode's data
	 */
	public boolean[] data;

	/**
	 * initializes data
	 */
	public BooleanArraySTreeNode() {
		data = new boolean[0];
	}

	public BooleanArraySTreeNode(boolean[] bs) {
		data = bs;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean[] getValue() {
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object o) {
		data = (boolean[]) o;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return new BooleanArraySTreeNodeInfoProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		String s = "";
		s += "<BooleanArraySTreeNode>:[\n";
		for (int i = 0; i < data.length; i++) {
			s += indent(indent + 1) + i + ":<boolean>:" + data[i] + "\n";
		}
		s += indent(indent) + "]";
		return s;
	}
}
