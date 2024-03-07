package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Settings.AppSettings;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Settings.RealmEditorSettings;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Constant.AppDataSource;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;


/**
 * Test App for Unit Tests
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
@AppSettings(dataSource = AppDataSource.FILE_SYSTEM)
@RealmEditorSettings()
public class MeshTVTestApp extends MeshTVApp
{

    @Override
    public String getDB() {
        return MeshTVTestApp.class.getSimpleName();
    }

    @Override
    public void notify(MeshMessage meshMessage)
    {

    }
}
