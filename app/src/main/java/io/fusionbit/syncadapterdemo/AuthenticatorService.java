package io.fusionbit.syncadapterdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by rutvik on 12/30/2016 at 8:48 AM.
 */

public class AuthenticatorService extends Service
{

    private Authenticator mAuthenticator;

    @Override
    public void onCreate()
    {
        mAuthenticator = new Authenticator(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return mAuthenticator.getIBinder();
    }
}
