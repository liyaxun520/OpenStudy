/*****************************************************************************//**
*  - Copyright (C) 2.0, XXX Co. Ltd.
*  - All rights reserved.
*                  
*  @file     cob_ridecode_def.h 
*  @brief    描述当前文档
*  
*  @author   DCXA-ZhangHuan \@decard
*  @date     2020年4月24日 14:25:23
*  @note     GNU General Public License (GPL) *
*  @remark   Description *
* - ‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐*
* - Change History *
* - <Date> | <Version> | <Author> | <Description> *
* - 2020年4月24日 | 2.0 | DCXA-ZhangHuan \@decard | Create file *
* - ‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐*
********************************************************************************/
#ifndef _COB_RIDECODE_DEF_H_
#define _COB_RIDECODE_DEF_H_
/***********************[本地应用头文件]*********************************/

/**********************************************************************************************//**
* @name   编译环境宏定义
* @author DCXA-ZhangHuan \@decard
* @date   2018年12月28日 14:27:31
* @{
*/
#ifdef __ANDROID__
#ifndef _ANDROID_DEV_
#define _ANDROID_DEV_ 1
#endif /* _ANDROID_DEV_ */
#elif __linux__
#ifndef _LINUX_DEV_
#define _LINUX_DEV_ 1
#endif /* _ANDROID_DEV_ */
#elif WIN32
#ifndef _WIN_DEV_
#define _WIN_DEV_ 1
#endif /* _ANDROID_DEV_ */
#endif 
/** @} */

/**********************************************************************************************//**
* @name   1.出入参标志
* @author DCXA-ZhangHuan \@decard
* @date   2018年12月14日 11:31:04
* @{
*/
#ifndef IN
#define IN 
#endif
#ifndef OUT
#define OUT 
#endif
#ifndef IO
#define IO 
#endif
#ifndef TRUE
#define TRUE		1
#endif
#ifndef TRUE
#define FALSE		0
#endif
/** @} */
#ifndef uchar
	typedef unsigned char uchar;
#endif
#ifndef uint
	typedef unsigned int uint;
#endif /* uint */


/***********************[宏定义]*****************************************/
#define QRC_VER_LEN               5   ///<[DCXA-ZhangHuan \@decard] | 版本长度
#define QRC_TRAOPRKINDEX_LEN      1   ///<[DCXA-ZhangHuan \@decard] | 公钥索引长度
#define QRC_GENEALG_LEN           1   ///<[DCXA-ZhangHuan \@decard] | 生成算法长度
#define QRC_OPRID_LEN             8   ///<[DCXA-ZhangHuan \@decard] | 运营商id长度
#define QRC_WALLETID_LEN          8   ///<[DCXA-ZhangHuan \@decard] | 钱包id长度
#define QRC_NUM_LEN               8   ///<[DCXA-ZhangHuan \@decard] | 票号长度
#define QRC_USERIDLEN_LEN         1   ///<[DCXA-ZhangHuan \@decard] | 用户ID长度得长度
#define QRC_USERID_LEN            256 ///<[DCXA-ZhangHuan \@decard] | 用户ID长度
#define QRC_SIGNEXP_LEN           15  ///<[DCXA-ZhangHuan \@decard] | 授权签名有效期长度
#define QRC_VALIDTIME_LEN         2   ///<[DCXA-ZhangHuan \@decard] | 有效期(S)长度
#define QRC_PUBKEY_LEN            512 ///<[DCXA-ZhangHuan \@decard] | 应用公钥长度
#define QRC_PUBKEYTYPE_LEN        1   ///<[DCXA-ZhangHuan \@decard] | 公钥类型长度
#define QRC_GENETIME_LEN          15  ///<[DCXA-ZhangHuan \@decard] | 生成时间长度
#define QRC_TICKTYPE_LEN          1   ///<[DCXA-ZhangHuan \@decard] | 票证类型长度
#define QRC_SEAT_LEN              1   ///<[DCXA-ZhangHuan \@decard] | 座位类型长度
#define QRC_PRIDATALEN_LEN        1   ///<[DCXA-ZhangHuan \@decard] | 私有数据长度得长度
#define QRC_PRIDATA_LEN           256 ///<[DCXA-ZhangHuan \@decard] | 私有数据长度
#define QRC_TRAOPRSIGN_LEN        72  ///<[DCXA-ZhangHuan \@decard] | 运营商签名长度
#define QRC_APPSIGN_LEN           72  ///<[DCXA-ZhangHuan \@decard] | 应用签名长度


/**********************[结构体/全局变量定义]****************************/
#ifndef COBRC_CODE_E
/**********************************************************************************************//**
* @name   9.银联执行的错误代码
* @author DCXA-ZhangHuan \@decard
* @date   2018年3月27日 15:15:38
* @{
*/
typedef enum COBRC_CODE_enum
{
    COBRC_OK              = 0,                 //成功                
    COBRCE_INIT           = 1,                 //初始化失败  
    COBRCE_INVALID        = 2,                 //无效码
    COBRCE_MONEY          = 3,                 //交易金额异常
    COBRCE_VERYSIGN       = 4,                 //验签失败
    COBRCE_NOPUBKEY       = 5,                 //未获取到公钥
    COBRCE_OUTTIME        = 6,                 //二维码已过期 
    COBRCE_REPET          = 7,                 //二维码重复 
    COBRCE_CREATE_JSON    = 8,                 //json组包失败
    COBRCE_PARSE_JSON     = 9,                 //json解包失败
	COBRCE_SEND			  = 10,                //网络发送失败
	COBRCE_RECV           = 11,                //网络接收失败
	COBRCE_DATA_LEN       = 12,                //报文长度错误
	COBRCE_DATA_MAC       = 13,                //mac校验错误
	COBRCE_SEND_LEN       = 14,                //数据长度错误
	COBRCE_ANS            = 15,                //占位
	COBRCE_ORTHER         = 16,                //未知错误
	COBRCE_FREE           = 17,                //设备空闲
	COBRCE_0X97           = 20,                //终端禁用或不存在
	COBRCE_0X96           = 21,                //后台数据处理异常
	COBRCE_0X95           = 22,                //消息类型不存在
	COBRCE_0X94           = 23,                //消息子类型不存在
	COBRCE_0X93           = 24,                //报文类型不存在
	COBRCE_0X92           = 25,                //商户号不存在或禁用
    COBRCE_END
}COBRC_CODE_E;
/** @} */
#endif /* COBRC_CODE_E */

/**********************************************************************************************//**
* @defgroup 公交运营商信息
* @author DCXA-ZhangHuan \@decard
* @date   2020年4月24日 15:37:58
* @{
*/
typedef struct
{
	uchar uc01_OprID[QRC_OPRID_LEN+1];		            //公交运营商ID
	uchar uc02_WalletID[QRC_WALLETID_LEN+1];		    //运营商钱包ID
	uchar uc03_QRCNumber[QRC_NUM_LEN*2+1];              //QRC票号
    uint  ui04_UserIDLen;                               //用户id长度
	uchar uc05_UserID[QRC_USERID_LEN+1];                //用户id
	uchar uc06_ExpTime[QRC_SIGNEXP_LEN+1];              //有效期
	uchar uc07_QRCValidTime[QRC_VALIDTIME_LEN*2+1];     //QRC失效时间（s）
	uchar ui08_AppPubKeylen;                            //APP公钥长度
	uchar uc08_AppPubKey[QRC_PUBKEY_LEN+1];             //APP公钥
	uchar uc09_AppPubKeyFormat[QRC_PUBKEYTYPE_LEN*2+1]; //01未压缩格式

}COBRC_TRAOPR_INFO;
/** @} */

/**********************************************************************************************//**
* @defgroup 应用程序信息
* @author DCXA-ZhangHuan \@decard
* @date   2020年4月24日 15:37:33
* @{
*/
typedef struct
{
	uchar uc01_QRCGeneTime[QRC_GENETIME_LEN+1];		   //二维码生成时间
	uchar uc02_TicketType[QRC_TICKTYPE_LEN*2+1];	   //用户的票证类型                                      
    /***************************************************
                                           00-普通票
	                                       02-学生票
	                                       03-老年人票
	                                       04-士兵票
	                                       05-员工入场券
	                                       06-免费票
	                                       07次入场券
	                                       08英里车票
	                                       0F-其他票
	****************************************************/
	uchar uc03_SeatClass[QRC_SEAT_LEN*2+1];             //座位等级 
	/***************************************************
										   00-通用
										   01-头等舱座位
										   02-二等座
										   03-其他舱座位
	****************************************************/
	uint ui04_TraOprDataLen;                           //运输运营商专有数据长度
    uchar uc05_TraOprData[QRC_PRIDATA_LEN+1];          //运输运营商专有数据

}COBRC_APP_INFO;
/** @} */



/**********************************************************************************************//**
* @defgroup 乘车码信息
* @author DCXA-ZhangHuan \@decard
* @date   2020年4月24日 15:37:10
* @{
*/
typedef struct
{
	uchar uc00_QrcodeVer[QRC_VER_LEN+1];		           //二维码版本
	uchar uc01_PublicKeyIndex[QRC_TRAOPRKINDEX_LEN*2+1];   //公钥索引
	uchar uc02_Algorithm[QRC_GENEALG_LEN*2+1];             //签名算法
	uint  ui03_TraOprLen;                                  //id3数据长度
    uchar uc03_TraOpr[1024];                               //公交运营商信息(临时方便验签)
	COBRC_TRAOPR_INFO st03_TraOpr;                         //公交运营商信息
    uint  ui04_AppLen;                                     //id4数据长度
	uchar uc04_App[1024];                                  //应用程序信息(临时方便验签)
	COBRC_APP_INFO st04_App;                               //应用程序信息
	uchar uc20_TraOprSign[QRC_TRAOPRSIGN_LEN*2+1];         //公交运营商签名
	uchar uc21_AppSign[QRC_APPSIGN_LEN*2+1];               //应用程序签名
	uchar ucTradeMoney[10+1];                              //交易金额
	uchar ucSerial[10+1];                                  //交易流水
	uchar ucTradetime[30+1];                               //交易时间
	uchar ucUpFlag[2+1];                                   //上送标志
	uchar ucUpOtherFlag[2+1];                              //上送第三方标志
 
}COBRIDECODE_TRADELOG;
/** @} */

/**********************************************************************************************//**
* @defgroup 设备信息
* @author DCXA-ZhangHuan \@decard
* @date   2020年5月8日 10:59:45
* @{
*/
typedef struct
{
	uchar ucAppVer[64+1];		                        //软件版本
	uchar ucAliQrCAVer[20+1];		                    //支付宝乘车码CA版本号
	uchar ucCupQrCAVer[20+1];		                    //银联乘车码CA版本号
	uchar ucAliEarliestTime[14+1];                      //支付宝乘车码未上送最早时间
	int uiAliNotUpCnt;                                  //支付宝乘车码未上送笔数 
	uchar ucCupEarliestTime[14+1];                      //银联乘车码未上送最早时间
	int uiCupNotUpCnt;                                  //银联乘车码未上送笔数 
	uchar ucOdaEarliestTime[14+1];                      //oda未上送最早时间
	int uiOdaNotUpCnt;                                  //oda未上送笔数 
	uchar ucNetworkFlow[20+1];                          //POS当日已使用流量

}COB_DEVSTATE_INFO;

/** @} */

/**********************************************************************************************//**
* @defgroup FTP信息
* @author DCXA-ZhangHuan \@decard
* @date   2020年4月2日 14:43:41
* @{
*/
typedef struct COB_HTTP_PARA_struct
{
    char achVerSion[64];                              //参数版本号需要下载什么文件传当前类型文件的版本号
	char achIP[16];                                   
	char achPort[6];
	char achUsr[20];
	char achPwd[20];
	char achPath[300];
	char achMd5[33];
	char achFileName[100];
	char achFileType[3];
	char achUpResult[3];
	char achTime[15];
	char achState[15];                               //交互信息时使用 01成功 02失败
}COB_HTTP_PARA_T;

/** @} */


/**********************[结构体/全局变量引用声明]************************/


#endif /*cob_ridecode_def.h*/
/**************************************************************************
**********************************【 cob_ridecode_def.h 结束】*******************
*************************************************************************
*/
