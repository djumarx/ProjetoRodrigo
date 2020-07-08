package br.com.eng3.crud_fornecedor.dominio;

public class Usuario extends EntidadeDominio {
	public String email;
	public String senha;
	public boolean tipo;
	public boolean usuarioAtivo;
	
	public Usuario(String email, String senha, boolean tipo, boolean usuarioAtivo) {
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
		this.usuarioAtivo = usuarioAtivo;
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
	public boolean isTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public boolean isUsuarioAtivo() {
		return usuarioAtivo;
	}
	public void setUsuarioAtivo(boolean usuarioAtivo) {
		this.usuarioAtivo = usuarioAtivo;
	}
}
