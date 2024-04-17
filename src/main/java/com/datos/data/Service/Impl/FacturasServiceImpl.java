package com.datos.data.Service.Impl;

import com.datos.data.Repository.FacturasRepository;
import com.datos.data.Service.IFacturasService;
import com.datos.data.model.Facturas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;



public class FacturasServiceImpl implements IFacturasService {

    private static final String JSON_API_URL_FACTURAS = "https://www.datos.gov.co/resource/ibyt-yi2f.json?$query=select * limit 100000";
    @Autowired
    private FacturasRepository facturasRepository;

    private final WebClient webClient;

    @Autowired
    public FacturasServiceImpl(FacturasRepository facturasRepository, WebClient.Builder webClientBuilder){
        this.facturasRepository = facturasRepository;
        this.webClient = webClientBuilder.baseUrl(JSON_API_URL_FACTURAS).build();
    }
    @Override
    public void fetchDataFromJsonApiAndSaveToDatabaseFacturas(){
        List<Facturas> suppliers = webClient.get()
                .uri(JSON_API_URL_FACTURAS)
                .retrieve()
                .bodyToFlux(Facturas.class)
                .collectList().block();
        if (suppliers != null && !suppliers.isEmpty()){
            facturasRepository.saveAll(suppliers);
        }
    }


}
