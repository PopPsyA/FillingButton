# FillingButton
Replace typical onClickListener with that library! **It's the new way to handle onClickListener on buttons.**

# Sample
![20190328_105032](https://user-images.githubusercontent.com/21290800/55136168-8492f300-514f-11e9-82dd-2edc218a2e90.gif)

## Usage
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
