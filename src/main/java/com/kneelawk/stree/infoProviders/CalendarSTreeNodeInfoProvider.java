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
