/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.factory;

import com.mycompany.horseracing.io.InputAction;
import com.mycompany.horseracing.io.InputActionType;
import com.mycompany.horseracing.model.GameInputAction;

/**
 * {@link InputActionFactory} factory class
 * 
 * @author colin
 */
public class InputActionFactory extends GameFactory<InputActionType, InputAction> {

	// eager initialization
	private static InputActionFactory factory = new InputActionFactory();
	
	private InputActionFactory() {}
	
	/**
	 * Singleton Design Pattern
	 * 
	 * @return factory
	 */
	public static InputActionFactory getFactory() {
		return factory;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public InputAction getObject(InputActionType type, Object... args) {
		if(type == InputActionType.GAME_INPUT_ACTION) {
			return new GameInputAction();
		}
		throw new RuntimeException();
	}
	
	
}
