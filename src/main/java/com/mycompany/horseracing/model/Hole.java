/**
 * 
 */
package com.mycompany.horseracing.model;

/**
 * @author colin
 *
 */
public class Hole implements GameObject {

	private int number;

	public Hole(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
