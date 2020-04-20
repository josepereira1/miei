package pt.uminho.di.aa;

public class Game {

	private String name;
	private int year;
	private float price;
	private String description;

	public String getName() {
		return this.name;
	}

	public int getYear() {
		return this.year;
	}

	public float getPrice() {
		return this.price;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * 
	 * @param price                                 
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}