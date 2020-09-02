package carry.service;

import carry.dao.CatDao;
import carry.repository.Cat;
import carry.repository.CatPicture;
import carry.repository.Catty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
public class CatInfoImpl implements CatInfo{

    @Autowired
    private CatDao catDao;

    //用于显示上下页一定数量的猫信息
    @Override
    public Map<Long, Catty> getCattyList(int startCursor,int endCursor) {
        Map<Long,Catty> map = new HashMap<Long, Catty>();
        List<Cat> catList = catDao.findByLimit(startCursor,endCursor);
        CatPicture catPicture = null;
        Catty catty = null;
        for (int i=0;i<catList.size();++i){
            Long id = catList.get(i).getId();
            catPicture = catDao.findCatPicture(id);
            catty = new Catty(catList.get(i),catPicture);
            map.put(id,catty);
        }
        return map;
    }

    @Override
    public List<Cat> getAllCat() {
        List<Cat> catList = catDao.findAll();
        return catList;
    }

    @Override
    public Map<Long, Cat> getCatList(int startCursor, int endCursor) {
        return null;
    }

    @Override
    public Catty getCattyInfoById(Long catId) {
        return null;
    }
}
