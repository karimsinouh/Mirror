# Mirror
Simple image loading library for compose for desktop.

I was inspired by many compose samples that are available on github.

![Workflow result](https://jitpack.io/v/io.github.karimsinouh/Mirror.svg)

# Implementation
in your gradle file:
```
repositories {
     ...
    maven { url 'https://jitpack.io' }
}
```
add the dependency
```
dependencies {
	   mplementation 'io.github.karimsinouh:Mirror:LatestVersion'
}
```
# How To Use
```
Mirror(
        "https://i1.sndcdn.com/avatars-cUl8H1mQmakaKjf3-e1uOdQ-t500x500.jpg",
        loading = { MirrorDefaultPlaceholder()},
        error = { Text("Error")}
    )
```
in case you didn't specify a Modifier with height and width the image will automatically be full size

```
Mirror(
    "https://i1.sndcdn.com/avatars-cUl8H1mQmakaKjf3-e1uOdQ-t500x500.jpg",
    loading = { MirrorDefaultPlaceholder()},
    error = { Text("Error")},
    modifier = Modifier.width(300.dp).height(300.dp)
)
```

### Result
![image](https://i.ibb.co/WWzDtCT/preview1.png)

# Placeholder
This library comes with a pre built placeholder to use while loading `MirrorDefaultPlaceholder()`,  and you can also specify your own composable

```
Mirror(
    ...
    loading = { MirrorDefaultPlaceholder()},
    ...
)
```
   
### result
![placeholder](https://i.ibb.co/QvLztLv/prev-2.png)

# Error
There is also a pre built error composable to use when some problem occures while loading a picture `MirrorDefaultError()`, and you can also specify your own composable

```
Mirror(
   ...
   error = { MirrorDefaultError() },
   ...
)
```

### result
![error](https://i.ibb.co/3hq0HXR/prev3.png)
