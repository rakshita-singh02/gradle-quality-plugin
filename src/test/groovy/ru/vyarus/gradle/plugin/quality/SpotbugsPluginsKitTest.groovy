package ru.vyarus.gradle.plugin.quality

import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.TaskOutcome

/**
 * @author Vyacheslav Rusakov
 * @since 20.02.2018
 */
class SpotbugsPluginsKitTest extends AbstractKitTest {

    def "Check spotbugs plugins"() {
        setup:
        build("""
            plugins {
                id 'java'
                id 'com.github.spotbugs'
                id 'ru.vyarus.quality'
            }

            quality {
                checkstyle false
                pmd false
                strict false
            }

            repositories { mavenCentral() }
            dependencies {
                spotbugsPlugins 'com.mebigfatguy.fb-contrib:fb-contrib:6.6.0'
            }
        """)

        fileFromClasspath('src/main/java/sample/Sample.java', '/ru/vyarus/gradle/plugin/quality/java/sample/Sample.java')
        fileFromClasspath('src/main/java/sample/Sample2.java', '/ru/vyarus/gradle/plugin/quality/java/sample/Sample2.java')

        when: "run check task with java sources"
        BuildResult result = run('check')

        then: "all plugins detect violations"
        result.task(":check").outcome == TaskOutcome.SUCCESS
        result.output.contains('SpotBugs rule violations were found')
    }

    def "Check spotbugs plugins 2"() {
        setup:
        build("""
            plugins {
                id 'java'
                id 'ru.vyarus.quality'
            }

            quality {
                checkstyle false
                pmd false
                strict false
            }

            repositories { mavenCentral() }
            afterEvaluate {
                dependencies {
                    spotbugsPlugins 'com.mebigfatguy.fb-contrib:fb-contrib:6.6.0'
                }
            }
        """)

        fileFromClasspath('src/main/java/sample/Sample.java', '/ru/vyarus/gradle/plugin/quality/java/sample/Sample.java')
        fileFromClasspath('src/main/java/sample/Sample2.java', '/ru/vyarus/gradle/plugin/quality/java/sample/Sample2.java')

        when: "run check task with java sources"
        BuildResult result = run('check')

        then: "all plugins detect violations"
        result.task(":check").outcome == TaskOutcome.SUCCESS
        result.output.contains('SpotBugs rule violations were found')
    }
}