package com.enviroment.unomerintegration;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.unomer.sdk.Unomer;
import com.unomer.sdk.UnomerListener;

public class UnomerSurvey {
    private Unomer mSurvey;
    private UnomerListener uListener;
    public static UnomerSurvey mUnomer;
    public static String TAG="UnomerSurvey";
    String pubID="",appID="";

    private Activity act;

    public static UnomerSurvey getInstace(){
        if(mUnomer == null){
            mUnomer=new UnomerSurvey();
        }
        return mUnomer;
    }

    public void initUnomer(final Context activity) {
        pubID   =   "fzwT6LXmQBgzHH9+qJP1dA==";
        appID   =   "CSAtYF4ep8zQEjmKiNOh1MuWG2DbXg";
        uListener=new UnomerListener() {
            @Override
            public void unomerSurveyFetchStarted(String s) {
                Log.d(TAG,"unomerSurveyFetchStarted : " + s);
                Toast.makeText(activity, "Loading", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void unomerSurveyFetchSuccess(String s) {
                Log.d(TAG,"unomerSurveyFetchSuccess : " + s);
                if(mSurvey != null && act !=null)
                mSurvey.showSurvey(act,uListener);
            }

            @Override
            public void unomerSurveyFetchFailed(String s, String s1) {
                Log.d(TAG,"unomerSurveyFetchFailed : " + s);
                Toast.makeText(activity, "Loading", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void unomerSurveyDisplayed(String s) {
                Log.d(TAG,"unomerSurveyDisplayed : " + s);
            }

            @Override
            public void unomerSurveyClosed(String s) {
                Log.d(TAG,"unomerSurveyClosed : " + s);
            }

            @Override
            public void unomerUploadComplete(int mReward, String s, String s1, boolean b, String s2) {
                Log.d(TAG,"unomerUploadComplete : " + s + " reward : " + mReward);

            }

            @Override
            public void unomerSurveySubmittedForUpload(int i, String s, String s1, boolean b, String s2) {
                Log.d(TAG,"unomerSurveySubmittedForUpload : " + s);
            }

            @Override
            public void unomerSurveyConfirmationDeclined(String s) {
                Log.d(TAG,"unomerSurveyConfirmationDeclined : " + s);
            }

            @Override
            public void unomerUploadFailed(String s) {
                Log.d(TAG,"unomerUploadFailed : " + s);
            }

            @Override
            public void unomerUserDisqualified(int i, String s, String s1, boolean b, String s2) {
                Log.d(TAG,"unomerUserDisqualified : " + s);
            }

            @Override
            public void unomerClosed(String s) {
                Log.d(TAG,"unomerClosed : " + s);
            }
        };
        mSurvey = new Unomer(activity,  pubID, appID, uListener);
    }

    public void showSurvey(Activity activity){
        act=activity;
        if(mSurvey!=null) {
            if (mSurvey.isSurveyReady("Default")) {
                mSurvey.showSurvey(activity, uListener);
            } else {
                fetchSurvey(activity);
            }
        }
    }

    public void fetchSurvey(Activity activity){
        String jsonParam="";
        if(mSurvey!=null) {
            mSurvey.fetchSurvey(activity.getApplication(), uListener, jsonParam);
        }
    }

    public void destroySurvey(){
        if(mSurvey != null) {
            Log.d(TAG, "destroySurvey");
            mSurvey.destroy();
        }
    }


}

