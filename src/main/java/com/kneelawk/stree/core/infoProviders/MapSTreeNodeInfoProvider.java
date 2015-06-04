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
import java.util.Map.Entry;
import java.util.Set;

import com.kneelawk.stree.core.EndSTreeNode;
import com.kneelawk.stree.core.MapSTreeNode;
import com.kneelawk.stree.core.STreeNode;

public class MapSTreeNodeInfoProvider implements STreeInfoProvider {

	public static final MapSTreeNodeInfoProvider INSTANCE = new MapSTreeNodeInfoProvider();

	protected MapSTreeNodeInfoProvider() {
	}

	public void write(STreeNode objectToWrite, DataOutput streamToWriteTo)
			throws IOException {
		MapSTreeNode node = (MapSTreeNode) objectToWrite;
		Set<Entry<String, STreeNode>> nodeSet = node.entrySet();
		for (Entry<String, STreeNode> entry : nodeSet) {
			STreeNode.writeSTreeNode(entry.getValue(), streamToWriteTo);
			streamToWriteTo.writeUTF(entry.getKey());
		}
		STreeNode.writeSTreeNode(new EndSTreeNode(), streamToWriteTo);
	}

	public MapSTreeNode read(DataInput streamToReadFrom) throws IOException {
		MapSTreeNode node = new MapSTreeNode();
		STreeNode innerNode;
		while ((innerNode = STreeNode.readSTreeNode(streamToReadFrom))
				.getInfoProvider().getSTreeID() != new EndSTreeNode()
				.getInfoProvider().getSTreeID()) {
			String name = streamToReadFrom.readUTF();
			node.put(name, innerNode);
		}
		return node;
	}

	public byte getSTreeID() {
		return 1;
	}
}
