package org.logaidetector.controllers;
import org.logaidetector.Model.Log;
import org.logaidetector.services.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/logs")
@CrossOrigin
public class LogsController
{
    private LogsService logsService;

    @Autowired
    public LogsController(LogsService logService)
    {
        this.logsService = logService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Long> uploadLog(@RequestBody String logContent)
    {
        Log log = new Log();
        log.setLogContent(logContent);

        Long id = logsService.addLog(log);
        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Log> getLogById(@PathVariable("id") Long id)
    {
        Log log = logsService.getById(id);
        return new ResponseEntity<Log>(log, HttpStatus.OK);
    }
}
