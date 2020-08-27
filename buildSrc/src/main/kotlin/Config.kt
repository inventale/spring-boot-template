object Versions {
    //Plugins
    const val versionsPlugin = "0.28.0"
    const val owaspPlugin = "5.3.2.1"

    //Libs
    const val springBoot = "2.3.1.RELEASE"
    const val lombok = "1.18.12"
    const val trove = "3.0.3"
    const val guava = "29.0-jre"
    const val gson = "2.8.6"
    const val slf4j = "1.7.30"
    const val javaxAnnotation = "1.3.2"
    const val micrometer = "1.4.1"

    // Libs for testing
    const val junit = "5.6.2"
    const val mockito = "3.3.3"
}

object Plugins {
    const val springBoot = "org.springframework.boot"
    const val versions = "com.github.ben-manes.versions"
    const val swagger = "io.swagger.core.v3.swagger-gradle-plugin"
    const val owasp = "org.owasp.dependencycheck"
}

object Libs {
    const val springBootStarter = "org.springframework.boot:spring-boot-starter:${Versions.springBoot}"
    const val springBootStarterActuator = "org.springframework.boot:spring-boot-starter-actuator:${Versions.springBoot}"
    const val springBootStarterWeb = "org.springframework.boot:spring-boot-starter-web:${Versions.springBoot}"
    const val springBootStarterAop = "org.springframework.boot:spring-boot-starter-aop:${Versions.springBoot}"
    const val springBootStarterTest = "org.springframework.boot:spring-boot-starter-test:${Versions.springBoot}"
    const val lombok = "org.projectlombok:lombok:${Versions.lombok}"
    const val guava = "com.google.guava:guava:${Versions.guava}"
    const val trove = "net.sf.trove4j:trove4j:${Versions.trove}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val slf4j = "org.slf4j:slf4j-api:${Versions.slf4j}"
    const val javaxAnnotation = "javax.annotation:javax.annotation-api:${Versions.javaxAnnotation}"
    // metrics
    const val micrometerPrometheus = "io.micrometer:micrometer-registry-prometheus:${Versions.micrometer}"
    const val micrometerCore = "io.micrometer:micrometer-core:${Versions.micrometer}"

    // Test libraries
    const val junit = "org.junit.jupiter:junit-jupiter-api:${Versions.junit}"
    const val junitEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit}"
    const val junitParams = "org.junit.jupiter:junit-jupiter-params:${Versions.junit}"
    const val mockito = "org.mockito:mockito-inline:${Versions.mockito}"
}
