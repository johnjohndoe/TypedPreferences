[![Travis build status](https://travis-ci.org/johnjohndoe/TypedPreferences.svg)](https://travis-ci.org/johnjohndoe/TypedPreferences) [![Build Status](https://johnjohndoe.ci.cloudbees.com/buildStatus/icon?job=TypedPreferences)](https://johnjohndoe.ci.cloudbees.com/job/TypedPreferences/)

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
* [`StringPreference`][string-pref] for a `String` value

Each class comes with two constructors - one of them allows to ommit
the default value.

All classes declare the same methods `get()`, `isSet()`, `set()` and `delete()`.
Here are the method signatures as definied in the `StringPreference` class.

```java
public class StringPreference {
    public String get() { ... }
    public boolean isSet() { ... }
    public void set(String value) { ... }
    public void delete() { ... }
}
```

## How to get the thing running?

Add the library as a dependency to your `build.gradle` in case you use Gradle:

```groovy
dependencies {
    compile 'info.metadude.android:typed-preferences:1.1.0'
}
```
Or if you use Maven you should be looking for this:

```xml
<dependency>
    <groupId>info.metadude.android</groupId>
    <artifactId>typed-preferences</artifactId>
    <version>1.1.0</version>
</dependency>
```

For anything else, go to [Maven Central][maven-central] - or just build the library yourself.


## Demo project

Check out the **demo project** `TypedPreferencesDemo` which shows how to use the library.



## Tests

Run `gradle robolectric` to execute tests.



## Reference

This library is mainly inspired by the classes which have been published
by [Jake Wharton][jake-wharton] in the [u2020 project][prefs-classes].


## Authors

* [Tobias Preuss][tobias-preuss]


## License

    Copyright 2014 Tobias Preuss

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
[string-pref]: https://github.com/johnjohndoe/TypedPreferences/blob/master/Library/src/main/java/info/metadude/android/typedpreferences/StringPreference.java
[maven-central]: http://search.maven.org/#search
[jake-wharton]: https://github.com/JakeWharton
[prefs-classes]: https://github.com/JakeWharton/u2020/commit/094d2146497997cd1f6779a9b5c3c7ce239b5435#diff-b28e0ef294012bd151c143531648c477
[tobias-preuss]: https://github.com/johnjohndoe
