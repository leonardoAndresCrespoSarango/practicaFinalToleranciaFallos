package ec.edu.ups.proyecto.controller;

import ec.edu.ups.proyecto.Service.UsuarioService;
import ec.edu.ups.proyecto.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService){this.usuarioService=usuarioService;}
    @GetMapping("/todos")
    public List<Usuario> obtenerTodosLosItems() {

        return usuarioService.getListaTodo();
    }

    @PostMapping("/crear")
    public void crearRegistro(@RequestBody Usuario rec) {
        usuarioService.insertarRegistro(rec);
    }
}
