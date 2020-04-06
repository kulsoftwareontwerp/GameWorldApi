package com.kuleuven.swop.group17.GameWorldApi;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;


/**
 * The GameWorldType defines the characteristics of a GameWorld.
 * 
 * @version 0.1
 * @author group17
 */
public interface GameWorldType {

	/**
	 * Retrieve the actions supported by this gameWorld.
	 * 
	 * @return a set with the supported actions of this gameWorld.
	 */
	public Set<Action> supportedActions();

	/**
	 * Retrieve the predicates supported by this gameWorld.
	 * 
	 * @return a set with the supported predicates of this gameWorld.
	 */
	public Set<Predicate> supportedPredicates();

	/**
	 * Retrieve an GameWorld instance for the given className
	 * 
	 * @param className The class name of the root class of a Game World API
	 *                  implementation.
	 * @return The corresponding gameWorld instance or null if no gameWorld instance
	 *         was found in the runtime environment that matches the given
	 *         className.
	 */
	public static GameWorld createInstance(String className) {
		try {
			Class<?> gameWorldClass;
			gameWorldClass = Class.forName(className);
			GameWorld gameWorld = (GameWorld) gameWorldClass.getConstructor().newInstance();
			return gameWorld;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			return null;
		}
	}
}
