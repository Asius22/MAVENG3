package olympics;

public interface BaseRepository<T>{
    void persist(T obj);
    void delete(T obj);
    void update(T obj);
    void findAll();
    void findByPk(int pk);
    void findByH(float height);
}
