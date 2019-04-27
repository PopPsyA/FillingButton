# FillingButton
[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-FillingButton-green.svg?style=flat )]( https://android-arsenal.com/details/1/7598 )
[![jitpack badge](https://jitpack.io/v/Devit951/FillingButton.svg)](https://jitpack.io/#Devit951/FillingButton)
[![badge android platform](https://camo.githubusercontent.com/4e7c3559fec3db6e04cd6d800d00fe6515f75260/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f706c6174666f726d2d616e64726f69642d627269676874677265656e2e737667)](https://developer.android.com/)
[![API 16+](https://img.shields.io/badge/API-16%2B-orange.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![GitHub license](https://img.shields.io/github/license/dcendents/android-maven-gradle-plugin.svg)](http://www.apache.org/licenses/LICENSE-2.0.html) 

![Build with love](https://forthebadge.com/images/badges/built-with-love.svg)

Replace typical onLongClickListener with that library! **It's the new way to handle onLongClickListener on buttons.**

# Sample
![20190328_105032](https://user-images.githubusercontent.com/21290800/55136168-8492f300-514f-11e9-82dd-2edc218a2e90.gif)

# Added new type of button **InternetSensableFillingButton**
![20190427_124552](https://user-images.githubusercontent.com/21290800/56846643-10cd3d00-68eb-11e9-883c-f95484056790.gif)


## Usage a simple FillingButton
```
 <com.github.devit951.fillingbutton.FillingButton
        android:id="@+id/fb_first"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="BUTTON"
        android:background="@color/colorAccent"
        app:fillColor="@color/colorPrimaryDark"
        app:fillDuration="500"/>
```

## Usage a simple InternetSensableFillingButton

```
 <com.github.devit951.fillingbutton.InternetSensableFillingButton
        android:id="@+id/fb_first"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="BUTTON"
        android:background="@color/colorAccent"
        app:fillColor="@color/colorPrimaryDark"
        app:fillDuration="500"/>
```

## List of xml attributes: 
```
app:fillColor=(color) -> Changes foreground color of filling
app:fillAlpha=(integer) -> Changes alpha of foreground color filling
app:fillDuration=(integer) -> Changes fill animation duration
```

## Setup
```
allprojects {
  repositories { 
    maven { url 'https://jitpack.io' } 
  }
}
  
dependencies {  
  implementation 'com.github.Devit951:FillingButton:v1.0'
}
```
