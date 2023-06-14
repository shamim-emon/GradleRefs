//Apply gradle plugins
//Gradle plugins give meaning to components/sub-projects
plugins {
    //application plugin: adds functionality for packging & running java application
    id("my-application")
}

application{
    mainClass.set("com.example.MyApplication")
}

dependencies{
    implementation(platform("com.example:platform"))
    implementation(project(":data-model"))
    implementation(project(":business-logic"))
//
//    implementation(libs.commonslang)
//    runtimeOnly(libs.slf4j.simple)
}

