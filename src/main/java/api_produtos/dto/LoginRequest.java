package api_produtos.dto;

public record LoginRequest(
        String email,
        String senha
) {}