package com.apkplug;


import com.apkplug.component.sobotsdk.Sobot;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class SimpleBundle implements BundleActivator
{

    private Sobot mSobot=null;
    private ServiceRegistration mReg = null;

    public void start(BundleContext context) throws Exception
    {
        System.err.println("BundleId为："+context.getBundle().getBundleId()+"的"+context.getBundle().getName()+"插件已经启动了");
        mSobot=new SobotImp(context.getAndroidContext());
        mReg=context.registerService(Sobot.class.getName(), mSobot, null);

    }

    public void stop(BundleContext context)
    {

        mReg.unregister();
    }

}