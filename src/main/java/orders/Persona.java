package orders;

import javax.persistence.*;
import java.util.List;

@Entity
public class Persona {
    @Id
    private int id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "lastName", length = 20)
    private String lastName;

    @OneToMany(
            mappedBy = "ordine",
            cascade = {CascadeType.ALL}
    )
    private List<Persona> orders;
}
