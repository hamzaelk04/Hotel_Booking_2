package util;

public class PromptUtil {
    public static String namePrompt() {
        return """
                Enter your name: \n
                ======================== \n
                """;
    }

    public static String emailPrompt() {
        return """
                Enter your email: \n
                ======================== \n
                """;
    }

    public static String phonePrompt() {
        return """
                Enter your number phone: \n
                ======================== \n
                """;
    }

    public static String passwordPrompt() {
        return """
                Enter your password: \n
                ======================== \n
                """;
    }

    public static String emptyPrompt() {
        return """
                Press Enter to continue: \n
                ======================== \n
                """;
    }
}
