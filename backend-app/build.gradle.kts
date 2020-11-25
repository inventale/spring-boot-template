plugins {
    java
    pmd
    id(Plugins.springBoot) version Versions.springBoot
}

group = "com.inventale.project"

tasks.getByName<Jar>("bootJar") {
    archiveFileName.set("backend.jar")
}.finalizedBy("copyConfigsNearJar") //copy /config near build jars to be used in docker

dependencies {
    annotationProcessor(Libs.lombok)
    compileOnly(Libs.lombok)

    implementation(project(":backend"))

    implementation(Libs.springBootStarterActuator)
    implementation(Libs.springBootStarterWeb)
    implementation(Libs.springBootStarterAop)
    implementation(Libs.gson)

    // put app logs in json format
    implementation(Libs.springBootStarterLogging)
    implementation(Libs.logstashLogbackEncoder)

    testAnnotationProcessor(Libs.lombok)
    testImplementation(Libs.lombok)
    testImplementation(Libs.junit)
    testImplementation(Libs.junitEngine)
    testImplementation(Libs.junitParams)
    testImplementation(Libs.mockito)
    testImplementation(Libs.springBootStarterTest)
}

tasks.test {
    onlyIf {
        project.hasProperty("functionalTests")
    }
    useJUnitPlatform()
    // to use properties from /config in tests
    workingDir = rootDir
}