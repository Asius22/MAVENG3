package olympics;

import java.sql.Date;

public class Test {
    public static void main(String[] args) {
        BaseRepository<Athlete> br = new RepositoryHelper();
        Athlete obj = Athlete.builder()
                .name("Ciro")
                .height(1.34f)
                .nation("italia")
                .birthdate(new Date(2000, 1,17))
                .build();

        br.persist(obj);
        br.findAll();
        br.findByH(1.2f);
        br.findByPk(1);

        obj.setName("gianfracchio");
        obj.setCode(2);
        br.update(obj);
        br.findAll();

    }
}
