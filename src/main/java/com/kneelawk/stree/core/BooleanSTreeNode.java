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

import com.kneelawk.stree.core.infoProviders.BooleanSTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.STreeInfoProvider;

/**
 * 
 * @author Kneelawk
 *
 */

public class BooleanSTreeNode extends STreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8524016049988676574L;
	/**
	 * this BooleanSTreeNode's data
	 */
	public boolean data = false;

	/**
	 * nothing happens here
	 */
	public BooleanSTreeNode() {

	}

	public BooleanSTreeNode(boolean b) {
		data = b;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean getValue() {
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object o) {
		data = (Boolean) o;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return BooleanSTreeNodeInfoProvider.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		return "<BooleanSTreeNode>:" + data;
	}

}
