package br.com.tonelli.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tonelli.projeto.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
	
	
} 