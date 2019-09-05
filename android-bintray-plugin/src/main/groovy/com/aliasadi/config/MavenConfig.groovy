package com.aliasadi.config


import com.aliasadi.extension.UploadExtension
import com.aliasadi.plugin.AndroidPlugin
import org.gradle.api.Project

class MavenConfig implements Config {

    private Project project

    MavenConfig(Project project) {
        this.project = project
    }

    /**
     * Maven update the POM file.
     * **/
    @Override
    void apply() {
        generatePom(project, project.extensions.getByName(UploadExtension.UPLOAD_TO_BINTRAY))
    }

    private void generatePom(Project proj, UploadExtension upload) {
        proj.version = upload.versionName
        proj.group = upload.groupId

        proj.install {
            repositories.mavenInstaller {
                pom {
                    project {
                        packaging 'aar'
                        groupId upload.groupId
                        artifactId upload.artifactId
                        name upload.getPackageName()
                        description upload.desc
                        url upload.website

                        licenses {
                            license {
                                name upload.licences
                            }
                        }

                        developers {
                            developer {
                                id upload.getOrganization(proj)
                                name upload.getOrganization(proj)
                            }
                        }

                        scm {
                            url upload.website
                            connection upload.getGitUrl()
                            developerConnection upload.getGitUrl()
                        }
                    }
                }
            }
        }

    }

}