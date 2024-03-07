package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;

/**
 * Handles Data Migration when Realm Objects are edited
 * @version 1.0
 * @author Mars Ray Canizares Araullo
 */
public class BittelMigration implements RealmMigration
{
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion)
    {

    }
}
