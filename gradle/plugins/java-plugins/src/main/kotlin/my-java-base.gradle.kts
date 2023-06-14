import com.example.Slf4jSimpleRule

plugins {
    id("java")
    id("com.diffplug.spotless")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}

sourceSets.create("integrationTests")

tasks.register<Test>("integrationTests") {
    testClassesDirs = sourceSets["integrationTests"].output.classesDirs
    classpath = sourceSets["integrationTests"].runtimeClasspath

    useJUnitPlatform()
}

//register component metadata-rule
dependencies.components {
    // Slf4jSimpleRule corrects metadata of dependency org.slf4j:slf4j-simple
    withModule<Slf4jSimpleRule>("org.slf4j:slf4j-simple")
}


/*
  1.tasks is task container that can be used to  configure registered tasks
  2.Tasks are added by plugin eg: compileJava is added by 'java' plugin
 */

/*
 we can configure tasks by type via withType<TaskType>()
 eg: we are configuring all JavaCompile type tasks below
 */
tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}


/*
if an accessor eg:tasks.compileJava  is not available
we can use notation tasks.named<>() to access the task
 */
tasks.named<JavaCompile>("compileJava") {}

tasks.compileTestJava{}

tasks.test{
    //use jUnit5
    useJUnitPlatform{
        //test task will exclude tests with tag 'slow'
        excludeTags("slow")
    }

    //run max 4 task in parallel
    maxParallelForks = 4
}

tasks.register<Test>("testSlow"){
    testClassesDirs = sourceSets.test.get().output.classesDirs
    classpath = sourceSets.test.get().runtimeClasspath

    useJUnitPlatform{
        //add tag for tests
        includeTags("slow")
    }
}

tasks.check{
    dependsOn(tasks.named("testSlow"))
}

tasks.javadoc {}