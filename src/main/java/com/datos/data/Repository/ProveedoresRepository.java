package com.datos.data.Repository;


import com.datos.data.dto.DepartamentoResponseDto;
import com.datos.data.dto.NitResponseDTO;
import com.datos.data.model.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores, Long> {

//    List<proveedores> findByDepartamento(String Departamento);

    @Query(value = "SELECT new com.datos.data.dto.DepartamentoResponseDto(p.nombre, p.codigo, p.municipio) FROM Proveedores p WHERE p.departamento = :departamento")
    List<DepartamentoResponseDto> findByDepartamento(@Param("departamento") String departamento);

    @Query(value = "SELECT * FROM proveedores WHERE nit = :nit", nativeQuery = true)
    List<Proveedores>findByNit(@Param("nit") String nit);

    //Proveedores findAllByNit(String nit);
    /*List<NitResponseDTO> listar();*/





}
