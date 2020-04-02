# EasyAlert
An awesome android library to show custom toast, alert-dialog, logs and progress dialog with few lines of code. 

[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![](https://img.shields.io/badge/Language-Kotlin-green.svg)](https://kotlinlang.org)
[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=plastic)](https://android-arsenal.com/api?level=15)
[![](https://jitpack.io/v/Jakir123/EasyAlert.svg)](https://jitpack.io/#Jakir123/EasyAlert)

## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```
## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.Jakir123:EasyAlert:1.1.1'
}
```

## Usage

#### Toast
To display an default Toast:
``` kotlin
EasyToast.showErrorToast(this,"Hello default toast...")
```
To display a success Toast:

``` kotlin
EasyToast.showSuccessToast(this,"Hello success toast...")
```
To display an info Toast:

``` kotlin
EasyToast.showInfoToast(this,"Hello info toast...")
```
To display a warning Toast:

``` kotlin
EasyToast.showWarningToast(this,"Hello warning toast...")
```
To display the error Toast:

``` kotlin
EasyToast.showErrorToast(this,"Hello error toast...")
```

#### Alert Dialog
To display the default Alert Dialog:

``` kotlin
 EasyAlert.showAlert(
        this,
        "Alert without Choices",
        "The alert message is here...."
 ) // observe this for doing something when user click on ok.
```
To display the default Alert Dialog with choice:

``` kotlin
EasyAlert.showAlertWithChoice(
    this,
    "Alert with Choices",
    "Do you want to see the default alert?"
).observe(this,
     Observer {
         if (it) {
            // handle ok button click
            EasyToast.showToast(this, "You clicked on Ok button!") // default toast
         } else {
            // handle cancel button click
            EasyToast.showToast(this, "You clicked on cancel button!") // default toast
         }
     })
```

#### Progress Dialog
To display the Progress Dialog without message:

``` kotlin
 EasyAlert.showProgressDialog(this)
```
To display the Progress Dialog with message:

``` kotlin
 EasyAlert.showProgressDialog(this, "showing progress dialog")
```

To hide the Progress Dialog:
``` kotlin
 EasyAlert.hideProgressDialog()
 ```

#### Log
To print Log without TAG:

```
EasyLog.logV("Verbose message") // only pass log text in parameter 
EasyLog.logI("Info message")
EasyLog.logD("Debug message")
EasyLog.logW("Warning message")
EasyLog.logE("Error message")
```

To print Log with TAG:

```
EasyLog.logV("Verbose message", "YOUR_TAG") // passing tag with second parameter is optional
EasyLog.logI("Info message", "YOUR_TAG")
EasyLog.logD("Debug message", "YOUR_TAG")
EasyLog.logW("Warning message", "YOUR_TAG")
EasyLog.logE("Error message", "YOUR_TAG")
```


## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2020 Jakir Hossain

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
