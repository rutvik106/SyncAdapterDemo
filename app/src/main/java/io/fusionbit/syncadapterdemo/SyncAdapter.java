package io.fusionbit.syncadapterdemo;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;

/**
 * Created by rutvik on 12/30/2016 at 8:46 PM.
 */

public class SyncAdapter extends AbstractThreadedSyncAdapter
{

    ContentResolver mContentResolver;

    public SyncAdapter(Context context, boolean autoInitialize)
    {
        super(context, autoInitialize);
        mContentResolver = context.getContentResolver();
    }

    public SyncAdapter(Context context, boolean autoInitialize, boolean allowParallelSyncs)
    {
        super(context, autoInitialize, allowParallelSyncs);
        this.mContentResolver = context.getContentResolver();
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority,
                              ContentProviderClient provider, SyncResult syncResult)
    {



    }
}
