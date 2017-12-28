package org.ocs.exception;

/**
 * Thrown when the sport has not been found on the database
 * 
 * @author rpila
 * @version 1.0 - 28/12/2017
 */
public class SportNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SportNotFoundException(String id) {
        super(String.format("No sport entry found with id: <%s>", id));
    }
}