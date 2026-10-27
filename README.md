# Android Selection Case Converter

A tiny Android app (~10 KB, no permissions, no network, no AI) that adds two entries to the text-selection menu:

- **UPPERCASE**: replaces the selection with `ALL CAPS`.
- **ChAoS cAsE**: replaces the selection with random mixed case (`hELlo wOrLd`). Never more than two letters in a row share a case, so it always looks chaotic.

Select text in any editable field, open the menu (tap **⋮** if the entries aren't shown directly), and pick one. The text is replaced in place. If the field is read-only (a web page, a chat message), the result is copied to the clipboard instead.

There is no launcher icon: the app only lives in the selection menu. Uninstall it from Settings → Apps → Case Menu.

## Install

Download `case-menu-v1.0.apk` from [Releases](../../releases) and open it on the phone (allow installs from your browser/file manager when asked).

## How it works

Two no-UI activities register for [`Intent.ACTION_PROCESS_TEXT`](https://developer.android.com/reference/android/content/Intent#ACTION_PROCESS_TEXT) (Android 6.0+, `minSdk 23`). Each reads `EXTRA_PROCESS_TEXT`, transforms it on device and returns it via `setResult`. Source: `app/src/main/java/com/danielrosehill/casemenu/`.

## Build

```sh
export JAVA_HOME=/path/to/jdk-17-or-21   # JDK 25 is not supported by AGP 8.9
./gradlew assembleRelease
# -> app/build/outputs/apk/release/app-release.apk
```

Needs an Android SDK with platform 35 (set `sdk.dir` in `local.properties` or `ANDROID_HOME`). The release build is signed with the standard Android debug keystore (`~/.android/debug.keystore`), so it is sideload-only, not for the Play Store.

## License

MIT
