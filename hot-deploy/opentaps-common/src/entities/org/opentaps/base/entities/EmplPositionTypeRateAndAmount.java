package org.opentaps.base.entities;

/*
 * Copyright (c) 2008 - 2009 Open Source Strategies, Inc.
 *
 * Opentaps is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Opentaps is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Opentaps.  If not, see <http://www.gnu.org/licenses/>.
 */

// DO NOT EDIT THIS FILE!  THIS IS AUTO GENERATED AND WILL GET WRITTEN OVER PERIODICALLY WHEN THE DATA MODEL CHANGES
// EXTEND THIS CLASS INSTEAD.

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javolution.util.FastMap;

import org.opentaps.foundation.entity.Entity;
import org.opentaps.foundation.entity.EntityFieldInterface;
import org.opentaps.foundation.repository.RepositoryException;
import org.opentaps.foundation.repository.RepositoryInterface;
import javax.persistence.*;
import org.hibernate.search.annotations.*;
import java.lang.String;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Auto generated base entity EmplPositionTypeRateAndAmount.
 */
@javax.persistence.Entity
@NamedNativeQuery(name="selectEmplPositionTypeRateAndAmounts", query="SELECT RA.RATE_AMOUNT AS \"rateAmount\",RA.PERIOD_TYPE_ID AS \"periodTypeId\",RA.RATE_CURRENCY_UOM_ID AS \"rateCurrencyUomId\",RA.FROM_DATE AS \"fromDate\",RA.THRU_DATE AS \"thruDate\",EPTR.EMPL_POSITION_TYPE_ID AS \"emplPositionTypeId\",EPTR.RATE_TYPE_ID AS \"rateTypeId\",EPTR.PAY_GRADE_ID AS \"payGradeId\",EPTR.SALARY_STEP_SEQ_ID AS \"salaryStepSeqId\",EPTR.FROM_DATE AS \"fromDate\",EPTR.THRU_DATE AS \"thruDate\" FROM EMPL_POSITION_TYPE_RATE EPTR INNER JOIN RATE_AMOUNT RA ON EPTR.EMPL_POSITION_TYPE_ID = RA.EMPL_POSITION_TYPE_ID AND EPTR.RATE_TYPE_ID = RA.RATE_TYPE_ID", resultSetMapping="EmplPositionTypeRateAndAmountMapping")
@SqlResultSetMapping(name="EmplPositionTypeRateAndAmountMapping", entities={
@EntityResult(entityClass=EmplPositionTypeRateAndAmount.class, fields = {
@FieldResult(name="rateAmount", column="rateAmount")
,@FieldResult(name="periodTypeId", column="periodTypeId")
,@FieldResult(name="rateCurrencyUomId", column="rateCurrencyUomId")
,@FieldResult(name="rateAmountFromDate", column="rateAmountFromDate")
,@FieldResult(name="rateAmountThruDate", column="rateAmountThruDate")
,@FieldResult(name="emplPositionTypeId", column="emplPositionTypeId")
,@FieldResult(name="rateTypeId", column="rateTypeId")
,@FieldResult(name="payGradeId", column="payGradeId")
,@FieldResult(name="salaryStepSeqId", column="salaryStepSeqId")
,@FieldResult(name="fromDate", column="fromDate")
,@FieldResult(name="thruDate", column="thruDate")
})})
@org.hibernate.annotations.Entity(mutable = false)
@org.hibernate.annotations.AccessType("field")
public class EmplPositionTypeRateAndAmount extends Entity {
static {
java.util.Map<String, String> fields = new java.util.HashMap<String, String>();
        fields.put("rateAmount", "RA.RATE_AMOUNT");
        fields.put("periodTypeId", "RA.PERIOD_TYPE_ID");
        fields.put("rateCurrencyUomId", "RA.RATE_CURRENCY_UOM_ID");
        fields.put("rateAmountFromDate", "RA.FROM_DATE");
        fields.put("rateAmountThruDate", "RA.THRU_DATE");
        fields.put("emplPositionTypeId", "EPTR.EMPL_POSITION_TYPE_ID");
        fields.put("rateTypeId", "EPTR.RATE_TYPE_ID");
        fields.put("payGradeId", "EPTR.PAY_GRADE_ID");
        fields.put("salaryStepSeqId", "EPTR.SALARY_STEP_SEQ_ID");
        fields.put("fromDate", "EPTR.FROM_DATE");
        fields.put("thruDate", "EPTR.THRU_DATE");
fieldMapColumns.put("EmplPositionTypeRateAndAmount", fields);
}
  public static enum Fields implements EntityFieldInterface<EmplPositionTypeRateAndAmount> {
    rateAmount("rateAmount"),
    periodTypeId("periodTypeId"),
    rateCurrencyUomId("rateCurrencyUomId"),
    rateAmountFromDate("rateAmountFromDate"),
    rateAmountThruDate("rateAmountThruDate"),
    emplPositionTypeId("emplPositionTypeId"),
    rateTypeId("rateTypeId"),
    payGradeId("payGradeId"),
    salaryStepSeqId("salaryStepSeqId"),
    fromDate("fromDate"),
    thruDate("thruDate");
    private final String fieldName;
    private Fields(String name) { fieldName = name; }
    /** {@inheritDoc} */
    public String getName() { return fieldName; }
    /** {@inheritDoc} */
    public String asc() { return fieldName + " ASC"; }
    /** {@inheritDoc} */
    public String desc() { return fieldName + " DESC"; }
  }

    
   private BigDecimal rateAmount;
    
   private String periodTypeId;
    
   private String rateCurrencyUomId;
    
   private Timestamp rateAmountFromDate;
    
   private Timestamp rateAmountThruDate;
    @Id
   private String emplPositionTypeId;
    
   private String rateTypeId;
    
   private String payGradeId;
    
   private String salaryStepSeqId;
    
   private Timestamp fromDate;
    
   private Timestamp thruDate;

  /**
   * Default constructor.
   */
  public EmplPositionTypeRateAndAmount() {
      super();
      this.baseEntityName = "EmplPositionTypeRateAndAmount";
      this.isView = true;
      
      this.primaryKeyNames = new ArrayList<String>();
      this.primaryKeyNames.add("periodTypeId");this.primaryKeyNames.add("rateCurrencyUomId");this.primaryKeyNames.add("rateAmountFromDate");this.primaryKeyNames.add("emplPositionTypeId");this.primaryKeyNames.add("rateTypeId");this.primaryKeyNames.add("fromDate");
      this.allFieldsNames = new ArrayList<String>();
      this.allFieldsNames.add("rateAmount");this.allFieldsNames.add("periodTypeId");this.allFieldsNames.add("rateCurrencyUomId");this.allFieldsNames.add("rateAmountFromDate");this.allFieldsNames.add("rateAmountThruDate");this.allFieldsNames.add("emplPositionTypeId");this.allFieldsNames.add("rateTypeId");this.allFieldsNames.add("payGradeId");this.allFieldsNames.add("salaryStepSeqId");this.allFieldsNames.add("fromDate");this.allFieldsNames.add("thruDate");
      this.nonPrimaryKeyNames = new ArrayList<String>();
      this.nonPrimaryKeyNames.addAll(allFieldsNames);
      this.nonPrimaryKeyNames.removeAll(primaryKeyNames);
  }

  /**
   * Constructor with a repository.
   * @param repository a <code>RepositoryInterface</code> value
   */
  public EmplPositionTypeRateAndAmount(RepositoryInterface repository) {
      this();
      initRepository(repository);
  }

    /**
     * This is a view-entity, so the setter methods will be private to this class and for use in its fromMap constructor only
     */
    /**
     * Auto generated value setter.
     * @param rateAmount the rateAmount to set
     */
    public void setRateAmount(BigDecimal rateAmount) {
        this.rateAmount = rateAmount;
    }
    /**
     * Auto generated value setter.
     * @param periodTypeId the periodTypeId to set
     */
    public void setPeriodTypeId(String periodTypeId) {
        this.periodTypeId = periodTypeId;
    }
    /**
     * Auto generated value setter.
     * @param rateCurrencyUomId the rateCurrencyUomId to set
     */
    public void setRateCurrencyUomId(String rateCurrencyUomId) {
        this.rateCurrencyUomId = rateCurrencyUomId;
    }
    /**
     * Auto generated value setter.
     * @param rateAmountFromDate the rateAmountFromDate to set
     */
    public void setRateAmountFromDate(Timestamp rateAmountFromDate) {
        this.rateAmountFromDate = rateAmountFromDate;
    }
    /**
     * Auto generated value setter.
     * @param rateAmountThruDate the rateAmountThruDate to set
     */
    public void setRateAmountThruDate(Timestamp rateAmountThruDate) {
        this.rateAmountThruDate = rateAmountThruDate;
    }
    /**
     * Auto generated value setter.
     * @param emplPositionTypeId the emplPositionTypeId to set
     */
    public void setEmplPositionTypeId(String emplPositionTypeId) {
        this.emplPositionTypeId = emplPositionTypeId;
    }
    /**
     * Auto generated value setter.
     * @param rateTypeId the rateTypeId to set
     */
    public void setRateTypeId(String rateTypeId) {
        this.rateTypeId = rateTypeId;
    }
    /**
     * Auto generated value setter.
     * @param payGradeId the payGradeId to set
     */
    public void setPayGradeId(String payGradeId) {
        this.payGradeId = payGradeId;
    }
    /**
     * Auto generated value setter.
     * @param salaryStepSeqId the salaryStepSeqId to set
     */
    public void setSalaryStepSeqId(String salaryStepSeqId) {
        this.salaryStepSeqId = salaryStepSeqId;
    }
    /**
     * Auto generated value setter.
     * @param fromDate the fromDate to set
     */
    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }
    /**
     * Auto generated value setter.
     * @param thruDate the thruDate to set
     */
    public void setThruDate(Timestamp thruDate) {
        this.thruDate = thruDate;
    }

    /**
     * Auto generated value accessor.
     * @return <code>BigDecimal</code>
     */
    public BigDecimal getRateAmount() {
        return this.rateAmount;
    }
    /**
     * Auto generated value accessor.
     * @return <code>String</code>
     */
    public String getPeriodTypeId() {
        return this.periodTypeId;
    }
    /**
     * Auto generated value accessor.
     * @return <code>String</code>
     */
    public String getRateCurrencyUomId() {
        return this.rateCurrencyUomId;
    }
    /**
     * Auto generated value accessor.
     * @return <code>Timestamp</code>
     */
    public Timestamp getRateAmountFromDate() {
        return this.rateAmountFromDate;
    }
    /**
     * Auto generated value accessor.
     * @return <code>Timestamp</code>
     */
    public Timestamp getRateAmountThruDate() {
        return this.rateAmountThruDate;
    }
    /**
     * Auto generated value accessor.
     * @return <code>String</code>
     */
    public String getEmplPositionTypeId() {
        return this.emplPositionTypeId;
    }
    /**
     * Auto generated value accessor.
     * @return <code>String</code>
     */
    public String getRateTypeId() {
        return this.rateTypeId;
    }
    /**
     * Auto generated value accessor.
     * @return <code>String</code>
     */
    public String getPayGradeId() {
        return this.payGradeId;
    }
    /**
     * Auto generated value accessor.
     * @return <code>String</code>
     */
    public String getSalaryStepSeqId() {
        return this.salaryStepSeqId;
    }
    /**
     * Auto generated value accessor.
     * @return <code>Timestamp</code>
     */
    public Timestamp getFromDate() {
        return this.fromDate;
    }
    /**
     * Auto generated value accessor.
     * @return <code>Timestamp</code>
     */
    public Timestamp getThruDate() {
        return this.thruDate;
    }




    /** {@inheritDoc} */
    @Override
    public void fromMap(Map<String, Object> mapValue) {
        preInit();
        setRateAmount(convertToBigDecimal(mapValue.get("rateAmount")));
        setPeriodTypeId((String) mapValue.get("periodTypeId"));
        setRateCurrencyUomId((String) mapValue.get("rateCurrencyUomId"));
        setRateAmountFromDate((Timestamp) mapValue.get("rateAmountFromDate"));
        setRateAmountThruDate((Timestamp) mapValue.get("rateAmountThruDate"));
        setEmplPositionTypeId((String) mapValue.get("emplPositionTypeId"));
        setRateTypeId((String) mapValue.get("rateTypeId"));
        setPayGradeId((String) mapValue.get("payGradeId"));
        setSalaryStepSeqId((String) mapValue.get("salaryStepSeqId"));
        setFromDate((Timestamp) mapValue.get("fromDate"));
        setThruDate((Timestamp) mapValue.get("thruDate"));
        postInit();
    }

    /** {@inheritDoc} */
    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> mapValue = new FastMap<String, Object>();
        mapValue.put("rateAmount", getRateAmount());
        mapValue.put("periodTypeId", getPeriodTypeId());
        mapValue.put("rateCurrencyUomId", getRateCurrencyUomId());
        mapValue.put("rateAmountFromDate", getRateAmountFromDate());
        mapValue.put("rateAmountThruDate", getRateAmountThruDate());
        mapValue.put("emplPositionTypeId", getEmplPositionTypeId());
        mapValue.put("rateTypeId", getRateTypeId());
        mapValue.put("payGradeId", getPayGradeId());
        mapValue.put("salaryStepSeqId", getSalaryStepSeqId());
        mapValue.put("fromDate", getFromDate());
        mapValue.put("thruDate", getThruDate());
        return mapValue;
    }


}