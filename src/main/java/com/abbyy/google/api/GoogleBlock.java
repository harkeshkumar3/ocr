package com.abbyy.google.api;

public class GoogleBlock {

	private String text;
	private EdgeDetails topLeft;
	private EdgeDetails topRight;
	private EdgeDetails bottomRight;
	private EdgeDetails bottomLeft;

	public GoogleBlock() {
	}
	
	

	public GoogleBlock(String text, EdgeDetails topLeft, EdgeDetails topRight, EdgeDetails bottomRight,
			EdgeDetails bottomLeft) {
		super();
		this.text = text;
		this.topLeft = topLeft;
		this.topRight = topRight;
		this.bottomRight = bottomRight;
		this.bottomLeft = bottomLeft;
	}



	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public EdgeDetails getTopLeft() {
		return topLeft;
	}

	public void setTopLeft(EdgeDetails topLeft) {
		this.topLeft = topLeft;
	}

	public EdgeDetails getTopRight() {
		return topRight;
	}

	public void setTopRight(EdgeDetails topRight) {
		this.topRight = topRight;
	}

	public EdgeDetails getBottomRight() {
		return bottomRight;
	}

	public void setBottomRight(EdgeDetails bottomRight) {
		this.bottomRight = bottomRight;
	}

	public EdgeDetails getBottomLeft() {
		return bottomLeft;
	}

	public void setBottomLeft(EdgeDetails bottomLeft) {
		this.bottomLeft = bottomLeft;
	}
	
	
	

}

class EdgeDetails {
	private int x;
	private int y;
	
	

	public EdgeDetails(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}