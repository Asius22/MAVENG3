package jpa;

import lombok.Data;

import javax.persistence.Entity;

@Entity
public class Family {
    private String id, description;
}
