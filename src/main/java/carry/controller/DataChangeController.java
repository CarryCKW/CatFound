package carry.controller;


import carry.dao.CatDao;
import carry.repository.Cat;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DataChangeController {

    @Autowired
    private CatDao catDao;

//    @RequestMapping(value = "/changeAdopted",method = RequestMethod.POST)
//    @ResponseBody
//    public boolean changeAdopted(long id){
//        System.out.println(id);
//        Cat cat = catDao.find(id);
//        boolean isAdopted = cat.getAdopted();
//        System.out.println(isAdopted);
//        return isAdopted;
//    }

    @RequestMapping(value = "/changeAdopted",method = RequestMethod.POST)
    public Map<Long,Boolean> changeAdopted(long id){
        System.out.println(id);
        Cat cat = catDao.find(id);
        boolean isAdopted = cat.getAdopted();
        System.out.println(isAdopted);
        Map<Long,Boolean> map = new HashMap<>();
        map.put(id,isAdopted);
        return map;
    }


}
