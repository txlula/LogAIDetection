-- make db
CREATE DATABASE IF NOT EXISTS ai_logs_db;
USE ai_logs_db;

-- log table
CREATE TABLE log (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      log_content LONGTEXT NOT NULL
);

-- sample log
INSERT INTO log (log_content) VALUES (
                                      '2025-11-17 10:14:21.884  INFO 1728 --- [nio-8080-exec-4] c.a.u.UserController        : Fetching user with ID 1029
                                      2025-11-17 10:14:21.887  WARN 1728 --- [nio-8080-exec-4] c.a.s.UserService            : No user found for ID: 1029
                                      2025-11-17 10:14:21.889 ERROR 1728 --- [nio-8080-exec-4] c.a.e.GlobalExceptionHandler : NullPointerException at UserService.getUser(UserService.java:58)
                                      java.lang.NullPointerException: Cannot invoke "User.getEmail()" because "user" is null
                                          at com.app.service.UserService.getUser(UserService.java:58)
                                          at com.app.controller.UserController.getUser(UserController.java:32)
                                          at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)'
                                  );