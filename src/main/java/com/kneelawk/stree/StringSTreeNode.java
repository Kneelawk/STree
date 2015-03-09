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

import com.kneelawk.stree.infoProviders.STreeInfoProvider;
import com.kneelawk.stree.infoProviders.StringSTreeNodeInfoProvider;

public class StringSTreeNode extends STreeNode implements CharSequence {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1806384892232942151L;
	/**
	 * the StringSTreeNode's data
	 */
	public String data = "";
	
	/**
	 * nothing happens here
	 */
	public StringSTreeNode() {
		
	}
	
	public StringSTreeNode(String s) {
		if(s != null) data = s;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getValue() {
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object o) {
		data = (String) o;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return new StringSTreeNodeInfoProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		return "<StringSTreeNode>:" + data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public char charAt(int arg0) {
		return data.charAt(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int length() {
		return data.length();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CharSequence subSequence(int arg0, int arg1) {
		return data.subSequence(arg0, arg1);
	}
}