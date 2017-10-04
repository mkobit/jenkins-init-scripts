val junitPlatformVersion: String by extra { "1.0.1" }
val junitPlatformGradlePluginVersion: String by extra { "1.0.1" }
val junitJupiterVersion: String by extra { "5.0.1" }
val junitVintageVersion: String by extra { "4.12.1" }
val junit5Log4jVersion: String by extra { "2.9.1" }

extra["junitTestImplementationArtifacts"] = mapOf(
  "junit-platform-runner" to mapOf("group" to "org.junit.platform", "name" to "junit-platform-runner", "version" to "${extra["junitPlatformVersion"]}"),
  "junit-jupiter-migrationsupport" to mapOf("group" to "org.junit.jupiter", "name" to "junit-jupiter-migrationsupport", "version" to "${extra["junitJupiterVersion"]}"),
  "junit-jupiter-api" to mapOf("group" to "org.junit.jupiter", "name" to "junit-jupiter-api", "version" to "${extra["junitJupiterVersion"]}")
)

extra["junitTestRuntimeOnlyArtifacts"] = mapOf(
  "junit-jupiter-engine" to mapOf("group" to "org.junit.jupiter", "name" to "junit-jupiter-engine", "version" to "${extra["junitJupiterVersion"]}"),
  "junit-vintage-engine" to mapOf("group" to "org.junit.vintage", "name" to "junit-vintage-engine", "version" to "${extra["junitVintageVersion"]}"),
  "log4j-core" to mapOf("group" to "org.apache.logging.log4j", "name" to "log4j-core", "version" to "${extra["junit5Log4jVersion"]}"),
  "log4j-core" to mapOf("group" to "org.apache.logging.log4j", "name" to "log4j-jul", "version" to "${extra["junit5Log4jVersion"]}")
)
