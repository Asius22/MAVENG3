package olympicsJPA;

import utils.JPAUtils;
import utils.Log;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class Repository implements BaseRepository<Athlete> {

    private EntityManager em;
    private EntityTransaction et;
    private static final Log l = Log.getInstance();

    public Repository() {
        em = JPAUtils.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public void persist(Athlete obj) {
        l.info("inizio persist...");
        et = em.getTransaction();
        et.begin();

        em.persist(obj);
        et.commit();
    }

    @Override
    public void delete(Athlete obj) {
        l.info("inizio delete...");
        et = em.getTransaction();
        et.begin();
        em.detach(obj);
        et.commit();
    }

    @Override
    public void update(Athlete obj) {
        l.info("inizio update...");

        et = em.getTransaction();
        et.begin();

        em.merge(obj);

        et.commit();
    }

    @Override
    public void findAll() {
        l.info("findAll ...");
        TypedQuery<Athlete> q = em.createQuery("select a from Athlete a", Athlete.class);

        printList(q.getResultList());
    }

    @Override
    public void findByPk(int pk) {
        l.info("findByPk...");
        TypedQuery<Athlete> q = em.createQuery("select a from Athlete a where a.code = :pk", Athlete.class);
        printList(q.getResultList());
    }

    @Override
    public void findByH(float height) {
        l.info("findByH...");
        TypedQuery<Athlete> q = em.createQuery("select a from Athlete a where a.height = :height", Athlete.class);
        printList(q.getResultList());
    }

    private void printList(List<Athlete> res){
        for (Athlete a : res) {
            l.info(a.toString());
        }
    }
}
