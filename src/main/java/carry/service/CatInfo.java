package carry.service;

import carry.repository.Cat;
import carry.repository.Catty;

import java.util.List;
import java.util.Map;

public interface CatInfo {
    Map<Long, Catty> getCattyList(int startCursor,int endCursor);
    Catty getCattyInfoById(Long catId);
    Map<Long,Cat> getCatList(int startCursor,int endCursor);
    List<Cat> getAllCat();
}
