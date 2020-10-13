plugins {
    `java-library`
    pmd
}

group = "com.inventale.project"

dependencies {
    annotationProcessor(Libs.lombok)
    compileOnly(Libs.lombok)
}
