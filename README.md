# Gradle quality plugin
[![License](https://img.shields.io/badge/license-MIT-blue.svg?style=flat)](http://www.opensource.org/licenses/MIT)
[![Build Status](https://img.shields.io/travis/xvik/gradle-quality-plugin.svg)](https://travis-ci.org/xvik/gradle-quality-plugin)
[![Appveyor build status](https://ci.appveyor.com/api/projects/status/github/xvik/gradle-quality-plugin?svg=true)](https://ci.appveyor.com/project/xvik/gradle-quality-plugin)
[![codecov](https://codecov.io/gh/xvik/gradle-quality-plugin/branch/master/graph/badge.svg)](https://codecov.io/gh/xvik/gradle-quality-plugin)

**DOCUMENTATION** http://xvik.github.io/gradle-quality-plugin

### About

Static code analysis for Java and Groovy projects using Checkstyle, PMD, SpotBugs (FindBugs) and CodeNarc.
Plugin implements unified console output for all quality plugins which greatly simplifies developer workflow: 
only console is required for working with violations and makes it feel the same as java compiler errors.

Features:
* Adds extra javac lint options to see more warnings
* Complete console output for all quality plugins
* Html and xml reports for all plugins (custom xsl used for findbugs html report because it can't generate both xml and html reports)
* Zero configuration by default: provided opinionated configs will make it work out of the box
* Task to copy default configs for customization
* Grouping tasks to run registered quality plugins for exact source set (e.g. checkQualityMain)

##### Summary

* Configuration: `quality`
* Tasks:
    - `initQualityConfig` - copy default configs for customization 
    - `checkQuality[Main]` - run quality tasks for main (or any other) source set       
* Enable plugins: [Checkstyle](https://docs.gradle.org/current/userguide/checkstyle_plugin.html),
[PMD](https://docs.gradle.org/current/userguide/pmd_plugin.html),
[SpotBugs](http://spotbugs.readthedocs.io/en/latest/gradle.html),
[FindBugs](https://docs.gradle.org/current/userguide/findbugs_plugin.html),
[CodeNarc](https://docs.gradle.org/current/userguide/codenarc_plugin.html)


### Setup

Releases are published to [bintray jcenter](https://bintray.com/vyarus/xvik/gradle-quality-plugin/), 
[maven central](https://maven-badges.herokuapp.com/maven-central/ru.vyarus/gradle-quality-plugin) and 
[gradle plugins portal](https://plugins.gradle.org/plugin/ru.vyarus.quality).

[![JCenter](https://api.bintray.com/packages/vyarus/xvik/gradle-quality-plugin/images/download.svg)](https://bintray.com/vyarus/xvik/gradle-quality-plugin/_latestVersion)
[![Maven Central](https://img.shields.io/maven-central/v/ru.vyarus/gradle-quality-plugin.svg)](https://maven-badges.herokuapp.com/maven-central/ru.vyarus/gradle-quality-plugin)

```groovy
buildscript {
    repositories {
        jcenter()
        gradlePluginPortal()
    }
    dependencies {
        classpath 'ru.vyarus:gradle-quality-plugin:3.0.0'
    }
}
apply plugin: 'ru.vyarus.quality'
```

OR

```groovy
plugins {
    id 'ru.vyarus.quality' version '3.0.0'
}
```

Plugin must be applied after `java` or `groovy` plugins. Otherwise it will do nothing.

**IMPORTANT** Plugin itself is compiled for java 7, but java quality tools require java 8 so, by default, 
you will need java 8 for java projects. Groovy project will work on java 7.

If you are using lower java versions use previous plugin releases.

### Usage

Read [documentation](http://xvik.github.io/gradle-quality-plugin)

### Might also like

* [mkdocs-plugin](https://github.com/xvik/gradle-mkdocs-plugin) - beautiful project documentation generation
* [python-plugin](https://github.com/xvik/gradle-use-python-plugin) - use python modules in build
* [pom-plugin](https://github.com/xvik/gradle-pom-plugin) - improves pom generation
* [java-lib-plugin](https://github.com/xvik/gradle-java-lib-plugin) - avoid boilerplate for java or groovy library project
* [github-info-plugin](https://github.com/xvik/gradle-github-info-plugin) - pre-configure common plugins with github related info
* [animalsniffer-plugin](https://github.com/xvik/gradle-animalsniffer-plugin) - java compatibility checks
* [java-library generator](https://github.com/xvik/generator-lib-java) - java library project generator

---
[![gradle plugin generator](http://img.shields.io/badge/Powered%20by-%20Gradle%20plugin%20generator-green.svg?style=flat-square)](https://github.com/xvik/generator-gradle-plugin)
