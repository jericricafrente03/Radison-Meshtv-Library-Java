package com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Control;

public interface MeshDigitalSigangeVideoListener
{
    public abstract void onBuffering();
    public abstract void onIdle();
    public abstract void onReady();
    public abstract void onEnd();
}
