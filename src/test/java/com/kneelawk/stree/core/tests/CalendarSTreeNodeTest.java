package com.kneelawk.stree.core.tests;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.junit.Test;

import com.kneelawk.stree.core.NewCalendarSTreeNode;
import com.kneelawk.stree.core.STreeIO;

public class CalendarSTreeNodeTest {

	@Test
	public void serializedCalendarShouldEqualOriginal() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Calendar original = Calendar.getInstance();
		STreeIO.writeSTreeNodeToStream(baos, new NewCalendarSTreeNode(original));
		byte[] data = baos.toByteArray();
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		NewCalendarSTreeNode node = (NewCalendarSTreeNode) STreeIO
				.readSTreeNodeFromStream(bais);
		Calendar copied = node.getValue();
		assertEquals(original, copied);
	}
}
