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

import com.kneelawk.stree.core.infoProviders.ByteArraySTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.STreeInfoProvider;

public class ByteArraySTreeNode extends STreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = 727276588274530055L;
	/**
	 * the ByteArraySTreeNode's data
	 */
	public byte[] data;
	
	/**
	 * initializes data
	 */
	public ByteArraySTreeNode(){
		data = new byte[0];
	}
	
	public ByteArraySTreeNode(byte[] byteData){
		data = byteData;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public byte[] getValue() {
		return data;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object o) {
		data = (byte[]) o;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return new ByteArraySTreeNodeInfoProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		String s = "";
		s += "<ByteArraySTreeNode>:[\n";
		for(int i = 0; i < data.length; i++){
			s += indent(indent + 1) + i + ":<byte>:" + data[i] + "\n";
		}
		s += indent(indent) + "]";
		return s;
	}
}
