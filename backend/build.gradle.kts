plugins {
    `java-library`
    pmd
}

group = "com.inventale.project"

dependencies {
    annotationProcessor(Libs.lombok)
    compileOnly(Libs.lombok)

    api(project(":common"))
    api(Libs.micrometerCore)
    api(Libs.micrometerPrometheus)

    testImplementation(Libs.junit)
    testImplementation(Libs.junitEngine)
    testImplementation(Libs.junitParams)
    testImplementation(Libs.mockito)
}


tasks.test {
    useJUnitPlatform()
}