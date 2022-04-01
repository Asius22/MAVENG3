package orders;

import utils.JPAUtils;
import utils.Log;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonaUtils implements EntityMethods<Persona> {
    private final EntityManager em;
    private EntityTransaction et;
    private static final Log l = Log.getInstance();

    public PersonaUtils() {
        em = JPAUtils.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public void persist(Persona obj) {
        et = em.getTransaction();
        et.begin();

        em.persist(obj);

        et.commit();
    }

    @Override
    public void delete(Persona obj) {
        et = em.getTransaction();
        et.begin();

        em.detach(obj);
        em.remove(obj);

        et.commit();
    }

    @Override
    public void update(Persona obj) {
        et = em.getTransaction();
        et.begin();

        em.merge(obj);

        et.commit();
    }

    @Override
    public void findAll() {
        et = em.getTransaction();
        et.begin();

        TypedQuery<Persona> q = em.createQuery("select p from Persona p", Persona.class);
        print(q.getResultList());
        et.commit();
    }

    private void print(List<Persona> res) {
        for (Persona p : res)
            l.info(p.toString());
    }

    @Override
    public void findByPk(int pk) {
        et = em.getTransaction();
        et.begin();

        TypedQuery<Persona> q = em.createQuery("select p from Persona p where p.id = :pk", Persona.class);
        l.info(q.getSingleResult().toString());
        et.commit();
    }

    @Override
    public void findByForeignKey(int fk){
       l.info("persona non ha chievi secondarie");
    }
}
