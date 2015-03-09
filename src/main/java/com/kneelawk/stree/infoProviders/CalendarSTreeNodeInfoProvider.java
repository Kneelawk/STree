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

package com.kneelawk.stree.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Calendar;

import com.kneelawk.stree.CalendarSTreeNode;
import com.kneelawk.stree.STreeNode;

public class CalendarSTreeNodeInfoProvider implements STreeInfoProvider {

	@Override
	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo)
			throws IOException {
		CalendarSTreeNode node = (CalendarSTreeNode) objectToWrite;
		streamToWriteTo.writeInt(node.getValue().get(Calendar.MILLISECOND));
		streamToWriteTo.writeInt(node.getValue().get(Calendar.SECOND));
		streamToWriteTo.writeInt(node.getValue().get(Calendar.MINUTE));
		streamToWriteTo.writeInt(node.getValue().get(Calendar.HOUR_OF_DAY));
		streamToWriteTo.writeInt(node.getValue().get(Calendar.DAY_OF_YEAR));
		streamToWriteTo.writeInt(node.getValue().get(Calendar.YEAR));
		streamToWriteTo.writeInt(node.getValue().get(Calendar.DST_OFFSET));
	}

	@Override
	public CalendarSTreeNode read(DataInput streamToReadFrom) throws IOException {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MILLISECOND, streamToReadFrom.readInt());
		cal.set(Calendar.SECOND, streamToReadFrom.readInt());
		cal.set(Calendar.MINUTE, streamToReadFrom.readInt());
		cal.set(Calendar.HOUR_OF_DAY, streamToReadFrom.readInt());
		cal.set(Calendar.DAY_OF_YEAR, streamToReadFrom.readInt());
		cal.set(Calendar.YEAR, streamToReadFrom.readInt());
		cal.set(Calendar.DST_OFFSET, streamToReadFrom.readInt());
		return new CalendarSTreeNode(cal);
	}

	@Override
	public byte getSTreeID() {
		return 16;
	}

}
