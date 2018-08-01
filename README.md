# XShadow

XShadow是一个阴影控件，支持自定义阴影半径、颜色、宽度、内圆角、阴影显示的四个边


运行效果如下图：

![阴影控件效果](http://bmob-cdn-20165.b0.upaiyun.com/2018/08/01/7b807da44042f2038062b34ad5ada726.png)


1. 添加依赖

- gradle配置

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}


dependencies {
    implementation 'com.github.yeaper:XShadow:1.0.1'
}
```

- Maven配置

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>


<dependency>
    <groupId>com.github.yeaper</groupId>
    <artifactId>XShadow</artifactId>
    <version>1.0.1</version>
</dependency>

```

2. 使用

只要在布局外面，套一个XShadow布局即可，然后可以设置阴影的几个属性值，设置属性有两种;

第一种，直接在布局中设置，如下：

```xml
<com.yyp.xshadow.XShadow
    android:id="@+id/shadow1"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:shadow_color="#21000000"
    app:shadow_radius="20dp"
    app:shadow_width="10dp"
    app:corner_radius="0dp"
    app:shadow_side="left|bottom|right">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="70dp"
        android:orientation="horizontal"
        android:gravity="center"
        android:paddingLeft="20dp"
        android:paddingRight="20dp">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="14sp"
            android:text="展示内容"
            android:textColor="#000000"
            android:background="@null"
            android:singleLine="true"/>
    </LinearLayout>

</com.xsb.xshadow.XShadow>
```

第二种，在java代码中设置，如下：


```java
XShadow shadow1 = findViewById(R.id.shadow1);
shadow1.setProperty(new XShadowProperty()
        .setShadowColor(0x21000000)
        .setShadowRadius(dip2px(10))
        .setCornerRadius(dip2px(2))
        .setShadowWidth(dip2px(10))
        .setShadowSide(XShadowSide.ALL));
```

3. 相关属性对应表

| 属性名 | 属性类型 | 描述 |
| ---- | ---- | ---- |
| shadow_color | color | 阴影颜色 |
| shadow_radius | dimension | 阴影模糊半径 |
| corner_radius | dimension | 内圆角半径 |
| shadow_width | dimension | 阴影宽度 |
| shadow_side | flag | 阴影显示的边，有left、top、right、bottom、all，可自由组合 |

