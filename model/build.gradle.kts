plugins {
    `java-library`
}

group = "com.inventale.project"

dependencies {
    annotationProcessor(Libs.lombok)
    compileOnly(Libs.lombok)
}
