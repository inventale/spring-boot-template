object Versions {
    //Plugins
    const val versionsPlugin = "0.36.0"
    const val owaspPlugin = "6.0.3"
    const val taskTreePlugin = "1.5"
    const val pmdToolPlugin = "6.21.0"

    //Libs
    const val springBoot = "2.4.1"
    const val springCloudAws = "2.2.5.RELEASE"
    const val lombok = "1.18.16"
    const val trove = "3.0.3"
    const val guava = "30.1-jre"
    const val gson = "2.8.6"

    const val javaxAnnotation = "1.3.2"
    const val micrometer = "1.6.2"

    // logs
    const val slf4j = "1.7.30"
    const val logstashLogbackEncoder = "6.5"

    // Libs for testing
    const val junit = "5.7.0"
    const val mockito = "3.6.28"
}

object Plugins {
    const val springBoot = "org.springframework.boot"
    const val versions = "com.github.ben-manes.versions"
    const val swagger = "io.swagger.core.v3.swagger-gradle-plugin"
    const val owasp = "org.owasp.dependencycheck"
    const val taskTree = "com.dorongold.task-tree"
}

object Libs {
    const val springBootStarter = "org.springframework.boot:spring-boot-starter:${Versions.springBoot}"
    const val springBootStarterActuator = "org.springframework.boot:spring-boot-starter-actuator:${Versions.springBoot}"
    const val springBootStarterLogging = "org.springframework.boot:spring-boot-starter-logging"
    const val springBootStarterWeb = "org.springframework.boot:spring-boot-starter-web:${Versions.springBoot}"
    const val springBootStarterAop = "org.springframework.boot:spring-boot-starter-aop:${Versions.springBoot}"
    const val springBootStarterCloudAwsAop = "org.springframework.cloud:spring-cloud-starter-aws:${Versions.springCloudAws}"
    const val springBootStarterTest = "org.springframework.boot:spring-boot-starter-test:${Versions.springBoot}"
    const val lombok = "org.projectlombok:lombok:${Versions.lombok}"
    const val guava = "com.google.guava:guava:${Versions.guava}"
    const val trove = "net.sf.trove4j:trove4j:${Versions.trove}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val javaxAnnotation = "javax.annotation:javax.annotation-api:${Versions.javaxAnnotation}"
    // metrics
    const val micrometerPrometheus = "io.micrometer:micrometer-registry-prometheus:${Versions.micrometer}"
    const val micrometerCore = "io.micrometer:micrometer-core:${Versions.micrometer}"
    const val micrometerCloudwatch = "io.micrometer:micrometer-registry-cloudwatch:${Versions.micrometer}"

    // logs
    const val slf4j = "org.slf4j:slf4j-api:${Versions.slf4j}"
    const val logstashLogbackEncoder = "net.logstash.logback:logstash-logback-encoder:${Versions.logstashLogbackEncoder}"

    // Test libraries
    const val junit = "org.junit.jupiter:junit-jupiter-api:${Versions.junit}"
    const val junitEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit}"
    const val junitParams = "org.junit.jupiter:junit-jupiter-params:${Versions.junit}"
    const val mockito = "org.mockito:mockito-inline:${Versions.mockito}"
}
