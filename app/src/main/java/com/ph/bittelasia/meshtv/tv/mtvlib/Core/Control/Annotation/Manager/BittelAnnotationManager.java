package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Manager;

import android.app.Activity;
import android.os.Handler;

import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Init;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Terminate;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Activity.AttachFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Widget.BindWidget;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Comparators.Comparators;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.TimeMethod.MeshTimedMethod;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.VH.MeshTVVHolder;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.CustomScrollingTextView.MeshTVScrollingTextView;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.MeshTVCustomList.MeshTVCustomListView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Manages annotations within the App
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
class BittelAnnotationManager
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    static final String TAG = "Mars-"+BittelAnnotationManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Instance---------------------------------------
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Method=========================================
    //-----------------------------------------------Method-----------------------------------------

    /**
     * Invokes a method
     * @param m Method to invoke
     * @param o
     */
    final static synchronized void  runMethod(Method m,Object o)
    {
        try
        {
            m.invoke(o);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Init------------------------------------------

    /**
     * Retrieves all methods annotated with {@link Init Init}
     * @param c Class to find {@link Init Init} annotated methods
     * @return ArrayList of {@link Init Init} annotated methods
     */
    final static synchronized ArrayList<Method> getInitMethods(Class c)
    {
        Log.i(TAG,"getInitMethods()");
        ArrayList<Method> methods = new ArrayList<>();
        for(Method m:c.getMethods())
        {
            if(m.getAnnotation(Init.class)!=null)
            {

                methods.add(m);
            }
        }
        Collections.sort(methods, Comparators.INIT_COMPARATOR);
        Log.i(TAG,"getInitMethods() - :"+methods.size());
        return methods;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Terminate-----------------------------------------
    /**
     * Retrieves all methods annotated with {@link Terminate Terminate}
     * @param c Class to find {@link Terminate Terminate} annotated methods
     * @return ArrayList of {@link Terminate Terminate} annotated methods
     */
    final static synchronized ArrayList<Method> getTerminateMethods(Class c)
    {
        Log.i(TAG,"getTerminateMethods()");
        ArrayList<Method> methods = new ArrayList<>();
        for(Method m:c.getMethods())
        {
            if(m.getAnnotation(Terminate.class)!=null)
            {

                methods.add(m);
            }
        }
        Collections.sort(methods, Comparators.TERMINATE_COMPARATOR);
        Log.i(TAG,"getTerminateMethods() - :"+methods.size());
        return methods;
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Timed-------------------------------------------
    /**
     * Retrieves all methods annotated with {@link TimedMethod TimedMethod}
     * @param c Class to find {@link TimedMethod TimedMethod} annotated methods
     * @return ArrayList of {@link TimedMethod TimedMethod} annotated methods
     */
    final static synchronized ArrayList<Method> getTimedMethods(Class c)
    {
        Log.i(TAG,"getTimedMethods()");
        ArrayList<Method> methods = new ArrayList<>();
        for(Method m:c.getMethods())
        {
            if(m.getAnnotation(TimedMethod.class)!=null)
            {

                methods.add(m);
            }
        }
        Log.i(TAG,"getTimedMethods() - :"+methods.size());
        return methods;
    }

    /**
     * Start all timed methods
     * @param h Handler to run the method
     * @param m Method to run
     * @param o
     */
    final static synchronized void startTimedMethod(final Handler h, final Method m, final Object o)
    {
        final TimedMethod mt = m.getAnnotation(TimedMethod.class);
        Runnable r = new Runnable() {
            @Override
            public void run()
            {
                try
                {
                    runMethod(m,o);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                h.postDelayed(this,mt.delay());
            }
        };

        if(mt.launchFirstImmediately())
        {
            h.post(r);
        }
        else
        {
            h.postDelayed(r,mt.delay());
        }

    }

    /**
     * Stop all timed methods
     * @param h Handler that contains the timed methods
     */
    final static synchronized void stopTimedMethod(Handler h)
    {
        h.removeCallbacksAndMessages(null);
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Fragment------------------------------------------

    /**
     * Retrieves all methods annotated with {@link AttachFragment AttachFragment}
     * @param c Class to find {@link AttachFragment AttachFragment} annotated methods
     * @return ArrayList of {@link AttachFragment AttachFragment} annotated methods
     */
    final static synchronized ArrayList<Method> getFragmentMethods(Class c)
    {
        Log.i(TAG,"getFragmentMethods()");
        ArrayList<Method> methods = new ArrayList<>();
        for(Method m:c.getMethods())
        {
            if(m.getAnnotation(AttachFragment.class)!=null)
            {

                methods.add(m);
            }
        }
        Collections.sort(methods, Comparators.ATTACH_FRAGMENT_COMPARATOR);
        Log.i(TAG,"getFragmentMethods() - :"+methods.size());
        return methods;

    }

    /**
     * Attach fragments
     * @param fm {@link FragmentManager FragmentManager} from the {@link Activity Activity}
     * @param m
     * @param o
     */
    final static synchronized void attachFragment(FragmentManager fm, Method m, Object o)
    {
        try
        {
            Fragment f = (Fragment) m.invoke(o);
            AttachFragment a = m.getAnnotation(AttachFragment.class);
            Log.i(TAG,"attachFragment() - :"+a.tag());
            Fragment prev = fm.findFragmentById(a.container());
            if(prev!=null)
            {
                fm.beginTransaction().remove(prev).commit();
            }
            fm.beginTransaction().add(a.container(),f,a.tag()).commit();

        }
        catch (Exception e)
        {

        }
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Widget------------------------------------------
    /**
     * Retrieves all Fields annotated with {@link BindWidget BindWidget} and establishes reference to a view using the resource id from {@link BindWidget BindWidget}'s
     * {@link BindWidget#value()}  value()} method
     * @param o Object to put reference to
     */
    final static synchronized void bindWidget(Object o)
    {
        Class c = o.getClass();
        View v = null;
        if(o instanceof Activity)
        {
            Activity a = (Activity) o;
            v = a.findViewById(android.R.id.content);
        }
        else  if (o instanceof Fragment)
        {
            Fragment fragment = (Fragment) o;
            v  = fragment.getView();

        }
        else if(o instanceof MeshTVVHolder)
        {
            v  = ((MeshTVVHolder) o).getViewHolderView();

        }

        if(v == null)
        {
            Log.i(TAG,"Cannot Bind Undefined Object");
        }
        else
        {
            for(Field f:c.getFields())
            {

                try
                {
                    BindWidget rw = f.getAnnotation(BindWidget.class);
                    if(rw!=null)
                    {

                        if(f.getType()==EditText.class)
                        {
                            f.set(o,(EditText)v.findViewById(rw.value()));
                        }
                        else if (f.getType()== MeshTVScrollingTextView.class)
                        {
                            f.set(o,(MeshTVScrollingTextView)v.findViewById(rw.value()));
                        }
                        else if(f.getType()==TextView.class)
                        {
                            f.set(o,(TextView)v.findViewById(rw.value()));
                        }
                        else if(f.getType()== Button.class)
                        {
                            f.set(o,(Button)v.findViewById(rw.value()));
                        }
                        else if(f.getType()== ImageButton.class)
                        {
                            f.set(o,(ImageButton)v.findViewById(rw.value()));
                        }
                        else if(f.getType()== ImageView.class)
                        {
                            f.set(o,(ImageView)v.findViewById(rw.value()));
                        }
                        else if(f.getType()== ListView.class)
                        {
                            f.set(o,(ListView)v.findViewById(rw.value()));
                        }
                        else if(f.getType()== GridView.class)
                        {
                            f.set(o,(GridView)v.findViewById(rw.value()));
                        }
                        else if(f.getType()== LinearLayout.class)
                        {
                            f.set(o,(LinearLayout)v.findViewById(rw.value()));
                        }
                        else if(f.getType()== RelativeLayout.class)
                        {
                            f.set(o,(RelativeLayout)v.findViewById(rw.value()));
                        }
                        else if(f.getType()== ConstraintLayout.class)
                        {
                            f.set(o,(ConstraintLayout)v.findViewById(rw.value()));
                        }
                        else if(f.getType()== MeshTVCustomListView.class)
                        {
                            f.set(o,(MeshTVCustomListView)v.findViewById(rw.value()));
                        }
                        else if(f.getType()== TextClock.class)
                        {
                            f.set(o,(TextClock)v.findViewById(rw.value()));
                        }
                        else if(f.getType()== AutoCompleteTextView.class)
                        {
                            f.set(o,(AutoCompleteTextView)v.findViewById(rw.value()));
                        }
                        else if(f.getType()== DatePicker.class)
                        {
                            f.set(o,(DatePicker)v.findViewById(rw.value()));
                        }
//                        else if(f.getType()== SimpleExoPlayerView.class)
//                        {
//                            f.set(o,(SimpleExoPlayerView)v.findViewById(rw.value()));
//                        }
                        else if(f.getType()== ViewSwitcher.class)
                        {
                            f.set(o,(ViewSwitcher)v.findViewById(rw.value()));
                        }
                        else if(f.getType()== ViewPager.class)
                        {
                            f.set(o,(ViewPager)v.findViewById(rw.value()));
                        }
                        else
                        {
                            f.set(o,v.findViewById(rw.value()));
                        }


                    }
                    else
                    {
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

        }


    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
