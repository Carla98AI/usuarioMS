package cl.duoc.usuarioMS.service;

import cl.duoc.usuarioMS.model.Usuario;
import cl.duoc.usuarioMS.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario guardar(Usuario u) {
        u.setFechaRegistro(LocalDateTime.now());
        u.setActivo(true);
        return repository.save(u);
    }

    public Usuario actualizar(Integer id, Usuario datos) {
        Usuario u = buscarPorId(id);
        u.setNombre(datos.getNombre());
        u.setApellido(datos.getApellido());
        u.setCorreo(datos.getCorreo());
        return repository.save(u);
    }

    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuario no existe");
        }
        repository.deleteById(id);
    }
}
