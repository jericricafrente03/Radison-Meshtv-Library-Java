package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.VH;

import android.view.View;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Manager.MeshAnnotationManager;

/**
 * Used by {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter MeshTVAdapter}
 * to reference views and widgets for each row.
 * <br>This supports {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Widget.BindWidget BindWidget} Annotation
 * @param <T> Object that is to be displayed. Must match the Object displayed by the {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter MeshTVAdapter}, omitting this will use a generic Object
 */
abstract class BittelViewHolder<T>
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    public static final String TAG = BittelViewHolder.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Instance-------------------------------------------
    /**
     * Object being displayed
     */
    T object;
    /**
     * Reference to the view that displayes {@link #object object}
     */
    View v;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Method============================================
    //---------------------------------------------View---------------------------------------------

    /**
     * Creates a reference to the {@link View View} and binds widgets
     * <br>Triggers abstract method {@link #initViews(View) initViews(View)} for sub-classes
     * @param v View to be implemented
     */
    public void inflate(View v)
    {
        this.v = v;
        MeshAnnotationManager.bindWidgets(this);
        initViews(v);
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Getter--------------------------------------------

    /**
     * Gets the value of {@link #object object}
     * @return returns the value of {@link #object object}
     */
    public T getObject() {
        return object;
    }

    /**
     * Gets the value of {@link #v v}
     * @return returns the value of {@link #v v}
     */
    public View getV() {
        return v;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Setter--------------------------------------------

    /**
     * Sets the object to be displayed
     * @param object object displayed
     */
    public void setObject(T object) {
        this.object = object;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Abstract==========================================

    /**
     * Method Triggered when view has been inflated and the widgets are binded
     * @param v reference of the view mainly used for widgets not supported by {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Widget.BindWidget BindWidget}
     */
    public abstract void initViews(View v);
    //==============================================================================================
}
