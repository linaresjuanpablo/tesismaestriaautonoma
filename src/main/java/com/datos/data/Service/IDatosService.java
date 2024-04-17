package com.datos.data.Service;

import com.datos.data.dto.DepartamentoResponse;
import com.datos.data.dto.DepartamentoResponseDto;
import com.datos.data.dto.NitResponse;
import com.datos.data.dto.NitResponseDTO;
import com.datos.data.model.Proveedores;

import java.util.List;
import java.util.Optional;

public interface IDatosService {

     Optional<Proveedores> getProveedorById(Long id);

     Proveedores saveProveedor(Proveedores proveedor);

     void deleteProveedor(Long id);

     void fetchDataFromJsonApiAndSaveToDatabase();

     //void fetchDataFromJsonApiAndSaveToDatabaseProponentes();

     //List<proveedores> findByDepartamento(String departamento);

     List<Proveedores> getAllProveedores();

     DepartamentoResponse findByDepartamento(String departamento);

     //NitResponse findByNitService(String nit);
}
