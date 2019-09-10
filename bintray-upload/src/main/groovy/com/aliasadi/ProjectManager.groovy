package com.aliasadi


import com.aliasadi.config.ConfigFactory
import com.aliasadi.extension.UploadExtension
import com.aliasadi.util.JarArtifactManager
import org.gradle.api.Project
import org.gradle.api.plugins.PluginManager
import static com.aliasadi.config.ConfigType.Maven
import static com.aliasadi.config.ConfigType.Bintray

/**
 * Created by Ali Asadi on 05/09/2019.
 */
class ProjectManager {

    private PluginManager pluginManager
    private Project project
    private JarArtifactManager artifactManager
    private ConfigFactory configFactory

    private ProjectManager(Project project, PluginManager pluginManager,
                           JarArtifactManager artifactManager, ConfigFactory configFactory) {
        this.project = project
        this.pluginManager = pluginManager
        this.artifactManager = artifactManager
        this.configFactory = configFactory
    }

    static ProjectManager newInstance(Project project) {
        return new ProjectManager(project, project.pluginManager,
                new JarArtifactManager(project), new ConfigFactory(project))
    }

    void applyBintrayPlugin() {
        pluginManager.apply("com.jfrog.bintray")
    }

    void applyMavenPlugin() {
        pluginManager.apply("com.github.dcendents.android-maven")
    }

    void applyMavenConfig() {
        configFactory.getConfig(Maven).apply()
    }

    void applyBintrayConfig() {
        configFactory.getConfig(Bintray).apply()
    }


    void createUploadExtension() {
        project.extensions.create(UploadExtension.UPLOAD_TO_BINTRAY, UploadExtension)
    }

    void createJarFiles() {
        artifactManager.update()
    }

    Project getProject() {
        return project
    }

    UploadExtension getUploadExtension() {
        return project.extensions.getByName(UploadExtension.UPLOAD_TO_BINTRAY)
    }

    void createUploadTask() {

        project.tasks.create(name: 'uploadToBintray', dependsOn: [project.clean, project.bintrayUpload])

        project.getTasks().getByName('uploadToBintray').mustRunAfter(project.clean)

        project.bintrayUpload.dependsOn project.build
        project.bintrayUpload.dependsOn project.install
    }


}