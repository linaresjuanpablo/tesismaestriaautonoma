package com.datos.data.job;

import com.datos.data.Service.IDatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DatosGuardadosScheduled {

    @Autowired
    private IDatosService datosService;

    @Scheduled(cron = "20 * * * * *")
    public void scheduledDatosAutomaticos(){

        //datosService.fetchDataFromJsonApiAndSaveToDatabase();
    }
}
