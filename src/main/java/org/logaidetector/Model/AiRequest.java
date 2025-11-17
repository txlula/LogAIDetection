package org.logaidetector.Model;

public class AiRequest {
    private String logContent;
        private String queryType;

        public AiRequest() {}

        public AiRequest(String logContent, String queryType) {
            this.logContent = logContent;
            this.queryType = queryType;
        }

        // Getter and Setter for logContent
        public String getLogContent() {
            return logContent;
        }

        public void setLogContent(String logContent) {
            this.logContent = logContent;
        }

        // Getter and Setter for queryType
        public String getQueryType() {
            return queryType;
        }

        public void setQueryType(String queryType) {
            this.queryType = queryType;
        }
    }



