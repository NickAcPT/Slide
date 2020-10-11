package me.ccrama.redditslide;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

import org.apache.commons.text.StringEscapeUtils;

/**
 * Created by carlo_000 on 10/19/2015.
 * Split from ImageLoaderUtils on 08/27/2020.
 */
/*Adapted from https://github.com/Kennyc1012/Opengur */
public class ImageLoaderUnescape extends ImageLoader {

    private volatile static ImageLoaderUnescape instance;

    public static ImageLoaderUnescape getInstance() {
        if (instance == null) {
            synchronized (ImageLoader.class) {
                if (instance == null) {
                    instance = new ImageLoaderUnescape();
                }
            }
        }
        return instance;
    }

    @Override
    public void displayImage(String uri, ImageAware imageAware, DisplayImageOptions options,
                             ImageSize targetSize, ImageLoadingListener listener, ImageLoadingProgressListener progressListener) {
        String newUri = StringEscapeUtils.unescapeHtml4(uri);
        super.displayImage(newUri, imageAware, options, targetSize, listener, progressListener);
    }
}
