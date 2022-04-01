//package jpa;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Person {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "personId")
//    private String id;
//
//    @Column(length = 100)
//    private String name, lastName;
//
//    @OneToMany(
//            mappedBy = "Family",
//            cascade = {CascadeType.ALL}
//    )
//    private List<Person> persona = new ArrayList<>();
//}