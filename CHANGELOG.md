# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).

## [Unreleased]
### Added

### Changed

### Fixed

## [3.6-RO] 2019-03-31
*Upstream changes*

### Added

### Changed
- Updated dependencies to AndroidX

### Fixed
- Bug where you could not use remote back button to exit YouTube if it was visited from Pocket (#1584)
- Fixed 4K YT bug (#277)
- Bug where cursor would disappear if on overlay during page load finish (#1732)
- Bug that could cause a crash on startup (#1778)
- Fixed links on settings About page that did not load (#1731)
- A memory leak (#1628)
- Fixed bug that could cause YouTube to display vertically offset from where it should be (#1719)
- Bug that could cause YouTube to be unresponsive if the overlay was opened during loading (#1830)
- Fixed Youtube back bug (#1939)
- Workaround for "grey screen" when returning to YouTube from Amazon homescreen (#1865)
- Backing from the navigation overlay when on the first site in your backstack will now properly exit the app (#1916)
- Bug that prevented the toolbar back button from working on YouTube (#1927)

## [3.4-A] - 2019-02-26
*Upstream changes*
** Version bump only from 3.3.1 **

## [3.3.1] - 2019-01-31
*Upstream changes*

Version-bump only - no change from v3.2.5

## [3.2.5] - 2019-01-29
*First release of Firefox for Android TV*
### Added
- Open overlay navigation with back button long press (convenient if your remote doesn't have menu button)

### Changed
- Remove Amazon devices specific permissions
- Changed ApplicationId so you can install both the official Fire TV build and this one.

## Previous versions
*See upstream project : https://github.com/mozilla-mobile/firefox-tv*

[Unreleased]: https://github.com/zecakeh/firefox-tv-for-android/compare/v3.6-RO..HEAD
[3.6-RO]: https://github.com/zecakeh/firefox-tv-for-android/compare/v3.4-A...v3.6-RO
[3.4-A]: https://github.com/zecakeh/firefox-tv-for-android/compare/v3.3.1...v3.4-A
[3.3.1]: https://github.com/zecakeh/firefox-tv-for-android/compare/v3.2.5...v3.3.1
[3.2.5]: https://github.com/mozilla-mobile/firefox-tv/compare/releases/v3.2.5...zecakeh:releases/v3.2.5
