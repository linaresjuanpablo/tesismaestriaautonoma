package com.datos.data.Service.Impl;

import com.datos.data.Repository.ProponentesRepository;
import com.datos.data.Service.IDatosService;
import com.datos.data.Service.IProponenteService;
import com.datos.data.model.Proponentes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.function.Supplier;

@Service

public class ProponentesServiceImpl implements IProponenteService {


    private static final String JSON_API_URL_PROPONENTES = "https://www.datos.gov.co/resource/hgi6-6wh3.json?$query=select * limit 100000";

    @Autowired
    private ProponentesRepository proponentesRepository;

    private final WebClient webClient;

    @Autowired
    public ProponentesServiceImpl(ProponentesRepository proponentesRepository, WebClient.Builder webClientBuider){
        this.proponentesRepository = proponentesRepository;
        this.webClient = webClientBuider.baseUrl(JSON_API_URL_PROPONENTES).build();
    }
    @Override
    public void fetchDataFromJsonApiAndSaveToDatabaseProponentes(){
        List<Proponentes> suppliers = webClient.get()
                .uri(JSON_API_URL_PROPONENTES)
                .retrieve()
                .bodyToFlux(Proponentes.class)
                .collectList().block();
        if (suppliers != null && !suppliers.isEmpty()){
            proponentesRepository.saveAll(suppliers);
        }
    }



}
