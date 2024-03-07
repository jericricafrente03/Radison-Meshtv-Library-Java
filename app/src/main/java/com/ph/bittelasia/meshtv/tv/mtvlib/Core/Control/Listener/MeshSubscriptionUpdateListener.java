package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener;

public interface MeshSubscriptionUpdateListener
{
   public abstract void subscriptionReset();
   public abstract void subscriptionUpdated();
   public abstract void subscriptionEmpty();
}
