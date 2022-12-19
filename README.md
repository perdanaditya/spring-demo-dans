# Spring Demo Apps

This repository is created for PT Dans Multi Pro technical test. For the stable version, please refer to `main` branch 

## What do you need (for initial installation)

1. Java 11
2. 5 minutes of patience for dependencies resolving
3. Your favorite IDE

## What tools/framework this project use
1. R2DBC
2. Spring Reactive
3. Lombok

## How to create initial schema

This project use flyway to generate schema for the apps, to start migrating initial data, you need :
1. Open Terminal/cmd
2. Navigate to /rest-web/resource/flyway
3. Run this command
```bash
flyway migrate
```
4. After that you fill the db username and password, click enter
5. The initial username and password to generate token is userTest/rum5tb4c
