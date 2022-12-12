package model;

/**
 * This is a class that represents the feedback displayed in the game.
 */
public class Feedback {
    private String prompt;
    private boolean success;

    /**
     * Constructor that initializes feedback values.
     */
    public Feedback() {
        this.prompt = null;
        this.success = false;
    }

    /**
     * Sets the message of a feedback.
     *
     * @param prompt message
     */
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    /**
     * Sets the value of displaying feedback.
     *
     * @param success true if successful, otherwise false
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Gets the message of a feedback
     *
     * @return prompt
     */
    public String getPrompt() {
        return prompt;
    }

    /**
     * Gets the boolean value if a feedback is done successfully.
     *
     * @return success
     */
    public boolean isSuccess() {
        return success;
    }
}