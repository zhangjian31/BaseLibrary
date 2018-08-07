package com.jery.config;

public class JeryConfig {
    public static String baseUrl;

    private JeryConfig() {

    }

    public static class JeryConfigBuilder {
        public JeryConfigBuilder baseUrl(String baseUrl) {
            JeryConfig.baseUrl = baseUrl;
            return this;
        }

        public final JeryConfig create() {
            return new JeryConfig();
        }
    }
}
