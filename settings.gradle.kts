rootProject.name = "carwashmetro-backend"

include(":shared")
project(":shared").projectDir = file("src/shared")
include(":bounded-context")
project(":bounded-context").projectDir = file("src/bounded-context")