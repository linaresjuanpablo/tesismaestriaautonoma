package com.datos.data.Controller;

import com.datos.data.Service.IDatosService;
import com.datos.data.dto.DepartamentoResponse;
import com.datos.data.dto.NitResponse;
import com.datos.data.dto.NitResponseDTO;
import com.datos.data.model.Proveedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/data")
public class datosController {

    @Autowired
    private IDatosService iDatosService;

    @GetMapping("/{id}")
    public Proveedores getProveedoresById(@PathVariable Long id) {
        return iDatosService.getProveedorById(id).orElse(null);
    }
    @PostMapping
    public Proveedores saveProveedor(@RequestBody Proveedores proveedor){
        return iDatosService.saveProveedor(proveedor);
    }
    @DeleteMapping("/{id}")
    public void deleteProveedor(@PathVariable Long id){
        iDatosService.deleteProveedor(id);
    }
    @GetMapping("/departamentos/{departamento}")
    public ResponseEntity<DepartamentoResponse> findByDepartamento(@PathVariable String departamento) {
        DepartamentoResponse response = iDatosService.findByDepartamento(departamento);
        return ResponseEntity.ok(response);
    }

    /*@GetMapping("/nit/{nit}")
    public ResponseEntity<NitResponse>findByNit(@PathVariable String nit){
        NitResponse response = iDatosService.findByNitService(nit);
        return ResponseEntity.ok(response);
    }*/

    @GetMapping("/proveedores")
    public List<Proveedores>getAllProveedores(){
        return iDatosService.getAllProveedores();
    }

}
