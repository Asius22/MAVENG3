package olympicsJPA;

import java.sql.Date;

public class Test {
    public static void main(String[] args) {
        BaseRepository<Athlete> br = new Repository();
        Athlete a = new Athlete();
        a.setName("ciro");
        a.setHeight(1.8f);
        a.setNation("Francia");
        a.setBirthdate(new Date(2000,1,17));
        System.out.println(a);
        //br.persist(a);
        a.setCode(8);
        br.update(a);
        br.findAll();

    }
}
