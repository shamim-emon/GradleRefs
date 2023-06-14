//Apply gradle plugins
//Gradle plugins give meaning to components/sub-projects
plugins {
    id("my-java-library")
}

dependencies {
    implementation(platform("com.example:platform"))

    implementation(project(":data-model"))
    implementation("org.apache.commons:commons-lang3")
    implementation("org.slf4j:slf4j-api")

   // implementation(libs.commonslang)
   // implementation(libs.slf4j.api)

    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")



    //runtimeOnly("group:name") <--- Only available at run time
    //compileOnly("group:name") <--- Only available at compile time
}


/*
  Container that summarize dependencies & artifacts(define,manage or modify configurations
 */
//configurations{
//   compileClasspath // <=Compile time "view" (aka variant)
//   runtimeClasspath // <=runtime  "view" (aka variant)
//}