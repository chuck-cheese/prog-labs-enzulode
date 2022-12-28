#include "com_enzulode_natives_NativeMethods.h"
#include <cstdlib>

JNIEXPORT jint JNICALL Java_com_enzulode_natives_NativeMethods_hashcode (JNIEnv *env, jclass clazz, jobject obj)
{

//    jobject testObj = env->AllocObject(env->GetObjectClass(obj));
    long rnd_part = 0;

    if (sizeof(int) < sizeof(long))
            rnd_part = (static_cast<long>(rand()) << (sizeof(int) * 8)) | rand();
    else
         rnd_part = rand();

    long hashcode = ((long) &obj) + rnd_part;
    return hashcode;
}