package com.example.spring.Controller;

import com.example.spring.Dao.DecorationDao;
import com.example.spring.Dao.DistrictDao;
import com.example.spring.Dao.ElevatorDao;
import com.example.spring.Dao.TotalDao;
import com.example.spring.Pojo.Decoration;
import com.example.spring.Pojo.District;
import com.example.spring.Pojo.Elevator;
import com.example.spring.Pojo.Total;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/house")

public class HouseController {
    @Autowired
    private DecorationDao decorationDao;
    @Autowired
    private DistrictDao districtDao;
    @Autowired
    private ElevatorDao elevatorDao;
    @Autowired
    private TotalDao totalDao;

    @RequestMapping("/decoration")
    public List<Decoration> getDecoration() {
        return decorationDao.findAll();
    }
    @RequestMapping("/district")
    public List<District> getDistrict() {
        return districtDao.findAll();
    }
    @RequestMapping("/elevator")
    public List<Elevator> getElevator() {
        return elevatorDao.findAll();
    }
    @RequestMapping("/total")
    public List<Total> getTotal() {
        return totalDao.findAll();
    }
}
