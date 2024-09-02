plugins {
    id("org.springframework.boot")
}

dependencies {
    implementation(project(":bounded-context"))
    runtimeOnly("org.postgresql:postgresql")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.bootJar {
    mainClass.set("io.santiagovogit.carwashmetro.MainApplication")
}

sourceSets {
    main {
        java.srcDirs("main")
        resources.srcDir("main/resources")
    }
    test {
        java.srcDirs("test")
    }
}
