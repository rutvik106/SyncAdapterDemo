package io.fusionbit.syncadapterdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by rutvik on 12/30/2016 at 8:58 PM.
 */

public class SyncService extends Service
{

    private static SyncAdapter mSyncAdapter = null;

    private static final Object mSyncAdapterLock = new Object();

    @Override
    public void onCreate()
    {
        synchronized (mSyncAdapterLock)
        {
            if (mSyncAdapter == null)
            {
                mSyncAdapter = new SyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return mSyncAdapter.getSyncAdapterBinder();
    }
}
