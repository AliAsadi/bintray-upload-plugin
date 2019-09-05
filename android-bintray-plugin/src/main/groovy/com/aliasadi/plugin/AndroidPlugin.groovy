package com.aliasadi.plugin

import com.aliasadi.ProjectManager
import com.aliasadi.util.Validator
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidPlugin implements Plugin<Project> {


    @Override
    void apply(Project project) {

        def projectManager = ProjectManager.newInstance(project)
        projectManager.createUploadExtension()
        projectManager.createJarFiles()
        projectManager.applyMavenPlugin()
        projectManager.applyBintrayPlugin()
        projectManager.createUploadTask()

        project.afterEvaluate {
            Validator.validate(projectManager.getUploadExtension())
            projectManager.applyMavenConfig()
            projectManager.applyBintrayConfig()
        }

    }


}