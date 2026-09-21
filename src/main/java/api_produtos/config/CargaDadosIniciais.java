package api_produtos.config;

import api_produtos.entity.Produto;
import api_produtos.entity.Usuario;
import api_produtos.entity.enuns.Role;
import api_produtos.repository.ProdutoRepository;
import api_produtos.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/** * Carga inicial de dados para popular o banco durante a inicialização da aplicação * */

@RequiredArgsConstructor
@Component
public class CargaDadosIniciais implements CommandLineRunner {

    private final ProdutoRepository produtoRepository;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        carregarProdutos();
        carregarUsuarios();
    }

    private void carregarProdutos(){
        //popula apenas se o banco de dados estiver vazio
        if(produtoRepository.count() == 0){
            List<Produto> produtosIniciais = List.of(
                    Produto.builder()
                            .nome("Notebook Dell Inspiron")
                            .preco(new BigDecimal("4500.00"))
                            .ativo(true)
                            .build(),
                    Produto.builder()
                            .nome("Mouse")
                            .preco(new BigDecimal("150.00"))
                            .ativo(true)
                            .build(),
                    Produto.builder()
                            .nome("Teclado Mecânico")
                            .preco(new BigDecimal("350.00"))
                            .ativo(true)
                            .build(),
                    Produto.builder()
                            .nome("Monitor 29")
                            .preco(new BigDecimal("1250.00"))
                            .ativo(true)
                            .build(),
                    Produto.builder()
                            .nome("Fone de ouvido bluetooth (descontinuado)")
                            .preco(new BigDecimal("200.00"))
                            .ativo(false)
                            .build()
            );
            produtoRepository.saveAll(produtosIniciais);
        }
    }

    private void carregarUsuarios(){
        if(!usuarioRepository.existsByEmail("admin@email.com")){
            Usuario admin = new Usuario();
            admin.setEmail("admin@email.com");
            admin.setSenha(passwordEncoder.encode("123456"));
            admin.setRole(Role.ADMIN);
            usuarioRepository.save(admin);
        }

        if(!usuarioRepository.existsByEmail("user@email.com")){
            Usuario user = new Usuario();
            user.setEmail("user@email.com");
            user.setSenha(passwordEncoder.encode("123456"));
            user.setRole(Role.USER);
            usuarioRepository.save(user);
        }
    }
}

