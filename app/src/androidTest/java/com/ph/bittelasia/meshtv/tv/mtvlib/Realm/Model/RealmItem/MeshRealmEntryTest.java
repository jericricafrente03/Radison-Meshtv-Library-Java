package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RealmItem;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmItemManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mars on 1/2/18.
 */
public class MeshRealmEntryTest
{
    @Test
    public void channelConstructor()
    {
        MeshChannel channel = new MeshChannel();
        channel.setId(1);
        channel.setChannel_title("ABS-CBN");
        channel.setChannel_description("Showtime");
        channel.setChannel_category_id(2);
        channel.setChannel_uri("uri");
        channel.setChannel_image("image");

        MeshRealmEntry entry = new MeshRealmEntry(channel);
        assertEquals(channel.getClass().getSimpleName(),entry.getmClass().getSimpleName());
        assertEquals(6,entry.getFields().size());

        MeshRealmItemManager.sortAscending(entry.getFields());
        assertEquals(0,entry.getFields().get(0).getOrder());
        assertEquals(1,entry.getFields().get(1).getOrder());
        assertEquals(2,entry.getFields().get(2).getOrder());
        assertEquals(3,entry.getFields().get(3).getOrder());
        assertEquals(4,entry.getFields().get(4).getOrder());
        assertEquals(5,entry.getFields().get(5).getOrder());

        MeshRealmItemManager.sortDescending(entry.getFields());
        assertEquals(0,entry.getFields().get(5).getOrder());
        assertEquals(1,entry.getFields().get(4).getOrder());
        assertEquals(2,entry.getFields().get(3).getOrder());
        assertEquals(3,entry.getFields().get(2).getOrder());
        assertEquals(4,entry.getFields().get(1).getOrder());
        assertEquals(5,entry.getFields().get(0).getOrder());

        assertEquals(1,entry.getFields().get(5).getValue());
        assertEquals("ABS-CBN",entry.getFields().get(4).getValue());
        assertEquals("Showtime",entry.getFields().get(3).getValue());
        assertEquals(2,entry.getFields().get(2).getValue());
        assertEquals("image",entry.getFields().get(1).getValue());
        assertEquals("uri",entry.getFields().get(0).getValue());

        MeshRealmItemManager.sortAscending(entry.getFields());
        assertEquals(0,entry.getFields().get(0).getOrder());
        assertEquals(1,entry.getFields().get(1).getOrder());
        assertEquals(2,entry.getFields().get(2).getOrder());
        assertEquals(3,entry.getFields().get(3).getOrder());
        assertEquals(4,entry.getFields().get(4).getOrder());
        assertEquals(5,entry.getFields().get(5).getOrder());

        assertEquals(1,entry.getFields().get(0).getValue());
        assertEquals("ABS-CBN",entry.getFields().get(1).getValue());
        assertEquals("Showtime",entry.getFields().get(2).getValue());
        assertEquals(2,entry.getFields().get(3).getValue());
        assertEquals("image",entry.getFields().get(4).getValue());
        assertEquals("uri",entry.getFields().get(5).getValue());

        assertEquals("ID:",entry.getFields().get(0).getDisplayName());
        assertEquals("Channel:",entry.getFields().get(1).getDisplayName());
        assertEquals("Description:",entry.getFields().get(2).getDisplayName());
        assertEquals("Category:",entry.getFields().get(3).getDisplayName());
        assertEquals("Logo:",entry.getFields().get(4).getDisplayName());
        assertEquals("Channel URI:",entry.getFields().get(5).getDisplayName());

        assertEquals("This must not be empty",entry.getFields().get(0).getHint());
        assertEquals("Name of Channel",entry.getFields().get(1).getHint());
        assertEquals("Short Channel Description",entry.getFields().get(2).getHint());
        assertEquals("Choose One",entry.getFields().get(3).getHint());
        assertEquals("Provide Logo URL",entry.getFields().get(4).getHint());
        assertEquals("Provide URI of Channel Source",entry.getFields().get(5).getHint());

        assertEquals(MeshChannel.TAG_ID,entry.getFields().get(0).getTag());
        assertEquals(MeshChannel.TAG_TITLE,entry.getFields().get(1).getTag());
        assertEquals(MeshChannel.TAG_DESCRIPTION,entry.getFields().get(2).getTag());
        assertEquals(MeshChannel.TAG_CATEGORY_ID,entry.getFields().get(3).getTag());
        assertEquals(MeshChannel.TAG_IMAGE_URL,entry.getFields().get(4).getTag());
        assertEquals(MeshChannel.TAG_URI,entry.getFields().get(5).getTag());


    }

}