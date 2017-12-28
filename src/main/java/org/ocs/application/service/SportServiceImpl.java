package org.ocs.application.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import org.ocs.exception.SportNotFoundException;
import org.ocs.model.Sport;
import org.ocs.model.SportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
/**
 * Implements every single operation that can be done on Sport objects. 
 * 
 * @author rpila
 * @version 1.0 - 28/12/2017
 *
 */
@Service
final class SportServiceImpl implements SportService {
 
    private final SportRepository repository;
 
    @Autowired
    SportServiceImpl(SportRepository repository) {
        this.repository = repository;
    }
 
    @Override
    public SportDTO create(SportDTO sportDTO) {
        Sport persisted = new Sport(sportDTO.getName(), sportDTO.getPlayers());
        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }
 
    @Override
    public SportDTO delete(String id) {
        Sport deleted = findSportById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }
 
    @Override
    public List<SportDTO> findAll() {
        List<Sport> todoEntries = repository.findAll();
        return convertToDTOs(todoEntries);
    }
 
    private List<SportDTO> convertToDTOs(List<Sport> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }
 
    @Override
    public SportDTO findById(String id) {
    	Sport found = findSportById(id);
        return convertToDTO(found);
    }
 
    @Override
    public SportDTO update(SportDTO sport) {
    	Sport updated = findSportById(sport.getId());
        updated.update(sport.getName(), sport.getPlayers());
        updated = repository.save(updated);
        return convertToDTO(updated);
    }
 
    private Sport findSportById(String id) {
        Optional<Sport> result = repository.findOne(id);
        return result.orElseThrow(() -> new SportNotFoundException(id));
    }
 
    private SportDTO convertToDTO(Sport model) {
    	SportDTO dto = new SportDTO();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setPlayers(model.getPlayers());
        return dto;
    }

}