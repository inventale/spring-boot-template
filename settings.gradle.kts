// https://docs.gradle.com/enterprise/gradle-plugin/
plugins {
    id("com.gradle.enterprise") version "3.3.4"
}

//You can see information about build and tests `./gradlew clean test --scan`
gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
    }
}

include(
        "model",
        "common",
        "backend",
        "backend-app"
)