#!/bin/bash

# .env 파일을 읽어 환경 변수로 설정
set -a
source /app/adoc/.env
set +a

# Java 실행
exec java -jar /app/adoc/app.jar
