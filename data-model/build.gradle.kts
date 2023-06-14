
//Apply gradle plugins
//Gradle plugins give meaning to components/sub-projects
plugins {
   id("my-java-library")
}

dependencies{
   implementation(platform("com.example:platform"))
}
