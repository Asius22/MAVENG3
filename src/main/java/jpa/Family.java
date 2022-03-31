package jpa;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Family {
    private String id, description;
}
