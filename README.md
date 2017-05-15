[![Travis build status](https://travis-ci.org/johnjohndoe/TypedPreferences.svg)](https://travis-ci.org/johnjohndoe/TypedPreferences) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/info.metadude.android/typed-preferences/badge.svg)](https://maven-badges.herokuapp.com/maven-central/info.metadude.android/typed-preferences) [![Apache License](http://img.shields.io/badge/license-Apache%20License%202.0-lightgrey.svg)](http://choosealicense.com/licenses/apache-2.0/) [![VersionEye](https://www.versioneye.com/user/projects/5462379dce5463a51700006a/badge.svg)](https://www.versioneye.com/user/projects/5462379dce5463a51700006a) [![Methods count](https://img.shields.io/badge/Methods%20and%20size-59%20|%208%20KB-e91e63.svg)](http://www.methodscount.com/?lib=info.metadude.android%3Atyped-preferences%3A%2B)

# Typed Preferences

![Typed Preferences Icon](gfx/typedpreferences-icon.png "Typed Preferences Icon")

This library for Android provides classes which allow to store
and retrieve settings from the preferences. There is an individual
class for each native type:


* [`BooleanPreference`][boolean-pref] for a `boolean` value
* [`DoublePreference`][double-pref] for a `double` value
* [`FloatPreference`][float-pref] for a `float` value
* [`IntPreference`][int-pref] for an `int` value
* [`LongPreference`][long-pref] for a `long` value
* [`ShortPreference`][short-pref] for a `short` value
* [`StringPreference`][string-pref] for a `String` value

Each class comes with two constructors - one of them allows to ommit
the default value.

All classes declare the same methods: `get()`, `isSet()`, `set()` and `delete()`.
Here are the method signatures as definied in the `StringPreference` class.

```java
public class StringPreference {
    public String get() { ... }
    public boolean isSet() { ... }
    public void set(String value) { ... }
    public void delete() { ... }
}
```

Wrappers for frequently used classes can be found and added in the [wiki][typedpreferences-wiki]. Take a look!


## How to get the thing running?

Add the library as a dependency to your `build.gradle` in case you use Gradle:

```groovy
dependencies {
    compile "info.metadude.android:typed-preferences:{$version}"
}
```
Or if you use Maven you should be looking for this:

```xml
<dependency>
    <groupId>info.metadude.android</groupId>
    <artifactId>typed-preferences</artifactId>
    <version>{$version}</version>
</dependency>
```

For anything else, go to [Maven Central][maven-central] - or just build the library yourself.


## Minimum SDK version / API level

The library is available in two different versions. If you need to support *API level 8* in your project you must include the latest *1.x.x* version. This library version persists the settings synchronously using the `commit` method of the `SharedPreferences.Editor`. If the minimum SDK version you need to support is *API level 9* you can choose the latest *2.x.x* version which relies on the `apply` method of the `SharedPreferences.Editor`. Thereby settings are persisted asynchronously.

For further information please stick to documentation of the `SharedPreferences.Editor` interface.


## Demo project

Check out the **demo project** `TypedPreferencesDemo` which shows how to use the library.



## Tests

Run `./gradlew clean test` to execute the tests.


## Feedback

If you use this library and you are happy with it please send a tweet to [@tbsprs][tbsprs] and feel free to announce your app. I will be happy to list it here.

In case you do not like the library please do not hesitate to [open an issue][issues] and let me know what can be improved.


## Which applications are using this library?

* [android-rss-reader](https://github.com/nshmura/android-rss-reader)
* [Hawkular Android Client](https://github.com/hawkular/hawkular-android-client)
* [MuzeiHistory](https://github.com/tasomaniac/MuzeiHistory)
* [Philips Hue Beacon Controller](https://github.com/alter-ego/philips-hue-beacon-controller)
* [yacc](https://github.com/grodin/yacc)


## Reference

This library is mainly inspired by the classes which have been published
by [Jake Wharton][jake-wharton] in the [u2020 project][prefs-classes].


## Authors

* [Tobias Preuss][tobias-preuss]


## Contributors

* [Daniel Beland][daniel-beland]
* [ligi][ligi]
* [Marius Volkhart][marius-volkhart]
* [Matthew Compton][matthew-compton]


## License

    Copyright 2014-2017 Tobias Preuss

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.




[boolean-pref]: https://github.com/johnjohndoe/TypedPreferences/blob/master/Library/src/main/java/info/metadude/android/typedpreferences/BooleanPreference.java
[double-pref]: https://github.com/johnjohndoe/TypedPreferences/blob/master/Library/src/main/java/info/metadude/android/typedpreferences/DoublePreference.java
[float-pref]: https://github.com/johnjohndoe/TypedPreferences/blob/master/Library/src/main/java/info/metadude/android/typedpreferences/FloatPreference.java
[int-pref]: https://github.com/johnjohndoe/TypedPreferences/blob/master/Library/src/main/java/info/metadude/android/typedpreferences/IntPreference.java
[long-pref]: https://github.com/johnjohndoe/TypedPreferences/blob/master/Library/src/main/java/info/metadude/android/typedpreferences/LongPreference.java
[short-pref]: https://github.com/johnjohndoe/TypedPreferences/blob/master/Library/src/main/java/info/metadude/android/typedpreferences/ShortPreference.java
[string-pref]: https://github.com/johnjohndoe/TypedPreferences/blob/master/Library/src/main/java/info/metadude/android/typedpreferences/StringPreference.java
[maven-central]: http://search.maven.org/#search
[jake-wharton]: https://github.com/JakeWharton
[prefs-classes]: https://github.com/JakeWharton/u2020/commit/094d2146497997cd1f6779a9b5c3c7ce239b5435#diff-b28e0ef294012bd151c143531648c477
[tobias-preuss]: https://github.com/johnjohndoe
[daniel-beland]: https://github.com/dcendents
[ligi]: https://github.com/ligi
[marius-volkhart]: https://github.com/MariusVolkhart
[matthew-compton]: https://github.com/matthew-compton
[typedpreferences-wiki]: https://github.com/johnjohndoe/TypedPreferences/wiki
[tbsprs]: http://twitter.com/tbsprs
[issues]: https://github.com/johnjohndoe/TypedPreferences/issues
