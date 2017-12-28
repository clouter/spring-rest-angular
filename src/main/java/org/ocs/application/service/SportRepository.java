package org.ocs.application.service;

import org.ocs.model.Sport;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * CRUD operations on Sport entries.
 * 
 * @author rpila
 * @version 1.0 - 28/12/2017
 */
interface SportRepository extends Repository<Sport, String> {

    /**
     * Deletes a Sport entry from the database.
     * @param deleted The deleted Sport entry.
     */
    void delete(Sport deleted);

    /**
     * Finds all Sport entries from the database.
     * @return  The information of all Sport entries that are found from the database.
     */
    List<Sport> findAll();

    /**
     * Finds the information of a single Sport entry.
     * @param id    The id of the requested Sport entry.
     * @return      The information of the found Sport entry. If no Sport entry
     *              is found, this method returns an empty {@link java.util.Optional} object.
     */
    Optional<Sport> findOne(String id);

    /**
     * Saves a new Sport entry to the database.
     * @param saved The information of the saved Sport entry.
     * @return      The information of the saved Sport entry.
     */
    Sport save(Sport saved);
}
