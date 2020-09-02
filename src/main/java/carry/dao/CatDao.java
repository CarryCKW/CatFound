package carry.dao;


import carry.repository.Cat;
import carry.repository.CatPicture;
import carry.repository.Variety;

import java.util.List;

public interface CatDao {
    public void insert(Cat cat);
    public void update(Cat cat);
    public void delete(long catId);
    public void update(List<Cat> cats);
    public Cat find(long catId);
    public List<Cat> find(List<Long> catIds);
    public List<Cat> find(Variety variety);
    public CatPicture findCatPicture(long catId);
    public List<Cat> findByLimit(int startCursor,int endCursor);
    List<Cat> findAll();
}
