package com.rest_spring_boot.dto;

public abstract class EntityDTO implements IEntityDTO{
    protected long id;

    public EntityDTO(long id) {
        this.id = id;
    }

    public EntityDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
