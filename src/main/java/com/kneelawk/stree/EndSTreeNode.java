package com.kneelawk.stree;

import com.kneelawk.stree.infoProviders.EndSTreeNodeInfoProvider;
import com.kneelawk.stree.infoProviders.STreeInfoProvider;
/**
 * EndSTreeNode - usualy put at the end of a {@link MapSTreeNode MapSTreeNode}'s inner nodes
 * @author Jed Pommert
 *
 */
public class EndSTreeNode extends STreeNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7078963500163036276L;

	@Override
	public Object getValue() {
		return null;
	}
	
	@Override
	public void setValue(Object o) {
		
	}

	@Override
	public STreeInfoProvider getInfoProvider() {
		return new EndSTreeNodeInfoProvider();
	}

	@Override
	public String toString(int indent) {
		return "<EndSTreeNode>";
	}
}
