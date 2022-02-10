# InputValidator
test-lib
[![](https://jitpack.io/v/JahongirmirzoDv/InputValidator.svg)](https://jitpack.io/#JahongirmirzoDv/InputValidator)

## Installation  
### add your settings.gradle  

```maven { url 'https://jitpack.io' }```

### add dependency  
```implementation 'com.github.JahongirmirzoDv:InputValidator:1.0'```

# Simple Example  

## xml file  
```
    <com.example.inputvalidator.EdittextValidator
        android:id="@+id/email_address"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="16dp"
        app:editTextHint="email"
        app:inputType="email" />
   ```     
        
## Activity class  
```
binding.emailAddress.editText.doOnTextChanged { text, start, before, count ->
            if (!Patterns.PHONE.matcher(text.toString()).matches()) {
                binding.emailAddress.setError(true)
                binding.emailAddress.editText.setError("Email address not correct .", null)
            } else {
                binding.emailAddress.setError(false)
            }
        }
```
