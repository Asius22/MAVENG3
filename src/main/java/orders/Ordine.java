package orders;

import javax.persistence.*;

@Entity
public class Ordine {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "personID")
    private Ordine personID;

}
