package com.somnus.drawable.androiddrawabledemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
    @Bind(R.id.btn_animator)
    Button btn_animator;
    @Bind(R.id.btn_animator_rotation)
    Button btn_animator_rotation;
    @Bind(R.id.btn_animator_translationx)
    Button btn_animator_translationx;
    @Bind(R.id.btn_animator_scaley)
    Button btn_animator_scaley;
    @Bind(R.id.btn_animatorset)
    Button btn_animatorset;
    @Bind(R.id.btn_animator_xml)
    Button btn_animator_xml;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
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
    @OnClick({R.id.btn_layer_anim,
            R.id.btn_shape_gradient_scale,
            R.id.btn_translate_anim,
            R.id.btn_scale_anim,
            R.id.btn_set_anim,
            R.id.btn_animator,
            R.id.btn_animator_rotation,
            R.id.btn_animator_translationx,
            R.id.btn_animator_scaley,
            R.id.btn_animatorset,
            R.id.btn_animator_xml
    })
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
            case R.id.btn_animator:
                statrAlphaObjectAnim();
                break;
            case R.id.btn_animator_rotation:
                statrRotationObjectAnim();
                break;
            case R.id.btn_animator_translationx:
                statrTranslationXObjectAnim();
                break;
            case R.id.btn_animator_scaley:
                statrScaleYObjectAnim();
                break;
            case R.id.btn_animatorset:
                statrAnimatorSet();
                break;
            case R.id.btn_animator_xml:
                startAnimatorSetXml();
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

    /****
     * ------------------------------ ObjectAnimator ----------------------------------------
     */
    private void statrAlphaObjectAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(btn_animator, "alpha", 1f, 0f, 1f);
        animator.setDuration(5000);
        animator.start();
    }

    private void statrRotationObjectAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(btn_animator_rotation, "rotation", 0f, 360f);
        animator.setDuration(5000);
        animator.start();
    }

    private void statrTranslationXObjectAnim() {
        float curTranslationX = btn_animator_translationx.getTranslationX();
        ObjectAnimator animator = ObjectAnimator.ofFloat(btn_animator_translationx, "translationX", curTranslationX, -500f, curTranslationX);
        animator.setDuration(5000);
        animator.start();
    }

    private void statrScaleYObjectAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(btn_animator_scaley, "scaleY", 1f, 3f, 1f);
        animator.setDuration(5000);
        animator.start();
    }

    private void statrAnimatorSet() {
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(btn_animatorset, "translationX", -500f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(btn_animatorset, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(btn_animatorset, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).after(moveIn);
        animSet.setDuration(5000);
        animSet.start();
    }

    private void startAnimatorSetXml() {
        /**
         * 如果想要使用XML来编写动画，首先要在res目录下面新建一个animator文件夹，所有属性动画的XML文件都应该存放在这个文件夹当中。然后在XML文件中我们一共可以使用如下三种标签：
         <animator>  对应代码中的ValueAnimator
         <objectAnimator>  对应代码中的ObjectAnimator
         <set>  对应代码中的AnimatorSet
         */
        int animatorxml = R.animator.anim_set_objectanimator;
        Animator animator = AnimatorInflater.loadAnimator(this, animatorxml);
        animator.setTarget(btn_animator_xml);
        animator.start();
    }
}
