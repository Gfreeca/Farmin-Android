// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Dependency.Plugins.APPLICATION) version Versions.GRADLE apply false
    id(Dependency.Plugins.LIBRARY) version Versions.GRADLE apply false
    id(Dependency.Plugins.KOTLIN) version Versions.KOTLIN apply false
    id(Dependency.Plugins.HILT_PLUGIN) version Versions.HILT apply false
}