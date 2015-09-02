# ToggleExpandLayout
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-ToggleExpandLayout-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/2412)

A togglelayout that can be used in setting interface.
Originally designed by [dribbble](https://dribbble.com/shots/2211566-Android-Toggle-Behaviour).
And the author said that's why he designed this:
>I never liked how some settings are disabled by default and not tappable until another settings has been turned on/off.

>My concept is to hide these disabled settings behind their "master toggle" and then have them transition out as they become active - making the list cleaner, with less clutter and ultimately easier to use.


###Preview
![toggleexpandlayout](http://i.imgur.com/xEy5sr9.gif)

###Usage
* **XML**
 
if yout just use one togglelayout:

```xml
 <com.fenjuly.mylibrary.ToggleExpandLayout
        android:id="@+id/toogleLayout"
        android:layout_marginTop="15dp"
        android:layout_marginLeft="15dp"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        >

        <View
            android:id="@+id/view1"
            android:layout_width="300dp"
            android:layout_height="80dp"
            android:background="#ffffff"
            android:elevation="2dp"
            android:outlineProvider="bounds"
            >
        </View>
        <View
            android:id="@+id/rootView"
            android:layout_width="300dp"
            android:layout_height="80dp"
            android:background="#ffffff"
            android:elevation="2dp"
            android:outlineProvider="bounds"
            >
        </View>
    </com.fenjuly.mylibrary.ToggleExpandLayout>
```

if yout want use more than one togglelayouts with drop and rise animation, use DropDownLayout:

```xml
 <com.fenjuly.mylibrary.DropDownLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginTop="15dp"
        android:layout_marginLeft="15dp"
        >

    <com.fenjuly.mylibrary.ToggleExpandLayout
        android:id="@+id/toogleLayout"
        android:layout_marginTop="15dp"
        android:layout_marginLeft="15dp"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        >
        ...
    </com.fenjuly.mylibrary.ToggleExpandLayout>
    
    <com.fenjuly.mylibrary.ToggleExpandLayout
        android:id="@+id/toogleLayout"
        android:layout_marginTop="15dp"
        android:layout_marginLeft="15dp"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        >
        ...
    </com.fenjuly.mylibrary.ToggleExpandLayout>
    </com.fenjuly.mylibrary.DropDownLayout>
```


* **JAVA**

two methods `public void open()` and `public void close()`

```java
layout.setOnToggleTouchListener(new ToggleExpandLayout.OnToggleTouchListener() {
            @Override
            public void onStartOpen() {
            }

            @Override
            public void onOpen() {
            }

            @Override
            public void onStartClose() {
            }

            @Override
            public void onClosed() {
            }
        });
  ```

###Get into your build
```gradle
repositories {
    maven {
        url "https://jitpack.io"
    }
}

dependencies {
    compile 'com.github.fenjuly:ToggleExpandLayout:774e497692'
}
```
  
###License
  
[MIT](https://github.com/fenjuly/ToggleExpandLayout/raw/master/LICENSE)
