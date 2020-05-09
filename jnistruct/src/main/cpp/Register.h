//
// Created by Administrator on 2020/5/9 0009.
//

#include <jni.h>
#include "DataBean.h"
#include "cob_ridecode_def.h"

#ifndef OPENFRAME_REGISTER_H

#define OPENFRAME_REGISTER_H


// 对应 android.graphics.Rect 类
typedef struct rect_block_t {
    jclass clazz;
    jfieldID left;
    jfieldID top;
    jfieldID right;
    jfieldID bottom;
    jmethodID constructor;
} rect_block;

// 对应 android.graphics.PointF 类
typedef struct point_block_t {
    jclass clazz;
    jfieldID x;
    jfieldID y;
    jmethodID constructor;
} point_block;

// 对应 com.decard.lib.jnistruct.data.DataBean$Inner 类
typedef struct inner_block_t {
    jclass clazz;
    jfieldID message;
    jmethodID constructor;
} inner_block;

// 对应 com.decard.lib.jnistruct.data.DataBean 类
typedef struct data_bean_block_t {
    jclass clazz;
    jfieldID rect;
    jfieldID points;
    jfieldID inner;

    jfieldID id;
    jfieldID score;
    jfieldID data;
    jfieldID double_dimen_array;

    jmethodID constructor;
} data_bean_block;

// 对应 com.decard.lib.jnistruct.data.DevStateInfo 类
typedef struct dev_state_info_t {
    jclass clazz;
    jfieldID ucAppVer;
    jfieldID ucAliQrCAVer;
    jfieldID ucCupQrCAVer;
    jfieldID ucAliEarliestTime;
    jfieldID uiAliNotUpCnt;
    jfieldID ucCupEarliestTime;
    jfieldID uiCupNotUpCnt;
    jfieldID ucOdaEarliestTime;
    jfieldID uiOdaNotUpCnt;
    jfieldID ucNetworkFlow;
    jmethodID constructor;
} dev_state_info_block;

// 注册
void register_classes(JNIEnv *env);

// C结构体转Java类
jobject data_bean_c_to_java(JNIEnv *env, jni_data_bean *data_bean);

// Java类转C结构体
void data_bean_java_to_c(JNIEnv *env, jobject data_bean_in, jni_data_bean *data_bean_out);

void data_devinfo_java_to_c(JNIEnv *env, jobject data_devinfo_in, COB_DEVSTATE_INFO *cobDevstateInfo);


#endif //OPENFRAME_REGISTER_H