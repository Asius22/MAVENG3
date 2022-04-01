//package jpa;
//
//import utils.JPAUtils;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Query;
//
//public class JpaTest {
//    private EntityManagerFactory emf;
//    private EntityManager em;
//    private EntityTransaction et;
//    private Query q;
//
//    public void init() {
//        emf = JPAUtils.getEntityManagerFactory();
//        em = emf.createEntityManager();
//    }
//
//    public void createTransaction() {
//        init();
//        et = em.getTransaction();
//        et.begin();
//
//        Person person;
//        Family family;
//
//        q = em.createQuery("select m from Person m");
//
//
//    }
//
//    public void print() {
//        int numberRows = q.getResultList().size();
//        System.out.println(numberRows);
//    }
//
//    public static void main(String[] args) {
//        JpaTest jt = new JpaTest();
//        jt.createTransaction();
//    }
//}
