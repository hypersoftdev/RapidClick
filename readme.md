# RapidClick

**RapidClick** is a Kotlin extension designed to prevent repetitive clicks on Android views by enforcing a minimum delay between click events. This ensures that accidental double-clicking, which can lead to bugs or unintended behavior, is avoided.

## Features

- Prevents multiple clicks within a customizable time interval.
- Simple and easy-to-use Kotlin extension function.
- Customizable click delay (default is 300ms).

## Gradle Integration

### Step A: Add Maven Repository

In your project-level **build.gradle** or **settings.gradle** file, add the JitPack repository:
```
repositories {
    google()
    mavenCentral()
    maven { url "https://jitpack.io" }
}
```  

### Step B: Add Dependencies

In your app-level **build.gradle** file, add the library dependency. Use the latest version: 

Groovy Version
```
 implementation 'com.github.hypersoftdev:RapidClick:x.x.x'
```
Kts Version
```
 implementation("com.github.hypersoftdev:RapidClick:x.x.x")
```

## Usage

Use the `rapidSafeClickListener` extension on any **View** object to safely handle click events without worrying about multiple rapid clicks.

### Example:

```
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.yourlibrary.RapidClick

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton: Button = findViewById(R.id.myButton)

        // Applying safe click listener to the button
        myButton.rapidSafeClickListener(time = 500) {
            // Handle click event
            println("Button clicked safely!")
        }
    }
}
```

## API

The `rapidSafeClickListener` extension function allows you to define a minimum time interval between consecutive clicks on a view.

```
View.rapidSafeClickListener(time: Int = 300, action: () -> Unit)
```

- time: (Optional) The minimum time interval between consecutive clicks, in milliseconds. The default is 300ms.
- action: The lambda function to be executed when a valid click occurs (after the defined time interval).

### Example:

```
myButton.rapidSafeClickListener(time = 400) {
// Your custom click handling code here
}
```

## Customization
You can adjust the default click interval by passing a custom time value to the `rapidSafeClickListener` function:
```
myButton.rapidSafeClickListener(time = 500) {
// Your click action
}
```

## Disadvantages of Not Using RapidClick

Without utilizing **RapidClick**, your Android app may face several issues related to handling multiple rapid clicks on UI elements:

1. **Accidental Multiple Actions:**  
   Users might unintentionally trigger the same action multiple times by quickly tapping a button. This can lead to issues like:
   - Submitting the same form multiple times.
   - Adding the same item to a cart repeatedly.
   - Triggering multiple API calls unintentionally.

2. **UI Overload:**  
   Repeated clicks can cause the user interface to become overwhelmed, leading to:
   - Animations or transitions being triggered multiple times.
   - Multiple dialogs or screens opening at once, confusing or frustrating the user.

3. **Inconsistent Data Handling:**  
   If your app is performing database or network operations, multiple rapid clicks can cause:
   - Duplicate data entries.
   - Conflicting updates to the app's state or backend systems.
   - Unnecessary or erroneous API calls that lead to data corruption or syncing issues.

4. **App Performance Issues:**  
   Allowing repeated clicks without any prevention can cause performance degradation due to:
   - Unnecessary processing or repeated network calls.
   - Overuse of system resources like CPU or memory, leading to potential app crashes.

5. **Poor User Experience:**  
   Without protection against rapid clicks, the app may seem buggy or unresponsive, resulting in a poor user experience. Users may:
   - Feel that their input was not recognized.
   - Be unsure whether their action was successfully processed.
   - Get frustrated by unexpected behavior such as duplicated actions.

## Limitations of RapidClick

While **RapidClick** is effective at preventing rapid consecutive clicks, it has some limitations that you should be aware of:

1. **Delayed User Response:**  
   The enforced time delay between clicks may cause some users to experience a slower response time, especially if they expect immediate feedback from their interactions.

2. **Overuse in UX:**  
   Applying click delays to too many interactive elements in your app can lead to a frustrating user experience. Not every click action requires prevention, and overuse of delays may disrupt the natural flow of the user interface.

3. **Custom Timing May Not Fit All Scenarios:**  
   The default time interval of 300ms might not be suitable for all scenarios. While the time interval can be customized, it may still be difficult to determine the perfect timing for every possible use case, especially in apps with varied types of interactions.

4. **No Feedback on Blocked Clicks:**  
   Users aren't notified when a click is blocked due to the rapid click prevention mechanism. This lack of feedback could lead to confusion, as users may not understand why their input isn't being registered, potentially leading to frustration.

It’s important to balance the use of **RapidClick** with user expectations to ensure that the app remains responsive and user-friendly, while still protecting against unintended rapid clicks.


# Acknowledgements

This work would not have been possible without the invaluable contributions of **Muhammad Saad**. His expertise, dedication, and unwavering support have been instrumental in bringing this project to fruition.

![Profile](https://github.com/hypersoftdev/RapidClick/blob/master/screens/profile_image.jpg?raw=true)

We are deeply grateful for **Muhammad Saad** involvement and his belief in the importance of this work. His contributions have made a significant impact, and we are honored to have had the opportunity to collaborate with him.

# LICENSE

Copyright 2023 Hypersoft Inc

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

