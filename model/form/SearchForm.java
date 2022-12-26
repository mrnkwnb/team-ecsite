package jp.co.internous.utopia.model.form;

import java.io.Serializable;

public class SearchForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int category;
	private String itemName;
	
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
