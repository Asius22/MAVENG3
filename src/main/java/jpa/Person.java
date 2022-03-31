package jpa;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Person {
    private String id, name, lastName;
}
