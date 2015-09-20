/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.factory;

/**
 * {@link GameFactory} factory - abstract class represents a family of factories
 * 
 * @author colin
 *
 */
public abstract class GameFactory <T, R> {

	/**
	 * Creates an object of type R given by the type T
	 * 
	 * @param type the type of R to create
	 * @return R
	 */
	public abstract R getObject(T type, Object... args);
}
