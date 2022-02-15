package com.example.craftsofttest.model;

public enum TaskStatus {
    PENDING("Pending"),
    DONE("Done"),
    WORKING_ON_IT("Working on it");

    private final String text;

    /**
     * @param text
     */
    private TaskStatus(String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }

    public static TaskStatus valueOfText(String text) {
        for (TaskStatus e : values()) {
            if (e.text.equals(text)) {
                return e;
            }
        }
        return null;
    }

}
