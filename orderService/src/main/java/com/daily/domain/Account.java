package com.daily.domain;

import java.math.BigDecimal;

public class Account {
    private String userId;

    private BigDecimal totalMoney;

    private BigDecimal rechargeMoney;

    private BigDecimal incomeMoney;

    private BigDecimal principalMoney;

    private BigDecimal repaymentMoney;

    private BigDecimal loanMoney;

    private BigDecimal loanNetvalue;

    private BigDecimal freezeForInvest;

    private BigDecimal freezeForCash;

    private Byte type;

    private Integer userIdNum;

    private Byte userType;

    private BigDecimal decimalMoney;
    // 银行电子账户ID
    private String bankAccountId;

    private String autoInvestCode;

    private String autoAssetBuyCode;
    
    private BigDecimal freeCashLimit;

    public Integer getUserIdNum() {
        return this.userIdNum;
    }

    public void setUserIdNum(Integer userIdNum) {
        this.userIdNum = userIdNum;
    }

    public Byte getUserType() {
        return this.userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    /**
     * @author zhishuo
     */
    public Account() {}

    /**
     * @author zhishuo
     * @param userId
     */
    public Account(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public BigDecimal getTotalMoney() {
        return this.totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getRechargeMoney() {
        return this.rechargeMoney;
    }

    public void setRechargeMoney(BigDecimal rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public BigDecimal getIncomeMoney() {
        return this.incomeMoney;
    }

    public void setIncomeMoney(BigDecimal incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    public BigDecimal getPrincipalMoney() {
        return this.principalMoney;
    }

    public void setPrincipalMoney(BigDecimal principalMoney) {
        this.principalMoney = principalMoney;
    }

    public BigDecimal getRepaymentMoney() {
        return this.repaymentMoney;
    }

    public void setRepaymentMoney(BigDecimal repaymentMoney) {
        this.repaymentMoney = repaymentMoney;
    }

    public BigDecimal getLoanMoney() {
        return this.loanMoney;
    }

    public void setLoanMoney(BigDecimal loanMoney) {
        this.loanMoney = loanMoney;
    }

    public BigDecimal getLoanNetvalue() {
        return this.loanNetvalue;
    }

    public void setLoanNetvalue(BigDecimal loanNetvalue) {
        this.loanNetvalue = loanNetvalue;
    }

    public BigDecimal getFreezeForInvest() {
        return this.freezeForInvest;
    }

    public void setFreezeForInvest(BigDecimal freezeForInvest) {
        this.freezeForInvest = freezeForInvest;
    }

    public BigDecimal getFreezeForCash() {
        return this.freezeForCash;
    }

    public void setFreezeForCash(BigDecimal freezeForCash) {
        this.freezeForCash = freezeForCash;
    }

    public Byte getType() {
        return this.type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * @return the decimalMoney
     */
    public BigDecimal getDecimalMoney() {
        return this.decimalMoney;
    }

    /**
     * @param decimalMoney the decimalMoney to set
     */
    public void setDecimalMoney(BigDecimal decimalMoney) {
        this.decimalMoney = decimalMoney;
    }

    public BigDecimal getAllAccountSum() {
        BigDecimal sum = this.getRechargeMoney().add(this.getLoanNetvalue()).add(this.getIncomeMoney())
                .add(this.getLoanMoney()).add(this.getPrincipalMoney()).add(this.getRepaymentMoney());
        return sum;
    }

    public String getBankAccountId() {
        return this.bankAccountId;
    }

    public void setBankAccountId(String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getAutoInvestCode() {
        return autoInvestCode;
    }

    public void setAutoInvestCode(String autoInvestCode) {
        this.autoInvestCode = autoInvestCode;
    }

    public String getAutoAssetBuyCode() {
        return autoAssetBuyCode;
    }

    public void setAutoAssetBuyCode(String autoAssetBuyCode) {
        this.autoAssetBuyCode = autoAssetBuyCode;
    }

	public BigDecimal getFreeCashLimit() {
		return freeCashLimit;
	}

	public void setFreeCashLimit(BigDecimal freeCashLimit) {
		this.freeCashLimit = freeCashLimit;
	}
    
    
}