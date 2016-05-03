package com.somnus.drawable.androiddrawabledemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * http://teachcourse.cn/1635.html
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn_shape)
    Button btnShape;
    @Bind(R.id.btn_layer_anim)
    Button btnLayerAnim;
    @Bind(R.id.btn_shape_gradient_scale)
    Button btnShapeGradientScale;
    @Bind(R.id.btn_translate_anim)
    Button btnTranslateAnim;
    @Bind(R.id.btn_scale_anim)
    Button btnScaleAnim;
    @Bind(R.id.btn_set_anim)
    Button btnSetAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * alpha标签
     */
    @OnClick({R.id.btn_layer_anim, R.id.btn_shape_gradient_scale, R.id.btn_translate_anim, R.id.btn_scale_anim,R.id.btn_set_anim})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_layer_anim:
                startAlphaAnim();
                break;
            case R.id.btn_shape_gradient_scale:
                startScaleAnim();
                break;
            case R.id.btn_translate_anim:
                startTranslateAnim();
                break;
            case R.id.btn_scale_anim:
                startRotateAnim();
                break;
            case R.id.btn_set_anim:
                startSetAnim();
                break;
            default:
                break;
        }

    }

    /**
     * 渐显动画
     */
    private void startAlphaAnim() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        btnLayerAnim.startAnimation(anim);
    }

    /**
     * 缩放动画
     */
    private void startScaleAnim() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        btnShapeGradientScale.startAnimation(anim);
    }

    /**
     * 移动动画
     */
    private void startTranslateAnim() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
        btnTranslateAnim.startAnimation(anim);

    }

    /**
     * 旋转动画
     */
    private void startRotateAnim() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        btnScaleAnim.startAnimation(anim);

    }

    /**
     * set动画
     */
    private void startSetAnim() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.set_anim);
        btnSetAnim.startAnimation(anim);
    }
}
