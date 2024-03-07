package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Dialog;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Manager.MeshAnnotationManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.Layout;

/**
 * Base class for all {@link MeshTVDialogFragment MeshTVDialogFragment}
 * <br>
 * <br>Requires:
 * <br>1. {@link Layout Layout} for layout
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
abstract class BittelDialogFragment extends DialogFragment
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    static final String TAG = BittelDialogFragment.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    /**
     * {@link Layout Layout} to be inflated by the {@link MeshTVDialogFragment MeshTVDialogFragment}
     */
    Layout layout = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================LifeCycle=======================================

    /**
     * Inflate the view
     * <br>
     * <br>Tasks:
     * <br> gets reference for the {@link Layout Layout} and throws an exception if it cannot
     * @param inflater Inflates the view
     * @param container
     * @param savedInstanceState
     * @return inflated view
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = null;
        layout = getClass().getAnnotation(Layout.class);
        if(layout==null)
        {
            throw new RuntimeException("MeshTVDialogFragment requires Layout Annotation");
        }

        v = inflater.inflate(layout.value(),container,false);

        return v;
    }

    /**
     * Event triggered when the view is created
     * <br>
     * <br>Task:
     * <br>1. Binds Widgets with {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Widget.BindWidget BindWidget} annotation
     * <br>2. Allow to reference other views using {@link #referenceViews() referenceViews()}
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MeshAnnotationManager.bindWidgets(this);
        referenceViews();
    }

    //==============================================================================================
    //===============================================Abstract=======================================

    /**
     * Abstract method to reference views not included in {@link MeshAnnotationManager#bindWidgets(Object) MeshAnnotationManager.bindWidgets(Object)}
     */
    public abstract void referenceViews();
    //==============================================================================================
}
