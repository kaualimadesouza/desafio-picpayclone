package com.kaualimadesouza.pagamento.Service;

import com.kaualimadesouza.pagamento.Usuario.TransferRequestDTO;
import com.kaualimadesouza.pagamento.Usuario.Usuario;
import com.kaualimadesouza.pagamento.Repository.UsuarioRepository;
import com.kaualimadesouza.pagamento.Usuario.UsuarioRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

   @Autowired
   private RestTemplate restTemplate;

    public String criarUsuario(UsuarioRequestDTO usu) {
        //String CPF = usuario.identificador().replace(".", "").replace("-", "");
        String ident = usu.identificador().replace(".", "").replace("-", "").replace("/", "");
        Usuario usuario = new Usuario(usu, ident);

        usuarioRepository.save(usuario);
        return "Criado com sucesso";
    }

    public String enviarSaldo(TransferRequestDTO transfer) throws Exception {
        Optional<Usuario> orig = usuarioRepository.findById(transfer.payer());
        Optional<Usuario> dest = usuarioRepository.findById(transfer.payee());


        if(orig.isPresent() || dest.isPresent()) {
            if(orig.get().getSaldo() - transfer.value() < 0) {
                throw new Exception("Saldo insuficiente.");
            }

            if(orig.get().getIdentificador().length() == 14) {
                throw new Exception("Lojista não pode enviar saldo.");
            }

            if(autorizarTransferencia()) {
                throw new Exception("Transação não autorizada.");
            }

            orig.get().setSaldo(orig.get().getSaldo() - transfer.value());
            dest.get().setSaldo(dest.get().getSaldo() + transfer.value());

            usuarioRepository.save(orig.get());
            usuarioRepository.save(dest.get());

            return "Transação realizada com sucesso";
        }
        throw new Exception("Erro!");
    }

    public Boolean autorizarTransferencia() {
        ResponseEntity<Map> response = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);
        if(response.getStatusCode() == HttpStatus.OK && response.getBody().get("status") == "success") {
            return true;
        } else return false;

    }



}
