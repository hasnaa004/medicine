pluginManagement {
    repositories {
<<<<<<< HEAD
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
=======
        google()
>>>>>>> secondary/main
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

<<<<<<< HEAD
rootProject.name = "Build Reminder"
include(":app")
 
=======
rootProject.name = "Medical App"
include(":app")
>>>>>>> secondary/main
