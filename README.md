# tgcryptobot

## Requirements:

- Java 11.
- [Create a new bot](https://core.telegram.org/bots#6-botfather) and get an authentication token for your bot.

## How to run by yourself:

### Windows:

1. Clone repository somewhere
2. Install Java 11 and run `./gradlew shadowJar`
3. Set Telegram Bot Token as environmental variable:
`setx TG_API "<token from BotFather>"`
4. Build Dockerfile: `docker build -t tgcryptobot:1.1.2 .`
5. Run Docker image: `docker run -p 8080:8080 -e TG_API tgcryptobot:1.1.2`

 