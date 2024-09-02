sourceSets {
    main {
        java.srcDirs("main")
    }
    test {
        java.srcDirs("test")
    }
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}