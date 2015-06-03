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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

import javax.swing.tree.TreeNode;

import com.kneelawk.stree.core.infoProviders.ListSTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.STreeInfoProvider;

public class ListSTreeNode extends STreeNode implements Iterable<STreeNode>,
		Collection<STreeNode>, List<STreeNode>, RandomAccess,
		STreeAccess<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6163624097221449784L;
	/**
	 * the ListSTreeNode's nodes
	 */
	public ArrayList<STreeNode> nodes;

	/**
	 * initializes nodes
	 */
	public ListSTreeNode() {
		nodes = new ArrayList<STreeNode>();
	}

	/**
	 * initializes nodes and then adds l to nodes
	 * 
	 * @param l
	 */
	public ListSTreeNode(Collection<? extends STreeNode> l) {
		this();
		nodes.addAll(l);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValue() {
		return nodes;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setValue(Object o) {
		nodes = (ArrayList<STreeNode>) o;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeInfoProvider getInfoProvider() {
		return new ListSTreeNodeInfoProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		String s = "";
		s += "<ListSTreeNode>:[\n";
		for (int i = 0; i < nodes.size(); i++) {
			s += indent(indent + 1) + i + ":"
					+ nodes.get(i).toString(indent + 1) + "\n";
		}
		s += indent(indent) + "]";
		return s;
	}

	public Enumeration<STreeNode> children() {
		return STreeNode.<STreeNode> toEnumeration(nodes.iterator());
	}

	public boolean getAllowsChildren() {
		return true;
	}

	public STreeNode getChildAt(int index) {
		return nodes.get(index);
	}

	public int getChildCount() {
		return nodes.size();
	}

	public int getIndex(TreeNode node) {
		return nodes.indexOf(node);
	}

	public boolean isLeaf() {
		return nodes.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add(STreeNode e) {
		return nodes.add(e);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(int index, STreeNode element) {
		nodes.add(index, element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addAll(Collection<? extends STreeNode> c) {
		return nodes.addAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addAll(int index, Collection<? extends STreeNode> c) {
		return nodes.addAll(index, c);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		nodes.clear();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(Object o) {
		return nodes.contains(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		return nodes.containsAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeNode get(int index) {
		return nodes.get(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int indexOf(Object o) {
		return nodes.indexOf(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return nodes.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<STreeNode> iterator() {
		return nodes.iterator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int lastIndexOf(Object o) {
		return nodes.lastIndexOf(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ListIterator<STreeNode> listIterator() {
		return nodes.listIterator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ListIterator<STreeNode> listIterator(int index) {
		return nodes.listIterator(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove(Object o) {
		return nodes.remove(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeNode remove(int index) {
		return nodes.remove(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		return nodes.removeAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		return nodes.retainAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeNode set(int index, STreeNode element) {
		return nodes.set(index, element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return nodes.size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<STreeNode> subList(int fromIndex, int toIndex) {
		return nodes.subList(fromIndex, toIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] toArray() {
		return nodes.toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		return nodes.<T> toArray(a);
	}

	/* Individual STreeNode get types */

	public BooleanArraySTreeNode getBooleanArray(int index) {
		return (BooleanArraySTreeNode) get(index);
	}

	public BooleanSTreeNode getBoolean(int index) {
		return (BooleanSTreeNode) get(index);
	}

	public ByteArraySTreeNode getByteArray(int index) {
		return (ByteArraySTreeNode) get(index);
	}

	public ByteSTreeNode getByte(int index) {
		return (ByteSTreeNode) get(index);
	}

	@Deprecated
	public CalendarSTreeNode getCalendar(int index) {
		return (CalendarSTreeNode) get(index);
	}

	public CharSTreeNode getChar(int index) {
		return (CharSTreeNode) get(index);
	}

	public DoubleSTreeNode getDouble(int index) {
		return (DoubleSTreeNode) get(index);
	}

	@Deprecated
	public FileSTreeNode getFile(int index) {
		return (FileSTreeNode) get(index);
	}

	public FloatSTreeNode getFloat(int index) {
		return (FloatSTreeNode) get(index);
	}

	public IntArraySTreeNode getIntArray(int index) {
		return (IntArraySTreeNode) get(index);
	}

	public IntSTreeNode getInt(int index) {
		return (IntSTreeNode) get(index);
	}

	public ListSTreeNode getList(int index) {
		return (ListSTreeNode) get(index);
	}

	public LongSTreeNode getLong(int index) {
		return (LongSTreeNode) get(index);
	}

	public MapSTreeNode getMap(int index) {
		return (MapSTreeNode) get(index);
	}

	public NewCalendarSTreeNode getNewCalendar(int index) {
		return (NewCalendarSTreeNode) get(index);
	}

	public ShortSTreeNode getShort(int index) {
		return (ShortSTreeNode) get(index);
	}

	public StringSTreeNode getString(int index) {
		return (StringSTreeNode) get(index);
	}

	@Override
	public boolean containsNode(Integer key) {
		int ival = key.intValue();
		return ival >= 0 && ival < nodes.size();
	}

	@Override
	public STreeNode getNode(Integer key) {
		return nodes.get(key.intValue());
	}

	@Override
	public void putNode(Integer key, STreeNode node) {
		int ival = key.intValue();
		if (ival < nodes.size())
			nodes.set(ival, node);
		else
			nodes.add(ival, node);
	}
}
