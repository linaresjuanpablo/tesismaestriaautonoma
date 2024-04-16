package com.datos.data.Controller;

import com.datos.data.Service.Impl.FacturasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/save/facturas")

public class FacturasControllerSave {

    @Autowired
    private FacturasServiceImpl facturasServiceImpl;

    @GetMapping
    public void guardarFacturas(){
        facturasServiceImpl.fetchDataFromJsonApiAndSaveToDatabaseFacturas();
    }
}
