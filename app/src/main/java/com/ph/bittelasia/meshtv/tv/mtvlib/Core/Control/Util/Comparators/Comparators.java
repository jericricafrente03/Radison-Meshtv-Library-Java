package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Comparators;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Init;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Terminate;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Activity.AttachFragment;

import java.lang.reflect.Method;
import java.util.Comparator;

/**
 * A collection of comparators to sort different kinds of objects
 * <br>Supported Objects
 * <br>1. {@link Init Init}
 * <br>2. {@link Terminate Terminate}
 * <br>3. {@link AttachFragment AttachFragment}
 */
public class Comparators
{
    //==========================================Variable============================================
    //------------------------------------------Constant--------------------------------------------
    public static String TAG = Comparators.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Comparators-----------------------------------------
    /**
     * Comparator for {@link Init Init} annotations
     */
    public static Comparator INIT_COMPARATOR = new Comparator<Method>() {

        @Override
        public int compare(Method o1, Method o2)
        {
            return o1.getAnnotation(Init.class).order()>o2.getAnnotation(Init.class).order()?1:-1;
        }
    };
    /**
     * Comparator for {@link Terminate Terminate} annotations
     */
    public static Comparator TERMINATE_COMPARATOR = new Comparator<Method>() {

        @Override
        public int compare(Method o1, Method o2)
        {
            return o1.getAnnotation(Terminate.class).order()>o2.getAnnotation(Terminate.class).order()?1:-1;
        }
    };
    /**
     * Comparator for {@link AttachFragment AttachFragment} annotations
     */
    public static Comparator ATTACH_FRAGMENT_COMPARATOR = new Comparator<Method>() {

        @Override
        public int compare(Method o1, Method o2)
        {
            return o1.getAnnotation(AttachFragment.class).order()>o2.getAnnotation(AttachFragment.class).order()?1:-1;
        }
    };
    //----------------------------------------------------------------------------------------------
    //==============================================================================================


}
