package com.kaualimadesouza.pagamento.Usuario;

public record UsuarioRequestDTO(String identificador, String nome_completo, String email, String senha, String saldo) {
}
