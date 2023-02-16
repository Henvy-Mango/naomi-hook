pluginManagement {
    repositories {
        // maven("https://maven.aliyun.com/repository/gradle-plugin")
        // maven("https://maven.aliyun.com/repository/google")
        // maven("https://maven.aliyun.com/repository/public")
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // maven("https://maven.aliyun.com/repository/google")
        // maven("https://maven.aliyun.com/repository/public")
        // maven("https://repo.huaweicloud.com/kunpeng/maven")
        google()
        mavenCentral()
        maven("https://api.xposed.info/")
    }
}

include(":app")
rootProject.name = "Naomi-Hook"

