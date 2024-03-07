package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.ResourceManager;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;


import com.ph.bittelasia.meshtv.tv.mtvlib.R;

import java.util.HashMap;

/**
 * Singleton that saves reference to drawables for faster display
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshResourceManager
{
    //========================================Variable==============================================
    /**
     * Static instance of the resource manager
     */
    private static MeshResourceManager resourceManager = null;
    public static final String TAG = "MeshResourceManager";
    /**
     * Stores the resource ids of the drawables
     */
    HashMap<String,Integer> map = new HashMap<>();
    //==============================================================================================
    //========================================Constructor===========================================

    /**
     * Default consturctor made private to limit instance
     * <br>Saves reference to weather icon drawables
     */
    private MeshResourceManager()
    {
        map = new HashMap<>();

        map.put("01d.png",R.drawable.w01d);
        map.put("01n.png",R.drawable.w01n);
        map.put("02d.png",R.drawable.w02d);
        map.put("02n.png",R.drawable.w02n);
        map.put("03d.png",R.drawable.w03d);
        map.put("03n.png",R.drawable.w03n);
        map.put("04d.png",R.drawable.w04d);
        map.put("04n.png",R.drawable.w04n);
        map.put("09d.png",R.drawable.w09d);
        map.put("09n.png",R.drawable.w09n);
        map.put("10d.png",R.drawable.w10d);
        map.put("10n.png",R.drawable.w10n);
        map.put("11d.png",R.drawable.w11d);
        map.put("11n.png",R.drawable.w11n);
        map.put("13n.png",R.drawable.w13d);
        map.put("13n.png",R.drawable.w13n);
        map.put("50d.png",R.drawable.w50d);
        map.put("50n.png",R.drawable.w50n);
    }
    //==============================================================================================
    //========================================Getter================================================

    /**
     * Creates a single instance of {@link MeshResourceManager MeshResourceManager}
     * @return
     */
    public static MeshResourceManager get()
    {
        if(resourceManager==null)
        {
            resourceManager = new MeshResourceManager();
        }
        return resourceManager;
    }

    /**
     * Gets the resource ID of the file that corresponds to the last part of the url which is usually the filename
     * @param url url of the image
     * @return resource id that corresponds to url. Returns -1 if no resource id corresponds to the url
     */
    public int getResourceId(String url)
    {
        if(map!=null)
        {
            if(map.containsKey(url))
            {
                return map.get(url);
            }
            else
            {


                String partition[] = url.split("/");
                String end = partition[partition.length-1];
                Log.e(TAG,"Trying:"+end);
                if(map.containsKey(end))
                {
                    return map.get(end);
                }
                else
                {
                    return 0;//not found

                }

            }
        }
        else
        {
            return -1;//map is null
        }
    }
    //==============================================================================================
    //========================================Setter================================================

    /**
     * Adds a resource id to {@link MeshResourceManager MeshResourceManager}
     * @param key key to recognize the drawable id
     * @param id
     */
    public void add(String key, int id)
    {
        if(map!=null)
        {
            map.put(key,id);
        }
        else
        {

        }
    }
    //==============================================================================================
    //========================================Methods===============================================

    /**
     * Request images for Live apps
     * @param context required to retrieve resources
     * @param iv ImageView that will display the image
     * @param url url of the image to be displayed
     */
    public static void displayLiveImageFor(Context context, ImageView iv, String url)
    {
        int drawable = MeshResourceManager.get().getResourceId(url);
        if(drawable>0)
        {
                iv.setImageDrawable(context.getResources().getDrawable(drawable));
        }
        else
        {
            if(url.length()>2)
            {
                String[] filename = url.split("/");
                String fn = filename[filename.length-1];
                new ImageDownloaderTask(iv,url,fn).execute();
//                new ImageDownloaderTask(iv,url,fn).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
            }
            else
            {
            }
        }
    }

    /**
     * Request images for live apps specifying the size
     * @param context required to retrieve resources
     * @param iv ImageView that will display the image
     * @param url url of the image to be displayed
     * @param width requested width of the image
     * @param height requested height of the image
     */
    public static void displayLiveImageForWithSize(Context context, ImageView iv, String url, int width, int height)
    {
        int drawable = MeshResourceManager.get().getResourceId(url);
        if(drawable>0)
        {
            iv.setImageDrawable(context.getResources().getDrawable(drawable));
        }
        else
        {
            if(url.length()<2)
            {

                String[] filename = url.split("/");
                String fn = filename[filename.length-1];

                new ImageDownloaderTask(iv,url,fn).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
            }
        }
    }
    @Deprecated
    public static void displayDemoImageFor(ImageView iv, String url)
    {
        int drawable = MeshResourceManager.get().getResourceId(url);
        if(drawable>0)
        {
            iv.setImageDrawable(iv.getContext().getResources().getDrawable(drawable));
        }
        else
        {
            if(url.length()<2)
            {
                String[] filename = url.split("/");
                String fn = filename[filename.length-1];
                new ImageDownloaderTask(iv,url,fn).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
            }
        }
    }

    //==============================================================================================

}
