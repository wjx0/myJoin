package myJoin.domain.product;

import myJoin.framework.domain.BaseDomain;

public class Product extends BaseDomain{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6455823158895354806L;

	private String id;
	
	private String name;
	
	private String description;
	
	private int quantity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
