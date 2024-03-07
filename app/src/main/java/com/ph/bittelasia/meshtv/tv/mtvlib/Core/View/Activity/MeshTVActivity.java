package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Activity;

import android.view.KeyEvent;
import android.widget.Toast;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshTVFragmentListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory;

/**
 * <br>
 * Required superclass of all Activity Instances of MeshTVApps
 * <br>Requires:
 * <br>{@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.Layout Layout} Annotation
 * <br>{@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Activity.ActivitySetting ActivitySetting} Annotation
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshTVActivity extends BittelActivity
{


    public boolean quickTuneTrigger(KeyEvent event)
    {

       return quickTune(event);
    }
    @Override
    public void quickTuneDisplay(int i) {

    }

    public void onStartRegister()
    {

    }

    @Override
    void onShoulRegister() {
        onStartRegister();
    }
}
