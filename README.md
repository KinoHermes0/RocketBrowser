
---

# Rocket Browser 
Warning: This fork is very early in development, expect lots of bugs

Getting Involved
----------------

We encourage you to participate in this open source project. We love Pull Requests, Bug Reports, ideas, (security) code reviews or any kind of positive contribution. Please read the [Community Participation Guidelines](https://www.mozilla.org/en-US/about/governance/policies/participation/).

* Issues: [https://github.com/KinoHermes0/RocketBrowser/issues](https://github.com/KinoHermes0/RocketBrowser/issues)

Build instructions
------------------

1. Clone the repository:

  ```shell
  git clone https://github.com/KinoHermes0/RocketBrowser
  ```
2. Since we're using submodule, run:

  ```shell
git submodule init
git submodule update
  ```


3. Open Android Studio and select File->Open and select FirefoxLite to open the project. Make sure to select the right build variant in Android Studio: **focusWebkitDebug**




Build instructions regarding Firebase
------------------

We're leveraging Firebase to offer some extra functionalities. However, Firebase is optional so normally you should be able to just develop on **focusWebkitDebug**.


Pull request checks
----
To mimimize the chance you are blocked by our build checks, you can self check these locally:
1. (build) run `./gradlew clean checkstyle assembleFocusWebkitDebug lint findbugs assembleAndroidTest ktlint`
2. (size check) run `python tools/metrics/apk_size.py focus webkit`
3. (Unit test) run `./gradlew testFocusWebkitDebugUnitTest`
4. (UI test) run `./gradlew connectedAndroidTest`

ktlint
----
- Download ktlint
```
curl -sSLO https://github.com/pinterest/ktlint/releases/download/0.30.0/ktlint &&
  chmod a+x ktlint &&
  sudo mv ktlint /usr/local/bin/
```
- Run `ktlint --install-git-pre-commit-hook` for hooks
- Run `./gradlew ktlint` or `ktlint` to run check
- Run `ktlint applyToIDEAProject` to make your IDE align with ktlint
- If you want to go extreme,run `ktlint -a -F`. This will use Android rule and gives you a lot of complains about max length, but we are not using it right now.
- See https://ktlint.github.io/ for details.

Docs
----

* [Content blocking](docs/contentblocking.md)
* [Translations](docs/translations.md)
* [Search](docs/search.md)
* [Telemetry](docs/telemetry.md)

License
-------

    This Source Code Form is subject to the terms of the Mozilla Public
    License, v. 2.0. If a copy of the MPL was not distributed with this
    file, You can obtain one at http://mozilla.org/MPL/2.0/
