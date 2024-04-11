package com.datos.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Facturas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String id_contrato;
    private String id_pago;
    private String numero_de_factura;
    private String fecha_factura;
    private String valor_neto;
    private String valor_total;
    private String notas;
    private String fecha_de_entrega;
    private String radicado;
    private String fecha_estiamda_de_pago;
    private String valor_a_pagar;
    private String estado;
    private String pago_confirmado;
    private String usuario_pago;

}
