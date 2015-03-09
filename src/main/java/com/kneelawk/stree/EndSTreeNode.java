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

import com.kneelawk.stree.infoProviders.EndSTreeNodeInfoProvider;
import com.kneelawk.stree.infoProviders.STreeInfoProvider;
/**
 * EndSTreeNode - usualy put at the end of a {@link MapSTreeNode MapSTreeNode}'s inner nodes
 * @author Jed Pommert
 *
 */
public class EndSTreeNode extends STreeNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7078963500163036276L;

	@Override
	public Object getValue() {
		return null;
	}
	
	@Override
	public void setValue(Object o) {
		
	}

	@Override
	public STreeInfoProvider getInfoProvider() {
		return new EndSTreeNodeInfoProvider();
	}

	@Override
	public String toString(int indent) {
		return "<EndSTreeNode>";
	}
}
