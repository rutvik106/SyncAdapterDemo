package io.fusionbit.syncadapterdemo;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ActivityInitial extends AppCompatActivity
{

    private static final String TAG = "SYNC " + ActivityInitial.class.getSimpleName();

    public static final String AUTHORITY = "io.fusionbit.syncadapterdemo.provider";

    public static final String ACCOUNT_TYPE = "io.fusionbit.myacc";

    public static final String ACCOUNT = "dummyaccount";

    Account mAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);


        mAccount = CreateSyncAccount(this);

    }


    public static Account CreateSyncAccount(Context context)
    {
        // Create the account type and default account
        Account newAccount = new Account(
                ACCOUNT, ACCOUNT_TYPE);
        // Get an instance of the Android account manager
        AccountManager accountManager =
                (AccountManager) context.getSystemService(
                        ACCOUNT_SERVICE);
        /*
         * Add the account and account type, no password or user data
         * If successful, return the Account object, otherwise report an error.
         */
        if (accountManager.addAccountExplicitly(newAccount, null, null))
        {
            Log.i(TAG, "inside IF");
            /*
             * If you don't set android:syncable="true" in
             * in your <provider> element in the manifest,
             * then call context.setIsSyncable(account, AUTHORITY, 1)
             * here.
             */
        } else
        {
            Log.i(TAG, "inside ELSE");
            /*
             * The account exists or some other error occurred. Log this, report it,
             * or handle it internally.
             */
        }

        return newAccount;
    }


}
