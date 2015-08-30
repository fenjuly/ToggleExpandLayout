# ToggleExpandLayout
A togglelayout that can be used in setting interface.
Originally designed by [dribbble](https://dribbble.com/shots/2211566-Android-Toggle-Behaviour).

###Preview
![toggleexpandlayout](http://i.imgur.com/aYZByoU.gif)

###Usage

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


```java
layout.setOnToggleTouchListener(new ToggleExpandLayout.OnToggleTouchListener() {
            @Override
            public void onStartOpen() {
            }

            @Override
            public void onOpen() {
               int childCount = layout.getChildCount();
               for(int i = 0; i < childCount; i++) {
                   View view = layout.getChildAt(i);
                   view.setElevation(dp2px(1));
               }
            }

            @Override
            public void onStartClose() {
                int childCount = layout.getChildCount();
                for(int i = 0; i < childCount; i++) {
                    View view = layout.getChildAt(i);
                    view.setElevation(dp2px(i));
                }
            }

            @Override
            public void onClosed() {

            }
        });
  ```
  
  ###License
  MIT
