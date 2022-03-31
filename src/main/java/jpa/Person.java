package jpa;

import lombok.Data;

import javax.persistence.Entity;
@Entity
public class Person {
    private String id, name, lastName;
}
