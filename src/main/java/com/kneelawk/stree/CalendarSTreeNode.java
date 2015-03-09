package com.kneelawk.stree;

import java.util.Calendar;

import com.kneelawk.stree.infoProviders.CalendarSTreeNodeInfoProvider;
import com.kneelawk.stree.infoProviders.STreeInfoProvider;

public class CalendarSTreeNode extends STreeNode {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8051856989852427073L;
	public Calendar data;
	
	public CalendarSTreeNode(){
		data = Calendar.getInstance();
	}
	
	public CalendarSTreeNode(Calendar c){
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
		return new CalendarSTreeNodeInfoProvider();
	}

	@Override
	public String toString(int indent) {
		String s = "<CalendarSTreeNode>:{\n" +
				indent(indent + 1) + "millisecond:" + data.get(Calendar.MILLISECOND) + "\n" +
				indent(indent + 1) + "second:" + data.get(Calendar.SECOND) + "\n" +
				indent(indent + 1) + "minute:" + data.get(Calendar.MINUTE) + "\n" +
				indent(indent + 1) + "hour_of_day:" + data.get(Calendar.HOUR_OF_DAY) + "\n" +
				indent(indent + 1) + "day_of_year:" + data.get(Calendar.DAY_OF_YEAR) + "\n" +
				indent(indent + 1) + "year:" + data.get(Calendar.YEAR) + "\n" +
				indent(indent + 1) + "dst_offset:" + data.get(Calendar.DST_OFFSET) + "\n" +
				indent(indent) + "}";
		return s;
	}

}
