# Automation Test Framework (API + Web)

## Teknologi
- Java 17
- Gradle
- Cucumber (Gherkin)
- Selenium WebDriver (Chrome)
- RestAssured (API)
- WebDriverManager
- GitHub Actions

## Struktur
... (cantumkan struktur yang sudah kita definisikan) ...

## Menjalankan test
- API: `./gradlew apiTest`
- Web:  `./gradlew webTest`

## CI
- GitHub Actions workflow `/.github/workflows/ci.yml` akan menjalankan test pada `workflow_dispatch` (manual) dan `pull_request`.
- Reports akan diupload sebagai artifacts.

## Catatan
- Untuk web tests di CI, Chrome dijalankan headless (via `CI_HEADLESS=true`).
- Untuk API, gunakan header `app-id: 63a804408eb0cb069b57e43a`.
