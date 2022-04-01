package orders;

import utils.JPAUtils;
import utils.Log;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrdineUtils implements EntityMethods<Ordine>{
    private final EntityManager em;
    private EntityTransaction et;
    private static final Log l = Log.getInstance();

    public OrdineUtils() {
        em = JPAUtils.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public void persist(Ordine obj) {
        et = em.getTransaction();
        et.begin();

        em.persist(obj);

        et.commit();
    }

    @Override
    public void delete(Ordine obj) {
        et = em.getTransaction();
        et.begin();

        em.remove(obj);

        et.commit();
    }

    @Override
    public void update(Ordine obj) {
        et = em.getTransaction();
        et.begin();

        em.merge(obj);

        et.commit();
    }

    @Override
    public void findAll() {
        et = em.getTransaction();
        et.begin();

        TypedQuery<Ordine> q = em.createQuery("select o from Ordine o", Ordine.class);
        print(q.getResultList());
        et.commit();
    }

    @Override
    public void findByPk(int pk) {
        et = em.getTransaction();
        et.begin();

        TypedQuery<Ordine> q = em.createQuery("select o from Ordine o where o.id = :pk", Ordine.class);
        l.info(q.getSingleResult().toString());
        et.commit();
    }

    @Override
    public void findByForeignKey(int fk){
        et = em.getTransaction();
        et.begin();

        TypedQuery<Ordine> q = em.createQuery("select o from Ordine o where o.persona.id = :fk", Ordine.class);
        print(q.getResultList());
        et.commit();
    }
    private void print(List<Ordine> res){
        for (Ordine o: res)
            l.info(o.toString());
    }
}
