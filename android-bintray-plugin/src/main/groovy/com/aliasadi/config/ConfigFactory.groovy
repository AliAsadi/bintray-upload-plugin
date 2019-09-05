package com.aliasadi.config

import org.gradle.api.Project

import static com.aliasadi.config.ConfigType.Maven

class ConfigFactory {

    private Project project

    ConfigFactory(Project project) {
        this.project = project
    }

    Config getConfig(ConfigType type) {
        return (type == Maven) ? new MavenConfig(project) : new BintrayConfig(project)
    }

}