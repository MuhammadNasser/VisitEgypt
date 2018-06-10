package com.visit_egypt.visitegypt.server;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.visit_egypt.visitegypt.R;

public class ImageLoader {

    private com.android.volley.toolbox.ImageLoader imageLoader;
    private int scalingRatio;

    public ImageLoader(Context context, int scalingRatio) {
        imageLoader = VolleySingleton.getInstance(context).getImageLoader();
        this.scalingRatio = (scalingRatio < 1) ? 1 : scalingRatio;
    }

    public void displayImage(String url, ImageView imageView) {
        imageLoader.get(url, new LoaderListener(url, imageView));
    }

    public void displayImage(String url, ImageView imageView, int maxWidth, int maxHeight) {
        imageLoader.get(url, new LoaderListener(url, imageView, maxWidth, maxHeight), maxWidth, maxHeight);
    }

    public void displayImage(String url, ImageView imageView, int maxWidth, int maxHeight, ImageView.ScaleType scaleType) {
        imageLoader.get(url, new LoaderListener(url, imageView, maxWidth, maxHeight, scaleType), maxWidth, maxHeight, scaleType);
    }

    public void loadBitmap(String url, int maxWidth, int maxHeight, com.android.volley.toolbox.ImageLoader.ImageListener imageListener) {
        imageLoader.get(url, imageListener, maxWidth, maxHeight);
    }

    private class LoaderListener implements com.android.volley.toolbox.ImageLoader.ImageListener {

        private ImageView imageView;

        private String url;
        private int maxWidth;
        private int maxHeight;
        private ImageView.ScaleType scaleType;

        private boolean removeListener;

        public LoaderListener(String url, ImageView imageView) {
            this(url, imageView, -1, -1);
        }

        public LoaderListener(String url, ImageView imageView, int maxWidth, int maxHeight) {
            this(url, imageView, maxWidth, maxHeight, imageView.getScaleType());
        }

        public LoaderListener(String url, ImageView imageView, int maxWidth, int maxHeight, ImageView.ScaleType scaleType) {
            this.url = url;
            this.imageView = imageView;
            this.maxWidth = maxWidth;
            this.maxHeight = maxHeight;
            this.scaleType = scaleType;
            removeListener = false;
            imageView.setImageResource(R.color.grayLight);
        }

        @Override
        public void onResponse(com.android.volley.toolbox.ImageLoader.ImageContainer response, boolean isImmediate) {

            Bitmap bitmap = response.getBitmap();

            if (bitmap != null) {
                if (ImageLoader.this.scalingRatio != 1) {
                    int height = bitmap.getHeight() / ImageLoader.this.scalingRatio;
                    int width = bitmap.getWidth() / ImageLoader.this.scalingRatio;

                    if (height < 200 || width < 200) {
                        height = bitmap.getHeight();
                        width = bitmap.getWidth();
                    }

                    imageView.setImageBitmap(Bitmap.createScaledBitmap(bitmap, width, height, false));
                } else {
                    imageView.setImageBitmap(bitmap);
                }

                if (removeListener) {
                    imageView.setScaleType(scaleType);
                    imageView.setOnClickListener(null);
                    imageView.setClickable(false);
                    removeListener = false;
                }
            } else {
                onErrorResponse(new VolleyError("bitmap is null url: " + response.getRequestUrl()));
            }
        }

        @Override
        public void onErrorResponse(VolleyError error) {
            if (!imageView.hasOnClickListeners()) {
                imageView.setImageResource(android.R.drawable.ic_popup_sync);
                scaleType = imageView.getScaleType();
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                removeListener = true;
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView.setScaleType(scaleType);
                        if (maxWidth != -1 && maxHeight != -1) {
                            displayImage(url, imageView, maxWidth, maxHeight);
                        } else {
                            displayImage(url, imageView);
                        }
                    }
                });
            } else {
                imageView.setImageResource(android.R.drawable.ic_dialog_alert);
            }
        }
    }
}
