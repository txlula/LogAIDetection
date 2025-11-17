package org.logaidetector.services

trait AIService {
  def analyse(id: Long): String
  def summarise(id: Long): String
  def detectAnomalies(id: Long): String
  def recommendFix(id: Long): String
  def chat(prompt: String): String
}
