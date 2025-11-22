package br.com.fiap.Wellsess.dto;

public class LoginResponseDTO {
    private boolean success;
    private String message;
    private UsuarioResponseDTO usuario;
    private GestaoResponseDTO gestor;

    // Construtor vazio
    public LoginResponseDTO() {}

    // Construtor completo
    public LoginResponseDTO(boolean success, String message, UsuarioResponseDTO usuario, GestaoResponseDTO gestor) {
        this.success = success;
        this.message = message;
        this.usuario = usuario;
        this.gestor = gestor;
    }

    // Construtor apenas para usuário
    public LoginResponseDTO(boolean success, String message, UsuarioResponseDTO usuario) {
        this.success = success;
        this.message = message;
        this.usuario = usuario;
        this.gestor = null;
    }

    public LoginResponseDTO(boolean success, String message, GestaoResponseDTO gestor) {
        this.success = success;
        this.message = message;
        this.usuario = null;
        this.gestor = gestor;
    }

    public LoginResponseDTO(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.usuario = null;
        this.gestor = null;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UsuarioResponseDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioResponseDTO usuario) {
        this.usuario = usuario;
    }

    public GestaoResponseDTO getGestor() {
        return gestor;
    }

    public void setGestor(GestaoResponseDTO gestor) {
        this.gestor = gestor;
    }
}