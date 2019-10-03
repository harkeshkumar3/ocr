package com.abbyy.google.api;

public class GooglefilterSet {
	
	private String text;
	private int top;
	private int bottom;
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
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
	public GooglefilterSet(String text, int top, int bottom) {
		super();
		this.text = text;
		this.top = top;
		this.bottom = bottom;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bottom;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + top;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GooglefilterSet other = (GooglefilterSet) obj;
		if (bottom != other.bottom)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (top != other.top)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GooglefilterSet [text=" + text + ", top=" + top + ", bottom=" + bottom + "]";
	}
	
	
	
	
	

}
