package com.kaualimadesouza.pagamento.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @Column(name = "cpf_cnpj", nullable = false)
    private String identificador;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private Double saldo;

    @Column(name = "tipo_usuario", nullable = false)
    private String tipoUsuario;

    public Usuario(UsuarioRequestDTO usuario, String ident) {
        this.identificador = ident;
        this.nomeCompleto = usuario.nome_completo();
        this.email = usuario.email();
        this.senha = usuario.senha();
        this.saldo = Double.valueOf(usuario.saldo());
        this.tipoUsuario = ident.length() == 11 ? "Comum" : "Lojista";
    }
}
