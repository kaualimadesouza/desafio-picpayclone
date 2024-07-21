package com.kaualimadesouza.pagamento.Repository;

import com.kaualimadesouza.pagamento.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
