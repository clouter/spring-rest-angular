package org.ocs.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

/**
 * Entity class that contains all the information related to a Sport. 
 * 
 * @author rpila
 * @version 1.0 - 28/12/2017
 *
 */
public class Sport {
	
    static final int MAX_LENGTH_NAME = 100;
	
	@Id
	private String id;
	
	@NotEmpty
	private String name;
	
	@NotNull
	private Integer players;

	public Sport() {
		super();
	}

	public Sport(String name, Integer players) {
		super();
		this.name = name;
		this.players = players;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPlayers() {
		return players;
	}

	public void setPlayers(Integer players) {
		this.players = players;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void update(String name, Integer players) {
        this.name = name;
        this.players = players;
    }
}