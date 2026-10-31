# InputValidator

An Android custom input component for displaying an EditText with configurable icons and visual validation feedback. The repository includes the `inputValidator` library module and a small `app` host.

## What it provides

- XML attributes for hint text, left and right icons, maximum length, and input mode.
- Input modes for email, password, phone, and name fields.
- Access to the inner EditText through `getEditText()`.
- `setError(true)` and `setError(false)` to display the component's error or success icon.

Validation rules belong to the calling app. Selecting `inputType="email"` configures the keyboard; it does not validate an address automatically.

## Use the component

The original project documents distribution through [JitPack](https://jitpack.io/#JahongirmirzoDv/InputValidator):

```groovy
// Add to dependencyResolutionManagement.repositories in settings.gradle:
maven { url 'https://jitpack.io' }

// Add to the consuming module's dependencies:
implementation 'com.github.JahongirmirzoDv:InputValidator:1.0'
```

The coordinate above preserves the existing integration instructions; remote artifact availability has not been verified. The library can also be inspected directly in this repository's `inputValidator` module.

```xml
<com.example.inputvalidator.EdittextValidator
    android:id="@+id/emailAddress"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:editTextHint="Email"
    app:inputType="email" />
```

Declare the usual `app` XML namespace on the parent layout. In Kotlin, apply an explicit rule to the exposed field:

```kotlin
binding.emailAddress.editText.doOnTextChanged { text, _, _, _ ->
    val valid = android.util.Patterns.EMAIL_ADDRESS
        .matcher(text?.toString().orEmpty())
        .matches()
    binding.emailAddress.setError(!valid)
}
```

The extension comes from `androidx.core.widget.doOnTextChanged`.

## Source map

- [EdittextValidator.java](inputValidator/src/main/java/com/example/inputvalidator/EdittextValidator.java): custom view and public methods.
- [attrs.xml](inputValidator/src/main/res/values/attrs.xml): supported custom attributes.
- [Library build](inputValidator/build.gradle): Android library and Maven publication configuration.
- [Sample app](app/): host application.

## Build

Open the repository in Android Studio and use the checked-in Gradle wrapper. The app currently declares compile SDK 32 and minimum Android API 21; install the matching Android SDK and use a JDK compatible with the project's Android Gradle Plugin.

```sh
./gradlew :app:assembleDebug
```

This command is a build entry point, not a recorded passing build. The project retains its original dependency versions, so Gradle sync or dependency updates may be needed with a current Android Studio installation.
