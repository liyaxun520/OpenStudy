/*****************************************************************************//**
*  - Copyright (C) 2.0, XXX Co. Ltd.
*  - All rights reserved.
*                  
*  @file     cob_ridecode_inc.h 
*  @brief    描述当前文档
*  
*  @author   DCXA-ZhangHuan \@decard
*  @date     2020年4月24日 14:30:30
*  @note     GNU General Public License (GPL) *
*  @remark   Description *
* - ‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐*
* - Change History *
* - <Date> | <Version> | <Author> | <Description> *
* - 2020年4月24日 | 2.0 | DCXA-ZhangHuan \@decard | Create file *
* - ‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐*
********************************************************************************/
#ifndef _COB_RIDECODE_INC_H_
#define _COB_RIDECODE_INC_H_
/***********************[本地应用头文件]*********************************/
#include <time.h>
#include <stdarg.h>
#include <stdint.h>
#include <stdio.h>
#include <string.h>
#include <stddef.h>
#include <time.h>

#include "cob_ridecode_def.h"
#include "comm_inc.h"

/***********************[宏定义]*****************************************/


/**********************[结构体/全局变量定义]****************************/

/**********************************************************************************************//**
* @name   日只函数接口定义
* @author DCXA-ZhangHuan \@decard
* @date   2019年3月5日 17:40:43
* @{
*/
typedef void (*COBRC_Log)(unsigned char level, const char *tag, const char *file, const char *func,
				const long line, const char *format, ...); 
typedef void (*COBRC_LogH)(char chLevel, const char*pccTag, const char*pccFile, const char*pccFun, const long clLine,
              const char * pccTitle, unsigned char * pucBuf, int iLen); 



/**********************[结构体/全局变量引用声明]************************/
/**********************************************************************************************//**
* @name   公用层回调函数结构体
* @author DCXA-ZhangHuan \@decard
* @date   2018年12月22日 17:46:30
* @{
*/
typedef struct COBRC_CBFUN_struct
{
	///<[DCXA-ZhangHuan \@decard] | 交易参数数据库路径
	char   *pchDbFilePara;
	///<[DCXA-ZhangHuan \@decard] | 交易明细数据库路径
	char   *pchDbFileTrade;
	///<[DCXA-ZhangHuan \@decard] | 设备SN号
	char   pchSn[50];
    ///<[DCXA-ZhangHuan \@decard] | 终端机编号
    char   pchTermID[32];
    ///<[DCXA-ZhangHuan \@decard] | 商户代码
    char   pchMerID[32];
    ///<[DCXA-ZhangHuan \@decard] | 城市代码
    char   pchCityCode[5];
    ///<[DCXA-ZhangHuan \@decard] | 设备类型
    char   pchDevType[3];
    ///<[DCXA-ZhangHuan \@decard] | 硬件版本号
    char   pchHardVer[32];
    ///<[DCXA-ZhangHuan \@decard] | 拓展版本号
    char   pchExpandVer[32];
	
} COBRC_CBFUN_T/* COBRC_CBFUN_T */ ;



/**********************[接口定义]****************************************/

#ifdef __cplusplus
extern "C"
{
#endif /*__cplusplus*/ 
	/**********************************************************************************************//**
	*  @fn		 void COB_ModuleInit(IN COBRC_CBFUN_T *pstCupCallBackFun, IN char chLogSwitch);
	*  @brief	 模块初始化入口
	*  
	*  @author	 DCXA-ZhangHuan \@decard
	*  @date	 2019年8月8日 16:45:28
	*  @param	[in] pstCupCallBackFun 模块所需的回调设置
	*  @param	[in] char chLogSwitch  模块开关
	*  @return	 -	 非0初始化失败
	***************************************************************************************************/
	int COB_ModuleInit(IN COBRC_CBFUN_T *pstCupCallBackFun, IN char chLogSwitch);
	/**********************************************************************************************//**
	*  @fn       int COB_GetPlatformCAStates(void);;
	*  @brief    获取平台下载公钥状态
	*  
	*  @author   DCXA-ZhangHuan \@decard
	*  @date     2020年5月8日 10:17:02
	*  @param   [in] void
	*  @return  -
	*            -0未下载 非0已下载
	***************************************************************************************************/
	int COB_GetPlatformCAStates(void);
	/**********************************************************************************************//**
	*  @fn       	int COB_GetPlatformSignStates(void);;
	*  @brief    获取平台签到状态
	*  
	*  @author   DCXA-ZhangHuan \@decard
	*  @date     2020年5月8日 10:19:15
	*  @param   [in] void
	*  @return  -
	*            -0未签到 非0已签到
	***************************************************************************************************/
	int COB_GetPlatformSignStates(void);
	/**********************************************************************************************//**
	*  @fn       void COB_Msg_DownPlatformCA(void);
	*  @brief    公钥下载
	*  
	*  @author   DCXA-ZhangHuan \@decard
	*  @date     2020年3月31日 17:49:10
	***************************************************************************************************/
	int COB_Msg_DownPlatformCA(void);
	/**********************************************************************************************//**
	*  @fn       	int COB_Msg_PlatformSign(COB_DEVSTATE_INFO * pstDevInfo);;
	*  @brief    平台签到获取公钥信息
	*  
	*  @author   DCXA-ZhangHuan \@decard
	*  @date     2020年5月8日 10:46:52
	*  @param   [io] pstDevInfo 传入当前设备信息，返回后台设备信息
	*  @return  -
	*            -0成功 非0失败
	***************************************************************************************************/
	int COB_Msg_PlatformSign(IO COB_DEVSTATE_INFO * pstDevInfo);

	/**********************************************************************************************//**
	*  @fn       	int COB_Msg_StateUp(IO COB_DEVSTATE_INFO * pstDevInfo);;
	*  @brief    状态上送
	*  
	*  @author   DCXA-ZhangHuan \@decard
	*  @date     2020年5月8日 10:50:02
	*  @param   [io] pstDevInfo 传入当前设备信息，返回后台设备信息
	*  @return  -
	*            -0成功 非0失败
	***************************************************************************************************/
	int COB_Msg_StateUp(IO COB_DEVSTATE_INFO * pstDevInfo);

	/**********************************************************************************************//**
	*  @fn       	int COB_Msg_TradeUp(void);;
	*  @brief    交易上送
	*  
	*  @author   DCXA-ZhangHuan \@decard
	*  @date     2020年5月8日 10:51:54
	*  @return  -
	*            -0成功 非0失败
	***************************************************************************************************/
	int COB_Msg_TradeUp(void);
	/**********************************************************************************************//**
	*  @fn           int COB_Msg_GetHTTPInfo(COB_HTTP_PARA_T* pstHttpPara);;
	*  @brief    获取HTTP文件下载信息
	*  
	*  @author   DCXA-ZhangHuan \@decard
	*  @date     2020年5月8日 11:05:13
	*  @param   [io] pstHttpPara 文件下载信息 参见COB_HTTP_PARA_T结构体
	*  @return  -
	*            -0成功 非0失败
	***************************************************************************************************/
    int COB_Msg_GetHTTPInfo(IO COB_HTTP_PARA_T* pstHttpPara);	
	/**********************************************************************************************//**
	*  @fn       	int COB_Msg_InteractionStateStart(COB_HTTP_PARA_T* pstHttpPara);;
	*  @brief    HTTP交互开始
	*  
	*  @author   DCXA-ZhangHuan \@decard
	*  @date     2020年5月8日 11:09:22
	*  @param   [in] pstHttpPara 文件下载信息 参见COB_HTTP_PARA_T结构体
	*  @return  -
	*            -0成功 非0失败
	***************************************************************************************************/
	int COB_Msg_InteractionStateStart(IN COB_HTTP_PARA_T* pstHttpPara);
	/**********************************************************************************************//**
	*  @fn       	int COB_Msg_InteractionStateEnd(IN COB_HTTP_PARA_T* pstHttpPara);;
	*  @brief    描述当前文档
	*  
	*  @author   DCXA-ZhangHuan \@decard
	*  @date     2020年5月8日 11:10:16
	*  @param   [in] pstHttpPara 文件下载信息 参见COB_HTTP_PARA_T结构体
	*  @return  -
	*            -0成功 非0失败
	***************************************************************************************************/
	int COB_Msg_InteractionStateEnd(IN COB_HTTP_PARA_T* pstHttpPara);
    /**********************************************************************************************//**
	*  @fn       	int COB_DB_GetDevInfo(COB_DEVSTATE_INFO * pstDevInfo);;
	*  @brief    获取设备信息（乘车码CA版本 未上送交易状态等）
	*  
	*  @author   DCXA-ZhangHuan \@decard
	*  @date     2020年5月8日 10:43:56
	*  @param   [in] pstDevInfo  设备信息详见COB_DEVSTATE_INFO结构体 
	*  @return  -
	*            -0成功 非0失败
	***************************************************************************************************/
	int COB_DB_GetDevInfo(OUT COB_DEVSTATE_INFO * pstDevInfo);
	/**********************************************************************************************//**
	*  @fn       	int COB_DB_SaveCAVer(uchar * pchVer);;
	*  @brief    存储支付宝乘车码CA版本
	*  
	*  @author   DCXA-ZhangHuan \@decard
	*  @date     2020年5月8日 11:13:08
	*  @param   [in] pchVer  支付宝乘车码CA版本
	*  @return  -
	*            -0成功 非0失败
	***************************************************************************************************/
	int COB_DB_SaveAliCAVer(IN uchar * pchVer);
	/**********************************************************************************************//**
	*  @fn       	int COB_DB_ParsingCupCAFiles(uchar* ucFilePath);;
	*  @brief    解析银联乘车码公钥文件
	*  
	*  @author   DCXA-ZhangHuan \@decard
	*  @date     2020年5月8日 11:16:44
	*  @param   [in] uchar* ucFilePath  文件路径
	*  @return  -
	*            -0成功 非0失败
	***************************************************************************************************/
	int COB_DB_ParsingCupCAFiles(IN uchar* ucFilePath);
	/**********************************************************************************************//**
	*  @fn       void COB_DB_TimerCRB(void);
	*  @brief    数据库定时备份
	*  
	*  @author   DCXA-ZhangHuan \@decard
	*  @date     2020年4月26日 14:24:08
	*  @return  -
	*            -void
	*  @note    (描述需要注意的问题) 
	*            - 1.需要定时调用，建议每1小时调用1次
	***************************************************************************************************/
	void COB_DB_TimerCRB(void);
	/**********************************************************************************************//**
	*  @fn		 int COB_DB_LoadTradeRecS(IN char *pchSQL, IN int iMaxRec, OUT int *pRecNum, OUT COBRIDECODE_TRADELOG *pStruct_log);
	*  @brief	 根据SQL语句加载对应的交易明细（多条交易记录加载）
	*  
	*  @author	 DCXA-ZhangHuan \@decard
	*  @date	 2020年4月26日 15:43:13
	*  @param	 [in]	pchSQL		SQL语句
	*  @param	 [in]	iMaxRec 	当前缓存pStruct_log最大存储交易明细的量
	*  @param	 [out]	pRecNum 	此次查询到的交易明细的总笔数
	*  @param	 [out]	pStruct_log 明细缓存区
	*  @return	 - 成功，0
	*			 - 失败，其他
	***************************************************************************************************/
	int COB_DB_LoadTradeRecS(IN char *pchSQL, IN int iMaxRec, OUT int *pRecNum, OUT COBRIDECODE_TRADELOG *pStruct_log);
	/**********************************************************************************************//**
	*  @fn       int COB_DB_LoadTradeRec(IN char *pchSQL, OUT COBRIDECODE_TRADELOG *pStruct_log);
	*  @brief    读取交易记录
	*  
	*  @author   DCXA-ZhangHuan \@decard
	*  @date     2020年4月26日 15:52:43
	*  @param   [in] char *pchSQL  sql语句
	*  @param   [out] pStruct_log  交易记录
	*  @return  -
	*            -0成功
	***************************************************************************************************/
	int COB_DB_LoadTradeRec(IN char *pchSQL, OUT COBRIDECODE_TRADELOG *pStruct_log);  
	/**********************************************************************************************//**
	*  @fn		 int COBRC_RideCode_Pay(IN uint uiMoney, uchar *pQRcode, uint QRdataLen, COBRIDECODE_TRADELOG* stRideCodeTrade);
	*  @brief	 乘车码验签
	*  
	*  @author	 DCXA-ZhangHuan \@decard
	*  @date	 2020年4月24日 16:23:15
	*  @param	[in] uint uiMoney	  交易金额
	*  @param	[in] uchar *pQRcode   二维码
	*  @param	[in] uint QRdataLen   二维码长度
	*  @param	[io] COBRIDECODE_TRADELOG* stRideCodeTrade 交易结构体
	*  @return	-
	*			 -参见错误码COBRC_CODE_E 
	***************************************************************************************************/
	int COBRC_RideCode_Pay(IN uint uiMoney,IN uchar *pQRcode,IN uint QRdataLen,IO COBRIDECODE_TRADELOG* stRideCodeTrade);
	

#ifdef __cplusplus
}
#endif /*__cplusplus*/ 

#endif /*cob_ridecode_inc.h*/
/**************************************************************************
**********************************【 cob_ridecode_inc.h 结束】*******************
*************************************************************************
*/

