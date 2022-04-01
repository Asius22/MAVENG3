package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import utils.Log;
import org.hibernate.cfg.Configuration;

public class Main {
    private Log l = Log.getInstance();
    public static void main(String[] args) {
        Main m = new Main();
        m.run();
    }

    public void run() {
        SessionFactory sf = null;
        Session session = null;
        Configuration configuration = new Configuration();
        configuration.configure("META-INF\\hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        sf = configuration.buildSessionFactory();
        session = sf.openSession();
        persistPerson(session);

    }

    private void persistPerson(Session session) {
        try {

            Transaction t = session.getTransaction();
            t.begin();

            Person person = new Person();
            person.setName("Ciro");
            person.setLastName("malafronte");
            person.setId("1");
            session.persist(person);
            t.commit();
        } catch (Exception e) {
            l.info(e.getMessage());
            e.printStackTrace();
        }
    }
}
