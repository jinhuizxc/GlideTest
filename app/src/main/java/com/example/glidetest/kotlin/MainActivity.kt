package com.example.glidetest.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.glidetest.R

/**
 *  java.lang.NoClassDefFoundError: Failed resolution of: Ljp/co/cyberagent/android/gpuimage/filter/GPUImageToonFilter;
 */
class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    findViewById<RecyclerView>(R.id.list).apply {
      layoutManager = LinearLayoutManager(context)
      adapter = MainAdapter(context, mutableListOf(
              MainAdapter.Type.Mask, MainAdapter.Type.NinePatchMask, MainAdapter.Type.RoundedCorners,
              MainAdapter.Type.CropTop, MainAdapter.Type.CropCenter, MainAdapter.Type.CropBottom, MainAdapter.Type.CropSquare, MainAdapter.Type.CropCircle,
              MainAdapter.Type.CropCircleWithBorder, MainAdapter.Type.Grayscale, MainAdapter.Type.Blur,
              MainAdapter.Type.SupportRSBlur, MainAdapter.Type.Toon, MainAdapter.Type.Sepia, MainAdapter.Type.Contrast, MainAdapter.Type.Invert,
              MainAdapter.Type.Pixel, MainAdapter.Type.Sketch, MainAdapter.Type.Swirl, MainAdapter.Type.Brightness, MainAdapter.Type.Kuawahara, MainAdapter.Type.Vignette
      ))
    }
  }
}
