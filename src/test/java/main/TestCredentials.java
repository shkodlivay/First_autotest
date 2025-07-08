package main;

public class TestCredentials {
    public static String getCredential(String key) {
        // Try system property first (from command line)
        String value = System.getProperty(key);

        // Fallback to environment variable
        if (value == null || value.isEmpty()) {
            String envVar = key.toUpperCase().replace('.', '_');
            value = System.getenv(envVar);
        }

        if (value == null || value.isEmpty()) {
            throw new IllegalStateException(key + " not configured. " +
                    "Set via -D" + key + "=value or " +
                    key.toUpperCase().replace('.', '_') + " environment variable");
        }
        return value;
    }

    public static String getLoginPassword() {
        return getCredential("testLoginPassword");
    }
}
