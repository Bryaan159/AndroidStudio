# Navegacion

```xml
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
```

## **Enlaces**
Developer Jecktpack
https://developer.android.com/jetpack/androidx/explorer?hl=es-419

### Build.gradle
plugin
```kotlin
    id 'androidx.navigation.safeargs.kotlin'

```
```kotlin
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    ext{
        activity_version = "1.4.0"
        fragment_version = "1.4.1"
        nav_version = "2.4.1"
    }
    repositories {
        google()
    }
    dependencies {
        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
    }
}

plugins {
    id 'com.android.application' version '7.1.2' apply false
    id 'com.android.library' version '7.1.2' apply false
    id 'org.jetbrains.kotlin.android' version '1.6.10' apply false
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
```
### Build.Gradle(dependencias)
```kotlin
implementation("androidx.activity:activity-ktx:$activity_version")
implementation("androidx.fragment:fragment-ktx:$fragment_version")
implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")
debugImplementation("androidx.fragment:fragment-testing:$fragment_version")

```

### Activity_main.xml

```xml


```
### nav_graph.xml
-New  
-Android Resourse File
-Type Navigation
```xml

```
### HomeFragment

### SecondFragment

### MainActivity
```kotlin


```

