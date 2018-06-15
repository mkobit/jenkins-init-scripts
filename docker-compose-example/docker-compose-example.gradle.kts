plugins {
  `lifecycle-base`
}

val groovyInitScripts by configurations.creating

dependencies {
  groovyInitScripts(project(path = ":groovy-init-scripts", configuration = "groovyScriptSource"))
}

val jenkinsCoreVersion: String by rootProject.extra

tasks {
  val composeGroup = "Docker Compose Example"

  val syncScripts by creating(Sync::class) {
    from(groovyInitScripts)
    into("$buildDir/init.groovy.d")
  }

  val dockerComposeBuild by creating(Exec::class) {
    description = "Builds Docker images for example"
    group = composeGroup
    inputs.files(syncScripts)
    commandLine("docker-compose", "build")
    environment("CORE_VERSION", jenkinsCoreVersion)
    if (!project.hasProperty("noPull")) {
      args("--pull")
    }
  }

  "dockerComposeUp"(Exec::class) {
    dependsOn(dockerComposeBuild)
    description = "Runs docker-compose up"
    group = composeGroup
    commandLine("docker-compose", "up")
  }

  "dockerComposeStop"(Exec::class) {
    description = "Runs docker-compose stop"
    group = composeGroup
    commandLine("docker-compose", "stop")
  }

  "dockerComposeDown"(Exec::class) {
    description = "Runs docker-compose down"
    group = composeGroup
    commandLine("docker-compose", "down")
  }

  "build" {
    dependsOn(dockerComposeBuild)
  }
}
