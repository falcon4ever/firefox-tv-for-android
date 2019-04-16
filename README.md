# Firefox for Android TV

_This is an unreliable fork of [Mozilla’s Firefox for Amazon’s Fire TV][main_project] with modifications for Android TV devices_

## Changes from main project
- Long press on back button will open the overlay (more convenient if you don't have a menu button)
- Remove Amazon devices specific permissions
- Changed applicationId to be able to install it next to Mozilla's apk.

## Features that would be nice to implement
- Voice search
- Provide APKs

## What to expect from this fork
- Don't rely on this. I will try to keep it updated as long as it suits my needs. I use it on my Nvidia Shield TV, so I will fix whatever breaks for me.
- You are welcome to create new issues for Android TV specific stuff. However, you should report bugs to upstream project whenever possible.
- You are welcome to fix issues. I might try to fix some of them too but there is no guarantee.
- You are welcome to fork this and make changes.
- In the end, it would be nicer if Mozilla was in charge of this so don't hesitate to +1 this issue :
    [Provide APK download links (on our Github releases page, FTP)][issue_240]

## Build instructions
1. Clone the repository:

  ```shell
  git clone https://github.com/zecakeh/firefox-tv-for-android
  ```

2. Import the project into Android Studio or build on the command line:

  ```shell
  ./gradlew clean app:assembleSystemDebug
  ```

3. Make sure to select the right build variant in Android Studio: **systemDebug**

For further instructions see the [main project][main_project].

## License

    This Source Code Form is subject to the terms of the Mozilla Public
    License, v. 2.0. If a copy of the MPL was not distributed with this
    file, You can obtain one at http://mozilla.org/MPL/2.0/
    
[main_project]: https://github.com/mozilla-mobile/firefox-tv
[issue_240]: https://github.com/mozilla-mobile/firefox-tv/issues/240
