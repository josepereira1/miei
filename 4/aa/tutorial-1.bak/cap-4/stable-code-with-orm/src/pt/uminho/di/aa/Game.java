/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: josepereira(Universidade do Minho)
 * License Type: Academic
 */
package pt.uminho.di.aa;

public class Game {
	public Game() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_GAME_PLATFORMS) {
			return ORM_platforms;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private String name;
	
	private int year;
	
	private float price;
	
	private String description;
	
	private java.util.Set ORM_platforms = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setYear(int value) {
		this.year = value;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setPrice(float value) {
		this.price = value;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	private void setORM_Platforms(java.util.Set value) {
		this.ORM_platforms = value;
	}
	
	private java.util.Set getORM_Platforms() {
		return ORM_platforms;
	}
	
	public final pt.uminho.di.aa.PlatformSetCollection platforms = new pt.uminho.di.aa.PlatformSetCollection(this, _ormAdapter, ORMConstants.KEY_GAME_PLATFORMS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
