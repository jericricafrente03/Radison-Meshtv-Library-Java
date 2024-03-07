package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Reads a raw file from a the raw folder using its resource ID
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshRawReader
{
    /**
     * Reads the raw resource using its resource ID
     * @param resourceID Resource ID of the raw file
     * @return contents of the Raw file
     */
    public static final String read(int resourceID)
    {
        String resultFromRaw = "";
        try
        {
            if(resourceID!=0)
            {
                InputStream inputStream = MeshTVApp.get().getResources().openRawResource(resourceID);
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String newLine="";
                do
                {

                    resultFromRaw=resultFromRaw+newLine;
                    newLine = br.readLine();
                }while (newLine!=null);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return resultFromRaw;
    }
}
