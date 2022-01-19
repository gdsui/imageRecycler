package com.motion.imagerecycler;

import android.net.Uri;

public class ImageClass {
    String title;
    Uri imageUri;

    public ImageClass(String title, Uri imageUri) {
        this.title = title;
        this.imageUri = imageUri;
    }

    public String getTitle() {
        return title;
    }

    public Uri getImageUri() {
        return imageUri;
    }
}
