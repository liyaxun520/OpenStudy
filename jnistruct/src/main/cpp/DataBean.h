//
// Created by Administrator on 2020/5/9 0009.
//

#ifndef OPENFRAME_DATABEAN_H
#define OPENFRAME_DATABEAN_H

typedef struct jni_rect_t {
    int left;
    int top;
    int right;
    int bottom;
} jni_rect;

typedef struct jni_point_t {
    float x;
    float y;
} jni_point;

typedef struct jni_data_bean_t {
    jni_rect rect; // Rect
    jni_point points[4]; // PointF[]
    const char *message; // String
    int id; // int
    float score; // float
    signed char data[4]; // byte[]
    int double_dimen_array[2][2]; // int[][]
} jni_data_bean;

#endif //OPENFRAME_DATABEAN_H
