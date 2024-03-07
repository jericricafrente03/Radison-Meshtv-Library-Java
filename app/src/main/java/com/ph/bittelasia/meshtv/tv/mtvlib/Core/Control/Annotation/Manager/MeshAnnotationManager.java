package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Manager;

import android.app.Activity;
import android.os.Handler;


import androidx.fragment.app.FragmentManager;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Init;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Terminate;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Activity.AttachFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Widget.BindWidget;

import java.lang.reflect.Method;
import java.util.ArrayList;


/**
 * Manages annotations within the App
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshAnnotationManager
{
    //===============================================Variable=======================================
    //-----------------------------------------------Constant---------------------------------------
    public static final String TAG = "Mars-"+MeshAnnotationManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //================================================Method========================================
    //------------------------------------------------Method----------------------------------------
    /**
     * Invokes all methods from a list
     * @param ms Methods to invoke
     * @param o
     */
    public synchronized static void runMethods(ArrayList<Method> ms,Object o)
    {
        for(Method m:ms)
        {
            BittelAnnotationManager.runMethod(m,o);
        }

    }
    /**
     * Invokes a method
     * @param m Method to invoke
     * @param o
     */
    public synchronized static void runMethod(Method m, Object o)
    {
        BittelAnnotationManager.runMethod(m,o);
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------Init-----------------------------------------
    /**
     * Retrieves all methods annotated with {@link Init Init}
     * @param c Class to find {@link Init Init} annotated methods
     * @return ArrayList of {@link Init Init} annotated methods
     */
    public static ArrayList<Method> getInit(Class c)
    {
        return BittelAnnotationManager.getInitMethods(c);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Terminate--------------------------------------
    /**
     * Retrieves all methods annotated with {@link Terminate Terminate}
     * @param c Class to find {@link Terminate Terminate} annotated methods
     * @return ArrayList of {@link Terminate Terminate} annotated methods
     */
    public static ArrayList<Method> getTerminate(Class c)
    {
        return BittelAnnotationManager.getTerminateMethods(c);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Timed-----------------------------------------
    /**
     * Retrieves all methods annotated with {@link TimedMethod TimedMethod}
     * @param c Class to find {@link TimedMethod TimedMethod} annotated methods
     * @return ArrayList of {@link TimedMethod TimedMethod} annotated methods
     */
    public static ArrayList<Method> getTimed(Class c)
    {
        return BittelAnnotationManager.getTimedMethods(c);
    }
    /**
     * Start all timed methods
     * @param h Handler to run the method
     * @param ms List of Methods to run
     * @param o
     */
    public synchronized static void startTimedMethods(ArrayList<Method> ms, Handler h, Object o)
    {
        for(Method m:ms)
        {
            BittelAnnotationManager.startTimedMethod(h,m,o);
        }
    }
    /**
     * Start all timed methods
     * @param h Handler to run the method
     * @param m Method to run
     * @param o
     */
    public synchronized static void startTimedMethod(Method m, Handler h,Object o)
    {
        BittelAnnotationManager.startTimedMethod(h,m,o);
    }
    /**
     * Stop all timed methods
     * @param h Handler that contains the timed methods
     */
    public synchronized static void stopTimedMethods(Handler h)
    {
        BittelAnnotationManager.stopTimedMethod(h);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Fragment---------------------------------------
    /**
     * Retrieves all methods annotated with {@link AttachFragment AttachFragment}
     * @param c Class to find {@link AttachFragment AttachFragment} annotated methods
     * @return ArrayList of {@link AttachFragment AttachFragment} annotated methods
     */
    public static ArrayList<Method> getFragment(Class c)
    {
        return BittelAnnotationManager.getFragmentMethods(c);
    }
    /**
     * Attach fragments
     * @param fm {@link FragmentManager FragmentManager} from the {@link Activity Activity}
     * @param ms List of Methods annotated with {@link AttachFragment AttachFragment}
     * @param o
     */
    public synchronized static void attachFragments(ArrayList<Method> ms, FragmentManager fm, Object o)
    {
        for(Method m:ms)
        {
            BittelAnnotationManager.attachFragment(fm,m,o);
        }

    }
    /**
     * Attach a fragment
     * @param fm {@link FragmentManager FragmentManager} from the {@link Activity Activity}
     * @param m
     * @param o
     */
    public synchronized static void attachFragment(Method m, FragmentManager fm, Object o)
    {
        BittelAnnotationManager.attachFragment(fm,m,o);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Widget-----------------------------------------
    /**
     * Retrieves all Fields annotated with {@link BindWidget BindWidget} and establishes reference to a view using the resource id from {@link BindWidget BindWidget}'s
     * {@link BindWidget#value()}  value()} method
     * @param o Object to put reference to
     */
    public synchronized static void bindWidgets(Object o)
    {
        BittelAnnotationManager.bindWidget(o);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

}
