plugins {
    `java-library`
    pmd
}

group = "com.inventale.project"

dependencies {
    annotationProcessor(Libs.lombok)
    compileOnly(Libs.lombok)

    api(project(":model"))
    api(Libs.trove)
    api(Libs.guava)
    api(Libs.slf4j)
    api(Libs.javaxAnnotation)

    testImplementation(Libs.junit)
    testImplementation(Libs.junitEngine)
    testImplementation(Libs.junitParams)
    testImplementation(Libs.mockito)
}

tasks.test {
    useJUnitPlatform()
}