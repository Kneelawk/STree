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

import com.kneelawk.stree.core.IntArraySTreeNode;
import com.kneelawk.stree.core.STreeNode;

public class IntArraySTreeNodeInfoProvider implements STreeInfoProvider {

	public static final IntArraySTreeNodeInfoProvider INSTANCE = new IntArraySTreeNodeInfoProvider();

	protected IntArraySTreeNodeInfoProvider() {
	}

	@Override
	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo)
			throws IOException {
		IntArraySTreeNode node = (IntArraySTreeNode) objectToWrite;
		int[] data = node.getValue();
		streamToWriteTo.writeInt(data.length);
		for (int i = 0; i < data.length; i++) {
			streamToWriteTo.writeInt(data[i]);
		}
	}

	@Override
	public IntArraySTreeNode read(DataInput streamToReadFrom)
			throws IOException {
		int length = streamToReadFrom.readInt();
		int[] data = new int[length];
		for (int i = 0; i < length; i++) {
			data[i] = streamToReadFrom.readInt();
		}
		return new IntArraySTreeNode(data);
	}

	@Override
	public byte getSTreeID() {
		return 7;
	}

}
