#include "com_enzulode_natives_NativeMethods.h"

JNIEXPORT jint JNICALL Java_com_enzulode_natives_NativeMethods_hashcode 
(JNIEnv *env, jclass clazz, jobject &obj)
{
    return ((reinterpret_cast<long>(obj) * 31) / 17);
}