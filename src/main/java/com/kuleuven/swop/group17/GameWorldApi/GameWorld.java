package com.kuleuven.swop.group17.GameWorldApi;

import java.awt.Graphics;

/**
 * A GameWorld is described by a GameWorldType. GameWorlds are able to perform
 * Actions, evaluate predicates, save and restore their state and draw
 * themselves on a given graphics object.
 * 
 * @version 0.1
 * @author group17
 */
public interface GameWorld {

	/**
	 * Perform the given action on the gameWorld.
	 * 
	 * @param action The action that should be performed.
	 * @throws UnsupportedOperationException when an action was given that's not
	 *                                       listed in the supportedActions of the
	 *                                       corresponding gameWorldType of this
	 *                                       gameWorld.
	 * @throws NullPointerException          when the given action is null.
	 * @throws RuntimeException              when something went wrong in the
	 *                                       evaluation of the predicate.
	 */
	public void performAction(Action action)
			throws UnsupportedOperationException, NullPointerException, RuntimeException;

	/**
	 * Evaluates the given predicate on the gameWorld.
	 * 
	 * @param predicate The predicate that should be evaluated.
	 * @throws UnsupportedOperationException when a predicate was given that's not
	 *                                       listed in the supportedPredicates of
	 *                                       the corresponding gameWorldType of this
	 *                                       gameWorld.
	 * @throws NullPointerException          when the given predicate is null.
	 * @throws RuntimeException              when something went wrong in the
	 *                                       evaluation of the predicate.
	 * @return the evaluation of the given predicate.
	 */
	public Boolean evaluate(Predicate predicate)
			throws UnsupportedOperationException, NullPointerException, RuntimeException;

	/**
	 * Saves the current state of the gameWorld.
	 * 
	 * @return a non inspectable snapshot with current state of the gameWorld
	 */
	public GameWorldSnapshot saveState();

	/**
	 * Set the state of the gameWorld to the given gameWorldState
	 * 
	 * @param state the state to which the gameWorld should be set.
	 * @throws IllegalArgumentException when the given state is not a state of this
	 *                                  gameWorld.
	 * @throws NullPointerException     when the given GameWorlSnapshot is null.
	 */
	public void restoreState(GameWorldSnapshot state) throws IllegalArgumentException;

	/**
	 * Paint the gameWorld on the given graphics object.
	 * 
	 * @param graphics the graphics object on which the gameWorld should be painted.
	 * @throws NullPointerException when the given graphics object is null.
	 * @throws RuntimeException     when something went wrong during painting
	 */
	public void paint(Graphics graphics) throws NullPointerException, RuntimeException;

	/**
	 * Retrieve the gameWorldType associated with this gameWorld.
	 * 
	 * @return the gameWorldType associated with this gameWorld
	 */
	public GameWorldType getType();

}
