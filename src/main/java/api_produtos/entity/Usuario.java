package api_produtos.entity;

import api_produtos.entity.enuns.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String email;

        @Column(nullable = false)
        private String senha; // hash BCrypt

        @Enumerated(EnumType.STRING) // salva "ADMIN"/"USER" em vez de 0/1
        @Column(nullable = false)
        private Role role;
}
