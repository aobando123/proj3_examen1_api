package com.cenfotec.examen.post.post.imageHandler;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryUtil {
    public static Cloudinary getCloudinaryInstance() {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "adrianleiton",
                "api_key", "672957356742822",
                "api_secret", "3YVM-0kcOuEbvP4k8_-GZrzVRVY"));
        return cloudinary;
    }

}
