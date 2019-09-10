package com.aliasadi.plugin

import com.aliasadi.ProjectManager
import com.aliasadi.util.Validator
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by Ali Asadi on 05/09/2019.
 */
class AndroidPlugin implements Plugin<Project> {


    @Override
    void apply(Project project) {

        def projectManager = ProjectManager.newInstance(project)
        projectManager.createUploadExtension()
        projectManager.applyMavenPlugin()
        projectManager.applyBintrayPlugin()
        projectManager.createUploadTask()

        project.afterEvaluate {
            Validator.validate(projectManager.getUploadExtension())
            projectManager.createJarFiles()
            projectManager.applyMavenConfig()
            projectManager.applyBintrayConfig()
        }

    }


}