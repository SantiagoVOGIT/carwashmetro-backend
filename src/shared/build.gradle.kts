plugins {
    `java-library`
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}