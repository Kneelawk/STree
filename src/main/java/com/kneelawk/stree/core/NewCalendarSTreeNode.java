package com.kneelawk.stree.core;

import java.util.Calendar;

import com.kneelawk.stree.core.infoProviders.NewCalendarSTreeNodeInfoProvider;
import com.kneelawk.stree.core.infoProviders.STreeInfoProvider;

/**
 * @deprecated Support for Calendar nodes is being removed. Please use
 *             MapSTreeNodes instead.
 * @author jedidiah
 *
 */
@Deprecated
public class NewCalendarSTreeNode extends STreeNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6314859802358144594L;

	public Calendar data;

	public NewCalendarSTreeNode() {
		data = Calendar.getInstance();
	}

	public NewCalendarSTreeNode(Calendar c) {
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
		return NewCalendarSTreeNodeInfoProvider.INSTANCE;
	}

	@Override
	public String toString(int indent) {
		String s = "<CalendarSTreeNode>:{\n" + indent(indent + 1)
				+ "zone_offset:" + data.get(Calendar.ZONE_OFFSET) + "\n"
				+ indent(indent + 1) + "millisecond:"
				+ data.get(Calendar.MILLISECOND) + "\n" + indent(indent + 1)
				+ "second:" + data.get(Calendar.SECOND) + "\n"
				+ indent(indent + 1) + "minute:" + data.get(Calendar.MINUTE)
				+ "\n" + indent(indent + 1) + "hour_of_day:"
				+ data.get(Calendar.HOUR_OF_DAY) + "\n" + indent(indent + 1)
				+ "day_of_year:" + data.get(Calendar.DAY_OF_YEAR) + "\n"
				+ indent(indent + 1) + "year:" + data.get(Calendar.YEAR) + "\n"
				+ indent(indent + 1) + "dst_offset:"
				+ data.get(Calendar.DST_OFFSET) + "\n" + indent(indent + 1)
				+ "era:" + data.get(Calendar.ERA) + "\n" + indent(indent) + "}";
		return s;
	}

}
