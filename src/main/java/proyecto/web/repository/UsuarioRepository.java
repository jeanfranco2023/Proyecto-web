package proyecto.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import proyecto.web.entity.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {
    
    Optional<Usuarios> findByEmail(String email);
    
}
