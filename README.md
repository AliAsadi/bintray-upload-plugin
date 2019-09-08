# Bintray Upload Plugin
Insanely easy way to upload your Android Library to Bintray/JCenter 📦

### Download

 Add plugin dependencie to `build.gradle` of the **Project**
```gradle
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath "com.aliasadi:android-bintray-plugin:1.0"
    }
}
```

### Getting started

1. Add apply plugin to `build.gradle` of the **Module** that you want to upload to bintray.
```gradle
apply plugin: 'com.aliasadi.android-bintray'
```
2. Use the `uploadToBintray` closure to set the info of your package:
```gradle
uploadToBintray {
    versionName = '0.0.1'
    groupId = 'com.aliasadi'
    artifactId = 'sample-lib'
    gitUrl = 'https://github.com/sample-lib.get'
}

```

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
