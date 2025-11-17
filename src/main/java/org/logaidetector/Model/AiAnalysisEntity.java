package org.logaidetector.Model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
    @Table(name = "ai_analysis")
    public class AiAnalysisEntity  {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(columnDefinition = "TEXT")
        private String logText;
        private String errorType;
        private String rootCause;
        private String suggestedFix;
        private String impact;
        private String severity;

        @Column(nullable = false, updatable = false)
        private LocalDateTime analyzedAt = LocalDateTime.now();

        // Getters and setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getLogText() { return logText; }
        public void setLogText(String logText) { this.logText = logText; }

        public String getErrorType() { return errorType; }
        public void setErrorType(String errorType) { this.errorType = errorType; }

        public String getRootCause() { return rootCause; }
        public void setRootCause(String rootCause) { this.rootCause = rootCause; }

        public String getSuggestedFix() { return suggestedFix; }
        public void setSuggestedFix(String suggestedFix) { this.suggestedFix = suggestedFix; }

        public String getImpact() { return impact; }
        public void setImpact(String impact) { this.impact = impact; }

        public String getSeverity() { return severity; }
        public void setSeverity(String severity) { this.severity = severity; }

        public LocalDateTime getAnalyzedAt() { return analyzedAt; }
        public void setAnalyzedAt(LocalDateTime analyzedAt) { this.analyzedAt = analyzedAt; }
    }


