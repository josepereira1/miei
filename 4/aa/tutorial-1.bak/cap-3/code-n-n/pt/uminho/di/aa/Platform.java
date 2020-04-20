package pt.uminho.di.aa;

import java.util.*;

public class Platform {

	private String name;
	private int year;
	private String description;
	private String manufacture;
	Collection<Game> games;

	public String getName() {
		return this.name;
	}

	public int getYear() {
		return this.year;
	}

	public String getDescription() {
		return this.description;
	}

	public String getManufacture() {
		return this.manufacture;
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
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @param manufacture
	 */
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

}