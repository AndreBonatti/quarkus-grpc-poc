package br.com.grpc.dev;

public class ResponseReact {
    private String message;

    public ResponseReact(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
