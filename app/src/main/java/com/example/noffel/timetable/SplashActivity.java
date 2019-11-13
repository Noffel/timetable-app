package com.example.noffel.timetable;

import android.content.Intent;
import android.widget.LinearLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashActivity extends AwesomeSplash {

    LinearLayout view ;
    @Override
    public void initSplash(ConfigSplash configSplash) {
        setContentView(R.layout.activity_splash);
        /* you don't have to override every property */
        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.lightIndigio); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(1000); //int ms
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        configSplash.setLogoSplash(R.mipmap.ic_launcher_3); //or any other drawable
        configSplash.setAnimLogoSplashDuration(1500); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeIn); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)

        configSplash.setTitleSplash("FASTer");
        configSplash.setTitleTextColor(R.color.darkIndigo);
        configSplash.setTitleTextSize(80f); //float value
        configSplash.setAnimTitleDuration(1850);
        configSplash.setAnimTitleTechnique(Techniques.ZoomIn);
        //configSplash.setTitleFont("fonts/myfont.ttf"); //provide string to your font located in assets/fonts/
    }

    @Override
    public void animationsFinished() {
        finish();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
