package main;

public class Message {
    private String message;
    private boolean error;

    public Message() {
        message = "";
        error = false;
    }

    public void setMessage(String message, boolean error) {
        this.message = message;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public boolean isError() {
        return error;
    }
}
