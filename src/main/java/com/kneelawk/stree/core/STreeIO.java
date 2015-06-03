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

import java.io.BufferedInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * STreeIO used for reading and writing STree Nodes. Example:<code>
 * 			STreeIO.writeSTreeNodeToFile(
 * 				new File("data.st"),
 * 				new StringSTreeNode("Hello World!"));
 * 			System.out.println(
 * 				STreeIO.readSTreeNodeFromFile(
 * 					new File("data.st"));
 * </code>
 * 
 * @author Kneelawk
 * @see STreeNode
 */
public class STreeIO {

	/**
	 * used for writing an {@link STreeNode STreeNode} to an OutputStream If an
	 * Exception is thrown the OutputStream is still flushed an closed
	 * 
	 * @param os
	 *            the OutputStream to write to
	 * @param node
	 *            the {@link STreeNode STreeNode} to write
	 * @throws IOException
	 */
	public static void writeSTreeNodeToStream(OutputStream os, STreeNode node)
			throws IOException {
		STreeNode.writeSTreeNode(node, new DataOutputStream(os));
	}

	/**
	 * Used for writing an {@link STreeNode STreeNode} to a File
	 * 
	 * @param file
	 *            the File to write to
	 * @param node
	 *            the {@link STreeNode STreeNode} to write
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void writeSTreeNodeToFile(File file, STreeNode node)
			throws FileNotFoundException, IOException {
		writeSTreeNodeToStream(new FileOutputStream(file), node);
	}

	/**
	 * Writes an {@link STreeNode STreeNode} to a file but only overrides it if
	 * it wrote successfully
	 * 
	 * @param file
	 *            the File to write to
	 * @param node
	 *            the {@link STreeNode STreeNode} to write to
	 * @return true if it wrote successfully
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static boolean safeWriteSTreeNodeToFile(File file, STreeNode node)
			throws FileNotFoundException, IOException {
		File file2 = new File(file.getAbsolutePath() + "_tmp");
		if (file2.exists())
			file2.delete();
		writeSTreeNodeToFile(file2, node);
		if (file.exists())
			file.delete();
		if (file.exists())
			return false;
		file2.renameTo(file);
		return true;
	}

	/**
	 * Used for reading an {@link STreeNode STreeNode} from an InputStream If an
	 * Exception is thrown, the InputStream is still closed
	 * 
	 * @param is
	 *            the InputStream to read from
	 * @return the {@link STreeNode STreeNode} from the InputStream
	 * @throws IOException
	 */
	public static STreeNode readSTreeNodeFromStream(InputStream is)
			throws IOException {
		return STreeNode.readSTreeNode(new DataInputStream(
				new BufferedInputStream(is)));
	}

	/**
	 * Used for reading an {@link STreeNode STreeNode} from a file
	 * 
	 * @param file
	 *            the File to read from
	 * @return the {@link STreeNode STreeNode} from the file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static STreeNode readSTreeNodeFromFile(File file)
			throws FileNotFoundException, IOException {
		return readSTreeNodeFromStream(new FileInputStream(file));
	}

	/**
	 * Writes node to the provided DataOutput (useful for custom encoding)
	 * 
	 * @param out
	 *            the provided DataOutput
	 * @param node
	 *            the {@link STreeNode STreeNode} to write to out
	 * @throws IOException
	 */
	public static void writeSTreeNodeToDataOutput(DataOutput out, STreeNode node)
			throws IOException {
		STreeNode.writeSTreeNode(node, out);
	}

	/**
	 * Reads an {@link STreeNode STreeNode} from the provided DataInput
	 * 
	 * @param in
	 *            the DataInput to read from
	 * @return the loaded {@link STreeNode STreeNode}
	 * @throws IOException
	 */
	public static STreeNode readSTreeNodeFromDataInput(DataInput in)
			throws IOException {
		return STreeNode.readSTreeNode(in);
	}
}
