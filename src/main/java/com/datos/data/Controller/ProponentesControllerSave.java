package com.datos.data.Controller;

import com.datos.data.Service.Impl.ProponentesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/save/proponentes")

public class ProponentesControllerSave {
    @Autowired
    private ProponentesServiceImpl proponentesServiceImpl;

    @GetMapping
    public void guardarProponentes(){
        proponentesServiceImpl.fetchDataFromJsonApiAndSaveToDatabaseProponentes();
    }
}
