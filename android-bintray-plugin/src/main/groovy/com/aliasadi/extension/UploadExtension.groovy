package com.aliasadi.extension

import org.gradle.api.Project

class UploadExtension {

    //default closure name
    public static final UPLOAD_TO_BINTRAY = 'uploadToBintray'

    /** Requirement **/
    String groupId
    String artifactId
    String versionName
    String gitUrl


    /** Optional **/
    //repository
    String repoName = 'maven'

    //package
    String packageName = ''

    //licences
    String licences = 'Apache-2.0'

    //organization id
    String organization = ''

    //description
    String desc = ''

    //sites
    String website = ''
    String issueTrackerUrl = ''

    //bintray
    String bintrayUser = ''
    String bintrayKey = ''

    String getBintrayUser(Project project) {
        return (bintrayUser) ? bintrayUser : project.getProperties().get("bintrayUser")
    }

    String getBintrayKey(Project project) {
        return (bintrayKey) ? bintrayKey : project.getProperties().get("bintrayKey")
    }

    void updateGitUrl() {
        if (gitUrl == null) {
            if (website.contains("github.com")) {
                gitUrl = website + ".git"
            }
        }
    }

    Map getRequirementObjects() {
        def requirements = new HashMap<>()
        requirements['groupId'] = groupId
        requirements['artifactId'] = artifactId
        requirements['versionName'] = versionName
        requirements['gitUrl'] = gitUrl
        return requirements
    }

    String getPackageName() {
        return !packageName.isEmpty() ? packageName : artifactId
    }

    String getOrganization(Project project) {
        return organization.isEmpty() ? getBintrayUser(project) : organization
    }

    String getGitUrl() {
        return (gitUrl != null) ? gitUrl : website + ".git"
    }

    String getIssueTrackerUrl() {
        if (!issueTrackerUrl.isEmpty()) {
            return issueTrackerUrl
        } else {
            return website.contains("github.com") ? website + "/issues" : ''
        }
    }
}
