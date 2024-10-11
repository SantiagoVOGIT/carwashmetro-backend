plugins {
    `java-library`
}

dependencies {
    implementation(project(":shared"))
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}