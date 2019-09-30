package com.abbyy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ocrtest")
public class BlockInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int top;
	private int bottom;
	private int left;
	private int right;
	private String text;

	public BlockInfo() {
	}

	public BlockInfo(int id,int top, int bottom, int left, int right, String text) {
		super();
		this.id = id;
		this.top = top;
		this.bottom = bottom;
		this.left = left;
		this.right = right;
		this.text = text;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getBottom() {
		return bottom;
	}

	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
