package org.logaidetector.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logContent;

    public long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getLogContent(){return logContent;}
    public void setLogContent(String logContent){this.logContent = logContent;}
}
