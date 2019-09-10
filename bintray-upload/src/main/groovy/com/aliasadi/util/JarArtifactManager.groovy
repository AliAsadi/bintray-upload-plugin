package com.aliasadi.util


import org.gradle.api.Project
import org.gradle.api.tasks.bundling.Jar
import org.gradle.api.tasks.javadoc.Javadoc

/**
 * Created by Ali Asadi on 05/09/2019.
 */
class JarArtifactManager {

    private Project project

    JarArtifactManager(Project project) {
        this.project = project
    }

    /***
     * Update project artifacts (SourceJar, DocJar)
     * **/
    void update() {
        updateArtifacts()
    }

    private void updateArtifacts() {
        project.artifacts {
            archives getJavaDocJar(project)
            archives getSourceJar(project)
        }
    }

    private Jar getJavaDocJar(Project project) {

        def javadoc = project.tasks.create(name: 'javadoc', type: Javadoc) {
            source = project.android.sourceSets.main.java.srcDirs
            classpath += project.files(project.android.getBootClasspath().join(File.pathSeparator))
        }

        def javadocJar = project.tasks.create(name: 'javadocJar', dependsOn: javadoc, type: Jar) {
            classifier = 'javadoc'
            from javadoc.destinationDir
        }
        return javadocJar
    }

    private Jar getSourceJar(Project project) {

        def sourcesJar = project.tasks.create(name: 'sourcesJar', type: Jar) {
            classifier = 'sources'
            from project.android.sourceSets.main.java.srcDirs
        }

        return sourcesJar
    }

}