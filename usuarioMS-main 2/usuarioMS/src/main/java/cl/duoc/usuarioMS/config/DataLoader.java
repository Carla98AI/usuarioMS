package cl.duoc.usuarioMS.config;

package cl.duoc.usuarioMS.config;

import cl.duoc.usuarioMS.model.Usuario;
import cl.duoc.usuarioMS.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initData(UsuarioRepository repo) {
        return args -> {
            if (repo.count() > 0) {
                System.out.println("No se cargaron datos porque hay datos en la BD");
            } else {
                repo.save(new Usuario(null, "Ana", "García", "ana@bloom.cl", LocalDateTime.now(), true));
                repo.save(new Usuario(null, "Carla", "Acuña", "carla@bloom.cl", LocalDateTime.now(), true));
                repo.save(new Usuario(null, "Valentina", "Rojas", "valentina@bloom.cl", LocalDateTime.now(), true));
                repo.save(new Usuario(null, "Fernanda", "Muñoz", "fernanda@bloom.cl", LocalDateTime.now(), true));
                repo.save(new Usuario(null, "Camila", "Pérez", "camila@bloom.cl", LocalDateTime.now(), true));

                System.out.println("Datos cargados con éxito");
            }
        };
    }
}
