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

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.tree.TreeNode;

import com.kneelawk.stree.core.infoProviders.BooleanArraySTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.BooleanSTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.ByteArraySTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.ByteSTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.CalendarSTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.CharSTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.DoubleSTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.EndSTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.FileSTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.FloatSTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.IntArraySTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.IntSTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.ListSTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.LongSTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.MapSTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.NewCalendarSTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.STreeInfoProvider;
import com.kneelawk.stree.core.infoProviders.ShortSTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.StringSTreeNodeInfoProvider;

/**
 * The abstract superclass of all the STreeNodes.
 * 
 * This is a <b>tree not a graph</b> and will be written like a tree.
 * 
 * @author Kneelawk
 * 
 */
@SuppressWarnings("deprecation")
public abstract class STreeNode implements TreeNode, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7469494752001261273L;

	public static HashMap<Byte, STreeInfoProvider> infoProviders = createPorviderList();

	protected STreeNode parent = null;
	protected boolean ivis = true;

	/**
	 * nothing happens here
	 */
	public STreeNode() {

	}

	public STreeNode(boolean includesValuesInString) {
		ivis = includesValuesInString;
	}

	private static HashMap<Byte, STreeInfoProvider> createPorviderList() {
		HashMap<Byte, STreeInfoProvider> infos = new HashMap<Byte, STreeInfoProvider>();
		addSTreeInfoProvider(infos, new EndSTreeNodeInfoProvider());
		addSTreeInfoProvider(infos, new MapSTreeNodeInfoProvider());
		addSTreeInfoProvider(infos, new ListSTreeNodeInfoProvider());
		addSTreeInfoProvider(infos, new ByteArraySTreeNodeInfoProvider());
		addSTreeInfoProvider(infos, new ByteSTreeNodeInfoProvider());
		addSTreeInfoProvider(infos, new DoubleSTreeNodeInfoProvider());
		addSTreeInfoProvider(infos, new FloatSTreeNodeInfoProvider());
		addSTreeInfoProvider(infos, new IntArraySTreeNodeInfoProvider());
		addSTreeInfoProvider(infos, new IntSTreeNodeInfoProvider());
		addSTreeInfoProvider(infos, new LongSTreeNodeInfoProvider());
		addSTreeInfoProvider(infos, new ShortSTreeNodeInfoProvider());
		addSTreeInfoProvider(infos, new StringSTreeNodeInfoProvider());
		addSTreeInfoProvider(infos, new BooleanSTreeNodeInfoProvider());
		addSTreeInfoProvider(infos, new CharSTreeNodeInfoProvider());
		addSTreeInfoProvider(infos, new FileSTreeNodeInfoProvider());
		addSTreeInfoProvider(infos, new BooleanArraySTreeNodeInfoProvider());
		addSTreeInfoProvider(infos, new CalendarSTreeNodeInfoProvider());
		addSTreeInfoProvider(infos, new NewCalendarSTreeNodeInfoProvider());
		return infos;
	}

	/**
	 * gets the STreeNode's value
	 * 
	 * @return the STreeNode's value
	 */
	public abstract Object getValue();

	/**
	 * sets the STreeNode's value to o
	 * 
	 * @param o
	 *            the value to set the STreeNode's value to
	 */
	public abstract void setValue(Object o);

	/**
	 * gets the STreeNode's
	 * {@link com.kneelawk.stree.core.infoProviders.STreeInfoProvider
	 * STreeInfoProvider}
	 * 
	 * @return the STreeNode's
	 *         {@link com.kneelawk.stree.core.infoProviders.STreeInfoProvider
	 *         STreeInfoProvider}
	 */
	public abstract STreeInfoProvider getInfoProvider();

	/**
	 * lets the STreeNode write info about it's self to a String
	 * 
	 * @param indent
	 *            how many lists or maps it is in
	 * @return the String about it's self
	 */
	public String toString(int indent) {
		return getClass().getName();
	}

	public boolean getAllowsChildren() {
		return false;
	}

	/**
	 * sets the parent of this STreeNode to the specified STreeNode
	 * 
	 * @param node
	 *            the specified STreeNode
	 */
	protected void setParent(STreeNode node) {
		if (parent != null)
			throw new IllegalArgumentException(
					"This node is already in an STreeNode array");
		parent = node;
	}

	public STreeNode getParent() {
		return parent;
	}

	/**
	 * returns a String with the necessary amount of tabs
	 * 
	 * @param indent
	 *            the ammount of tabs
	 * @return the String with the tabs in it
	 */
	public String indent(int indent) {
		String s = "";
		for (int i = 0; i < indent; i++) {
			s += "\t";
		}
		return s;
	}

	/**
	 * gets the STreeNode ID of this STreeNode
	 * 
	 * @return the ID of this STreeNode
	 */
	public int getSTreeID() {
		return getInfoProvider().getSTreeID();
	}

	/**
	 * registers an
	 * {@link com.kneelawk.stree.core.infoProviders.STreeInfoProvider
	 * STreeInfoProvider} for reading
	 * 
	 * @param info
	 *            the
	 *            {@link com.kneelawk.stree.core.infoProviders.STreeInfoProvider
	 *            STreeInfoProvider} to register
	 */
	public static void regiserInfoProvider(STreeInfoProvider info) {
		if (infoProviders.containsKey(info.getSTreeID()))
			throw new RuntimeException(
					"There is already a STreeNodeInfoProvider registered with the id: "
							+ info.getSTreeID());
		infoProviders.put(info.getSTreeID(), info);
	}

	/**
	 * Writes an STreeNode to the specified DataOutput
	 * 
	 * @param node
	 *            the STreeNode to write
	 * @param out
	 *            the DataOutput to write to
	 * @throws IOException
	 */
	public static void writeSTreeNode(STreeNode node, DataOutput out)
			throws IOException {
		out.writeByte(node.getSTreeID());
		if (node.getSTreeID() == new EndSTreeNode().getSTreeID())
			return;
		node.getInfoProvider().write(node, out);
	}

	/**
	 * Reads an STreeNode from the specified DataInput
	 * 
	 * @param in
	 *            the DataInput to read from
	 * @return the STreeNode from the DataInput
	 * @throws IOException
	 */
	public static STreeNode readSTreeNode(DataInput in) throws IOException {
		byte type = in.readByte();
		if (type == new EndSTreeNode().getSTreeID())
			return new EndSTreeNode();
		if (!infoProviders.containsKey(type))
			throw new IOException("Malformed STree Node (unknown ID): " + type);
		STreeInfoProvider info = infoProviders.get(type);
		return info.read(in);
	}

	/**
	 * gets an {@link com.kneelawk.stree.core.infoProviders.STreeInfoProvider
	 * STreeInfoProvider} from STreeNode's private list of STreeInfoProviders
	 * 
	 * @param id
	 *            the ID of the
	 *            {@link com.kneelawk.stree.core.infoProviders.STreeInfoProvider
	 *            STreeInfoProvider} (same as ID of the linked STreeNode)
	 * @return the
	 *         {@link com.kneelawk.stree.core.infoProviders.STreeInfoProvider
	 *         STreeInfoProvider} that has the specified ID
	 */
	public static STreeInfoProvider getInfoProviderForID(byte id) {
		return infoProviders.get(id);
	}

	/**
	 * returns this STreeNode as a String
	 */
	public String toString() {
		if (ivis) {
			return toString(0);
		} else {
			if (parent != null) {
				if (parent.getAllowsChildren()) {
					return parent.getIndex(this) + ":" + getClass().getName();
				} else {
					return getClass().getName();
				}
			} else {
				return getClass().getName();
			}
		}
	}

	public Enumeration<STreeNode> children() {
		return null;
	}

	public STreeNode getChildAt(int index) {
		return null;
	}

	public int getChildCount() {
		return 0;
	}

	public int getIndex(TreeNode node) {
		return 0;
	}

	public boolean isLeaf() {
		return true;
	}

	public STreeNode setIncludesValuesInString(boolean includesValuesInString) {
		ivis = includesValuesInString;
		return this;
	}

	public boolean getIncludesValuesInString() {
		return ivis;
	}

	public static <T> Enumeration<T> toEnumeration(Iterator<T> it) {
		return new STreeNodeEnumeration<T>(it);
	}

	public static <T> Iterator<T> toIterator(Enumeration<T> en) {
		return new STreeNodeIterator<T>(en);
	}

	private static void addSTreeInfoProvider(
			HashMap<Byte, STreeInfoProvider> list, STreeInfoProvider info) {
		list.put(info.getSTreeID(), info);
	}
}
