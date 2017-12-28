package org.ocs.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Information of every sport entry to be propagated to the database.
 * 
 * @author rpila
 * @version 1.0 - 28/12/2017
 */
public final class SportDTO {

    private String id;

    @Size(max = Sport.MAX_LENGTH_NAME)
    @NotNull
    private String name;
    
    @NotNull
    private Integer players;

    public SportDTO() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPlayers() {
        return players;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayers(Integer players) {
        this.players = players;
    }
}