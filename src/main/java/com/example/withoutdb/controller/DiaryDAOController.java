package com.example.withoutdb.controller;


import com.example.withoutdb.DAO.DiaryDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/diaryDD")
//diary Drop down values

public class DiaryDAOController {
    private final DiaryDAO diaryDAO;

    public DiaryDAOController(DiaryDAO diaryDAO) {
        this.diaryDAO = diaryDAO; ;
    }
    @GetMapping
    public Map<String, List<String>> getDiary() {
        System.out.println("Connection reached DiaryDAOController getDiary method\n");
        return diaryDAO.getDiary();
    }
}
