package orders;

import javax.persistence.*;
import java.util.List;

@Entity
public class Persona {
    @Id
    @Column(name = "personID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "lastName", length = 20)
    private String lastName;

    @OneToMany
    private List<Ordine> ordini;

    public Persona() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Ordine> getOrdini() {
        return ordini;
    }

    public void setOrdini(List<Ordine> ordini) {
        this.ordini = ordini;
    }
}
