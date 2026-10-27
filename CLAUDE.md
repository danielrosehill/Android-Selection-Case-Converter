# Android Selection Case Converter

Release tier: **small** (tags `v1.0`, `v1.1`, ...). Bump `versionCode`/`versionName` in `app/build.gradle` per release.

Build: `JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64 ./gradlew assembleRelease` (JDK 25 fails with AGP 8.9.1; the shell's default JAVA_HOME on this laptop points to a missing JDK 17 path). SDK: `~/Development/Android/Sdk`.
Release: `gh release create vX.Y /tmp/case-menu-vX.Y.apk --target master` (copy the APK to that name first; `gh` here rejects the `#label` form).
