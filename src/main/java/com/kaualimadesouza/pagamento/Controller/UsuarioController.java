package com.kaualimadesouza.pagamento.Controller;

import com.kaualimadesouza.pagamento.Usuario.TransferRequestDTO;
import com.kaualimadesouza.pagamento.Usuario.Usuario;
import com.kaualimadesouza.pagamento.Usuario.UsuarioRequestDTO;
import com.kaualimadesouza.pagamento.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<String> criarUsuarioBanco(@RequestBody UsuarioRequestDTO usu) {
        String resposta = usuarioService.criarUsuario(usu);
        return ResponseEntity.ok(resposta);
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> enviarDinheiro(@RequestBody TransferRequestDTO transfer) throws Exception {
        String resposta = usuarioService.enviarSaldo(transfer);
        return ResponseEntity.ok(resposta);
    }
}
