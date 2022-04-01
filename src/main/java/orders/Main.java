package orders;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Persona p = new Persona();
       /* p.setLastName("Malafronte");
        p.setName("Ciro");
        p.setOrdini(new ArrayList<>());
        PersonaUtils pu = new PersonaUtils();
        pu.persist(p);

        pu.findAll();*/

        Ordine o = new Ordine();
        OrdineUtils ou = new OrdineUtils();
        p.setId(3);
        o.setPersona(p);
        ou.persist(o);
        ou.findAll();
    }
}
