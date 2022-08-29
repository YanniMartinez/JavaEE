package org.ymartinezm.apiservlet.webapp.headers.services;

import org.ymartinezm.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImpl implements ProductoService {

    @Override
    public List<Producto> listar() {
        //Retornando un arreglo de 3 elementos tipo Producto
        return Arrays.asList( new Producto( 1L, "Notebook", "Computación",175000),
                new Producto(2L, "Mesa Escritorio", "Oficina",10000),
                new Producto(3L, "Teclado Mecánico", "Computación",40000));

    }
}
