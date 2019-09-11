package com.example.glidetest.java;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.glidetest.R;
import com.example.transformations.BlurTransformation;
import com.example.transformations.ColorFilterTransformation;
import com.example.transformations.CropCircleTransformation;
import com.example.transformations.CropCircleWithBorderTransformation;
import com.example.transformations.CropSquareTransformation;
import com.example.transformations.CropTransformation;
import com.example.transformations.GrayscaleTransformation;
import com.example.transformations.MaskTransformation;
import com.example.transformations.RoundedCornersTransformation;
import com.example.transformations.SupportRSBlurTransformation;
import com.example.transformations.gpu.BrightnessFilterTransformation;
import com.example.transformations.gpu.ContrastFilterTransformation;
import com.example.transformations.gpu.InvertFilterTransformation;
import com.example.transformations.gpu.KuwaharaFilterTransformation;
import com.example.transformations.gpu.PixelationFilterTransformation;
import com.example.transformations.gpu.SepiaFilterTransformation;
import com.example.transformations.gpu.SketchFilterTransformation;
import com.example.transformations.gpu.SwirlFilterTransformation;
import com.example.transformations.gpu.ToonFilterTransformation;
import com.example.transformations.gpu.VignetteFilterTransformation;
import com.example.transformations.internal.Utils;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private List<Type> dataSet = new ArrayList<>();

    public MainAdapter(Context context, List<Type> dataSet) {
        this.context = context;
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    /**
     * val multi = MultiTransformation<Bitmap>(
     * BlurTransformation(25),
     * RoundedCornersTransformation(128, 0, CornerType.BOTTOM))))
     * Glide.with(this).load(R.drawable.demo)
     * .apply(RequestOptions.bitmapTransform(multi))
     * .into(imageView))
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RequestOptions requestOptions = new RequestOptions();
        switch (dataSet.get(position)) {
            case Mask:
                requestOptions.override(Ext.get(context, 266), Ext.get(context, 252));
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(requestOptions)
                        .apply(RequestOptions.bitmapTransform(new MultiTransformation<Bitmap>(new CenterCrop(),
                                new MaskTransformation(R.drawable.mask_starfish))))
                        .into(holder.image);
                break;
            case NinePatchMask:
                requestOptions.override(Ext.get(context, 300), Ext.get(context, 200));
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(requestOptions)
                        .apply(RequestOptions.bitmapTransform(new MultiTransformation<Bitmap>(new CenterCrop(),
                                new MaskTransformation(R.drawable.mask_chat_right))))
            .into(holder.image);
                break;
            case CropTop:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(new CropTransformation(
                                Ext.get(context, 300),
                                Ext.get(context, 100), CropTransformation.CropType.TOP)))
                        .into(holder.image);
                break;
            case CropCenter:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(new CropTransformation(
                                Ext.get(context, 300),
                                Ext.get(context, 100), CropTransformation.CropType.CENTER)))
                        .into(holder.image);
                break;
            case CropBottom:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(new CropTransformation(
                                Ext.get(context, 300),
                                Ext.get(context, 100),
                                CropTransformation.CropType.BOTTOM)))
                        .into(holder.image);
                break;
            case CropSquare:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(new CropSquareTransformation()))
                        .into(holder.image);
                break;
            case CropCircle:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(new CropCircleTransformation()))
                        .into(holder.image);
                break;
            case CropCircleWithBorder:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(
                                new CropCircleWithBorderTransformation(Utils.toDp(4), Color.rgb(0, 145, 86))))
                        .into(holder.image);
                break;
            case ColorFilter:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(new ColorFilterTransformation(Color.argb(80, 255, 0, 0))))
                        .into(holder.image);
                break;
            case Grayscale:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(new GrayscaleTransformation()))
                        .into(holder.image);
                break;
            case RoundedCorners:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(45, 0,
                                RoundedCornersTransformation.CornerType.ALL)))
                        .into(holder.image);
                break;
            case Blur:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(new BlurTransformation(25)))
                        .into(holder.image);
                break;
            case SupportRSBlur:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(new SupportRSBlurTransformation(25, 10)))
                        .into(holder.image);
                break;
            case Toon:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(new ToonFilterTransformation()))
                        .into(holder.image);
                break;
            case Sepia:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(new SepiaFilterTransformation()))
                        .into(holder.image);
                break;
            case Contrast:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(new ContrastFilterTransformation(2.0f)))
                        .into(holder.image);
                break;
            case Invert:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(new InvertFilterTransformation()))
                        .into(holder.image);
                break;
            case Pixel:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(new PixelationFilterTransformation(20f)))
                        .into(holder.image);
                break;
            case Sketch:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(new SketchFilterTransformation()))
                        .into(holder.image);
                break;
            case Swirl:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(
                                new SwirlFilterTransformation(0.5f, 1.0f, new PointF(0.5f, 0.5f))).dontAnimate())
                        .into(holder.image);
                break;
            case Brightness:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(new BrightnessFilterTransformation(0.5f)).dontAnimate())
                        .into(holder.image);
                break;
            case Kuawahara:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(new KuwaharaFilterTransformation(25)).dontAnimate())
                        .into(holder.image);
                break;
            case Vignette:
                float[] floatArray = new float[]{0.0f, 0.0f, 0.0f};
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(new VignetteFilterTransformation(new PointF(0.5f, 0.5f),
                                floatArray, 0f, 0.75f)).dontAnimate())
                        .into(holder.image);
                break;
        }

        holder.title.setText(dataSet.get(position).name());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public enum Type {
        Mask,
        NinePatchMask,
        CropTop,
        CropCenter,
        CropBottom,
        CropSquare,
        CropCircle,
        CropCircleWithBorder,
        ColorFilter,
        Grayscale,
        RoundedCorners,
        Blur,
        SupportRSBlur,
        Toon,
        Sepia,
        Contrast,
        Invert,
        Pixel,
        Sketch,
        Swirl,
        Brightness,
        Kuawahara,
        Vignette
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
        }
    }
}
