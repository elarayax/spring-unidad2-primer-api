package com.example.unidad2.semana2.duoc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.unidad2.semana2.duoc.modelo.producto;

@RestController
@RequestMapping("/api/v1")
public class productoController {
    ArrayList<producto> listaProducto = new ArrayList<>();

    @GetMapping("/productos/{id}")
    @ResponseBody
    public producto buscar(@PathVariable int id) {
        for (producto p : listaProducto) {
            if (p.getID() == id) {
                return p;
            }
        }
        throw new RuntimeException("Producto con ID " + id + " no encontrado.");
    }
    
    @PostMapping("/productos")
    public producto agregarProducto(@RequestBody producto nuevoProducto) {
        listaProducto.add(nuevoProducto);
        return nuevoProducto;
    }

    @GetMapping("/productos")
    public List<producto> listarProductos() {
        return listaProducto;
    }

    @PutMapping("/productos/{id}")
    public producto actualizarProducto(@PathVariable int id, @RequestBody producto productoActualizado) {
        for (producto p : listaProducto) {
            if (p.getID() == id) {
                p.setNombre(productoActualizado.getNombre());
                p.setPrecio(productoActualizado.getPrecio());
                return p;
            }
        }
        throw new RuntimeException("Producto con ID " + id + " no encontrado.");
    }

    @PatchMapping("/productos/{id}")
    public producto actualizarParcialProducto(@PathVariable int id, @RequestBody producto productoActualizado) {
        for (producto p : listaProducto) {
            if (p.getID() == id) {
                if (productoActualizado.getNombre() != null) {
                    p.setNombre(productoActualizado.getNombre());
                }
                if (productoActualizado.getPrecio() != 0) {
                    p.setPrecio(productoActualizado.getPrecio());
                }
                return p;
            }
        }
        throw new RuntimeException("Producto con ID " + id + " no encontrado.");
    }

    @DeleteMapping("/productos/{id}")
    public String eliminarProducto(@PathVariable int id) {
        for (producto p : listaProducto) {
            if (p.getID() == id) {
                listaProducto.remove(p); // Elimina el producto
                return "Producto con ID " + id + " ha sido eliminado.";
            }
        }
        throw new RuntimeException("Producto con ID " + id + " no encontrado.");
    }
}
