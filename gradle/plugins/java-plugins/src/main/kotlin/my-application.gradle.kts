import com.example.JarCount
import gradle.kotlin.dsl.accessors._1f3c36413d92d98cc58e980fa4104ab8.jar
import gradle.kotlin.dsl.accessors._1f3c36413d92d98cc58e980fa4104ab8.runtimeClasspath

plugins {
    id("application")
    id("my-java-base")
}

//count the jar files that make up our application & write the result to a file
tasks.register<JarCount>("countJars") {
    group = "My Group"
    description = "Counts!"

    allJars.from(tasks.jar)
    allJars.from(configurations.runtimeClasspath)

    countFile.set(layout.buildDirectory.file("gen/count.txt"))
}

/*
  Register a new task bundle of type Zip
 */
tasks.register<Zip>("bundle") {
    group = "My Group"
    description = "Package it all!"

    //zip output of jar task
    from(tasks.jar)
    //zip all the jars of the dependencies via runtimeClassPath
    from(configurations.runtimeClasspath)

    destinationDirectory.set(layout.buildDirectory.dir("distribution"))
}

tasks.build {
    dependsOn(tasks.named("bundle"))
}

/*
  We can create our own lifecycle tasks
  To create a lifecycle task , create a task without any type
 */
tasks.register("buildAll"){
    description = "Builds even more"

    dependsOn(tasks.build)
    dependsOn(tasks.named("countJars"))
}
