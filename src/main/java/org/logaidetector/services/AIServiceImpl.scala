package org.logaidetector.services

import org.logaidetector.Repository.LogRepository
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.stereotype.Service
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3._

@Service
@Autowired
class AIServiceImpl(logRepository: LogRepository) extends AIService {
  @Value("${openai.api.key}")
  private var apiKey: String = _

  private val client = new OkHttpClient()
  private val jsonType = MediaType.parse("application/json")
  private val mapper = new ObjectMapper()


  override def analyse(id: Long): String = {
    val log: String = logRepository.findById(id).get().getLogContent

    val prompt = s"Analyse the following logs, and structure your response in the following format: 1. Root Cause. 2. Suggested Fix. 3. Severity. 4. Risk Score. Don't bother with examples. Here is the log: $log"
    aiCall(prompt)
  }

  override def summarise(id: Long): String = {
    val log = logRepository.findById(id).get().getLogContent
    val prompt = s"Summarise the following log in a concise, 5-10 line summary. This is the entire log, so don't ask for anything else: $log"
    val response = aiCall(prompt)
    response
  }

  override def detectAnomalies(id: Long): String = {
    val log = logRepository.findById(id).get().getLogContent
    val prompt = s"Detect any anomalies or unusual patterns in the following log. Don't ask for anything else: $log"
    val response = aiCall(prompt)
    response
  }

   override def recommendFix(id: Long): String = {
    val log = logRepository.findById(id).get().getLogContent
    val prompt = s"Recommend a fix for this log, and don't ask for anything else: $log"
    val response = aiCall(prompt)
    response
  }

  override def chat(prompt: String): String = {
    val response = aiCall(prompt)
    response
  }

  private def aiCall(prompt: String) = {
    val safePrompt = prompt
      .replace("\\", "\\\\")  // escape backslashes first
      .replace("\"", "\\\"")  // escape quotes
      .replace("\n", "\\n")   // escape newlines
      .replace("\r", "")      // remove CR

    val body =
      s"""
      {
        "model": "gpt-4.1-mini",
        "messages": [
          {"role": "system", "content": "You are an expert log analyser"},
          {"role": "user", "content": "$safePrompt"}
        ]
      }
      """
    val requestBody: okhttp3.RequestBody = okhttp3.RequestBody.create(jsonType,body)


    //test
    //println(body)

    // build req
    val request = new Request.Builder()
      .url("https://api.openai.com/v1/chat/completions")
      .addHeader("Authorization", s"Bearer $apiKey")
      .post(requestBody)
      .build()

    // exe request and return response
    val response = client.newCall(request).execute().body().string()
    //response
    // parse json and extract msg



    val finalResponse: String = mapper
      .readTree(response)
      .get("choices")
      .get(0)
      .get("message")
      .get("content")
      .asText()
    finalResponse
  }
}
