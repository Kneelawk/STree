package com.kneelawk.stree;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

import com.kneelawk.stree.infoProviders.MapSTreeNodeInfoProvider;

public class MapSTreeNode extends STreeNode implements Map<String, STreeNode> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 645771021719936912L;
	/**
	 * the MapSTreeNode's nodes
	 */
	public TreeMap<String, STreeNode> nodes;

	/**
	 * initializes data
	 */
	public MapSTreeNode() {
		nodes = new TreeMap<String, STreeNode>();
	}

	/**
	 * initializes nodes and adds all of stuffToAdd to nodes
	 * 
	 * @param stuffToAdd
	 */
	public MapSTreeNode(Map<? extends String, ? extends STreeNode> stuffToAdd) {
		this();
		nodes.putAll(stuffToAdd);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TreeMap<String, STreeNode> getValue() {
		return nodes;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setValue(Object o) {
		nodes = (TreeMap<String, STreeNode>) o;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MapSTreeNodeInfoProvider getInfoProvider() {
		return new MapSTreeNodeInfoProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(int indent) {
		String s = "";
		s += "<MapSTreeNode>:{\n";
		Set<Entry<String, STreeNode>> set = nodes.entrySet();
		for (Entry<String, STreeNode> en : set) {
			s += indent(indent + 1) + en.getKey() + ":"
					+ en.getValue().toString(indent + 1) + "\n";
		}
		s += indent(indent) + "}";
		return s;
	}

	public boolean getAllowsChildren() {
		return true;
	}

	@SuppressWarnings("unchecked")
	public Enumeration<STreeNode> children() {
		return new MapSTreeNodeEnumeration(
				(HashMap<String, STreeNode>) nodes.clone());
	}

	public STreeNode getChildAt(int index) {
		Set<Entry<String, STreeNode>> set = nodes.entrySet();
		STreeNode node = null;
		int i = 0;
		for (Entry<String, STreeNode> ent : set) {
			if (i == index) {
				node = ent.getValue();
				break;
			}
			i++;
		}
		return node;
	}

	public int getChildCount() {
		return nodes.size();
	}

	public int getIndex(TreeNode tn) {
		if (!(tn instanceof STreeNode))
			return -1;
		Set<Entry<String, STreeNode>> set = nodes.entrySet();
		int i = 0;
		for (Entry<String, STreeNode> ent : set) {
			if (ent.getValue().equals(tn)) {
				break;
			}
			i++;
		}
		return i;
	}

	public boolean isLeaf() {
		return nodes.isEmpty();
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
	public boolean containsKey(Object key) {
		return nodes.containsKey(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsValue(Object value) {
		return nodes.containsValue(value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<java.util.Map.Entry<String, STreeNode>> entrySet() {
		return nodes.entrySet();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeNode get(Object key) {
		return nodes.get(key);
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
	public Set<String> keySet() {
		return nodes.keySet();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeNode put(String key, STreeNode value) {
		return nodes.put(key, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void putAll(Map<? extends String, ? extends STreeNode> m) {
		nodes.putAll(m);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public STreeNode remove(Object key) {
		return nodes.remove(key);
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
	public Collection<STreeNode> values() {
		return nodes.values();
	}

	/* Individual STreeNode get types */

	public BooleanArraySTreeNode getBooleanArray(String key) {
		return (BooleanArraySTreeNode) get(key);
	}

	public BooleanSTreeNode getBoolean(String key) {
		return (BooleanSTreeNode) get(key);
	}

	public ByteArraySTreeNode getByteArray(String key) {
		return (ByteArraySTreeNode) get(key);
	}

	public ByteSTreeNode getByte(String key) {
		return (ByteSTreeNode) get(key);
	}

	public CalendarSTreeNode getCalendar(String key) {
		return (CalendarSTreeNode) get(key);
	}

	public CharSTreeNode getChar(String key) {
		return (CharSTreeNode) get(key);
	}

	public DoubleSTreeNode getDouble(String key) {
		return (DoubleSTreeNode) get(key);
	}

	public FileSTreeNode getFile(String key) {
		return (FileSTreeNode) get(key);
	}

	public FloatSTreeNode getFloat(String key) {
		return (FloatSTreeNode) get(key);
	}

	public IntArraySTreeNode getIntArray(String key) {
		return (IntArraySTreeNode) get(key);
	}

	public IntSTreeNode getInt(String key) {
		return (IntSTreeNode) get(key);
	}

	public ListSTreeNode getList(String key) {
		return (ListSTreeNode) get(key);
	}

	public LongSTreeNode getLong(String key) {
		return (LongSTreeNode) get(key);
	}

	public MapSTreeNode getMap(String key) {
		return (MapSTreeNode) get(key);
	}

	public ShortSTreeNode getShort(String key) {
		return (ShortSTreeNode) get(key);
	}

	public StringSTreeNode getString(String key) {
		return (StringSTreeNode) get(key);
	}
}
