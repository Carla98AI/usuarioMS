package cl.duoc.usuarioMS.controller;

import cl.duoc.usuarioMS.dto.UsuarioResponseDTO;
import cl.duoc.usuarioMS.model.Usuario;
import cl.duoc.usuarioMS.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> lista = service.listar();
        if (lista.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<UsuarioResponseDTO> obtenerDTO(@PathVariable Integer id) {
        Usuario u = service.buscarPorId(id);
        UsuarioResponseDTO dto = new UsuarioResponseDTO(
                u.getId(), u.getNombre(), u.getApellido(), u.getCorreo());
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Usuario> guardar(@RequestBody Usuario u) {
        return ResponseEntity.ok(service.guardar(u));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Integer id, @RequestBody Usuario u) {
        try {
            return ResponseEntity.ok(service.actualizar(id, u));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

