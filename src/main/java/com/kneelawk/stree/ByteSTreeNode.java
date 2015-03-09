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

package com.kneelawk.stree;

import com.kneelawk.stree.infoProviders.ByteSTreeNodeInfoProvider;
import com.kneelawk.stree.infoProviders.STreeInfoProvider;

public class ByteSTreeNode extends STreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1170154962291192779L;
	/**
	 * the ByteSTreeNode's data
	 */
	public byte data = 0;
	
	/**
	 * nothing happens here
	 */
	public ByteSTreeNode(){
		
	}
	
	public ByteSTreeNode(byte b) {
		data = b;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Byte getValue() {
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object o) {
		data = (Byte) o;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return new ByteSTreeNodeInfoProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		return "<ByteSTreeNode>:" + data;
	}

}
