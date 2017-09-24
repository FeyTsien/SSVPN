package com.tsien.ssvpn.ui.fragment.configuration;

import android.app.Activity;
import android.os.Handler;

import com.tsien.ssvpn.ui.widget.fabbutton.FabButton;

/**
 * Created by kurt on 08 06 2015 .
 */
public class ProgressHelper {

    private int currentProgress = 0;
    private Handler handle=new Handler();
    private final FabButton button;
    private final Activity activity;

    public ProgressHelper(FabButton button, Activity activity) {
        this.button = button;
        this.activity = activity;
    }

    private Runnable getRunnable(final Activity activity){
        return new Runnable() {
            @Override
            public void run() {
                currentProgress += 1;
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button.setProgress(currentProgress);
                        if(currentProgress <= 100){
                            handle.postDelayed(getRunnable(activity),50);
                        }
                    }
                });
            }
        };
    }

    public void startIndeterminate() {
        button.showProgress(true);
    }

    public void stopIndeterminate() {
        button.setIndeterminate(false);
        button.setProgress(100);
    }

    public void startDeterminate() {
        button.resetIcon();
        button.showShadow(false);
        currentProgress = 0;
        button.showProgress(true);
        button.setProgress(currentProgress);
        getRunnable(activity).run();
    }


}
