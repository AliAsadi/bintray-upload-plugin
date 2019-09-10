# Bintray Upload Plugin
Insanely easy way to upload your Android Library to Bintray/JCenter 📦

![Download](https://api.bintray.com/packages/aliassadi/maven/bintray-upload/images/download.svg)

# Download

 Add plugin dependencie to `build.gradle` of the **Project**
```gradle
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath "com.aliasadi:bintray-upload:1.0.1"
    }
}
```

# Getting started

1. Add apply plugin to `build.gradle` of the **Module** that you want to upload to bintray.
```gradle
apply plugin: 'com.aliasadi.bintray-upload'
```
2. Use the `uploadToBintray` closure to set the info of your package:
```gradle
uploadToBintray {
    versionName = '0.0.1'
    groupId = 'com.aliasadi'
    artifactId = 'sample-library'
    gitUrl = 'https://github.com/sample-library.git'
}

```

# Upload to bintray
* Terminal
```
./gradlew uploadToBintray -P bintrayUser=USER -P bintrayKey=KEY 
```
* IDE
<p>
  <img src="https://i.ibb.co/pwpx0Tj/Screen-Shot-2019-09-10-at-13-40-49.png" width="450" title="hover text">
</p>

# Misc
Configuration of the **uploadToBintray** closure

| Propertie | Description |
| --- | --- |
| *groupId | The group id to use for the upload |
| *artifactId | The artifact id to use |
| *versionName | The versionName to use |
| *gitUrl | The url of the vcs for this project |
| desc | A short description for this package in bintray |
| website | A string with the url for the website of this project. The Github repo can be used here |
| bintrayUser | The username to be used to upload |
| bintrayKey | The bintray API key for the user account |
| repoName | The repository name. Set to 'maven' by default |
| packageName | The display name for this package in bintray. If not set, the artifactId will be used for this. |
| organization | organization name to use for upload the library to specific organizationId |
| issueTrackerUrl | The url of the issue tracker for the project |
| licences | The licence name. Set to 'Apache-2.0' by default |


### License

```
Copyright 2019 Ali Asadi.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
