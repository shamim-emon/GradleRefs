plugins {
    //Tells gradle that this project is  a project to write gradle plugin in kotlin dsl
    `kotlin-dsl`
}

dependencies {
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.8.0")
}