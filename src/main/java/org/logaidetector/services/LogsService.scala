package org.logaidetector.services
import org.logaidetector.Model.Log

trait LogsService {
  def addLog(log: Log) : Long

  def getById(id: Long) : Log
}
