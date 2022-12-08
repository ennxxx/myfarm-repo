package model;

public class Feedback {
    private String prompt;
    private boolean success;

    public Feedback() {
        this.prompt = null;
        this.success = false;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getPrompt() {
        return prompt;
    }

    public boolean isSuccess() {
        return success;
    }
}