rootProject.name = "carwashmetro-backend"

include(":app")
include(":bounded-context")
include(":shared")

project(":app").projectDir = file("app")
project(":bounded-context").projectDir = file("src/bounded-context")
project(":shared").projectDir = file("src/shared")