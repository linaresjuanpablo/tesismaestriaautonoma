package com.datos.data.Controller;

import com.datos.data.Service.Impl.DatosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/consume-and-save")
public class ConsumeAndSaveController {

    @Autowired
    private DatosServiceImpl datosServiceImpl;

    @GetMapping
    public void consumeAndSave() {
        datosServiceImpl.fetchDataFromJsonApiAndSaveToDatabase();
    }
}
