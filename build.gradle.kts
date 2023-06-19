// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Dependency.Plugins.APPLICATION) version Versions.ANDROID apply false
    id(Dependency.Plugins.LIBRARY) version Versions.ANDROID apply false
    id(Dependency.Plugins.KOTLIN) version Versions.KOTLIN apply false
}