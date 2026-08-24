package api_produtos.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

/**
 * Dados necessários para cadastrar um novo produto
 *
 * @param nome nome comercial do produto
 * @param preco preço de venda do produto
 *
 * * */

@Schema(description = "Dados de um produto retornados pela API")
public record ProdutoCreateRequest (
       @Schema(
               description = "Nome do produto",
               example = "Notebook Dell"
       )
       @NotBlank (message = "o nome é obrigatorio")
       @Size (min=3, max=100, message = "o nome deve possuir entre 3 e 100 caracteres")
       String nome,

       @Schema (
               description = "preco de venda do produto",
               example = "4500.00"
       )
       @NotNull (message = "o preco é obrigatorio")
       @Positive(message = "o preco deve ser maior que zero")
       BigDecimal preco
) { }
