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

import java.util.Calendar;

import com.kneelawk.stree.core.infoProviders.CalendarSTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.STreeInfoProvider;

/**
 * @deprecated Support for Calendar nodes is being removed. Please use
 *             MapSTreeNodes instead.
 * @author Kneelawk
 *
 */

@Deprecated
public class CalendarSTreeNode extends STreeNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8051856989852427073L;
	public Calendar data;

	public CalendarSTreeNode() {
		data = Calendar.getInstance();
	}

	public CalendarSTreeNode(Calendar c) {
		data = c;
	}

	@Override
	public Calendar getValue() {
		return data;
	}

	@Override
	public void setValue(Object o) {
		data = (Calendar) o;
	}

	@Override
	public STreeInfoProvider getInfoProvider() {
		return CalendarSTreeNodeInfoProvider.INSTANCE;
	}

	@Override
	public String toString(int indent) {
		String s = "<CalendarSTreeNode>:{\n" + indent(indent + 1)
				+ "millisecond:" + data.get(Calendar.MILLISECOND) + "\n"
				+ indent(indent + 1) + "second:" + data.get(Calendar.SECOND)
				+ "\n" + indent(indent + 1) + "minute:"
				+ data.get(Calendar.MINUTE) + "\n" + indent(indent + 1)
				+ "hour_of_day:" + data.get(Calendar.HOUR_OF_DAY) + "\n"
				+ indent(indent + 1) + "day_of_year:"
				+ data.get(Calendar.DAY_OF_YEAR) + "\n" + indent(indent + 1)
				+ "year:" + data.get(Calendar.YEAR) + "\n" + indent(indent + 1)
				+ "dst_offset:" + data.get(Calendar.DST_OFFSET) + "\n"
				+ indent(indent) + "}";
		return s;
	}

}
