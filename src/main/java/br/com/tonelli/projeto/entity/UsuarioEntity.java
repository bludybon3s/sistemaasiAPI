package br.com.tonelli.projeto.entity;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import br.com.tonelli.projeto.dto.UsuarioDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ASI_USUARIO")
public class UsuarioEntity {
	//Id é uma primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Nenhum campo pode estar em branco
	@Column(nullable = false)
	private String nome, senha, email;
	
	//O login deve ser unico
	@Column(nullable = false, unique = true)
	private String login;
	
	public UsuarioEntity(UsuarioDTO usuario) {
		BeanUtils.copyProperties(usuario, this); 
	}
	
	public UsuarioEntity() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEntity other = (UsuarioEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
