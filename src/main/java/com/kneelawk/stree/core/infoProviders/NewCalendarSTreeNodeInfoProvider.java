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

package com.kneelawk.stree.core.infoProviders;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Calendar;

import com.kneelawk.stree.core.NewCalendarSTreeNode;
import com.kneelawk.stree.core.STreeNode;

/**
 * @deprecated Support for Calendar nodes is being removed. Please use
 *             MapSTreeNodes instead.
 * @author jedidiah
 *
 */
@Deprecated
public class NewCalendarSTreeNodeInfoProvider implements STreeInfoProvider {

	public static final byte VERSION_START = 0;
	public static final byte CURRENT_VERSION = VERSION_START;

	public static final NewCalendarSTreeNodeInfoProvider INSTANCE = new NewCalendarSTreeNodeInfoProvider();

	protected NewCalendarSTreeNodeInfoProvider() {
	}

	@Override
	public void write(STreeNode obj, DataOutput stream) throws IOException {
		Calendar cal = ((NewCalendarSTreeNode) obj).getValue();
		stream.writeByte(CURRENT_VERSION);
		stream.writeInt(cal.get(Calendar.ZONE_OFFSET));
		stream.writeInt(cal.get(Calendar.MILLISECOND));
		stream.writeInt(cal.get(Calendar.SECOND));
		stream.writeInt(cal.get(Calendar.MINUTE));
		stream.writeInt(cal.get(Calendar.HOUR_OF_DAY));
		stream.writeInt(cal.get(Calendar.DAY_OF_YEAR));
		stream.writeInt(cal.get(Calendar.YEAR));
		stream.writeInt(cal.get(Calendar.DST_OFFSET));
		stream.writeInt(cal.get(Calendar.ERA));
	}

	@Override
	public STreeNode read(DataInput stream) throws IOException {
		Calendar cal = null;
		byte version = stream.readByte();
		switch (version) {
		case VERSION_START:
			cal = Calendar.getInstance();
			cal.set(Calendar.ZONE_OFFSET, stream.readInt());
			cal.set(Calendar.MILLISECOND, stream.readInt());
			cal.set(Calendar.SECOND, stream.readInt());
			cal.set(Calendar.MINUTE, stream.readInt());
			cal.set(Calendar.HOUR_OF_DAY, stream.readInt());
			cal.set(Calendar.DAY_OF_YEAR, stream.readInt());
			cal.set(Calendar.YEAR, stream.readInt());
			cal.set(Calendar.DST_OFFSET, stream.readInt());
			cal.set(Calendar.ERA, stream.readInt());
			break;
		default:
			throw new IOException("Unknown calendar node version: " + version);
		}
		return new NewCalendarSTreeNode(cal);
	}

	@Override
	public byte getSTreeID() {
		return 17;
	}

}
