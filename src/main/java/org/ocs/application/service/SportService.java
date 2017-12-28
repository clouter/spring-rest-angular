package org.ocs.application.service;

import java.util.List;

import org.ocs.model.SportDTO;

/**
 * Interface that declares the methods that provides CRUD operations for
 * Sport objects.
 * 
 * @author rpila
 * @version 1.0 - 28/12/2017
 */
interface SportService {

    /**
     * Creates a new Sport entry.
     * @param sport The information of the created sport entry.
     * @return The information of the created sport entry.
     */
    SportDTO create(SportDTO sport);

    /**
     * Deletes a Sport entry.
     * @param id The id of the deleted sport entry.
     * @return THe information of the deleted sport entry.
     */
    SportDTO delete(String id);

    /**
     * Finds all Sport entries.
     * @return The information of all sports entries.
     */
    List<SportDTO> findAll();

    /**
     * Finds a single Sport entry.
     * @param id The id of the requested Sport entry.
     * @return The information of the requested sport entry.
     */
    SportDTO findById(String id);

    /**
     * Updates the information of a Sport entry.
     * @param sport The information of the updated Sport entry.
     * @return The information of the updated Sport entry.
     */
    SportDTO update(SportDTO sport);
}
