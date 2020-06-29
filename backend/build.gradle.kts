plugins {
    `java-library`
}

group = "com.inventale.project"

dependencies {
    annotationProcessor(Libs.lombok)
    compileOnly(Libs.lombok)

    api(project(":common"))

    testImplementation(Libs.junit)
    testImplementation(Libs.junitEngine)
    testImplementation(Libs.junitParams)
    testImplementation(Libs.mockito)
}


tasks.test {
    useJUnitPlatform()
}