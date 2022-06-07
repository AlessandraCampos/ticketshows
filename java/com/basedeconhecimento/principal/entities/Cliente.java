package com.basedeconhecimento.principal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Campo nome não pode ficar em branco")
	private String nome;
	
	@NotEmpty(message="Campo cpf não pode ficar em branco")
	@Size(min=11,max=11,message="Digitos insuficientes")
	private String cpf;
	
	@NotEmpty(message="Campo email não pode ficar em branco")
	private String email;
	
	@NotEmpty(message="Campo senha não pode ficar em branco")
	private String senha;
	
	

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

	


