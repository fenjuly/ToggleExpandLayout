# ToggleExpandLayout
A togglelayout that can be used in setting interface.
Originally designed by [dribbble](https://dribbble.com/shots/2211566-Android-Toggle-Behaviour).
And the author said that's why he designed this:
>I never liked how some settings are disabled by default and not tappable until another settings has been turned on/off.

>My concept is to hide these disabled settings behind their "master toggle" and then have them transition out as they become active - making the list cleaner, with less clutter and ultimately easier to use.


###Preview
![toggleexpandlayout](http://i.imgur.com/aYZByoU.gif)

###Usage
* **XML**
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

* **JAVA**

two method `public void open()` and `public void close()`

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
  
###License
  
[MIT](https://github.com/fenjuly/ToggleExpandLayout/raw/master/LICENSE)
