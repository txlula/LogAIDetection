package org.logaidetector.services
import org.logaidetector.Repository.LogRepository
import org.springframework.stereotype.Service
import org.logaidetector.Model.Log
import org.springframework.beans.factory.annotation.Autowired

@Service
class LogsServiceImpl(@Autowired logsRepo: LogRepository) extends LogsService {

  override def addLog(log: Log): Long =
  {
    if (log.getLogContent.isBlank)
    {
      throw new Exception("Cannot add an empty log")
    }
    logsRepo.save(log)
    log.getId
  }

  override def getById(id: Long): Log =
  {
    var log = logsRepo.findById(id).orElseThrow(() => new Exception("Could not find Log with that id"))
    log
  }
}
