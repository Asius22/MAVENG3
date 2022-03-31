package jpa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "familyId")
    private String id;

    @Column(length = 100)
    private String description;

    @ManyToOne
    @JoinColumn(name = "familyId")
    private Family family;
}
