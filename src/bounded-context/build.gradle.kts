// src/bounded-context/build.gradle.kts
dependencies {
    implementation(project(":shared"))
}

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