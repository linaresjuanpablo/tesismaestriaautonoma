package com.datos.data.Service.Impl;

import com.datos.data.Repository.ProveedoresRepository;
import com.datos.data.Service.IDatosService;
import com.datos.data.dto.DepartamentoResponse;
import com.datos.data.dto.DepartamentoResponseDto;
import com.datos.data.dto.NitResponse;
import com.datos.data.dto.NitResponseDTO;
import com.datos.data.model.Proveedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DatosServiceImpl implements IDatosService {

    private static final String JSON_API_URL = "https://www.datos.gov.co/resource/qmzu-gj57.json?$query=select * limit 100000";

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    private final WebClient webClient;

    @Autowired
    public DatosServiceImpl(ProveedoresRepository proveedoresRepository, WebClient.Builder webClientBuilder) {
        this.proveedoresRepository = proveedoresRepository;
        this.webClient = webClientBuilder.baseUrl(JSON_API_URL).build();
    }

    @Override
    public Optional<Proveedores> getProveedorById(Long id) {
        return proveedoresRepository.findById(id);
    }

    @Override
    public Proveedores saveProveedor(Proveedores proveedor) {
        return proveedoresRepository.save(proveedor);
    }


    @Override
    public void deleteProveedor(Long id) {
        proveedoresRepository.deleteById(id);
    }

    @Override
    public void fetchDataFromJsonApiAndSaveToDatabase() {
        List<Proveedores> suppliers = webClient.get()
                .uri(JSON_API_URL)
                .retrieve()
                .bodyToFlux(Proveedores.class)
                .collectList().block(); // Bloquea para simplicidad; prefiere la programación reactiva en aplicaciones reales

        if (suppliers != null && !suppliers.isEmpty()) {
            proveedoresRepository.saveAll(suppliers);
        }
    }

    @Override
    public DepartamentoResponse findByDepartamento(String departamento) {

        DepartamentoResponse departamentoResponse = new DepartamentoResponse();

        List<DepartamentoResponseDto> departamentoResponseDto = new ArrayList<>();

        List<DepartamentoResponseDto> list = proveedoresRepository.findByDepartamento(departamento);

        if(list == null || list.isEmpty()){
            System.out.println("No hay datos");
        }

        DepartamentoResponseDto responseDto = new DepartamentoResponseDto("","","");

        for(DepartamentoResponseDto dto: list){

            responseDto.setNombre(dto.getNombre());
            responseDto.setCodigo(dto.getCodigo());
            responseDto.setMunicipio(dto.getMunicipio());
           // responseDto.setDescripcionCategoria(dto.getDescripcionCategoria());

            departamentoResponseDto.add(responseDto);
        }

        departamentoResponse.setDepartamentoResponseDtos(departamentoResponseDto);

        return departamentoResponse;
    }

    @Override
    public List<Proveedores> getAllProveedores() {
        return (List<Proveedores>) proveedoresRepository.findAll();
    }
   @Override
    public NitResponse  findByNitService(String nit){
       NitResponse nitResponse = new NitResponse();
       List<NitResponseDTO> nitResponseDTO = new ArrayList<>();
       List<Proveedores> list = proveedoresRepository.findByNit(nit);

       if (list == null || list.isEmpty()){
           System.out.println("no hay datos");
       }
       NitResponseDTO responseDTO = new NitResponseDTO();
       for(Proveedores dto: list){
           responseDTO.setNombre(dto.getNombre());
           responseDTO.setMunicipio(dto.getMunicipio());
           responseDTO.setDepartamento(dto.getDepartamento());
           responseDTO.setTipo_empresa(dto.getTipo_empresa());
           responseDTO.setNombre_representante_legal(dto.getNombre_representante_legal());

           nitResponseDTO.add(responseDTO);
       }

       nitResponse.setNitResponseDTOS(nitResponseDTO);
       return nitResponse;


    }


}
