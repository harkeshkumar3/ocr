package com.abbyy.model;

public class BlockFinderParam {

	private int top;
	//private int bottom;
	private int minleft;
	private int maxleft;
	private String blockName;

	public BlockFinderParam() {
	}

	public BlockFinderParam(int top, int minleft, int maxleft, String blockName) {
		super();
		this.top = top;
		this.minleft = minleft;
		this.maxleft = maxleft;
		this.blockName = blockName;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getMinleft() {
		return minleft;
	}

	public void setMinleft(int minleft) {
		this.minleft = minleft;
	}

	public int getMaxleft() {
		return maxleft;
	}

	public void setMaxleft(int maxleft) {
		this.maxleft = maxleft;
	}

}
