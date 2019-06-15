# android-labservice

Service testing lab that runs in the background even when the application is terminated.

In addition, in cases where the device is turned off for any reason whatsoever, upon restart, service execution is restored.

I used threads because the recommendation is that services run on threads other than the main application thread running on Android.