package com.decard.lib.jnistruct.data;

public class DevStateInfo {
    String ucAppVer; //软件版本
    String ucAliQrCAVer; //支付宝乘车码CA版本号
    String ucCupQrCAVer; //银联乘车码CA版本号
    String ucAliEarliestTime; //支付宝乘车码未上送最早时间
    int uiAliNotUpCnt; //支付宝乘车码未上送笔数
    String ucCupEarliestTime; //银联乘车码未上送最早时间
    int uiCupNotUpCnt; //银联乘车码未上送笔数
    String ucOdaEarliestTime; //oda未上送最早时间
    int uiOdaNotUpCnt; //oda未上送笔数
    String ucNetworkFlow; //POS当日已使用流量

    public String getUcAppVer() {
        return ucAppVer;
    }

    public void setUcAppVer(String ucAppVer) {
        this.ucAppVer = ucAppVer;
    }

    public String getUcAliQrCAVer() {
        return ucAliQrCAVer;
    }

    public void setUcAliQrCAVer(String ucAliQrCAVer) {
        this.ucAliQrCAVer = ucAliQrCAVer;
    }

    public String getUcCupQrCAVer() {
        return ucCupQrCAVer;
    }

    public void setUcCupQrCAVer(String ucCupQrCAVer) {
        this.ucCupQrCAVer = ucCupQrCAVer;
    }

    public String getUcAliEarliestTime() {
        return ucAliEarliestTime;
    }

    public void setUcAliEarliestTime(String ucAliEarliestTime) {
        this.ucAliEarliestTime = ucAliEarliestTime;
    }

    public int getUiAliNotUpCnt() {
        return uiAliNotUpCnt;
    }

    public void setUiAliNotUpCnt(int uiAliNotUpCnt) {
        this.uiAliNotUpCnt = uiAliNotUpCnt;
    }

    public String getUcCupEarliestTime() {
        return ucCupEarliestTime;
    }

    public void setUcCupEarliestTime(String ucCupEarliestTime) {
        this.ucCupEarliestTime = ucCupEarliestTime;
    }

    public int getUiCupNotUpCnt() {
        return uiCupNotUpCnt;
    }

    public void setUiCupNotUpCnt(int uiCupNotUpCnt) {
        this.uiCupNotUpCnt = uiCupNotUpCnt;
    }

    public String getUcOdaEarliestTime() {
        return ucOdaEarliestTime;
    }

    public void setUcOdaEarliestTime(String ucOdaEarliestTime) {
        this.ucOdaEarliestTime = ucOdaEarliestTime;
    }

    public int getUiOdaNotUpCnt() {
        return uiOdaNotUpCnt;
    }

    public void setUiOdaNotUpCnt(int uiOdaNotUpCnt) {
        this.uiOdaNotUpCnt = uiOdaNotUpCnt;
    }

    public String getUcNetworkFlow() {
        return ucNetworkFlow;
    }

    public void setUcNetworkFlow(String ucNetworkFlow) {
        this.ucNetworkFlow = ucNetworkFlow;
    }
}
