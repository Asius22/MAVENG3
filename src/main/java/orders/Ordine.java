package orders;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ordine {
    @Id @Column(name = "orderId")
    private int id;
    @OneToOne
    @JoinColumn(name = "personID")
    private Persona persona;

    public Ordine(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}