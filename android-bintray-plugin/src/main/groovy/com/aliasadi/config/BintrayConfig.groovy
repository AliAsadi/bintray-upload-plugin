package com.aliasadi.config

import com.aliasadi.extension.UploadExtension
import com.aliasadi.plugin.AndroidPlugin
import org.gradle.api.Project
import org.gradle.api.tasks.Delete
import org.gradle.api.tasks.javadoc.Javadoc

class BintrayConfig implements Config {

    private Project project

    BintrayConfig(Project project) {
        this.project = project
    }

    /**
     * Bintray creates aar, uploading to bintray.
     * **/
    @Override
    void apply() {
        updateBintrayConfig(project, project.extensions.getByName(UploadExtension.UPLOAD_TO_BINTRAY))
    }


    private void updateBintrayConfig(Project project, UploadExtension upload) {
        project.version = upload.versionName

        project.bintray {

            user = upload.getBintrayUser(project)
            key = upload.getBintrayKey(project)
            configurations = ['archives']

            pkg {
                userOrg = upload.getOrganization(project)
                repo = upload.repoName
                name = upload.getPackageName()
                desc = upload.desc
                websiteUrl = upload.website
                vcsUrl = upload.getGitUrl()
                issueTrackerUrl = upload.getIssueTrackerUrl()
                licenses = [upload.licences]
                publish = true
                publicDownloadNumbers = true
                version {
                    name = upload.versionName
                    desc = upload.desc
                }
            }
        }
    }


}

