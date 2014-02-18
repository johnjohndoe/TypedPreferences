# Typed Preferences

This library for Android provides classes which allow to store
and retrieve settings from the preferences. There is an individual
class for each native type:

* `BooleanPreference` for a `boolean` value
* `DoublePreference` for a `double` value
* `FloatPreference` for a `float` value
* `IntPreference` for an `int` value
* `LongPreference` for a `long` value
* `StringPreference` for a `String` value

Each class comes with two constructors - one of them allows to ommit
the default value.

A common interface defines the following methods:

```java
public interface TypedPreference<T extends Object> {
    public T get();
    public boolean isSet();
    public void set(T value);
    public void delete();
}
```

## How to get the thing running?

Add the library as a dependency to your `build.gradle`:

```groovy
dependencies {
    compile 'info.metadude.android:typed-preferences:1.0.0'
}
```

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




[jake-wharton]: https://github.com/JakeWharton
[prefs-classes]: https://github.com/JakeWharton/u2020/commit/094d2146497997cd1f6779a9b5c3c7ce239b5435#diff-b28e0ef294012bd151c143531648c477
[tobias-preuss]: https://github.com/johnjohndoe
