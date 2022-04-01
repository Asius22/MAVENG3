package orders;

public interface EntityMethods<T> {
    void persist(T obj);

    void delete(T obj);

    void update(T obj);

    void findAll();

    void findByPk(int pk);

    void findByForeignKey(int fk);
}
