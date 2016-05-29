[![Build Status](https://travis-ci.org/MichaelRocks/callmemaybe.svg?branch=master)](https://travis-ci.org/MichaelRocks/callmemaybe)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-CallMeMaybe-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/3542)

CallMeMaybe
===========
An Android `EditText` for phone numbers.

![CallMeMaybe](https://raw.githubusercontent.com/MichaelRocks/CallMeMaybe/master/callmemaybe.gif)

Download
--------
Gradle:
```groovy
repositories {
  jcenter()
}

dependencies {
  compile 'io.michaelrocks:callmemaybe:1.2.0'
}
```

Usage
-----
Just replace your `EditText` with the `PhoneEditText` and that's it!

If using the `PhoneEditText` view doesn't work wll for you it's possible
to make `TextView` act as the `PhoneEditText`.
```java
final TextView phoneEditText = (TextView) findViewById(R.id.phoneEditText);
CallMeMaybe.attachTo(phoneEditText);
```

License
=======
    Copyright 2016 Michael Rozumyanskiy

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
