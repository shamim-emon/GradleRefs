

pluginManagement{
    repositories.gradlePluginPortal()
    //repositories.mavenCentral()
//    repositories.google()
//    repositories.maven("https://mylocation/repo"){
//        credentials.username = "....."
//        credentials.password = "....."
//    }

    //local plugins
    //this path contains separate build that contains gradle plugins
    includeBuild("gradle/plugins")
}

/*
  This block allows us to include
  external repositories/component in our project
* */
dependencyResolutionManagement {

    //region binary components/repositories
    //These components are already built by gradle/another build tool

    repositories.mavenCentral()
    //repositories.google()
    //include your own custom repository/component
//    repositories.maven("https://myrepolocation.com"){
//        //configuration of your custom repository/component
//        credentials.username = "....."
//        credentials.password = "....."
//    }
    //endregion

    //region non-binary components/repositories

    //includeBuild tells gradle that there are other component somewhere that
    // can be potentially be build by  gradle.
    //Note: includeBuild() only tells gradle where to potentially find components
    //This does not tell gradle which components we actually need
   // includeBuild("my-other-project")
    includeBuild("gradle/platform")
    //endregion
}

rootProject.name = "my-project"

include("app")
include("business-logic")
include("data-model")