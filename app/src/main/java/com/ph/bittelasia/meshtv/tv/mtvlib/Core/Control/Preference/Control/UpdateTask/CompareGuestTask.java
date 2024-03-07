package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.UpdateTask;

import android.os.AsyncTask;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshGuest;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
/**
 * Asynchronously compares a {@link MeshGuest MeshGuest} with the data from
 * {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.GuestPreference GuestPreference}
 * <br>Triggers:
 * <br>1. {@link MeshGuest#update()}  MeshGuest.update()} on any discrepancy found
 * <br>2. {@link MeshTVApp#checkInGuest(MeshGuest)  MeshTVApp.checkInGuest(MeshGuest)}
 * <br>3. {@link MeshTVApp#updateGuest(MeshGuest) MeshTVApp.updateGuest(MeshGuest)}
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class CompareGuestTask extends AsyncTask<Void,Void,Integer>
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    private static final String TAG          =   "Mars-"+CompareGuestTask.class.getSimpleName();
    private static final int CHECKIN         =   1;
    private static final int UPDATE          =   2;
    private static final int NO_CHANGE       =   0;
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    /**
     * New {@link MeshGuest MeshGuest} to be compared
     */
    MeshGuest guest = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Constructor========================================
    /**
     * Requires an instance of {@link MeshGuest MeshGuest} from the datasource to compare with {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.GuestPreference GuestPreference} data
     * @param guest {@link MeshGuest MeshGuest} to be compared
     */
    public CompareGuestTask(MeshGuest guest)
    {
        this.guest = guest;
    }
    //==============================================================================================
    //============================================LifeCycle=========================================
    @Override
    protected final void onPreExecute()
    {
        super.onPreExecute();

    }
    @Override
    protected final Integer doInBackground(Void... voids)
    {
        if(!(guest.getFirstname()+guest.getLastname()).equals(MeshTVPreferenceManager.getGuestFirstName(null)+MeshTVPreferenceManager.getGuestLastName(null)))
        {
            guest.update();
            return CHECKIN;
        }
        else
        {
            if (!guest.getAddress().equals(MeshTVPreferenceManager.getGuestAddress(null)))
            {
                guest.update();
                return UPDATE;
            }
            if(!guest.getBirthDate().equals(MeshTVPreferenceManager.getGuestBirthDate(null)))
            {
                guest.update();
                return UPDATE;
            }
            if(!guest.getCity().equals(MeshTVPreferenceManager.getGuestCity(null)))
            {
                guest.update();
                return UPDATE;
            }
            if(!guest.getCountry().equals(MeshTVPreferenceManager.getGuestCountry(null)))
            {
                guest.update();
                return UPDATE;
            }
            if(!guest.getEmail().equals(MeshTVPreferenceManager.getGuestEmail(null)))
            {
                guest.update();
                return UPDATE;
            }
            if(!guest.getMobile().equals(MeshTVPreferenceManager.getGuestMobile(null)))
            {
                guest.update();
                return UPDATE;
            }
            if(!guest.getLandline().equals(MeshTVPreferenceManager.getGuestLandline(null)))
            {
                guest.update();
                return UPDATE;
            }

        }
        return NO_CHANGE;
    }
    @Override
    protected final void onPostExecute(Integer i)
    {
        super.onPostExecute(i);
        if(MeshTVApp.get()!=null)
        {
            switch (i)
            {
                case UPDATE:
                    MeshTVApp.get().updateGuest(guest);
                    break;
                case CHECKIN:
                    MeshTVApp.get().checkInGuest(guest);
                    break;
            }
        }

    }
    //==============================================================================================
}
