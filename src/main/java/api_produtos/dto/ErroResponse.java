package api_produtos.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema (description = "Estrutura padronizada para respostas de erro de API")
public record ErroResponse (
    @Schema(description = "Codigo de Status HTTP", example = "404")
    Integer Status,

    @Schema(description = "Descrição curta do tipo de erro", example = "Recurso nao encontrado")
    String erro,

    @Schema(description = "Mensagem detalhada do erro", example = "Produto nao encontrado com id")
    String mensagem,

    @Schema(description = "Url de requisicao que originou o erro", example = "/produtos/1")
    String caminho,

    @Schema(description = "Data e hora do erro", example = "2026-08-22T19:17:46")
    LocalDateTime timestamp

    /*
     *  Construtor utilitario para gerar a resposta atribuindo a hora atual automaticamente
     **/
){
    public static ErroResponse criar(Integer status, String erro, String mensagem, String caminho) {
        return new ErroResponse(status, erro, mensagem, caminho, LocalDateTime.now());
    }
}
