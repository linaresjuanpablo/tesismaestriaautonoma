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



    @Query(value = "SELECT new com.datos.data.dto.DepartamentoResponseDto(p.nombre, p.codigo, p.municipio) FROM Proveedores p WHERE p.departamento = :departamento")
    List<DepartamentoResponseDto> findByDepartamento(@Param("departamento") String departamento);


   /* @Query(value = "SELECT new com.datos.data.dto.NitResponseDTO(nombre, municipio, departamento, tipo_empresa, nombre_representante_legal) FROM Proveedores  WHERE nit = :nit")
    List<NitResponseDTO>findByNit(@Param("nit")String nit);
    */


}
