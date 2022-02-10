package com.example.inputvalidator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class EdittextValidator extends RelativeLayout {

    EditText editText;
    ImageView leftIcon;
    ImageView rightIcon;
    RelativeLayout layout;

    public EdittextValidator(Context context) {
        this(context, null);
    }

    public EdittextValidator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EdittextValidator(final Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.layout_style_input_edittext, this);
        editText = findViewById(R.id.edit_text);
        leftIcon = findViewById(R.id.image_view);
        rightIcon = findViewById(R.id.error_image_view);
        layout = findViewById(R.id.layout);
        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.StyleInputEditText, 0, 0);
            String text = "";
            Drawable rightIcon = null;
            Drawable leftIcon = null;
            String hint = "";
            String inputType = "";
            int maxLength = 0;

            try {
                text = typedArray.getString(R.styleable.StyleInputEditText_text);
                leftIcon = typedArray.getDrawable(R.styleable.StyleInputEditText_leftIcon);
                rightIcon = typedArray.getDrawable(R.styleable.StyleInputEditText_rightIcon);
                maxLength = typedArray.getInt(R.styleable.StyleInputEditText_maxLength, 50);
                hint = typedArray.getString(R.styleable.StyleInputEditText_editTextHint);
                inputType = typedArray.getString(R.styleable.StyleInputEditText_inputType);


            } catch (Exception e) {
                Log.e("StyleInputEditText", "There was an error loading attributes.");
            } finally {
                typedArray.recycle();
                setLeftIcon(leftIcon);
                setHint(hint);
                setRightIcon(rightIcon);
                setMaxLength(maxLength);
                setInputType(inputType);
            }
        }
    }

    public void setText(String text) {
        editText.setText(text);
    }

    private void setMaxLength(int maxLength) {
        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(maxLength);
        editText.setFilters(FilterArray);
    }

    public void setInputType(String input) {
        switch (input) {
            case "email":
                editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                break;
            case "password":
                editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                editText.setTypeface(editText.getTypeface());
                break;
            case "phone":
                editText.setInputType(InputType.TYPE_CLASS_PHONE);
                break;
            case "name":
                editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
                break;
        }
    }

    public void setRightIcon(Drawable icon) {
        if (icon == null) {
            rightIcon.setVisibility(GONE);
        } else {
            rightIcon.setVisibility(VISIBLE);
            rightIcon.setImageDrawable(icon);
        }

    }


    public void setHint(String hint) {
        editText.setHint(hint);
    }


    public void setLeftIcon(Drawable image) {
        if (image == null) {
            leftIcon.setVisibility(GONE);
        } else {
            leftIcon.setImageDrawable(image);
        }
    }


    public void setError(boolean status) {
        rightIcon.setVisibility(View.VISIBLE);
        if (status) {
            rightIcon.setImageResource(R.drawable.wrong_icon);
        } else {
            rightIcon.setImageResource(R.drawable.correct_icon);
        }
    }

    public EditText getEditText() {
        return editText;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    public ImageView getLeftIcon() {
        return leftIcon;
    }

    public void setLeftIcon(ImageView leftIcon) {
        this.leftIcon = leftIcon;
    }

    public ImageView getRightIcon() {
        return rightIcon;
    }

    public void setRightIcon(ImageView rightIcon) {
        this.rightIcon = rightIcon;
    }

    public RelativeLayout getLayout() {
        return layout;
    }

    public void setLayout(RelativeLayout layout) {
        this.layout = layout;
    }
}
