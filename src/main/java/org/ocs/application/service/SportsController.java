package org.ocs.application.service;

import java.util.List;

import javax.validation.Valid;

import org.ocs.exception.ApiError;
import org.ocs.exception.SportNotFoundException;
import org.ocs.model.SportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * API Rest to make CRUD operations on Sports entities. 
 * 
 * @author rpila 
 * @version 1.0 - 28/12/2017 
 *
 */
@RestController
@RequestMapping(value = "/sports")
public class SportsController {

	private final SportService service;

	@Autowired
	SportsController(SportService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	SportDTO create(@RequestBody @Valid SportDTO SportEntry) {
		return service.create(SportEntry);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	SportDTO delete(@PathVariable("id") String id) {
		return service.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	List<SportDTO> findAll() {
		return service.findAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	SportDTO findById(@PathVariable("id") String id) {
		return service.findById(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	SportDTO update(@RequestBody @Valid SportDTO SportEntry) {
		return service.update(SportEntry);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> handleSportNotFound(SportNotFoundException ex) {
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
	    apiError.setMessage(ex.getMessage());
	    return buildResponseEntity(apiError);
	}
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
	    return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}
